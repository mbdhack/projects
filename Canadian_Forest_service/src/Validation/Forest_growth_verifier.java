/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author karthik
 */
public class Forest_growth_verifier extends InputVerifier {

    @Override
    public boolean verify(JComponent input) {
         String text = ((JTextField) input).getText();
        if(text==null)
            return false;
        else
        return text.matches("^\\s*(?=.*[1-9])\\d*(?:\\.\\d{1,2})?\\s*$");
    }
    
}
