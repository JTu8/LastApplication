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
 * @author s698941
 */
public class TaskDAO {
    
    public Tasks AddTask(String kuvaus, String paikka) { //Lisää uuden tehtävän
        Tasks urs = new Tasks();
        Task t;
        Connection connect = null;
        //aloitus = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        
        try {
            String url = "jdbc:mysql://localhost/javaharjoitustyö";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(url, "root", "");
            if (!connect.isClosed()) {
                System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
            }
            Statement stmt = connect.createStatement();
            int rs = stmt.executeUpdate("INSERT INTO Task (Description, Place) VALUES ('" + kuvaus +  "','" + paikka  +  "')");
            
            
            
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
    
    
    
    public Tasks updateID(int user_id, int id) {
            Tasks urs = new Tasks();
            Task r;
            Connection connect = null;
            
            try {
                String url = "jdbc:mysql://localhost/javaharjoitustyö";
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                connect = DriverManager.getConnection(url, "root", "");
                if (!connect.isClosed()) {
                    System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
                }
                Statement stmt = connect.createStatement();
                int rs = stmt.executeUpdate("UPDATE Task SET UserID='" + user_id + "' WHERE ID = '" + id + "'");
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
    
    public Tasks DeleteTasks(String kuvaus) {
        Tasks urs = new Tasks();
        Task t;
        Connection connect = null;
        
        try {
            String url = "jdbc:mysql://localhost/javaharjoitustyö";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(url, "root", "");
            if (!connect.isClosed()) {
                System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
            }
            Statement stmt = connect.createStatement();
            int rs = stmt.executeUpdate("DELETE FROM task WHERE Description LIKE '" + kuvaus + "';");
            
            
            
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
    
  

     public Tasks getTasks() { // Hakee kaikki tehtävät
         Tasks urs = new Tasks();
         Task t;
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
             ResultSet rs = stmt.executeQuery("SELECT * FROM task");
             while (rs.next()) {
                 t = new Task();
                 //Start, Stop, Description,Explanation,Lon,Lat,Place
                 t.setId(rs.getInt("ID"));
                 t.setUserId(rs.getInt("UserID"));
                 t.setStart(rs.getString("Start"));
                 t.setStop(rs.getString("Stop"));
                 t.setDescription(rs.getString("Description"));
                 //t.setExplanation(rs.getString("Explanation"));
                 //t.setLon(rs.getString("Lon"));
                 //t.setLat(rs.getString("Lat"));
                 t.setPlace(rs.getString("Place"));
                 urs.add(t);
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

    Tasks getTasks(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
 }