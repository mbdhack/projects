/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task.manager12;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author karthik
 */
public class list_all_categories {
    public static ArrayList<String> list_all_categories() throws IOException
    {
         ArrayList<String> m=null;
        BufferedReader br=null;
        try {
            m=new ArrayList<String>();
            br = new BufferedReader(new FileReader(new File("C:\\Users\\karthik\\Desktop\\directorylist.txt")));
            String line=null;
            while((line=br.readLine())!=null)
            {
                m.add(line);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            
            
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
               
              ex.printStackTrace();
            }
        }
        return m;
    }
    
}
