/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canadian_forest_service;

/**
 *
 * @author karthik
 */
public class Tree {
   private int id;
   private double height;
   private double percentGrowth;

    public Tree(int id, double height, double percentGrowth) {
        this.id = id;
        this.height = height;
        this.percentGrowth = percentGrowth;
    }
    public void modify()
            
    {
        
        height = Canadian_Foreset_service.getRandomNumberInRange(1.00, 5.00);
        percentGrowth=Canadian_Foreset_service.getRandomNumberInRange(55.00, 100.00);
        
        
    }
    public void grow(int years)
    {
        
        for(int i =0;i<years;i++){
        height+=height*(percentGrowth/100);
        height=Canadian_Foreset_service.RoundTo2Decimals(height);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getPercentGrowth() {
        return percentGrowth;
    }

    public void setPercentGrowth(double percentGrowth) {
        this.percentGrowth = percentGrowth;
    }

    
    
}
