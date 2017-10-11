/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.text.SimpleDateFormat;
/**
 *
 * @author Sirpa
 */
public class ReservedDAO {
    
        public Reserve moveTask(String description) { //siirtää rivin Task taulusta Reserved tauluun
            Reserve urs = new Reserve();
            Reserved r;
            Connection connect = null;
            
            try {
            String url = "jdbc:mysql://localhost/javaharjoitustyö";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(url, "root", "");
            if (!connect.isClosed()) {
                System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
            }
            Statement stmt = connect.createStatement();
            int rs = stmt.executeUpdate("INSERT INTO Reserved(UserID, Start ,Stop, Description, Place) (SELECT UserID, Start ,Stop, Description, Place FROM Task WHERE Description = '" + description + "') ");
            int rs2 = stmt.executeUpdate("DELETE FROM Task WHERE Description = '" + description + "'");
            //int rs3 = stmt.executeUpdate("UPDATE Reserved SET UserID='" + user_id + "' WHERE ID = '" + id + "'");
           
      
        }
        catch (Exception ex) {
             System.err.println("Exception: " + ex.getMessage());
         } finally {
             try {
                 if (connect != null) {
                     connect.close();
                 }
             } catch (SQLException e) {
                 //---------------------------
             }

         }
            
            return urs;
        }
        
        public Reserve updateID(int user_id, int id) {
            Reserve urs = new Reserve();
            Reserved r;
            Connection connect = null;
            
            try {
                String url = "jdbc:mysql://localhost/javaharjoitustyö";
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                connect = DriverManager.getConnection(url, "root", "");
                if (!connect.isClosed()) {
                    System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
                }
                Statement stmt = connect.createStatement();
                int rs = stmt.executeUpdate("UPDATE Reserved SET UserID='" + user_id + "' WHERE ID = '" + id + "'");
            }
            catch (Exception ex) {
                System.err.println("Exception: " + ex.getMessage());
         } finally {
             try {
                 if (connect != null) {
                     connect.close();
                 }
             } catch (SQLException e) {
                 //---------------------------
             }

            }
            
            return urs;
        }
        
        public Reserve getReserved() { // Hakee Reserved taulusta tiedot
            Reserve urs = new Reserve();
            Reserved r;
            Connection connect = null;
            
            try {
             String url = "jdbc:mysql://localhost/javaharjoitustyö";
              //String url = "jdbc:mysql://localhost/java";
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             connect = DriverManager.getConnection(url, "root", "");
             //connect = DriverManager.getConnection(url, "root", "");
             if (!connect.isClosed()) {
                 System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
             }
             Statement stmt = connect.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM reserved");
             while (rs.next()) {
                 r = new Reserved();
                 //Start, Stop, Description,Explanation,Lon,Lat,Place
                 r.setId(rs.getInt("ID"));
                 r.setUserId(rs.getInt("UserID"));
                 r.setStart(rs.getString("Start"));
                 r.setStop(rs.getString("Stop"));
                 r.setDescription(rs.getString("Description"));
                 //t.setExplanation(rs.getString("Explanation"));
                 //t.setLon(rs.getString("Lon"));
                 //t.setLat(rs.getString("Lat"));
                 r.setPlace(rs.getString("Place"));
                 urs.add(r);
                 //rs = stmt.executeQuery("SELECT UserID FROM user");

             }
         }
         catch (Exception ex) {
             System.err.println("Exception: " + ex.getMessage());
         } finally {
             try {
                 if (connect != null) {
                     connect.close();
                 }
             } catch (SQLException e) {
                 //---------------------------
             }

         }
            
            return urs;
        }
        
      
    
    public Reserve DeleteReserved(String description) { // Poistaa rivin Reserved taulusta
        Reserve urs = new Reserve();
        Reserved r;
        Connection connect = null;
        
        try {
            String url = "jdbc:mysql://localhost/javaharjoitustyö";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(url, "root", "");
            if (!connect.isClosed()) {
                System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
            }
            Statement stmt = connect.createStatement();
            int rs = stmt.executeUpdate("DELETE FROM Reserved WHERE Description = '" + description + "'");
            
            
            
        }
        catch (Exception ex) {
             System.err.println("Exception: " + ex.getMessage());
         } finally {
             try {
                 if (connect != null) {
                     connect.close();
                 }
             } catch (SQLException e) {
                 //---------------------------
             }

         }
        
        return urs;
    }
    
    public Reserve Start(String description) {
        Reserve urs = new Reserve();
        Task t;
        Connection connect = null;
        String aloitus = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        
        try {
            String url = "jdbc:mysql://localhost/javaharjoitustyö";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(url, "root", "");
            if (!connect.isClosed()) {
                System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
            }
            Statement stmt = connect.createStatement();
            int rs = stmt.executeUpdate("UPDATE Reserved SET Start = '" + aloitus + "'WHERE Description = '" + description + "'");
        }
        catch(Exception ex) {
            
        }
        
        return urs;
    }
    
    public Reserve Stop(String description) { //Asettaa lopetus ajan tehtävälle
        Reserve urs = new Reserve();
        Reserved r;
        Connection connect = null;
        String lopetus = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        
        try {
            String url = "jdbc:mysql://localhost/javaharjoitustyö";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(url, "root", "");
            if (!connect.isClosed()) {
                System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
            }
            Statement stmt = connect.createStatement();
            int rs = stmt.executeUpdate("UPDATE Reserved SET Stop = '" + lopetus + "'WHERE Description = '" + description + "'");
        }
        catch (Exception ex) {
            System.err.println("Exception: " + ex.getMessage());
        } finally {
            try {
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                
            }
        }
        
        return urs;
    }
}
