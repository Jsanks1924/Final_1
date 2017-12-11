package sample.model;

import java.util.ArrayList;

public class UserDB {

    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<User> getUsers(){
        return users;
    }
    public static void setUsers(ArrayList<User> users){
        UserDB.users=users;
    }
}
