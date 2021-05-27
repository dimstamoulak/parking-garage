package objects;

public class Motorcycle extends Vehicle {

    public Motorcycle(String plate) {

        super(plate, 2, System.currentTimeMillis());
    }
}
