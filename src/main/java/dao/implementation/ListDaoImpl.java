package dao.implementation;

import dao.interfaces.ListDao;
import entity.List;
import jdbc.Database;

import java.sql.*;

public class ListDaoImpl implements ListDao {

    private Connection connection;

    public ListDaoImpl() {
        connection = Database.getConnection();
    }

    public static void main(String[] args) {
        List list = new List();
    }

    @Override
    public void create(List list) throws SQLException {
        String query = "INSERT INTO list (idUser, name, createDate, isDone ) VALUES (?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        prepareStatement(list, statement);
        statement.execute();

        statement.close();
    }

    @Override
    public List read(int id) throws SQLException {
        String query = "SELECT idList, idUser, name, createDate, isDone FROM list WHERE idList=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        List list = new List();

        ResultSet set = statement.executeQuery();
        if (set.next()) {
            setList(list, set);
        }

        set.close();
        statement.close();
        return list;
    }

    @Override
    public void update(List list) throws SQLException {
        String query = "UPDATE list SET idUser=?, name=?, createDate=?, isDone=?  WHERE idList=?";
        PreparedStatement statement = connection.prepareStatement(query);
        prepareStatement(list, statement);
        statement.setInt(5, list.getId());
        statement.execute();

        statement.close();
    }

    @Override
    public void delete(List list) throws SQLException {
        String query = "DELETE FROM list WHERE idList=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, list.getId());
        statement.execute();

        statement.close();
    }

    private void prepareStatement(List list, PreparedStatement statement) throws SQLException {
        statement.setInt(1, list.getIdUser());
        statement.setString(2, list.getName());
        statement.setDate(3, Date.valueOf(list.getCreateDate()));
        statement.setBoolean(4, list.getDone());
    }

    private void setList(List list, ResultSet set) throws SQLException {
        list.setId(set.getInt("id"));
        list.setIdUser(set.getInt("idUser"));
        list.setName(set.getString("name"));
        list.setCreateDate(set.getDate("createDate").toLocalDate());
        list.setDone(set.getBoolean("isDone"));
    }
}
