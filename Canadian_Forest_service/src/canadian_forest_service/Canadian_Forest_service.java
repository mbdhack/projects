/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canadian_forest_service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.objects.NativeMath.round;

/**
 *
 * @author karthik
 */
public class Canadian_Forest_service {

    /**
     * @param args the command line arguments
     */
  private  Forest tempForest;
   

   
    public Canadian_Forest_service(){
        
    }
    

   
    
    public Forest createForest(String name)
    {
        List<Tree> treeList=new ArrayList<Tree>();
        for(int i=1;i<=10;i++)
        {
            Tree t=new Tree(i,getRandomNumberInRange(1.00,5.00),getRandomNumberInRange(55.00,100.00));
            treeList.add(t);
        }
        tempForest=new Forest(treeList,name);
        tempForest.setCreated(true);
        
        return tempForest;
    }
    public  Forest loadForest(String name, Forest tempForest) throws IOException 
    {
        //load to check if forest with name exists
        
        BufferedReader br = null;
        List<Tree> treelist=null;
        
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\karthik\\Desktop\\CanadianForestSimulation\\"+name));
        
        String line = null;
             treelist=new ArrayList<Tree>();
             while ((line = br.readLine()) != null)
             {
                 String[] tokens=line.split(":");
                 int id=Integer.parseInt(tokens[0]);
                 double height=Double.parseDouble(tokens[1]);
                 double percentageGrowth=Double.parseDouble(tokens[2]);
                 Tree t=new Tree(id,height,percentageGrowth);
                 treelist.add(t);
             }
        
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        tempForest.setTreeList(treelist);
        tempForest.setName(name);
        tempForest.setCreated(true);
        return tempForest;
    }
   
   
    
    
    public  int saveForestInFile(Forest tempForest)
    {
        if(tempForest.created==false)
            return 1;
        String pathname="C:\\Users\\karthik\\Desktop\\CanadianForestSimulation\\" + tempForest.getName() ;
        File f=new File(pathname);
        if(f.exists())
            return 2;
        PrintWriter pw=null;
        try {
            
            
            
            String pathname1="C:\\Users\\karthik\\Desktop\\CanadianForestSimulation\\" + tempForest.getName() ;
            
            
            pw=new PrintWriter(new BufferedWriter(new FileWriter(pathname1,true )));
           List<Tree> t= tempForest.getTreeList();
           Iterator<Tree> i=t.iterator();
           while(i.hasNext())
           {
               Tree t1=i.next();
               pw.println(t1.getId()+":"+t1.getHeight()+":"+t1.getPercentGrowth());
               
           }
           
        } catch (IOException ex) {
            ex.printStackTrace();
        }
            finally
        {
            pw.close();
        }
    return 3;
        
    }
    public Forest ReapForest(float max, Forest tempForest)
    {
        List<Tree> t= tempForest.getTreeList();
           Iterator<Tree> i=t.iterator();
           while(i.hasNext())
           {
               Tree t1=i.next();
               //insert code to print previous
               if(t1.getHeight()>max)
               {
                  t1.modify();
               }
               //insert code to print modified
           }
          return tempForest; 
    }
     public Forest simulateForestGrowth(int years,Forest tempForest)
     {
         List<Tree> t= tempForest.getTreeList();
           Iterator<Tree> i=t.iterator();
            while(i.hasNext())
           {
               Tree t1=i.next();
               t1.grow(years);
            
               
           }
            //insert code to print tree
          return tempForest;
     }
    
            
    
    
   public static double getRandomNumberInRange(double min, double max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		
		double randNumber = Math.random() * (max-min) + min;
                return RoundTo2Decimals(randNumber);

	}
    
  public static  double RoundTo2Decimals(double val) {
            DecimalFormat df2 = new DecimalFormat("###.##");
        return Double.valueOf(df2.format(val));
}
    
   
}
