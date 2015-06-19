/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task.manager12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author karthik
 */
public class edit_task {
    
    
    public static String recover_entire_line(String pathname,String task_name)
    {
        Scanner m=null;
        try {
            File f=new File(pathname);
             m=new Scanner(f);
            String[] token1=null; String temp=null;
            while(m.hasNextLine())
            {
                temp=m.nextLine();
                token1=temp.split(":");
                if(task_name.equals(token1[0]))
                {
                    return temp;
                }
                
            }
            m.close();
                       
        } catch (FileNotFoundException ex) {
           ex.printStackTrace();
        }
        finally{
             m.close();
            
        }
        return null;
    }
    
    
      public static void removeLineFromFile(String file, String lineToRemove) {
BufferedReader br=null;
PrintWriter pw=null;
    try {

      File inFile = new File(file);

      if (!inFile.isFile()) {
        System.out.println("Parameter is not an existing file");
        return;
      }

      //Construct the new file that will later be renamed to the original filename.
      File tempFile = new File(inFile.getAbsolutePath() + "1");

       br = new BufferedReader(new FileReader(file));
       pw = new PrintWriter(new FileWriter(tempFile));

      String line = null;

      //Read from the original file and write to the new
      //unless content matches data to be removed.
      while ((line = br.readLine()) != null) {

        if (!line.trim().equals(lineToRemove)) {

          pw.println(line);
          pw.flush();
        }
      }
      pw.close();
      br.close();

      //Delete the original file
      if (!inFile.delete()) {
        System.out.println("Could not delete file");
        return;
      }

      //Rename the new file to the filename the original file had.
      if (!tempFile.renameTo(inFile))
        System.out.println("Could not rename file");

    }
    catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
    finally
    {
          pw.close();
    try {
        br.close();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
        
    }
  }
    
}
