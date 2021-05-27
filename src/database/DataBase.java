package database;

import objects.ParkingSpot;
import objects.Vehicle;

import java.util.Date;

public class DataBase {

    private static ParkingSpot[] parkingSpots = new ParkingSpot[10];

    public DataBase() {
        fillData();
    } //initialize database

    public static void fillData(){

        parkingSpots[0] = new ParkingSpot(0, true);
        parkingSpots[1] = new ParkingSpot(1, true);
        parkingSpots[2] = new ParkingSpot(2, true);
        parkingSpots[3] = new ParkingSpot(3, true);
        parkingSpots[4] = new ParkingSpot(4, true);
        parkingSpots[5] = new ParkingSpot(5, true);
        parkingSpots[6] = new ParkingSpot(6, true);
        parkingSpots[7] = new ParkingSpot(7, true);
        parkingSpots[8] = new ParkingSpot(8, true);
        parkingSpots[9] = new ParkingSpot(9, true);

    }

    public static ParkingSpot checkAvailability(){

        for (ParkingSpot parkingSpot : parkingSpots){
            if (parkingSpot.isFree() == true){
                return parkingSpot;
            }
        }
        return null;
    }

    public static int availableSpots(){
        int counter = 0;
        for (ParkingSpot parkingSpot : parkingSpots){
            if (parkingSpot.isFree() == true){
                counter++;
            }
        }

        if (counter == 0){
            System.out.println("There is not any parking spot available!");
            return 0;
        }
        return counter;

    }

    public static boolean isFull(){
        for (ParkingSpot parkingSpot : parkingSpots){
            if (parkingSpot.isFree() == true){
                return false;
            }
        }
        return true;

    }


    public static boolean isExistedPlate(String numberPlate) {
        for (ParkingSpot parkingSpot : parkingSpots){
            if (parkingSpot.getVehicle() != null && parkingSpot.getVehicle().getPlate().equals(numberPlate)){
                return true;
            }
        }
        return false;

    }

    public static void removeVehicle(String numberPlate) {
        for (ParkingSpot parkingSpot : parkingSpots){
            if (parkingSpot.getVehicle() != null && parkingSpot.getVehicle().getPlate().equals(numberPlate)){
                parkingSpot.setFree(true);
                charge(parkingSpot.getVehicle());
                parkingSpot.setVehicle(null);
            }
        }
    }
    //calculate price
    private static void charge(Vehicle vehicle) {
        double duration = (double) (System.currentTimeMillis() - vehicle.getEntranceInstance()) / 3600000;
        System.out.println("You should pay " + vehicle.getChargePerHour() * duration + " euro");
    }
}
