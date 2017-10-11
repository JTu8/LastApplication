/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vtkinju
 */


import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

 /**  * Simple table model for displaying properties common to all objects.  * Note that all methods must run inside the event dispatch thread.  */
 public class MyTableModel extends AbstractTableModel {

     public MyTableModel(ArrayList<User> o) {
         for (Object item : o) {
             addObject(item);
         }
     }
   
     private final List<Object> objects = new ArrayList<Object>();

     public void addObject(Object obj) {
         addObject(obj, objects.size());
     }

     public void addObject(Object obj, int index) {
         objects.add(index, obj);
         fireTableRowsInserted(index, index);
     }

     public void removeObject(Object obj) {
         int index = objects.indexOf(obj);
         objects.remove(index);
         fireTableRowsDeleted(index, index);
     }

     public Object getObject(int rowIndex) {
         return objects.get(rowIndex);
     }

     @Override
     public int getRowCount() {
         return objects.size();
     }

     @Override
     public int getColumnCount() {
         return 2;
     }

     @Override
     public String getColumnName(int columnIndex) {
         switch (columnIndex) {
             case 0:
                 return "Name";
             case 1:
                 return "Password";
             default:
                 throw new IndexOutOfBoundsException();
         }
     }

     @Override
     public Class<?> getColumnClass(int columnIndex) {
         switch (columnIndex) {
             case 0:
                 return String.class;
             case 1:
                 return String.class;
             default:
                 throw new IndexOutOfBoundsException();
         }
     }

     @Override
     public Object getValueAt(int rowIndex, int columnIndex) {
         User obj = (User)objects.get(rowIndex);
         switch (columnIndex) {
             case 0:
                 return obj.getName();
             case 1:
                 return obj.getPassword();
             default:
                 throw new IndexOutOfBoundsException();
         }
     }
 }
