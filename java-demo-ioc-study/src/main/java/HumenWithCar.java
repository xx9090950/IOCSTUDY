/**
 * 有车一族，继承人类
 */
public abstract class HumenWithCar implements Human {
    protected Car car;

    public HumenWithCar(Car car) {
        this.car = car;
    }

    /**
     * 由于每个人回家的路线是不同的，有车一族这个类不能给具体的实现。交由具体的某个人来实现回家方法
     */
    public abstract void goHome();
}
