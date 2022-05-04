package postorder.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import postorder.logica.Artikel;

/**
 *
 * @author evertjan.jacobs
 */
public class DataLayerJDBC {

    private final String dbUrl = "jdbc:mysql://localhost:3306/";
    private final String login = "root";
    private final String pass = "Azerty123";
    private final Connection con;

    public DataLayerJDBC(String dbName) throws SQLException {
        createDatabase(dbName);
        this.con = getConnection(dbName);
        this.con.setAutoCommit(false);
    }

    private void createDatabase(String dbName) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //create database
            conn = getConnection("");
            stmt = conn.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS " + dbName;
            stmt.executeUpdate(sql);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }

            try {
                if (conn != null) {

                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    private Connection getConnection(String dbName) throws SQLException {
        Connection conn = DriverManager.getConnection(dbUrl + dbName + "?serverTimezone=UTC&allowMultiQueries=true", login, pass);
        return conn;
    }

    public void closeConnection() throws SQLException {
        this.con.close();
    }

    public List<Integer> geefBestellingenGeleverdBinnen7Dagen() {
                List<Integer> bestellingen = new ArrayList<>();
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Configuratie.QUERY_LEVERING_IN_MINDER_DAN_7_DAGEN);
            while (rs.next()) {
                bestellingen.add(rs.getInt(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataLayerJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataLayerJDBC.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return bestellingen;
    
    }
    
    public List<Calendar> geefDatumsGeleverdInGent() {
        List<Calendar> datums = new ArrayList<>();
        Statement stmt = null;
        Calendar calendar;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Configuratie.QUERY_DATA_LEVERING_KLANTEN_GENT);
            while (rs.next()) {
                Date datum = rs.getDate(1);
                calendar = Calendar.getInstance();
                calendar.setTime(datum);
                datums.add(calendar);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataLayerJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataLayerJDBC.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return datums;
    }

    public List<Artikel> geefArtikelenMinsten4xBesteld() {
        List<Artikel> artikelen = new ArrayList<>();
        Statement stmt = null;

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Configuratie.QUERY_ARTIKELEN_MIN_4_BESTELD_VERSPREID_OVER_MEERDERE_LEVERINGEN);
            while (rs.next()) {
                int artikelId = rs.getInt(1);
                String beschrijving = rs.getString(2);
                Artikel artikel = new Artikel(artikelId, beschrijving);
                artikelen.add(artikel);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataLayerJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataLayerJDBC.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return artikelen;
    }

    public LinkedHashMap<Integer, Double> geefDuursteArtikelPerBestelling() {
        LinkedHashMap<Integer, Double> duursteArtikelPerBestelling = new LinkedHashMap<>();

        Statement stmt = null;

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Configuratie.QUERY_DUURSTE_ARTIKEL_PER_BESTELLING);
            while (rs.next()) {
                int bestelling = rs.getInt(1);
                double prijs = rs.getDouble(2);
                duursteArtikelPerBestelling.put(bestelling, prijs);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataLayerJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataLayerJDBC.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return duursteArtikelPerBestelling;
    }

    public double geefTotaleFactuurprijs() {
        double som = 0;
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Configuratie.QUERY_TOTALE_PRIJS_BESTELLING_1);
            if (rs.next()) {
                som = rs.getDouble(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataLayerJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataLayerJDBC.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return som;
    }

    public int getValue(String query) {
        int aantal = -1;
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                aantal = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataLayerJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataLayerJDBC.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return aantal;
    }

}
