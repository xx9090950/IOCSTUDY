public class ZhangSan extends HumenWithCar {
    public ZhangSan(Car car) {
        super(car);
    }

    public void goHome() {
        car.start();
        car.left();
        car.right();
        car.stop();
    }
}
