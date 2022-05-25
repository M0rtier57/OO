package Datalaag;

import logica.DVD;
import logica.Genre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Datalaag {
    private String dbName;
    private final String login = "root";
    private final String pass = "Azerty123";
    private Connection con;

    public String getDbName() {
        return dbName;
    }

    public Datalaag(String dbName, boolean alternative) {
        this.dbName = dbName;
        if (alternative) {
            makeConnectionAlternative();
        } else {
            makeConnection();
        }
    }

    private void makeConnection() {
        try {
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
                    + dbName + "?serverTimezone=UTC&allowMultiQueries=true", login, pass);

        } catch (SQLException ex) {
            Logger.getLogger(Datalaag.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void makeConnectionAlternative() {
        try {
            Properties connectionProps = new Properties();
            connectionProps.setProperty("user", this.login);
            connectionProps.setProperty("password", this.pass);
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
                    + dbName + "?serverTimezone=UTC&allowMultiQueries=true", connectionProps);
        } catch (SQLException ex) {
            Logger.getLogger(Datalaag.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<DVD> geefDVDLijst() throws SQLException {
        Statement stmt = null;
        List<DVD> DVDS = null;

        try {
            stmt = this.con.createStatement();
            //createStudentenDB(stmt);
            ResultSet rs = stmt.executeQuery("SELECT id,titel, genre, jaar,regisseur FROM dvdinfo");
            DVDS = new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt(1);
                String titel = rs.getString(2);
                Genre genre = Genre.valueOf(rs.getString(3));
                int jaar = rs.getInt(4);
                String regisseur = rs.getString(6);
                DVD DVD = new DVD(titel, genre, jaar, regisseur);
                DVDS.add(DVD);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Datalaag.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return DVDS;
    }

}
