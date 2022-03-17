
package Projekt2;

import java.sql.*;

public class Polaczenie {

    public static void testCanConnect() {
        Connection conn = null;
        Statement stmt = null;

        try {

            String url = "jdbc:sqlite:baza.db";

            conn = DriverManager.getConnection(url);

            System.out.println("Połączenie udane.");

            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT *  FROM osoby;");

            while (rs.next()) {

                String imie = rs.getString("imie");
                String nazwisko = rs.getString("nazwisko");
                String przedmiot = rs.getString("przedmiot");
                String ocena = rs.getString("ocena");
                System.out.println(String.format("Znalezione rekordy: "));
                System.out.println(String.format("%s", imie));
                System.out.println(String.format("%s", nazwisko));
                System.out.println(String.format("%s", przedmiot));
                System.out.println(String.format("%s", ocena));
            }

            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        testCanConnect();
    }
}