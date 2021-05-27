package objects;

public class Car extends Vehicle {

    public Car(String plate) {

        super(plate, 5, System.currentTimeMillis());
    }

}
