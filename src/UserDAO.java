/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vtkinju
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.*;

/**
*
* @author vtkinju
*/
public class UserDAO {

    public Users getUsers() {
        Users urs = new Users();
        User u;
        Connection connect = null;
            
        try {
            String url = "jdbc:mysql://localhost/javaharjoitustyö";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(url, "root", "");
            if (!connect.isClosed()) {
                System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
            }
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user");
            while (rs.next()) {
                u = new User();
                u.setId(rs.getInt("ID"));
                String name = rs.getString("Name");
                u.setPassword(rs.getString("Password"));
                u.setDescription(rs.getString("Name"));
                u.setName(name); 
                urs.add(u);
                System.out.println("User's name was " + name);

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
    
    public User getUser(String nimi, String salasana) {
        User urs = new User();
        User u;
        Connection connect = null;
        
        try {
            String url = "jdbc:mysql://localhost/javaharjoitustyö";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(url, "root", "");
            if (!connect.isClosed()) {
                System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
            }
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM User WHERE Name LIKE '" + nimi + "' AND Password LIKE '" + salasana + "'");
            while (rs.next()) {
                urs.setId(rs.getInt("ID"));
                String name = rs.getString("Name");
                urs.setPassword(rs.getString("Password"));
                urs.setDescription(rs.getString("Description"));
                urs.setName(name);
            }
        }
        catch(Exception ex) {
            System.err.println("Exception: " + ex.getMessage());
        } finally {
            try {
                if (connect != null) {
                    connect.close();
                }
            }
            catch (SQLException e) {
                
            }
        }
        
        
        return urs;
        
    }
    
    public Users addUser(String nimi, String salasana, String kuvaus) {
        Users urs = new Users();
        User u;
        Connection connect = null;
            
        try {
            String url = "jdbc:mysql://localhost/javaharjoitustyö";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(url, "root", "");
            if (!connect.isClosed()) {
                System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
            }
            Statement stmt = connect.createStatement();
            int rs = stmt.executeUpdate("INSERT INTO User (Name, Password, Description) VALUES ('" + nimi + "','" + salasana + "','" + kuvaus + "')");
            
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
    
    public void deleteUser(String nimi) {
        Connection connect = null;
        
        try {
            String url = "jdbc:mysql://localhost/javaharjoitustyö";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(url, "root", "");
            if (!connect.isClosed()) {
                System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
            }
            Statement stmt = connect.createStatement();
            stmt.executeUpdate("DELETE FROM user WHERE name LIKE '" + nimi + "';");

        } catch (Exception ex) {
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
    }
}
