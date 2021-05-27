package objects;

public class Vehicle {
    private String plate;
    private int chargePerHour;
    private long entranceInstance;

    public Vehicle(String plate, int chargePerHour, long entranceInstance) {
        this.plate = plate;
        this.chargePerHour = chargePerHour;
        this.entranceInstance = entranceInstance;
    }

    public String getPlate() {

        return plate;
    }

    public void setPlate(String plate) {

        this.plate = plate;
    }

    public int getChargePerHour() {

        return chargePerHour;
    }

    public void setChargePerHour(int chargePerHour) {

        this.chargePerHour = chargePerHour;
    }

    public long getEntranceInstance() {

        return entranceInstance;
    }

}
