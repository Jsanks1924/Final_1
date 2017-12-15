package sample.model;


        import java.io.*;

/**
 * Created by tkanchanawanchai6403 on 6/30/2016.
 */
public class UserIO {
    public static void writeUsers(Object data) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("users.dat"));
        output.writeObject(data);
    }
    public static Object readUsers() throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("users.dat"));
        return input.readObject();
    }
}