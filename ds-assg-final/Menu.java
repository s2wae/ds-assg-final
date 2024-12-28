import java.util.HashMap;
import java.util.Scanner;

public class Menu {


    public HashMap<String, String> user_db = new HashMap<String, String>();
    Scanner sc = new Scanner(System.in);

    public void chooseStartOption(){

        System.out.println("Choose Option Number (-1 to exit)");
        System.out.println("1. Register");
        System.out.println("2. Login");

        String choice = sc.nextLine();
        int choiceInt = Integer.parseInt(choice);
        
        if(choiceInt == -1){
            System.out.println("Exiting...");
            return;
        }

        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        User user = new User(username, password);
        
        switch(choiceInt){
            case 1:
                if(user.checkValidUser(username, user_db) == true){
                    user.addUser(username, password, user_db);
                    System.out.println("Successfully registered!");
                    // Add another method here to go somewhere after registering
                }else{
                    System.out.println("User already exists!");
                }
                chooseStartOption();
                break;
            case 2:
                if(user.checkUserLogin(username, password, user_db) == true){
                    System.out.println("Successful login!");
                    // Add another method here to go somewhere after logging in
                }else{
                    System.out.println("Incorrect username or password!");
                }
                chooseStartOption();
                break;
            default:
                break;
        }
    }


}
