package validation;

import database.DataBase;

public class Validation {

    public static boolean isValideForEnter(String plate){

        if (plate.equals("")){
            return false;
        }

        if (DataBase.isExistedPlate(plate)){
            System.out.println("---->This plate is already existed<----\n\n");
            return false;
        }

        return true;
    }

    public static boolean isValideForExit(String plate){

        if (plate.equals("")){
            return false;
        }

        if (!DataBase.isExistedPlate(plate)){
            System.out.println("---->This plate is not existed<----\n\n");
            return false;
        }

        return true;
    }

}
