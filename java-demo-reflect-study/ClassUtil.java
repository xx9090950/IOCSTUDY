import java.lang.reflect.Method;

class ClassUtil {
    public static void getClassInfoByObj(Object object) {
        //首先获取传入对象的类类型
        Class c = object.getClass();

        System.out.println("类的名称:" + c.getName());

        System.out.println("下面是类的方法");

        //获取到类里所有的方法数组
        Method[] mds = c.getMethods();
        for (Method md : mds) {
            //获取方法的返回值类型的类类型
            Class returnType = md.getReturnType();
            System.out.print(returnType.getName());
            //获取方法名
            System.out.print(md.getName() + " (");
            //获取方法入参类型的类类型 因为入参可能有多个，所以是数组
            Class[] parameterTypes = md.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                //打印入参的类名
                System.out.print(parameterTypes[i].getName());
                if (i != parameterTypes.length - 1) {
                    System.out.print(",");
                }
            }
            System.out.println(")");

        }
    }
}