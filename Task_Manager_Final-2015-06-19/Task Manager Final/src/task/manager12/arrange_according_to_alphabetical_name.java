/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task.manager12;

import java.util.Comparator;

/**
 *
 * @author karthik
 */
public class arrange_according_to_alphabetical_name implements Comparator<TaskBean>{

    @Override
    public int compare(TaskBean t, TaskBean t1) {
        return(t.getTask_name().compareTo(t1.getTask_name()));
        //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
