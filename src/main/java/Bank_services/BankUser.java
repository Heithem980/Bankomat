package Bank_services;

import java.util.ArrayList;

public class BankUser {

    private int id_number;
    private String name;
    private int pin_code;

    public static ArrayList<BankUser> users = new ArrayList<BankUser>();

    public BankUser(int id_number, String name,int pin_code) {
        this.id_number = id_number;
        this.name = name;
        this.pin_code = pin_code;
    }

    public static String getUserID(int id_number) {

        for(BankUser user : users){

            if(id_number == user.id_number){
                return user.name;
            }

        }

        return "User not found";
    }

    public static void addUser(BankUser user) {

        users.add(user);
    }

    public static String logInIfCorrect(int id_number, int pin_code) {

        Boolean locked = MainBank.checkIfLocked(id_number);

        if(!locked) {

            for (BankUser user : users) {

                if (id_number == user.id_number) {

                    if (user.pin_code == pin_code) {

                        MainBank.userLoggedIn(id_number);
                        return "Log in successful";
                    } else {
                        int tries = MainBank.addNumberOfTries(user.id_number);

                        if (tries < 3 && tries > 0) {
                            return "You have: " + tries + " tries left";
                        } else {
                            return "Your account is locked";
                        }
                    }
                }

            }
        }else{
            return "Your account is locked";
        }

        return "Failed to log in";
    }
}
