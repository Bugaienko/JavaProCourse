package homework29;

import org.sqlite.JDBC;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Sergii Bugaienko
 */

public class DbHandler {
    private static final String separator = File.separator;
    private static final String mainPath = separator + "JavaProCourse" + separator + "src" + separator + "homework29" + separator;
    private static final String CON_STR = "jdbc:sqlite:" +  mainPath + "db1.db";
    private static DbHandler instance = null;
    private Connection connection;
    public static synchronized DbHandler getInstance() throws SQLException {
        if (instance == null) {
            instance = new DbHandler();
        }
        return instance;
    }

    private DbHandler() {
        try {
            DriverManager.registerDriver(new JDBC());
            this.connection = DriverManager.getConnection(CON_STR);
            System.out.println("Connection done");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        try(Statement statement = this.connection.createStatement())
        {
            List<User> users = new ArrayList<>();
            ResultSet res = statement.executeQuery(
                    "SELECT id, name, pass FROM users"
            );
            while (res.next()) {
                users.add(
                        new User(
                                res.getInt("id"),
                                res.getString("name"),
                                res.getString("pass")
                        )
                );
            }
            return users;

        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public boolean checkUser(String name, String pass) {

        return false;
    }
}
