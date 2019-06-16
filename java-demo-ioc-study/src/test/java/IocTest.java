import org.junit.Before;
import org.junit.Test;

public class IocTest {

    private IocController iocController=new IocController();
    @Before
    public void before(){
        //把bean依次注册到容器中
        iocController.setBean(BMW.class,BMW.class.getName());
        iocController.setBean(Audi.class,Audi.class.getName());
        iocController.setBean(ZhangSan.class,ZhangSan.class.getName(),Audi.class.getName());
        iocController.setBean(LiSi.class,LiSi.class.getName(),BMW.class.getName());
    }
    @Test
    public void test(){
        Human zhangsan= (Human) iocController.getBean(ZhangSan.class.getName());
        zhangsan.goHome();
    }
}
