package Projekt2;

import java.sql.*;

public class Tworzenie {

    /**
     * Create a new table in the test database
     *
     */
    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:baza.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE osoby (\n"
                + "	id int PRIMARY KEY,\n"
                + "	imie varchar,\n"
                + "	nazwisko varchar, \n"
                + "	przedmiot varchar, \n"
                + "	ocena double \n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createNewTable();
    }

}