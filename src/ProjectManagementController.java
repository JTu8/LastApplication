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



public class ProjectManagementController {
    public Users getUsers() {
        return new UserDAO().getUsers();
    }
    
    public void addUser(String nimi, String salasana, String kuvaus) {
        new UserDAO().addUser(nimi, salasana, kuvaus);
    }
    
    public void deleteUser(String nimi) {
        new UserDAO().deleteUser(nimi);
    }
    
    public Tasks getTasks() {
         return new TaskDAO().getTasks();
     }
    
    public void addTask(String kuvaus, String paikka) {
        new TaskDAO().AddTask(kuvaus, paikka);
    }
    
    
    public void DeleteTask(String start) {
        new TaskDAO().DeleteTasks(start);
    }
    
    public Tasks getUsersTasks(int user_id){
            return new TaskDAO().getTasks("SELECT * FROM task WHERE 1=1 and UserID=" + user_id);
        }
    
    public void moveTask(String description) {
        new ReservedDAO().moveTask(description);
    }
    
    public Reserve getReserved() {
        return new ReservedDAO().getReserved();
    }
    
    public void DeleteReserved(String description) {
        new ReservedDAO().DeleteReserved(description);
    }
    
    public void Start(String description) {
        new ReservedDAO().Start(description);
    }
    
    public void Stop(String description) {
        new ReservedDAO().Stop(description);
    }
    
    public User getUser(String nimi, String salasana) {
        return new UserDAO().getUser(nimi, salasana);
    }
    
    public void updateId(int user_id, int id) {
        new ReservedDAO().updateID(user_id, id);
    }

 
}