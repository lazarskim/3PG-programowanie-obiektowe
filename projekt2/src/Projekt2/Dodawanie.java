package Projekt2;

import java.sql.*;

public class Dodawanie {

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:baza.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insert(String imie, String nazwisko, String przedmiot, String ocena) {
        String sql = "INSERT INTO osoby(imie,nazwisko,przedmiot,ocena) VALUES(?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, imie);
            pstmt.setString(2, nazwisko);
            pstmt.setString(3, przedmiot);
            pstmt.setString(4, ocena);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        Dodawanie app = new Dodawanie();
        // insert three new rows
        app.insert("Jan", "Kowalski", "Matematyka", "4.0");

    }

}