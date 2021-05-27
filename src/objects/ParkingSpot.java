package objects;

public class ParkingSpot {

    private int index;
    private boolean isFree;
    private Vehicle vehicle;

    public ParkingSpot(int index, boolean isFree) {
        this.index = index;
        this.isFree = isFree;
    }

    public int getIndex() {
        return index;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

}
