package ioc_annotation.pojo;

/**
 * @author LX
 * @date 2019/3/17 - 19:46
 */
public class Worker {

    private CarLife carLife;

    @Override
    public String toString() {
        return "Worker{" +
                "carLife=" + carLife +
                '}';
    }

    public CarLife getCarLife() {
        return carLife;
    }

    public void setCarLife(CarLife carLife) {
        this.carLife = carLife;
    }
}
