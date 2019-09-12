import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class IocController {
    /**
     * ioc 约定
     * <p>
     * 1.所有bean对象由ioc创建
     * 2.对象有依赖先创建依赖对象
     * 3.所有被依赖的bean由构造方法传入
     */
    //创建一个储存bean的容器 使用线程安全的Map（String 就是每个bean的ID，代表一个对象的键值）
    private Map<String, Object> beans = new ConcurrentHashMap<String, Object>();

    public Object getBean(String beanId) {
        //传入键值，到容器中取对应的bean
        Object bean = beans.get(beanId);
        if (bean == null) {
            throw new RuntimeException("所需对象在容器中没有找到");
        }
        return bean;
    }

    /**
     * 将所需要的bean放入容器
     *
     * @param clazz       所需要的对象的类
     * @param beanId      创建bean对象在容器中的id
     * @param relyBeanIds 依赖对象在容器的beanId（有可能有多个，就传多个）
     */
    public void setBean(Class<?> clazz, String beanId, String... relyBeanIds) {
        //首先我们所有的bean都通过构造方法去创建，构造方法就需要所需的参数
        //参数其实就是这个类所依赖的类的对象。那我们先去取所依赖的对象。然后传进去就好了
        //考虑到有多个依赖就会有多个构造方法
        Object[] paramValues = new Object[relyBeanIds.length];
        for (int i = 0; i < paramValues.length; i++) {
            paramValues[i] = getBean(relyBeanIds[i]);
        }
        Object bean = null;
        //实例化我们要创建的bean。通过构造方法
        for (Constructor<?> constructor : clazz.getConstructors()) {
            try {
                bean = constructor.newInstance(paramValues);
            } catch (InstantiationException ignored) {
            } catch (IllegalAccessException ignored) {
            } catch (InvocationTargetException ignored) {
            }
        }
        //如果循环了一轮之后，容器还是没有值
        if (bean == null) {
            throw new RuntimeException("传入依赖对象时出错");
        }
        //将实例化好的对象放到容器中

        beans.put(beanId, bean);

    }
}
