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


        DataBase.fillData(); //Initialize Database

        boolean flag = true;

        printMenu(); // Method presents menu


        while (flag) {

            int action;

            do {
                System.out.println("\nEnter the action: ");
                action = Integer.parseInt(scanner.readLine());
                break;
            } while (true);

            switch (action) {
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
                    printMenu();
                    break;
                case 5:
                    flag = false;
                    System.out.println("\n\nApplication closed!");
                    break;
                default:
                    System.out.println("Wrong input...\n");
            }
        }
    }
    //exit garage:remove vehicle
    private static void exitFromGarage() throws IOException {

        String numberPlate;

        do {
            System.out.println("Please enter plate of your vehicle: ");
            numberPlate = scanner.readLine();
            if (Validation.isValidForExit(numberPlate)) {
                break;
            }
        } while (true);

        DataBase.removeVehicle(numberPlate); //remove vehicle

    }
    //enter car or motor
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
                    if (Validation.isValidForEnter(numberPlate)) {
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
                        System.out.println("Wrong input, try 'car' or 'motor'");
                    }
                } while (true);
                ParkingSpot parkingSpot = DataBase.checkAvailability();
                parkingSpot.setVehicle(vehicle);
                parkingSpot.setFree(false);
                break;

        } while (true);
    }

    //method appear menu
    private static void printMenu() {
        System.out.println("\n=========MENU========= \n" +

                "1- Add a vehicle\n" +
                "2- Exit from garage\n" +
                "3- Is the garage full or how may spots are available?\n" +
                "4- The available action\n" +
                "5- Quit\n");
    }
}

