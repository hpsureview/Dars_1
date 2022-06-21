import java.sql.*;

public class DatabaseService {
    private String url = "jdbc:postgresql://localhost:5432/app_jdbc";
    private String dbuser = "postgres";
    private String password = "b130131112";
    public void saveUser(User user) throws SQLException {

        Connection connection = DriverManager.getConnection(url,dbuser,password);
        Statement statement = connection.createStatement();
        String query = "insert into users(firstname,lastname,username,password) values('"+user.getFirstname()+"','"+user.getLastname()+"','"+user.getUsername()+"','"+user.getPassword()+"') ";
        statement.execute(query);
        System.out.println("User added");
    }

    public void getUser() throws SQLException {
        Connection connection = DriverManager.getConnection(url,dbuser,password);
        Statement statement = connection.createStatement();
        String query = "select * from users";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String firstname = resultSet.getString(2);
            String lastname = resultSet.getString(3);
            String username = resultSet.getString(4);
            String password = resultSet.getString(5);
            User user = new User(id,firstname,lastname,username,password);
           // System.out.println(user.getFirstname()+"  "+user.getLastname()+"  "+user.getUsername()+"  "+user.getPassword());
            System.out.println(user);

        }
    }

    public void deleteId(int userId) throws SQLException {
        Connection connection = DriverManager.getConnection(url,dbuser,password);
        Statement statement = connection.createStatement();
        String query = "delete from users where id = " + userId;
        statement.execute(query);
        System.out.println("O'chirildi");
    }

    public void editUser (User user) throws SQLException {
        Connection connection = DriverManager.getConnection(url,dbuser,password);
        Statement statement = connection.createStatement();
        String query = "update users set ";
        if (!user.getFirstname().isEmpty()){
            query+="firstname='"+user.getFirstname()+"',";
        }
        if (!user.getLastname().isEmpty()){
            query+="lastname='"+user.getLastname()+"',";
        }
        if (!user.getUsername().isEmpty()){
            query+="username='"+user.getUsername()+"',";
        }
        if (!user.getPassword().isEmpty()){
            query+="password='"+user.getPassword()+"'";
        }
        if (!query.equals("update users set ")){
            if (query.endsWith("',")){
                query  = query.substring(0,query.length()-1);
            }
            query+= "where id="+user.getId();
            statement.execute(query);
            System.out.println("User edited");
        }
    }
}
