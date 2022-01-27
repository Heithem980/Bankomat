package Bank_services;

public class BankService{
    private MainBank mainBank;
    private BankUser bankUser;

    public BankService(MainBank mainBank, BankUser bankUser) {
        this.mainBank = mainBank;
        this.bankUser = bankUser;
    }



    public String getUser(int id_number) {

        String userName = BankUser.getUserID(id_number);

        return userName;
    }

    public String logIn(int id_number, int pin_code) {

        String success = BankUser.logInIfCorrect(id_number,pin_code);
        return success;
    }



}
