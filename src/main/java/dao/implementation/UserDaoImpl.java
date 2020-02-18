package dao.implementation;

import dao.interfaces.UserDao;
import entity.User;
import jdbc.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private PreparedStatement ps;
    private ResultSet rs;
    private String[] generateId = {"id"};
    private int id;

    public static void main(String[] args) {
        User user = new User();

        user.setName( "Taras" );
        user.setSurname( "Melnyk" );
        user.setEmail( "qwe1@i.ua" );
        user.setPassword( "1111" );
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.addUser( user );
    }

    public Integer addUser(User user) {
        String sql = "INSERT INTO user ( name, surname, email, password)  VALUES (?,?,?,?)";
        try {
            ps = Database.getConnection().prepareStatement( sql );
            ps.setString( 1, user.getName() );
            ps.setString( 2, user.getSurname() );
            ps.setString( 3, user.getEmail() );
            ps.setString( 4, user.getPassword() );

            ps.execute();

//            if (ps.executeUpdate() != 0) {
//                rs = ps.getGeneratedKeys();
//                if (rs.next()) {
//                    id = rs.getInt( 1 );
//                }
//                return id;
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}