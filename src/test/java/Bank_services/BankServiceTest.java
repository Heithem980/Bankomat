package Bank_services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;

class BankServiceTest {

    private MainBank mainBank;
    private BankService bankService;
    private BankUser bankUser;

    @BeforeAll
    public static void addUsers(){


        BankUser user1 = new BankUser(346577,"John",2311);
        BankUser user2 = new BankUser(964688,"David",6666);
        BankUser user3 = new BankUser(321278,"Matthew",5454);
        BankUser user4 = new BankUser(993344,"Joe",9500);

        BankUser.addUser(user1);
        BankUser.addUser(user2);
        BankUser.addUser(user3);
        BankUser.addUser(user4);

        MainBank userAccount1 = new MainBank(346577,0,false,50000,false);
        MainBank userAccount2 = new MainBank(964688,0,false,1000,false);
        MainBank userAccount3 = new MainBank(321278,0,false,23000,false);
        MainBank userAccount4 = new MainBank(993344,0,false,100,false);

        MainBank.addUserAccount(userAccount1);
        MainBank.addUserAccount(userAccount2);
        MainBank.addUserAccount(userAccount3);
        MainBank.addUserAccount(userAccount4);


    }
    @BeforeEach
    void setUp() {





        mainBank = mock(MainBank.class);

        bankService = new BankService(mainBank, bankUser);

    }

    @Test
    void should_getUser_when_cardProvided(){

        String actual = bankService.getUser(321278);
        String expected = "Matthew";

        assertEquals(expected,actual);
    }

    @Test
    void should_logIn_when_pinCodeIsCorrect(){

        String actual = bankService.logIn(321278, 5454);
        String expected = "Log in successful";

        assertEquals(expected,actual);


    }

    @Test
    void should_addTries_when_pinCodeIsInCorrect(){

        String actual = bankService.logIn(321278, 5451);
        String expected = "You have: 2 tries left";

        assertEquals(expected,actual);


    }
    @Test
    void should_lockAccount_when_pinCodeIsInCorrect3Times(){

        bankService.logIn(321278, 5433);
        bankService.logIn(321278, 5433);
        String actual = bankService.logIn(321278, 5451);
        String expected = "Your account is locked";

        Boolean locked = MainBank.checkIfLocked(321278);

        assertTrue(locked);
        assertEquals(expected,actual);


    }
    // --4  -----------------------------------------------------

    @Test
    void should_getTotalAmount_when_LogInSuccessful(){



        bankService.logIn(993344, 9500);

        int actual = MainBank.getTotal(993344);
        int expected = 100;

        assertEquals(expected,actual);


    }

    
    // --10  ----------------------------------------------------.

    @Test
    void should_confirmBank_when_called(){


        String actual = MainBank.requestBank();

        String expected = "swedbank";

        assertEquals(expected,actual);


    }






}