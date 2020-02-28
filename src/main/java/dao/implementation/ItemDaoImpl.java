package dao.implementation;

import dao.interfaces.ItemDao;
import entity.Item;
import jdbc.Database;

import java.sql.*;

public class ItemDaoImpl implements ItemDao {

    private Connection connection;

    public ItemDaoImpl() {
        connection = Database.getConnection();
    }

    public static void main(String[] args) throws SQLException {
        Item item = new Item();
        ItemDaoImpl itemDao = new ItemDaoImpl();
//        item.setIdList(1);
//        item.setText("milk");
//        item.setCreateDate(LocalDate.now());
//        item.setDone(false);
 //       itemDao.create(item);
          item = itemDao.read(2);
        System.out.println(item.toString());
    }

    @Override
    public void create(Item item) throws SQLException {
        String query = "INSERT INTO item (idlist, text, createdate, isdone) VALUES (?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        prepareStatement(item, statement);
        statement.execute();

        statement.close();
    }

    @Override
    public Item read(int id) throws SQLException {
        String query = "SELECT id, idList, text, createDate, isDone FROM item WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        Item item = new Item();

        ResultSet set = statement.executeQuery();
        if (set.next()) {
            setItem(item, set);
        }

        set.close();
        statement.close();
        return item;
    }

    @Override
    public void update(Item item) throws SQLException {
        String query = "UPDATE item SET idList=?, text=?, createDate=?, isdone=?  WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        prepareStatement(item, statement);
        statement.setInt(5, item.getId());
        statement.execute();

        statement.close();
    }

    @Override
    public void delete(Item item) throws SQLException {
        String query = "DELETE FROM item WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, item.getId());
        statement.execute();

        statement.close();
    }

    private void setItem(Item item, ResultSet set) throws SQLException {
        item.setId(set.getInt("id"));
        item.setIdList(set.getInt("idList"));
        item.setText(set.getString("text"));
        item.setCreateDate(set.getDate("createDate").toLocalDate());
        item.setDone(set.getBoolean("isDone"));
    }


    private void prepareStatement(Item item, PreparedStatement statement) throws SQLException {
        statement.setInt(1, item.getIdList());
        statement.setString(2, item.getText());
        statement.setDate(3, Date.valueOf(item.getCreateDate()));
        statement.setBoolean(4, item.getDone());
    }
}
