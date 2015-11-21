/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canadian_forest_service;

import java.util.List;

/**
 *
 * @author karthik
 */
public class Forest {
    private List<Tree> treeList;
    private String name;

    public Forest(List<Tree> treeList, String name) {
        this.treeList = treeList;
        this.name = name;
    }
    
    

    public List<Tree> getTreeList() {
        return treeList;
    }

    public void setTreeList(List<Tree> treeList) {
        this.treeList = treeList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
     
    
}
