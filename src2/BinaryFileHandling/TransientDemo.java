package BinaryFileHandling;

import java.io.*;

class User implements Serializable {
    private String username;
    private  String password; // Marked as transient
//    private transient int userID;
    public  Address userAddress;
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}

class Address implements Serializable
{
    String street;
}
public class TransientDemo {
    public static void main(String[] args) {
        User user = new User("Alice", "secret");
        user.userAddress = new Address();
        user.userAddress.street = "my city";

        // Serializing the user object
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("F:/user.dat"))) {
            oos.writeObject(user);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // Deserializing the user object
        User deserializedUser = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("F:/user.dat"))) {
            deserializedUser = (User) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Original User: " + user);
        System.out.println("Deserialized User: " + deserializedUser);

    }
}