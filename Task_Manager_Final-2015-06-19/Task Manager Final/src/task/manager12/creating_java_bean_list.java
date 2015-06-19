/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task.manager12;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author karthik
 */

public class creating_java_bean_list {
    public static ArrayList<TaskBean> java_bean_list( String directory_name, int case_num) 
    {
        BufferedReader br = null;
        ArrayList<TaskBean> f=null;
      
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\karthik\\Desktop\\"+directory_name));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(creating_java_bean_list.class.getName()).log(Level.SEVERE, null, ex);
        }
            String line = null;
             f=new ArrayList<TaskBean>();
           
        try {
            // if no more lines the readLine() returns null
            while ((line = br.readLine()) != null) {
                // reading lines until the end of the file
                String[] tokens=line.split(":");
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date due_date = null;
                
                try {
                    due_date = formatter.parse(tokens[5]);
                } catch (ParseException ex) {
                    Logger.getLogger(creating_java_bean_list.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                Date created_date=null;
                
                try {
                    created_date=formatter.parse(tokens[6]);
                } catch (ParseException ex) {
                    Logger.getLogger(creating_java_bean_list.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                TaskBean m=new TaskBean(tokens[0],tokens[1],due_date,Integer.parseInt(tokens[2]),tokens[3],tokens[4],created_date);
                f.add(m);
                
                
            }
        } catch (IOException ex) {
            Logger.getLogger(creating_java_bean_list.class.getName()).log(Level.SEVERE, null, ex);
        }
        
           if(case_num==20)
           return f;

           if(case_num==1){
           Collections.sort(f,new arrange_according_to_alphabetical_name());
           return f;}
           if(case_num==2){
           Collections.sort(f,new Arrange_according_to_priority());
           return f;
           }
           if(case_num==3){
               Collections.sort(f,new Arrange_according_to_due_date());
           return f;
           }
           if(case_num==4)
           {
               Collections.sort(f,new Arrange_according_to_created_date());
           return f;
           }
            return null;
    }
    
    
    
}
