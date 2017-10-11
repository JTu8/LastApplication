/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author htmjs
 */
public class CurrentUser {
    private static CurrentUser instance;
    
    private String currentUserId;
    
    CurrentUser() {
        currentUserId = null;
    }
    
    public static CurrentUser instance() {
        if (instance == null) {
            instance = new CurrentUser(); 
        }
        
        return instance;
    }
    
    public boolean isLoggedIn() {
        return currentUserId != null;
    }
    
    public String getCurrentUser() {
        return currentUserId == null ? "<none>" : currentUserId;
    }
    
    public void loginAs(String user_id) {
        currentUserId = user_id;
    }
}
