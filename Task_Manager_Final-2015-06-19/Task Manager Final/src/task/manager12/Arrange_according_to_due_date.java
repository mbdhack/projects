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
public class Arrange_according_to_due_date implements Comparator<TaskBean> {
    
    public int compare(TaskBean a,TaskBean b)
    {
        return(a.getDuedate().compareTo(b.getDuedate()));
        
    }
    
}
