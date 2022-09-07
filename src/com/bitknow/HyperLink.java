/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitknow;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class HyperLink {

    public HyperLink(String url) {
        try {
            Desktop.getDesktop().browse(URI.create(url));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Sentimos muito! Mas houve um erro, o programador disse que essas coisas parece que crescem em árvore" + 
                    "/n" + "Tente novamente ou contate o desenvolvedor");
        }
        
    }
    
}
