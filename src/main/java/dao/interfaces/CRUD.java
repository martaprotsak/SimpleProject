package dao.interfaces;

import java.sql.SQLException;

public interface CRUD <T> {

    void create(T t) throws SQLException;

    T read (int id) throws SQLException;

    void update(T t) throws SQLException;

    void delete(T t) throws SQLException;
}
