import database.DataBase;
import objects.Car;
import objects.Motorcycle;
import objects.ParkingSpot;
import objects.Vehicle;
import validation.Validation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParkingGarageApp {

    private static BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        DataBase.fillData();

        boolean flag = true;

        printActions();


        while (flag) {

            int action;
            do {
                System.out.println("\n...Enter the action: ");
                action = Integer.parseInt(scanner.readLine());
                break;
            } while (true);

            switch (action) {
                case 0:
                    flag = false;
                    System.out.println("\n\nShout-down application...");
                    break;
                case 1:
                    enter();
                    break;
                case 2:
                    exitFromGarage();
                    break;
                case 3:
                    if (DataBase.isFull()) {
                        System.out.println("\n\nGarage is full.");
                    } else {
                        int freeSpots = DataBase.availableSpots();
                        System.out.println("\n\n" + freeSpots + " are available.");
                    }
                    break;
                case 4:
                    printActions();
                    break;
                default:
                    System.out.println("Wrong input...\n");
            }
        }
    }

    private static void exitFromGarage() throws IOException {

        String numberPlate;
        do {
            System.out.println("Please enter plate of your vehicle: ");
            numberPlate = scanner.readLine();
            if (Validation.isValideForExit(numberPlate)) {
                break;
            }
        } while (true);

        DataBase.removeVehicle(numberPlate);

    }

    private static void enter() throws IOException {

        do {
                if (DataBase.isFull()) {
                    System.out.println("The parking is full!");
                    break;
                }

                String numberPlate;
                do {
                    System.out.println("Please enter plate of your vehicle: ");
                    numberPlate = scanner.readLine();
                    if (Validation.isValideForEnter(numberPlate)) {
                        break;
                    }
                } while (true);
                Vehicle vehicle;
                String type;
                do {
                    System.out.println("Is car or moto? ");
                    type = scanner.readLine();
                    if (type.equals("car")) {
                        vehicle = new Car(numberPlate);
                        break;
                    } else if (type.equals("moto")) {
                        vehicle = new Motorcycle(numberPlate);
                        break;
                    } else {
                        System.out.println("---->Wrong input, try again<----");
                    }
                } while (true);
                ParkingSpot parkingSpot = DataBase.checkAvailability();
                parkingSpot.setVehicle(vehicle);
                parkingSpot.setFree(false);
                break;

        } while (true);
    }


    private static void printActions() {
        System.out.println("The available action is: (Press 5 for available action)\n" +
                "0- Quit\n" +
                "1- Add a vehicle\n" +
                "2- Exit from garage\n" +
                "3- Is the garage full or how may spots are available?\n" +
                "4- The available action");
    }
}

