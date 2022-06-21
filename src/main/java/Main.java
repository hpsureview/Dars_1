import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner in  = new Scanner(System.in);
        DatabaseService databaseService = new DatabaseService();
        int i=-1;
        while (i!=0){
            System.out.println("0 => Exit, 2 => New User, 3=> Edit User, 4 => List Users");
            i = in.nextInt();
            in = new Scanner(System.in);
            switch (i){
                case 1:
                    System.out.println("Enter firstname");
                    String firstname = in.nextLine();
                    System.out.println("Enter lastname");
                    String lastname = in.nextLine();
                    System.out.println("Enter username");
                    String username = in.nextLine();
                    System.out.println("Enter password");
                    String password = in.nextLine();
                    User user = new User(firstname,lastname,username,password);
                    databaseService.saveUser(user);
                    break;
                case 2:
                    System.out.println("id kiriting");
                    int id1 = in.nextInt();
                    in = new Scanner(System.in);
                    System.out.println("enter firstname");
                    String ism  = in.nextLine();
                    System.out.println("enter lastname");
                    String fam  = in.nextLine();
                    System.out.println("enter username");
                    String log  = in.nextLine();
                    System.out.println("enter password");
                    String pass  = in.nextLine();
                    User user1 = new User(id1,ism,fam,log,pass);
                    databaseService.editUser(user1);
                    break;
                case 3:
                    System.out.println("id kiriting");
                    int id = in.nextInt();
                    databaseService.deleteId(id);
                    break;
                case 4:
                    databaseService.getUser();
                    break;
            }
        }
    }
}
