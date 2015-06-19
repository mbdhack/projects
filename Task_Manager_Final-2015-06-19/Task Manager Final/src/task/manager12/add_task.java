/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task.manager12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author karthik
 */
public class add_task {
     public static void Print_task_into_file(String task_name,TaskBean o)
    {
        PrintWriter pw=null;
        try {
            
            
            
            String pathname="C:\\Users\\karthik\\Desktop\\" + task_name;
            
            
            pw=new PrintWriter(new BufferedWriter(new FileWriter(pathname,true )));
           /* pw.println(o.getTask_name()+":"+o.getDescription()+":"+o.getStatus()+":"
                    + o.getPriority()+":"+o.getCreated_date().toString()+":"+o.getDuedate().toString()+":"+
                    o.getTag_string());*/
            pw.println(o.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
            finally
        {
            pw.close();
        }
    
        
    }
    
    public static boolean valid_tag(String m){
        Scanner p=new Scanner(m);
        p.useDelimiter(",");
        int count=0;
        
                while (p.hasNext()) {
                    //
                    // Get each splited data from the Scanner object and print
                    // the value.
                    //
                    String part = p.next();
                     
                  if(!add_task.name_validate(part))
                  {
                      return false;
                  }
                    
                }                
     
        
               return true;
        
    }
    public static boolean validate_date(String m)
    {
        String[] c=m.split("/");
        int dd=Integer.parseInt(c[0]);
        int mm=Integer.parseInt(c[1]);
        int yyyy=Integer.parseInt(c[2]);
        	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
 
	try {
 
		Date date_entered = formatter.parse(m);
                   
	   //get current date time with Date()
	   
 
	   //get current date time with Calendar()
	   Calendar cal = Calendar.getInstance();
	   Date todays_date=cal.getTime();
           if(date_entered.before(todays_date))
           {
              
               return false;
           }
		
 
	} catch (ParseException e) {
		e.printStackTrace();
	}
        

        
        {
            if((dd<=31 && dd>=1) && (mm>=1 && mm<=12)&& (yyyy>=0000 && yyyy<=9999))
                return true;
            else
                return false;
        } 
       
        
    }
    public static boolean name_validate(String name)
        {
        
		if(name==null || name.trim().equals(""))
			return false;
		if(!Character.isLetter(name.charAt(0)))
				return false;

		
		
		if(name.trim().contains(" "))
			return false;
		
		for(int i = 1 ; i < name.length() ; i++)
		{
			if(!(Character.isLetter(name.charAt(i)) || Character.isDigit(name.charAt(i))))
				return false;
		}
		return true;
        }
              public static   boolean is_directory_in_list(String m)
    {
        BufferedReader f=null;
        File f1=null;
     
        try{
             f1=new File("C:\\Users\\karthik\\Desktop\\directorylist.txt");
            f=new BufferedReader(new FileReader(f1));
            
            String p=null;
            while((p=f.readLine())!=null)
            {
                if(p.equals(m))
                {
                    return true;
                }
            }
        }
        catch(FileNotFoundException e)
        {
            return false;
        }
               
        catch(IOException e)
        {
            e.printStackTrace();
          
            
        }
        finally
        {
            try {
                f.close();
                
            } 
            catch(NullPointerException e)
            {
                return false;
            }
            
            catch (IOException ex) {
               ex.printStackTrace();
            }
        }
        return false;
    }
             public static void add_directory_to_list(String m)
    {
        PrintWriter pw=null;
        
        try {
            
             pw=new PrintWriter(new BufferedWriter(new FileWriter( "C:\\Users\\karthik\\Desktop\\directorylist.txt",true)));
            pw.println(m);
            
            
        
        } catch (IOException ex) {
           ex.printStackTrace();
        } finally {
            pw.close();
        }
    }
              public static  void create_file_for_directory(String s)
    {     try {
        File f=null;
        
        
        String pathname="C:\\Users\\karthik\\Desktop\\" + s ;
        
        f=new File(pathname);
        f.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
      }
                public static boolean  is_task_name_unique(String s,String p)
   {
      Scanner r=null;
        try {
            File f=null;String read1=null; String[] tokens1=null;
            String pathname="C:\\Users\\karthik\\Desktop\\" + p;
            f=new File(pathname);
          
            
            
            
            
            r = new Scanner(new FileReader(f));
            String temp=null;
            while(r.hasNextLine())
            { 
                temp=r.nextLine();
                tokens1= temp.split(":");
                if(s.equals(tokens1[0]))
                {
                    return true;
                    
                }
                
            }
        
        r.close();
        } catch (FileNotFoundException ex) {
           ex.printStackTrace();
        }
        finally
        {
           r.close(); 
        }
     
       return false;
       }

            
        }


