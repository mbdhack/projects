package task.manager12;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegexTestHarness {

    public static ArrayList<String> RegexTextHarness(String directory_name,String search_name) throws IOException{
       int count=0;
        BufferedReader br = null; ArrayList<String> list=new ArrayList<String>();
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\karthik\\Desktop\\"+directory_name));
            
            String line=null;
          
             int i=0;
          
            ArrayList<TaskBean> n=creating_java_bean_list.java_bean_list(directory_name,20);
            while ((line=(br.readLine()))!=null) {
                
                Pattern pattern =
                        Pattern.compile(search_name);
                
                Matcher matcher=pattern.matcher(line);;
                
               
                String t=null; 
                while (matcher.find()) {
                    count++;
                    t=(" \nI found the text " +
                            matcher.group()+ " starting at " +
                            " index "+ matcher.start()+ "  and ending at index "+matcher.end()+" in " + " "+ n.get(i).outputString());
                    
                    list.add(t);
                    i++;
                   
                }
                
            }
            
                    
               
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RegexTestHarness.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(RegexTestHarness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
      return list;
    }
}
