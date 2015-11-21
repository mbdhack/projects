/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

import java.util.regex.Pattern;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author karthik
 */
public class Forest_name_verifier extends InputVerifier {

    @Override
    public boolean verify(JComponent input) {
        String text = ((JTextField) input).getText().trim();
        
        if(text==null)
            return false;
        else
        {
            Pattern pattern = Pattern.compile("^\\p{L}+(?: \\p{L}+)*$");
             if (pattern.matcher(text).matches())
                 return true;
             else
                 return false;
        }
        
    }
    
}
