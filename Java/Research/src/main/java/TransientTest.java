import java.io.*;

/**
 * Created by yjw on 18-6-6.
 */
public class TransientTest {
    public static void main(String[] args) {
        User user = new User();
        user.setUsername("husky");
        user.setPasswd("123456");
        System.out.println("read before Serializable:");
        System.out.println("username :" + user.getUsername());
        System.out.println("password:" + user.getPasswd());
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("user.txt"));
            os.writeObject(user);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("user.txt"));
            user = (User) is.readObject();
            is.close();
            System.out.println("read after Serializable:");
            System.out.println("username: " + user.getUsername());
            System.out.println("password:" + user.getPasswd());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
class User implements Serializable {
    private static final long serialVersionUID = 4247442794223186297L;

    private String username;
    private transient  String passwd;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}