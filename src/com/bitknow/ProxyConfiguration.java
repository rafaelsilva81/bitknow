/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitknow;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

public class ProxyConfiguration extends javax.swing.JFrame {
    public int x;
    public int y;
   public MainApp m = new MainApp(false);
    public ProxyConfiguration() {
        setIcon();
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        enter();
    }
    public void enter() {
              JPanel h = new JPanel();
        h.setSize(1280,30);
        h.setLocation(0, 0);
        h.setVisible(true);

        h.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        h.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                setLocation(getX() + e.getX() - x,getY() + e.getY() - y);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });
        add(h);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JPanel();
        MenuTop = new javax.swing.JPanel();
        MenuClose = new javax.swing.JLabel();
        Config = new javax.swing.JLabel();
        proxyPortTxt = new javax.swing.JTextField();
        Port = new javax.swing.JLabel();
        proxyServerTxt = new javax.swing.JTextField();
        TwoPoints = new javax.swing.JLabel();
        Host = new javax.swing.JLabel();
        Auth = new javax.swing.JLabel();
        Password = new javax.swing.JLabel();
        User = new javax.swing.JLabel();
        proxyPasswordTxt = new javax.swing.JTextField();
        proxyUserTxt = new javax.swing.JTextField();
        AuthOBS = new javax.swing.JLabel();
        Confirm = new javax.swing.JButton();
        ProxyBG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Menu.setBackground(new java.awt.Color(35, 39, 42));
        Menu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        MenuTop.setBackground(new java.awt.Color(255, 255, 255));
        MenuTop.setPreferredSize(new java.awt.Dimension(188, 30));

        MenuClose.setBackground(new java.awt.Color(255, 255, 255));
        MenuClose.setFont(new java.awt.Font("Oswald", 0, 24)); // NOI18N
        MenuClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuClose.setText("X");
        MenuClose.setMaximumSize(new java.awt.Dimension(15, 30));
        MenuClose.setMinimumSize(new java.awt.Dimension(15, 30));
        MenuClose.setPreferredSize(new java.awt.Dimension(15, 30));
        MenuClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuCloseMouseExited(evt);
            }
        });

        javax.swing.GroupLayout MenuTopLayout = new javax.swing.GroupLayout(MenuTop);
        MenuTop.setLayout(MenuTopLayout);
        MenuTopLayout.setHorizontalGroup(
            MenuTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuTopLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(MenuClose, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        MenuTopLayout.setVerticalGroup(
            MenuTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuClose, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Config.setFont(new java.awt.Font("Segoe UI Light", 0, 65)); // NOI18N
        Config.setForeground(new java.awt.Color(255, 255, 255));
        Config.setText("Configuração do Servidor Proxy");

        proxyPortTxt.setFont(new java.awt.Font("Segoe UI Semilight", 0, 46)); // NOI18N

        Port.setFont(new java.awt.Font("Segoe UI Light", 0, 52)); // NOI18N
        Port.setForeground(new java.awt.Color(255, 255, 255));
        Port.setText("Porta :");

        proxyServerTxt.setFont(new java.awt.Font("Segoe UI Semilight", 0, 46)); // NOI18N

        TwoPoints.setFont(new java.awt.Font("Segoe UI Semibold", 0, 100)); // NOI18N
        TwoPoints.setForeground(new java.awt.Color(255, 255, 255));
        TwoPoints.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TwoPoints.setText(":");

        Host.setFont(new java.awt.Font("Segoe UI Light", 0, 52)); // NOI18N
        Host.setForeground(new java.awt.Color(255, 255, 255));
        Host.setText("Host :");

        Auth.setFont(new java.awt.Font("Segoe UI Light", 0, 65)); // NOI18N
        Auth.setForeground(new java.awt.Color(255, 255, 255));
        Auth.setText("Autenticação");

        Password.setFont(new java.awt.Font("Segoe UI Light", 0, 52)); // NOI18N
        Password.setForeground(new java.awt.Color(255, 255, 255));
        Password.setText("Senha:");

        User.setFont(new java.awt.Font("Segoe UI Light", 0, 52)); // NOI18N
        User.setForeground(new java.awt.Color(255, 255, 255));
        User.setText("Usuário:");

        proxyPasswordTxt.setFont(new java.awt.Font("Segoe UI Semilight", 0, 46)); // NOI18N

        proxyUserTxt.setFont(new java.awt.Font("Segoe UI Semilight", 0, 46)); // NOI18N

        AuthOBS.setFont(new java.awt.Font("Segoe UI Semilight", 0, 22)); // NOI18N
        AuthOBS.setForeground(new java.awt.Color(255, 255, 255));
        AuthOBS.setText("OBS : Deixar Usuário e Senha em branco caso o servidor proxy não necessite de auenticação.");

        Confirm.setBackground(new java.awt.Color(255, 255, 255));
        Confirm.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        Confirm.setText("Confirmar e Autenticar");
        Confirm.setBorderPainted(false);
        Confirm.setDefaultCapable(false);
        Confirm.setFocusPainted(false);
        Confirm.setRequestFocusEnabled(false);
        Confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmActionPerformed(evt);
            }
        });

        ProxyBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bitknow/resources/Final7.png"))); // NOI18N

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(MenuTop, javax.swing.GroupLayout.DEFAULT_SIZE, 1278, Short.MAX_VALUE))
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(699, 699, 699)
                .addComponent(Port, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(691, 691, 691)
                .addComponent(proxyPortTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(User)
                .addGap(4, 4, 4)
                .addComponent(proxyUserTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(proxyServerTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(598, 598, 598)
                .addComponent(TwoPoints, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(proxyPasswordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(AuthOBS))
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(Host, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(ProxyBG)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(Auth, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(Config, javax.swing.GroupLayout.PREFERRED_SIZE, 977, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(982, 982, 982)
                .addComponent(Confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(MenuTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127)
                .addComponent(Port)
                .addGap(12, 12, 12)
                .addComponent(proxyPortTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(User)
                    .addComponent(proxyUserTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(242, 242, 242)
                .addComponent(proxyServerTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(521, 521, 521)
                .addComponent(Password))
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(521, 521, 521)
                .addComponent(proxyPasswordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(604, 604, 604)
                .addComponent(AuthOBS, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(Host))
            .addComponent(ProxyBG)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(325, 325, 325)
                .addComponent(Auth))
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(Config, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(TwoPoints, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(658, 658, 658)
                .addComponent(Confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuCloseMouseClicked
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_MenuCloseMouseClicked

    private void MenuCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuCloseMouseEntered
        MenuClose.setForeground(Color.RED);
    }//GEN-LAST:event_MenuCloseMouseEntered

    private void MenuCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuCloseMouseExited
        MenuClose.setForeground(Color.BLACK);
    }//GEN-LAST:event_MenuCloseMouseExited

    private void ConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmActionPerformed
        m.proxyServer = proxyServerTxt.getText();
        m.proxyPort = proxyPortTxt.getText();
        m.proxyUser = proxyUserTxt.getText();
        m.proxyPassword = proxyPasswordTxt.getText();
        m.setVisible(true);
        System.out.println(m.proxyServer);
        System.out.println(m.proxyPort);
        System.out.println(m.proxyUser);
        System.out.println(m.proxyPassword);
        dispose();
    }//GEN-LAST:event_ConfirmActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProxyConfiguration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProxyConfiguration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProxyConfiguration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProxyConfiguration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProxyConfiguration().setVisible(true);
            }
        });
    }
    public void setIcon() {
      setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/bitknow/resources/Icon2.png"))); 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Auth;
    private javax.swing.JLabel AuthOBS;
    private javax.swing.JLabel Config;
    private javax.swing.JButton Confirm;
    private javax.swing.JLabel Host;
    private javax.swing.JPanel Menu;
    private javax.swing.JLabel MenuClose;
    private javax.swing.JPanel MenuTop;
    private javax.swing.JLabel Password;
    private javax.swing.JLabel Port;
    private javax.swing.JLabel ProxyBG;
    private javax.swing.JLabel TwoPoints;
    private javax.swing.JLabel User;
    private javax.swing.JTextField proxyPasswordTxt;
    private javax.swing.JTextField proxyPortTxt;
    private javax.swing.JTextField proxyServerTxt;
    private javax.swing.JTextField proxyUserTxt;
    // End of variables declaration//GEN-END:variables
}
