/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task.manager12;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


/**
 *
 * @author karthik
 */
public class search_across_all {
    public static ArrayList<list_and_name_bean> search_across_all(String m) throws IOException
    {
       ArrayList<list_and_name_bean> r0=new ArrayList<list_and_name_bean>();
        ArrayList<String> r5=list_all_categories.list_all_categories();
       Iterator<String> m8=r5.iterator();
      
       while(m8.hasNext())
       {
         String j2 =  m8.next();
            list_and_name_bean g3=new list_and_name_bean();
           g3.setCategory_name(j2);
           g3.setList(RegexTestHarness.RegexTextHarness(j2, m));
           r0.add(g3);
          
           
       }
       return r0; 
    }
    
}
