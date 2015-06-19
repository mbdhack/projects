/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package task.manager12;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author karthik Hs
 */
public class TaskBean {
   
    private String description;
   private Date duedate;

   private int priority;
   private String task_name;
   private String status;
   private String tag_string;
   private Date created_date;

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

   
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

   

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTag_string() {
        return tag_string;
    }

    public void setTag_string(String tag_string) {
        this.tag_string = tag_string;
    }

    public TaskBean(String task_name,String description, Date duedate, int priority,  String status, String tag_string, Date created_date) {
        this.description = description;
        this.duedate = duedate;
        this.priority = priority;
        this.task_name = task_name;
        this.status = status;
        this.tag_string = tag_string;
        this.created_date = created_date;
    }
public String toString()
{
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    
		
		
                
   return(task_name+":"+description+":"+ priority+":"+status+":"+tag_string+":"+formatter.format(duedate)+":"+formatter.format(created_date));
               
}
public String outputString()
{
    return("task name= "+task_name+" "+"description= "+description +" "+"priority= "+priority+"\n"
            +" satus= "+status+" tag_string= "+tag_string+" due date= "+duedate +" created date= "+created_date);
}
   
}
