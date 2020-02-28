package dao.implementation;

import dao.interfaces.UserDao;
import entity.User;
import jdbc.Database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private PreparedStatement ps;

    public static void main(String[] args) {
        User user = new User();

        user.setName("Пантелеймон");
        user.setSurname("Куліш");
        user.setEmail("qwe1@i.ua");
        user.setPassword("1111");
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.create(user);
    }

    @Override
    public void create(User user) {
        String sql = "INSERT INTO user (name, surname, email, password)  VALUES (?,?,?,?)";
        try {
            ps = Database.getConnection().prepareStatement( sql );
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User read(int id) {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }
}