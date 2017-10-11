/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Sirpa
 */
public class MyTableModel3 extends AbstractTableModel {
    
    public MyTableModel3 (ArrayList<Reserved> o) {
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
        fireTableRowsInserted(index, index);
        
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
        return 5;
       
    }
    
    
    @Override
    public String getColumnName(int columnIndex) {
        switch(columnIndex) {
            case 0:
                return "UserId";
            case 1:
                return "Start";
            case 2:
                return "Stop";
            case 3:
                return "Description";
            case 4:
                return "Place";
            default:
                throw new IndexOutOfBoundsException();
        }
            
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            default:
                throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Reserved obj = (Reserved) objects.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return obj.getUserId();
            case 1:
                return obj.getStart();
            case 2:
                return obj.getStop();
            case 3:
                return obj.getDescription();
            case 4:
                return obj.getPlace();
            default:
                throw new IndexOutOfBoundsException();
        }
        
    }
}
