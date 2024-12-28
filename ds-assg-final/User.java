import java.util.HashMap;

public class User {


    public String username, password;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public boolean checkValidUser(String username, HashMap<String, String> user_db){
        if(user_db.containsKey(username)){
            return false;
        }
        return true;
    }

    public boolean checkUserLogin(String username, String password, HashMap<String, String> user_db){

        if(!user_db.containsKey(username) || user_db.get(username) == null){
            return false;
        }

        if((!password.equals(user_db.get(username)))){
            return false;
        }

        return true;
    }

    public HashMap<String, String> addUser(String username, String password, HashMap<String, String> user_db){
        HashMap<String, String> temp_map = user_db;
        temp_map.put(username, password);
        return temp_map;
    }


    public void showUserDetails(){
        System.out.print("Account Username: " + username);
    }
}
