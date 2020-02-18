package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    public static void main(String[] args) {
        getConnection();
    }

    public static Connection getConnection() {
        try  {
            Connection con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/dbname?serverTimezone=Europe/Kiev&allowPublicKeyRetrieval=true",
                            "root","-rCm9NG5_11q");
            System.out.println("Connect");
            return con;
        }
        catch(Exception ex) {
            System.out.println("Database.getConnection() Error -->" + ex.getMessage());
            return null;
        }
    }

    public static void close(Connection con) {
        try  {
            con.close();
        }
        catch(Exception ex) {
        }
    }
}
