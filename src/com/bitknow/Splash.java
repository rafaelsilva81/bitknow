/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitknow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

/**
 *
 * @author Rafael
 */
public class Splash {
    private final int LARGURA_IMG = 420;
    private final int ALTURA_IMG = 250;
    private final int TEMPO_DE_SPLASH = 2500;
    
    public Splash() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
        JLabel j = new JLabel(" ", new ImageIcon(getClass().getResource("/com/bitknow/resources/SplashArtIcon.png")), SwingConstants.CENTER);
        j.setOpaque(false);
        JWindow janelaSplash = new JWindow();
        janelaSplash.getContentPane().add(j);
        
   Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension dimension = toolkit.getScreenSize();
    
    janelaSplash.setBounds(
            (dimension.width - LARGURA_IMG) / 2,
            (dimension.height - ALTURA_IMG) / 2,
            LARGURA_IMG,
            ALTURA_IMG );
    janelaSplash.setAlwaysOnTop(true);
    janelaSplash.setBackground(new Color(0,0,0,0));
    janelaSplash.setVisible(true);
    
    try {
        Thread.sleep(TEMPO_DE_SPLASH);
    }catch (InterruptedException e) {
        e.printStackTrace();
    } janelaSplash.dispose();
            }
        });
        t.start();
    }
    
 
}
