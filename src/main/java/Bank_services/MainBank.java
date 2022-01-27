package Bank_services;

import java.util.ArrayList;


public class MainBank {

    private int id_number;
    private int tries;
    private Boolean locked;
    private Boolean loggedIn;
    private int total;

    public static ArrayList<MainBank> usersAccounts = new ArrayList<MainBank>();


    public MainBank(int id_number, int tries, Boolean locked, int total, Boolean loggedIn) {
        this.id_number = id_number;
        this.tries = tries;
        this.locked = locked;
        this.total = total;
        this.loggedIn = loggedIn;
    }




    public static int addNumberOfTries(int userID) {

        for(MainBank account : usersAccounts){

            if(userID == account.id_number){

                if(account.tries == 3){
                    account.locked = true;
                    return 3;
                }else {
                    account.tries += 1;
                    return 3 - account.tries;
                }
            }


        }

        return 404;
    }

    public static void addUserAccount(MainBank userAccount) {
        usersAccounts.add(userAccount);
    }

    public static Boolean checkIfLocked(int id_number) {

        for(MainBank account : usersAccounts){

            if(account.id_number == id_number) {
                //System.out.print(account.locked);
                return account.locked;

            }

        }


        return false;
    }

    public static void userLoggedIn(int id_number) {

        for(MainBank account : usersAccounts){

            if(account.id_number == id_number){
                account.loggedIn = true;
            }
        }
    }

    public static int getTotal(int id_number) {



        for(MainBank account : usersAccounts){

            if(account.id_number == id_number && account.loggedIn) {
                return account.total;

            }

        }
        return 404;
    }

    public static String requestBank() {



        String bank = "swedbank";

        return bank;
    }
}
