/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitknow;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.UIManager;
/**
 *
 * @author Rafael
 */
import org.json.JSONObject;

public class MainApp extends javax.swing.JFrame {
    CardLayout cl;
    public JSONObject j;
    public JSONObject ping;
    public String coin = null;
    public String SelectedCurrency = "brl";
    public String ConversionCurrency;
    public String CurrencySymbol = "R$ ";
    public int x;
    public int y;
    
    int easteregg = 0;
     
    public double ConversionResult;
    public double ConversionCurrencyValue;
    public double CurrencyValue;
    
    public String proxyServer = "";
    public String proxyPort = "";
    public String proxyUser = "";
    public String proxyPassword = "";
    public Image icon;
    public String a;
    public int cont = 0;
    public MainApp m;
    public boolean wait = true;
    public MainApp(boolean go){
            if (go) {
            chamaSplash();
            } cont++;
            setIcon();
            UIManager.put("ProgressBar.foreground", Color.blue);
            setUndecorated(true);
            initComponents();
            MenuProgress.setVisible(false);
            setLocationRelativeTo(null);
            prepareImages();
        JPanel p = new JPanel();
        p.setSize(1280,30);
        p.setLocation(0, 0);
        p.setVisible(true);

        p.addMouseListener(new MouseListener() {
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
        p.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                setLocation(getX() + e.getX() - x,getY() + e.getY() - y);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });

        add(p);
    }
    
        public void Redimension (JLabel target, String path, boolean opaque) {
        ImageIcon i = new ImageIcon(getClass().getResource(path));
        int w; int h;
        w = target.getWidth();
        h = target.getHeight();
        target.setIcon(new ImageIcon(i.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH)));
        target.setOpaque(opaque);
        
    }
        public void prepareImages() {
            Redimension(Btc,"/com/bitknow/resources/ImgButtons/BTC.png" ,true);
            Redimension(Ltc,"/com/bitknow/resources/ImgButtons/LTC.png",true);
            Redimension(Doge,"/com/bitknow/resources/ImgButtons/DOGE.png",true);
            Redimension(Xmr,"/com/bitknow/resources/ImgButtons/XMR.png",true);
            Redimension(Eth,"/com/bitknow/resources/ImgButtons/ETH.png",true);
            Redimension(Etc,"/com/bitknow/resources/ImgButtons/ETC.png",true);
            Redimension(Bch,"/com/bitknow/resources/ImgButtons/BCH.png",true);
            Redimension(Dash,"/com/bitknow/resources/ImgButtons/DASH.png",true);
            
            Redimension(BtcCGLogo,"/com/bitknow/resources/CoinGeckoLogo.png",false);
            Redimension(BtcOfSiteLogo,"/com/bitknow/resources/BtcLogo.png",false);
            Redimension(BtcForumLogo,"/com/bitknow/resources/Forum.png",false);
            Redimension(BtcCyLogo,"/com/bitknow/resources/BlockCypher.png",false);
            
            Redimension(LtcCGLogo,"/com/bitknow/resources/CoinGeckoLogo.png",false);
            Redimension(LtcOfSiteLogo,"/com/bitknow/resources/LtcLogo.png",false);
            Redimension(LtcForumLogo,"/com/bitknow/resources/Forum.png",false);
            Redimension(LtcCyLogo,"/com/bitknow/resources/BlockCypher.png",false);
            
            Redimension(XmrCGLogo,"/com/bitknow/resources/CoinGeckoLogo.png",false);
            Redimension(XmrOfSiteLogo,"/com/bitknow/resources/XmrLogo.png",false);
            Redimension(XmrForumLogo,"/com/bitknow/resources/Forum.png",false);
            
            Redimension(DogeCGLogo,"/com/bitknow/resources/CoinGeckoLogo.png",false);
            Redimension(DogeOfSiteLogo,"/com/bitknow/resources/DogeLogo.png",false);
            Redimension(DogeForumLogo,"/com/bitknow/resources/Forum.png",false);
            Redimension(DogeCyLogo,"/com/bitknow/resources/BlockCypher.png",false);
            
            Redimension(DashCGLogo,"/com/bitknow/resources/CoinGeckoLogo.png",false);
            Redimension(DashOfSiteLogo,"/com/bitknow/resources/DashLogo.png",false);
            Redimension(DashForumLogo,"/com/bitknow/resources/Forum.png",false);
            Redimension(DashCyLogo,"/com/bitknow/resources/BlockCypher.png",false);
            
            Redimension(BchCGLogo,"/com/bitknow/resources/CoinGeckoLogo.png",false);
            Redimension(BchOfSiteLogo,"/com/bitknow/resources/BchLogo.png",false);
            Redimension(BchForumLogo,"/com/bitknow/resources/Forum.png",false);
            
            Redimension(EthCGLogo,"/com/bitknow/resources/CoinGeckoLogo.png",false);
            Redimension(EthOfSiteLogo,"/com/bitknow/resources/EthLogo.png",false);
            Redimension(EthForumLogo,"/com/bitknow/resources/Forum.png",false);
            
            Redimension(EtcCGLogo,"/com/bitknow/resources/CoinGeckoLogo.png",false);
            Redimension(EtcOfSiteLogo,"/com/bitknow/resources/EtcLogo.png",false);
            Redimension(EtcForumLogo,"/com/bitknow/resources/Forum.png",false);
            
            SidePanel.setBackground(new Color(0,0,0,150));
            
            BtcSidePanel.setBackground(new Color(255,255,255,120));
            LtcSidePanel.setBackground(new Color(255,255,255,120));
            XmrSidePanel.setBackground(new Color(255,255,255,120));
            DogeSidePanel.setBackground(new Color(255,255,255,120));
            DashSidePanel.setBackground(new Color(255,255,255,120));
            BchSidePanel.setBackground(new Color(255,255,255,120));
            EthSidePanel.setBackground(new Color(255,255,255,120));
            EtcSidePanel.setBackground(new Color(255,255,255,120));

        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Root = new javax.swing.JPanel();
        Menu = new javax.swing.JPanel();
        ProxyConfig = new javax.swing.JButton();
        MenuTop = new javax.swing.JPanel();
        MenuClose = new javax.swing.JLabel();
        MenuMinimize = new javax.swing.JLabel();
        BtcMainTitle1 = new javax.swing.JLabel();
        MenuProgress = new javax.swing.JProgressBar();
        SidePanel = new javax.swing.JPanel();
        Btc = new javax.swing.JLabel();
        Ltc = new javax.swing.JLabel();
        Xmr = new javax.swing.JLabel();
        Doge = new javax.swing.JLabel();
        Dash = new javax.swing.JLabel();
        Bch = new javax.swing.JLabel();
        Eth = new javax.swing.JLabel();
        Etc = new javax.swing.JLabel();
        CoinSelection = new javax.swing.JLabel();
        UtileTitle = new javax.swing.JLabel();
        Utile1 = new javax.swing.JLabel();
        Utile2 = new javax.swing.JLabel();
        MenuBG = new javax.swing.JLabel();
        Info = new javax.swing.JButton();
        BtcPanel = new javax.swing.JPanel();
        BtcTop = new javax.swing.JPanel();
        BtcClose = new javax.swing.JLabel();
        BtcBack = new javax.swing.JButton();
        BtcRefresh = new javax.swing.JButton();
        BtcMinimize = new javax.swing.JLabel();
        BtcMainTitle = new javax.swing.JLabel();
        BtcTitle = new javax.swing.JLabel();
        BtcConversion = new javax.swing.JLabel();
        BtcVChoose = new javax.swing.JComboBox<>();
        BtcEnter = new javax.swing.JTextField();
        BtcCChoose = new javax.swing.JComboBox<>();
        BtcConvert = new javax.swing.JButton();
        BtcClear = new javax.swing.JButton();
        BtcResult = new javax.swing.JTextField();
        BtcValue = new javax.swing.JLabel();
        BtcHistory = new javax.swing.JLabel();
        BtcSidePanel = new javax.swing.JPanel();
        BtcCG = new javax.swing.JLabel();
        BtcCGLogo = new javax.swing.JLabel();
        BtcOfSiteLogo = new javax.swing.JLabel();
        BtcForumLogo = new javax.swing.JLabel();
        BtcCyLogo = new javax.swing.JLabel();
        BtcUtile = new javax.swing.JLabel();
        BtcForum = new javax.swing.JLabel();
        BtcOfSite = new javax.swing.JLabel();
        BtcCy = new javax.swing.JLabel();
        XmrBG4 = new javax.swing.JLabel();
        LtcPanel = new javax.swing.JPanel();
        LtcTop = new javax.swing.JPanel();
        LtcClose = new javax.swing.JLabel();
        LtcBack = new javax.swing.JButton();
        LtcRefresh = new javax.swing.JButton();
        LtcMinimize = new javax.swing.JLabel();
        LtcMainTitle = new javax.swing.JLabel();
        LtcTitle = new javax.swing.JLabel();
        LtcConversion = new javax.swing.JLabel();
        LtcVChoose = new javax.swing.JComboBox<>();
        LtcEnter = new javax.swing.JTextField();
        LtcCChoose = new javax.swing.JComboBox<>();
        LtcConvert = new javax.swing.JButton();
        LtcClear = new javax.swing.JButton();
        LtcResult = new javax.swing.JTextField();
        LtcValue = new javax.swing.JLabel();
        LtcHistory = new javax.swing.JLabel();
        LtcSidePanel = new javax.swing.JPanel();
        LtcCG = new javax.swing.JLabel();
        LtcCGLogo = new javax.swing.JLabel();
        LtcOfSiteLogo = new javax.swing.JLabel();
        LtcForumLogo = new javax.swing.JLabel();
        LtcCyLogo = new javax.swing.JLabel();
        LtcUtile = new javax.swing.JLabel();
        LtcForum = new javax.swing.JLabel();
        LtcOfSite = new javax.swing.JLabel();
        LtcCy = new javax.swing.JLabel();
        XmrBG6 = new javax.swing.JLabel();
        XmrPanel = new javax.swing.JPanel();
        XmrTop = new javax.swing.JPanel();
        XmrClose = new javax.swing.JLabel();
        XmrBack = new javax.swing.JButton();
        XmrRefresh = new javax.swing.JButton();
        XmrMinimize = new javax.swing.JLabel();
        XmrMainTitle = new javax.swing.JLabel();
        XmrTitle = new javax.swing.JLabel();
        XmrConversion = new javax.swing.JLabel();
        XmrVChoose = new javax.swing.JComboBox<>();
        XmrEnter = new javax.swing.JTextField();
        XmrCChoose = new javax.swing.JComboBox<>();
        XmrConvert = new javax.swing.JButton();
        XmrClear = new javax.swing.JButton();
        XmrResult = new javax.swing.JTextField();
        XmrValue = new javax.swing.JLabel();
        XmrHistory = new javax.swing.JLabel();
        XmrSidePanel = new javax.swing.JPanel();
        XmrCG = new javax.swing.JLabel();
        XmrCGLogo = new javax.swing.JLabel();
        XmrOfSiteLogo = new javax.swing.JLabel();
        XmrForumLogo = new javax.swing.JLabel();
        XmrUtile = new javax.swing.JLabel();
        XmrForum = new javax.swing.JLabel();
        XmrOfSite = new javax.swing.JLabel();
        XmrBG7 = new javax.swing.JLabel();
        DogePanel = new javax.swing.JPanel();
        DogeTop = new javax.swing.JPanel();
        DogeClose = new javax.swing.JLabel();
        DogeBack = new javax.swing.JButton();
        DogeRefresh = new javax.swing.JButton();
        DogeMinimize = new javax.swing.JLabel();
        DogeMainTitle = new javax.swing.JLabel();
        DogeTitle = new javax.swing.JLabel();
        DogeConversion = new javax.swing.JLabel();
        DogeVChoose = new javax.swing.JComboBox<>();
        DogeEnter = new javax.swing.JTextField();
        DogeCChoose = new javax.swing.JComboBox<>();
        DogeConvert = new javax.swing.JButton();
        DogeClear = new javax.swing.JButton();
        DogeResult = new javax.swing.JTextField();
        DogeValue = new javax.swing.JLabel();
        DogeHistory = new javax.swing.JLabel();
        DogeSidePanel = new javax.swing.JPanel();
        DogeCG = new javax.swing.JLabel();
        DogeCGLogo = new javax.swing.JLabel();
        DogeOfSiteLogo = new javax.swing.JLabel();
        DogeForumLogo = new javax.swing.JLabel();
        DogeUtile = new javax.swing.JLabel();
        DogeForum = new javax.swing.JLabel();
        DogeOfSite = new javax.swing.JLabel();
        DogeCy = new javax.swing.JLabel();
        DogeCyLogo = new javax.swing.JLabel();
        XmrBG8 = new javax.swing.JLabel();
        DashPanel = new javax.swing.JPanel();
        DashTop = new javax.swing.JPanel();
        DashClose = new javax.swing.JLabel();
        DashBack = new javax.swing.JButton();
        DashRefresh = new javax.swing.JButton();
        DashMinimize = new javax.swing.JLabel();
        DashMainTitle = new javax.swing.JLabel();
        DashTitle = new javax.swing.JLabel();
        DashConversion = new javax.swing.JLabel();
        DashVChoose = new javax.swing.JComboBox<>();
        DashEnter = new javax.swing.JTextField();
        DashCChoose = new javax.swing.JComboBox<>();
        DashConvert = new javax.swing.JButton();
        DashClear = new javax.swing.JButton();
        DashResult = new javax.swing.JTextField();
        DashValue = new javax.swing.JLabel();
        DashHistory = new javax.swing.JLabel();
        DashSidePanel = new javax.swing.JPanel();
        DashCG = new javax.swing.JLabel();
        DashCGLogo = new javax.swing.JLabel();
        DashOfSiteLogo = new javax.swing.JLabel();
        DashForumLogo = new javax.swing.JLabel();
        DashUtile = new javax.swing.JLabel();
        DashForum = new javax.swing.JLabel();
        DashOfSite = new javax.swing.JLabel();
        DashCy = new javax.swing.JLabel();
        DashCyLogo = new javax.swing.JLabel();
        XmrBG9 = new javax.swing.JLabel();
        BchPanel = new javax.swing.JPanel();
        BchTop = new javax.swing.JPanel();
        BchClose = new javax.swing.JLabel();
        BchBack = new javax.swing.JButton();
        BchRefresh = new javax.swing.JButton();
        BchMinimize = new javax.swing.JLabel();
        BchMainTitle = new javax.swing.JLabel();
        BchTitle = new javax.swing.JLabel();
        BchConversion = new javax.swing.JLabel();
        BchVChoose = new javax.swing.JComboBox<>();
        BchEnter = new javax.swing.JTextField();
        BchCChoose = new javax.swing.JComboBox<>();
        BchConvert = new javax.swing.JButton();
        BchClear = new javax.swing.JButton();
        BchResult = new javax.swing.JTextField();
        BchValue = new javax.swing.JLabel();
        BchHistory = new javax.swing.JLabel();
        BchSidePanel = new javax.swing.JPanel();
        BchCG = new javax.swing.JLabel();
        BchCGLogo = new javax.swing.JLabel();
        BchOfSiteLogo = new javax.swing.JLabel();
        BchForumLogo = new javax.swing.JLabel();
        BchUtile = new javax.swing.JLabel();
        BchForum = new javax.swing.JLabel();
        BchOfSite = new javax.swing.JLabel();
        XmrBG10 = new javax.swing.JLabel();
        EthPanel = new javax.swing.JPanel();
        EthTop = new javax.swing.JPanel();
        EthClose = new javax.swing.JLabel();
        EthBack = new javax.swing.JButton();
        EthRefresh = new javax.swing.JButton();
        EthMinimize = new javax.swing.JLabel();
        EthMainTitle = new javax.swing.JLabel();
        EthTitle = new javax.swing.JLabel();
        EthConversion = new javax.swing.JLabel();
        EthVChoose = new javax.swing.JComboBox<>();
        EthEnter = new javax.swing.JTextField();
        EthCChoose = new javax.swing.JComboBox<>();
        EthConvert = new javax.swing.JButton();
        EthClear = new javax.swing.JButton();
        EthResult = new javax.swing.JTextField();
        EthValue = new javax.swing.JLabel();
        EthHistory = new javax.swing.JLabel();
        EthSidePanel = new javax.swing.JPanel();
        EthCG = new javax.swing.JLabel();
        EthCGLogo = new javax.swing.JLabel();
        EthOfSiteLogo = new javax.swing.JLabel();
        EthForumLogo = new javax.swing.JLabel();
        EthUtile = new javax.swing.JLabel();
        EthForum = new javax.swing.JLabel();
        EthOfSite = new javax.swing.JLabel();
        XmrBG11 = new javax.swing.JLabel();
        EtcPanel = new javax.swing.JPanel();
        EtcTop = new javax.swing.JPanel();
        EtcClose = new javax.swing.JLabel();
        EtcBack = new javax.swing.JButton();
        EtcRefresh = new javax.swing.JButton();
        EtcMinimize = new javax.swing.JLabel();
        EtcMainTitle = new javax.swing.JLabel();
        EtcTitle = new javax.swing.JLabel();
        EtcConversion = new javax.swing.JLabel();
        EtcVChoose = new javax.swing.JComboBox<>();
        EtcEnter = new javax.swing.JTextField();
        EtcCChoose = new javax.swing.JComboBox<>();
        EtcConvert = new javax.swing.JButton();
        EtcClear = new javax.swing.JButton();
        EtcResult = new javax.swing.JTextField();
        EtcValue = new javax.swing.JLabel();
        EtcHistory = new javax.swing.JLabel();
        EtcSidePanel = new javax.swing.JPanel();
        EtcCG = new javax.swing.JLabel();
        EtcCGLogo = new javax.swing.JLabel();
        EtcOfSiteLogo = new javax.swing.JLabel();
        EtcForumLogo = new javax.swing.JLabel();
        EtcUtile = new javax.swing.JLabel();
        EtcForum = new javax.swing.JLabel();
        EtcOfSite = new javax.swing.JLabel();
        XmrBG12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 101));
        setOpacity(1f);

        Root.setBackground(new java.awt.Color(35, 39, 42));
        Root.setForeground(new java.awt.Color(255, 255, 255));
        Root.setEnabled(false);
        Root.setPreferredSize(new java.awt.Dimension(1280, 720));
        Root.setLayout(new java.awt.CardLayout());

        Menu.setBackground(new java.awt.Color(0, 51, 51));
        Menu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        Menu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Menu.setMaximumSize(new java.awt.Dimension(1280, 720));
        Menu.setMinimumSize(new java.awt.Dimension(1280, 720));
        Menu.setOpaque(false);
        Menu.setPreferredSize(new java.awt.Dimension(1280, 720));

        ProxyConfig.setBackground(new java.awt.Color(255, 255, 255));
        ProxyConfig.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        ProxyConfig.setText("Configurar Proxy");
        ProxyConfig.setBorder(null);
        ProxyConfig.setBorderPainted(false);
        ProxyConfig.setFocusPainted(false);
        ProxyConfig.setFocusable(false);
        ProxyConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProxyConfigActionPerformed(evt);
            }
        });

        MenuTop.setBackground(new java.awt.Color(255, 255, 255));
        MenuTop.setPreferredSize(new java.awt.Dimension(188, 30));

        MenuClose.setBackground(new java.awt.Color(255, 255, 255));
        MenuClose.setFont(new java.awt.Font("Oswald", 0, 23)); // NOI18N
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

        MenuMinimize.setBackground(new java.awt.Color(255, 255, 255));
        MenuMinimize.setFont(new java.awt.Font("Oswald", 0, 48)); // NOI18N
        MenuMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuMinimize.setText("-");
        MenuMinimize.setMaximumSize(new java.awt.Dimension(12, 30));
        MenuMinimize.setMinimumSize(new java.awt.Dimension(12, 30));
        MenuMinimize.setPreferredSize(new java.awt.Dimension(12, 30));
        MenuMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuMinimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuMinimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuMinimizeMouseExited(evt);
            }
        });

        BtcMainTitle1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 19)); // NOI18N
        BtcMainTitle1.setText("BitKnow - Menu");

        javax.swing.GroupLayout MenuTopLayout = new javax.swing.GroupLayout(MenuTop);
        MenuTop.setLayout(MenuTopLayout);
        MenuTopLayout.setHorizontalGroup(
            MenuTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuTopLayout.createSequentialGroup()
                .addGap(540, 540, 540)
                .addComponent(BtcMainTitle1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 545, Short.MAX_VALUE)
                .addComponent(MenuMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MenuClose, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        MenuTopLayout.setVerticalGroup(
            MenuTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuTopLayout.createSequentialGroup()
                .addGroup(MenuTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(MenuClose, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtcMainTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MenuMinimize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        MenuProgress.setForeground(new java.awt.Color(51, 255, 51));
        MenuProgress.setMaximum(150);
        MenuProgress.setToolTipText("Carregando");

        Btc.setBackground(new java.awt.Color(247, 147, 26));
        Btc.setOpaque(true);
        Btc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtcMouseClicked(evt);
            }
        });

        Ltc.setBackground(new java.awt.Color(184, 184, 184));
        Ltc.setForeground(new java.awt.Color(81, 81, 81));
        Ltc.setOpaque(true);
        Ltc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LtcMouseClicked(evt);
            }
        });

        Xmr.setBackground(new java.awt.Color(255, 255, 255));
        Xmr.setOpaque(true);
        Xmr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                XmrMouseClicked(evt);
            }
        });

        Doge.setBackground(new java.awt.Color(225, 179, 3));
        Doge.setOpaque(true);
        Doge.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DogeMouseClicked(evt);
            }
        });

        Dash.setBackground(new java.awt.Color(85, 124, 176));
        Dash.setOpaque(true);
        Dash.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashMouseClicked(evt);
            }
        });

        Bch.setBackground(new java.awt.Color(102, 212, 82));
        Bch.setOpaque(true);
        Bch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BchMouseClicked(evt);
            }
        });

        Eth.setBackground(new java.awt.Color(236, 240, 241));
        Eth.setOpaque(true);
        Eth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EthMouseClicked(evt);
            }
        });

        Etc.setBackground(new java.awt.Color(60, 60, 61));
        Etc.setOpaque(true);
        Etc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EtcMouseClicked(evt);
            }
        });

        CoinSelection.setFont(new java.awt.Font("Segoe UI Light", 0, 42)); // NOI18N
        CoinSelection.setForeground(new java.awt.Color(255, 255, 255));
        CoinSelection.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CoinSelection.setText("Selecione uma moeda");

        javax.swing.GroupLayout SidePanelLayout = new javax.swing.GroupLayout(SidePanel);
        SidePanel.setLayout(SidePanelLayout);
        SidePanelLayout.setHorizontalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Ltc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Xmr, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Doge, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Bch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Eth, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Etc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Dash, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SidePanelLayout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(CoinSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        SidePanelLayout.setVerticalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SidePanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(CoinSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Btc, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Ltc, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Xmr, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Doge, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Dash, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Bch, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Eth, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Etc, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        UtileTitle.setBackground(new java.awt.Color(255, 255, 255));
        UtileTitle.setFont(new java.awt.Font("Segoe UI Semilight", 0, 32)); // NOI18N
        UtileTitle.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        UtileTitle.setText("Links Úteis : ");

        Utile1.setBackground(new java.awt.Color(255, 255, 255));
        Utile1.setFont(new java.awt.Font("Segoe UI Semilight", 0, 30)); // NOI18N
        Utile1.setForeground(new java.awt.Color(0, 0, 255));
        Utile1.setText("O que é Criptomoeda?");
        Utile1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Utile1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Utile1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Utile1MouseExited(evt);
            }
        });

        Utile2.setBackground(new java.awt.Color(255, 255, 255));
        Utile2.setFont(new java.awt.Font("Segoe UI Semilight", 0, 30)); // NOI18N
        Utile2.setForeground(new java.awt.Color(0, 0, 255));
        Utile2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Utile2.setText("Como consegui-la?");
        Utile2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Utile2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Utile2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Utile2MouseExited(evt);
            }
        });

        MenuBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bitknow/resources/BG.jpg"))); // NOI18N
        MenuBG.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        MenuBG.setMinimumSize(new java.awt.Dimension(1275, 677));
        MenuBG.setPreferredSize(new java.awt.Dimension(1275, 709));

        Info.setBackground(new java.awt.Color(255, 255, 255));
        Info.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        Info.setText("Info. Do Aplicativo");
        Info.setBorderPainted(false);
        Info.setFocusPainted(false);
        Info.setRequestFocusEnabled(false);
        Info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addComponent(SidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createSequentialGroup()
                        .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UtileTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Utile2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Utile1)))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createSequentialGroup()
                        .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MenuProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(ProxyConfig, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Info, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)))
                        .addGap(29, 29, 29))))
            .addGroup(MenuLayout.createSequentialGroup()
                .addComponent(MenuTop, javax.swing.GroupLayout.PREFERRED_SIZE, 1276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MenuLayout.createSequentialGroup()
                    .addComponent(MenuBG, javax.swing.GroupLayout.PREFERRED_SIZE, 1275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1, Short.MAX_VALUE)))
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addComponent(MenuTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(UtileTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Utile1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Utile2)
                        .addGap(386, 386, 386)
                        .addComponent(Info, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ProxyConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(MenuProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 17, Short.MAX_VALUE))
                    .addComponent(SidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 684, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createSequentialGroup()
                    .addContainerGap(32, Short.MAX_VALUE)
                    .addComponent(MenuBG, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        Root.add(Menu, "Menu");

        BtcPanel.setBackground(new java.awt.Color(247, 130, 3));
        BtcPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        BtcPanel.setMaximumSize(new java.awt.Dimension(1280, 720));
        BtcPanel.setMinimumSize(new java.awt.Dimension(1280, 720));
        BtcPanel.setPreferredSize(new java.awt.Dimension(1280, 720));

        BtcTop.setBackground(new java.awt.Color(255, 255, 255));
        BtcTop.setMinimumSize(new java.awt.Dimension(1276, 30));
        BtcTop.setName(""); // NOI18N
        BtcTop.setPreferredSize(new java.awt.Dimension(1276, 30));

        BtcClose.setBackground(new java.awt.Color(255, 255, 255));
        BtcClose.setFont(new java.awt.Font("Oswald", 0, 24)); // NOI18N
        BtcClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtcClose.setText("X");
        BtcClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtcCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtcCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtcCloseMouseExited(evt);
            }
        });

        BtcBack.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        BtcBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bitknow/resources/BackIconBlack.png"))); // NOI18N
        BtcBack.setContentAreaFilled(false);
        BtcBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtcBackActionPerformed(evt);
            }
        });

        BtcRefresh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BtcRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bitknow/resources/RefreshBlack.png"))); // NOI18N
        BtcRefresh.setBorderPainted(false);
        BtcRefresh.setContentAreaFilled(false);
        BtcRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtcRefreshActionPerformed(evt);
            }
        });

        BtcMinimize.setBackground(new java.awt.Color(255, 255, 255));
        BtcMinimize.setFont(new java.awt.Font("Oswald", 0, 48)); // NOI18N
        BtcMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtcMinimize.setText("-");
        BtcMinimize.setMaximumSize(new java.awt.Dimension(12, 30));
        BtcMinimize.setMinimumSize(new java.awt.Dimension(12, 30));
        BtcMinimize.setPreferredSize(new java.awt.Dimension(12, 30));
        BtcMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtcMinimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtcMinimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtcMinimizeMouseExited(evt);
            }
        });

        BtcMainTitle.setFont(new java.awt.Font("Segoe UI Semibold", 0, 19)); // NOI18N
        BtcMainTitle.setText("BitKnow - Bitcoin");

        javax.swing.GroupLayout BtcTopLayout = new javax.swing.GroupLayout(BtcTop);
        BtcTop.setLayout(BtcTopLayout);
        BtcTopLayout.setHorizontalGroup(
            BtcTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BtcTopLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(BtcBack, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtcRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(476, 476, 476)
                .addComponent(BtcMainTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 524, Short.MAX_VALUE)
                .addComponent(BtcClose)
                .addContainerGap())
            .addGroup(BtcTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BtcTopLayout.createSequentialGroup()
                    .addGap(1223, 1223, 1223)
                    .addComponent(BtcMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(32, Short.MAX_VALUE)))
        );
        BtcTopLayout.setVerticalGroup(
            BtcTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BtcTopLayout.createSequentialGroup()
                .addGroup(BtcTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(BtcMainTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtcRefresh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(BtcBack, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtcClose, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(BtcTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BtcTopLayout.createSequentialGroup()
                    .addComponent(BtcMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 28, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        BtcTitle.setBackground(new java.awt.Color(247, 147, 26));
        BtcTitle.setFont(new java.awt.Font("Segoe UI Semilight", 0, 55)); // NOI18N
        BtcTitle.setForeground(new java.awt.Color(255, 255, 255));
        BtcTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtcTitle.setText("Bitcoin (Btc)");
        BtcTitle.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        BtcTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        BtcConversion.setBackground(new java.awt.Color(247, 147, 26));
        BtcConversion.setFont(new java.awt.Font("Segoe UI Semilight", 0, 48)); // NOI18N
        BtcConversion.setForeground(new java.awt.Color(255, 255, 255));
        BtcConversion.setText("Conversão:");
        BtcConversion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        BtcVChoose.setFont(new java.awt.Font("Source Sans Pro", 0, 20)); // NOI18N
        BtcVChoose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "brl", "usd", "eur", "jpy", "gbp", "cad", "mxn" }));
        BtcVChoose.setToolTipText("Escolha uma moeda");
        BtcVChoose.setBorder(null);
        BtcVChoose.setRequestFocusEnabled(false);
        BtcVChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtcVChooseActionPerformed(evt);
            }
        });

        BtcEnter.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        BtcEnter.setForeground(new java.awt.Color(204, 204, 204));
        BtcEnter.setText("Digite o valor aqui");
        BtcEnter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtcEnterMouseClicked(evt);
            }
        });
        BtcEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtcEnterActionPerformed(evt);
            }
        });

        BtcCChoose.setFont(new java.awt.Font("Source Sans Pro", 0, 16)); // NOI18N
        BtcCChoose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "brl", "usd", "eur", "jpy", "gbp", "cad", "mxn" }));
        BtcCChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtcCChooseActionPerformed(evt);
            }
        });

        BtcConvert.setFont(new java.awt.Font("Source Sans Pro", 0, 12)); // NOI18N
        BtcConvert.setText("Converter");
        BtcConvert.setBorderPainted(false);
        BtcConvert.setDefaultCapable(false);
        BtcConvert.setFocusPainted(false);
        BtcConvert.setRequestFocusEnabled(false);
        BtcConvert.setRolloverEnabled(false);
        BtcConvert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtcConvertActionPerformed(evt);
            }
        });

        BtcClear.setFont(new java.awt.Font("Source Sans Pro", 0, 12)); // NOI18N
        BtcClear.setText("Limpar");
        BtcClear.setBorderPainted(false);
        BtcClear.setFocusPainted(false);
        BtcClear.setRequestFocusEnabled(false);
        BtcClear.setRolloverEnabled(false);
        BtcClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtcClearActionPerformed(evt);
            }
        });

        BtcResult.setEditable(false);
        BtcResult.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        BtcResult.setForeground(new java.awt.Color(204, 204, 204));
        BtcResult.setText("O Resultado aparecerá aqui");
        BtcResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtcResultActionPerformed(evt);
            }
        });

        BtcValue.setBackground(new java.awt.Color(247, 147, 26));
        BtcValue.setFont(new java.awt.Font("Segoe UI Semilight", 0, 36)); // NOI18N
        BtcValue.setForeground(new java.awt.Color(255, 255, 255));
        BtcValue.setText("1 Btc ≈ ");
        BtcValue.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        BtcHistory.setBackground(new java.awt.Color(247, 147, 26));
        BtcHistory.setFont(new java.awt.Font("Segoe UI Semibold", 0, 30)); // NOI18N
        BtcHistory.setForeground(new java.awt.Color(255, 255, 255));
        BtcHistory.setText("<html>Info: Bitcoin foi a primeira criptomoeda bem-sucedida e que utilizou tecnologia peer-to-peer (p2p), foi criada\npor Satoshi Nakamoto, pseudônimo de um programador (ou de uma equipe) que até hoje não se sabe sua real \nidentidade <br> </html>");
        BtcHistory.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        BtcHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        BtcSidePanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        BtcCG.setBackground(new java.awt.Color(0, 0, 255));
        BtcCG.setFont(new java.awt.Font("Segoe UI Light", 0, 52)); // NOI18N
        BtcCG.setText("Página do CoinGecko");
        BtcCG.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtcCG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtcCGMouseClicked(evt);
            }
        });

        BtcCGLogo.setBackground(new java.awt.Color(0, 0, 255));
        BtcCGLogo.setFont(new java.awt.Font("Oswald", 0, 45)); // NOI18N
        BtcCGLogo.setForeground(new java.awt.Color(0, 0, 255));
        BtcCGLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtcCGLogo.setOpaque(true);
        BtcCGLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtcCGLogoMouseClicked(evt);
            }
        });

        BtcOfSiteLogo.setBackground(new java.awt.Color(0, 0, 255));
        BtcOfSiteLogo.setFont(new java.awt.Font("Oswald", 0, 45)); // NOI18N
        BtcOfSiteLogo.setForeground(new java.awt.Color(0, 0, 255));
        BtcOfSiteLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtcOfSiteLogo.setOpaque(true);
        BtcOfSiteLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtcOfSiteLogoMouseClicked(evt);
            }
        });

        BtcForumLogo.setBackground(new java.awt.Color(0, 0, 255));
        BtcForumLogo.setFont(new java.awt.Font("Oswald", 0, 45)); // NOI18N
        BtcForumLogo.setForeground(new java.awt.Color(0, 0, 255));
        BtcForumLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtcForumLogo.setOpaque(true);
        BtcForumLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtcForumLogoMouseClicked(evt);
            }
        });

        BtcCyLogo.setBackground(new java.awt.Color(0, 0, 255));
        BtcCyLogo.setFont(new java.awt.Font("Oswald", 0, 45)); // NOI18N
        BtcCyLogo.setForeground(new java.awt.Color(0, 0, 255));
        BtcCyLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtcCyLogo.setOpaque(true);
        BtcCyLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtcCyLogoMouseClicked(evt);
            }
        });

        BtcUtile.setBackground(new java.awt.Color(0, 0, 255));
        BtcUtile.setFont(new java.awt.Font("Segoe UI Light", 0, 60)); // NOI18N
        BtcUtile.setText("Links Úteis - Bitcoin : ");
        BtcUtile.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtcUtile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtcUtileMouseClicked(evt);
            }
        });

        BtcForum.setBackground(new java.awt.Color(0, 0, 255));
        BtcForum.setFont(new java.awt.Font("Segoe UI Light", 0, 52)); // NOI18N
        BtcForum.setText("Fórum Oficial");
        BtcForum.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtcForum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtcForumMouseClicked(evt);
            }
        });

        BtcOfSite.setBackground(new java.awt.Color(0, 0, 255));
        BtcOfSite.setFont(new java.awt.Font("Segoe UI Light", 0, 52)); // NOI18N
        BtcOfSite.setText("Site Oficial");
        BtcOfSite.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtcOfSite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtcOfSiteMouseClicked(evt);
            }
        });

        BtcCy.setBackground(new java.awt.Color(0, 0, 255));
        BtcCy.setFont(new java.awt.Font("Segoe UI Light", 0, 51)); // NOI18N
        BtcCy.setText("Transações ao Vivo");
        BtcCy.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtcCy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtcCyMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout BtcSidePanelLayout = new javax.swing.GroupLayout(BtcSidePanel);
        BtcSidePanel.setLayout(BtcSidePanelLayout);
        BtcSidePanelLayout.setHorizontalGroup(
            BtcSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BtcSidePanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(BtcSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtcUtile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(BtcSidePanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(BtcSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BtcSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(BtcSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(BtcSidePanelLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(BtcCGLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(BtcSidePanelLayout.createSequentialGroup()
                                        .addComponent(BtcOfSiteLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(BtcSidePanelLayout.createSequentialGroup()
                                    .addComponent(BtcForumLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)))
                            .addGroup(BtcSidePanelLayout.createSequentialGroup()
                                .addComponent(BtcCyLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(BtcSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BtcCy, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                            .addComponent(BtcForum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtcOfSite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtcCG, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)))))
        );
        BtcSidePanelLayout.setVerticalGroup(
            BtcSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BtcSidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtcUtile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(64, 64, 64)
                .addGroup(BtcSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtcCGLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtcCG, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BtcSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtcOfSiteLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtcOfSite, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BtcSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtcForumLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtcForum, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BtcSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtcCy, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtcCyLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(199, 199, 199))
        );

        XmrBG4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bitknow/resources/Final7.png"))); // NOI18N
        XmrBG4.setPreferredSize(new java.awt.Dimension(1268, 677));

        javax.swing.GroupLayout BtcPanelLayout = new javax.swing.GroupLayout(BtcPanel);
        BtcPanel.setLayout(BtcPanelLayout);
        BtcPanelLayout.setHorizontalGroup(
            BtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BtcPanelLayout.createSequentialGroup()
                .addGroup(BtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, BtcPanelLayout.createSequentialGroup()
                        .addComponent(BtcTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, BtcPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(BtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtcHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(BtcPanelLayout.createSequentialGroup()
                                .addComponent(BtcValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtcVChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BtcPanelLayout.createSequentialGroup()
                                .addGroup(BtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BtcTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BtcConversion)
                                    .addGroup(BtcPanelLayout.createSequentialGroup()
                                        .addComponent(BtcResult, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BtcConvert)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BtcClear, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(BtcPanelLayout.createSequentialGroup()
                                        .addComponent(BtcEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BtcCChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(BtcSidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(BtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BtcPanelLayout.createSequentialGroup()
                    .addComponent(XmrBG4, javax.swing.GroupLayout.PREFERRED_SIZE, 1276, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        BtcPanelLayout.setVerticalGroup(
            BtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BtcPanelLayout.createSequentialGroup()
                .addComponent(BtcTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtcSidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 695, Short.MAX_VALUE)
                    .addGroup(BtcPanelLayout.createSequentialGroup()
                        .addComponent(BtcTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(BtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BtcVChoose)
                            .addComponent(BtcValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtcHistory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(BtcConversion, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(BtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtcEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtcCChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(BtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtcResult, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtcConvert, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtcClear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(BtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BtcPanelLayout.createSequentialGroup()
                    .addComponent(XmrBG4, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 22, Short.MAX_VALUE)))
        );

        Root.add(BtcPanel, "BtcPanel");

        LtcPanel.setBackground(new java.awt.Color(77, 77, 77));
        LtcPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        LtcPanel.setMaximumSize(new java.awt.Dimension(1280, 720));
        LtcPanel.setMinimumSize(new java.awt.Dimension(1280, 720));

        LtcTop.setBackground(new java.awt.Color(255, 255, 255));
        LtcTop.setMinimumSize(new java.awt.Dimension(1276, 30));
        LtcTop.setName(""); // NOI18N
        LtcTop.setPreferredSize(new java.awt.Dimension(815, 30));

        LtcClose.setBackground(new java.awt.Color(255, 255, 255));
        LtcClose.setFont(new java.awt.Font("Oswald", 0, 24)); // NOI18N
        LtcClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LtcClose.setText("X");
        LtcClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LtcCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LtcCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LtcCloseMouseExited(evt);
            }
        });

        LtcBack.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        LtcBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bitknow/resources/BackIconBlack.png"))); // NOI18N
        LtcBack.setBorderPainted(false);
        LtcBack.setContentAreaFilled(false);
        LtcBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LtcBackActionPerformed(evt);
            }
        });

        LtcRefresh.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        LtcRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bitknow/resources/RefreshBlack.png"))); // NOI18N
        LtcRefresh.setToolTipText("");
        LtcRefresh.setContentAreaFilled(false);
        LtcRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LtcRefreshActionPerformed(evt);
            }
        });

        LtcMinimize.setBackground(new java.awt.Color(255, 255, 255));
        LtcMinimize.setFont(new java.awt.Font("Oswald", 0, 48)); // NOI18N
        LtcMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LtcMinimize.setText("-");
        LtcMinimize.setMaximumSize(new java.awt.Dimension(12, 30));
        LtcMinimize.setMinimumSize(new java.awt.Dimension(12, 30));
        LtcMinimize.setPreferredSize(new java.awt.Dimension(12, 30));
        LtcMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LtcMinimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LtcMinimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LtcMinimizeMouseExited(evt);
            }
        });

        LtcMainTitle.setFont(new java.awt.Font("Segoe UI Semibold", 0, 19)); // NOI18N
        LtcMainTitle.setText("BitKnow - Litecoin");

        javax.swing.GroupLayout LtcTopLayout = new javax.swing.GroupLayout(LtcTop);
        LtcTop.setLayout(LtcTopLayout);
        LtcTopLayout.setHorizontalGroup(
            LtcTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LtcTopLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(LtcBack, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LtcRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(472, 472, 472)
                .addComponent(LtcMainTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LtcMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LtcClose)
                .addContainerGap())
        );
        LtcTopLayout.setVerticalGroup(
            LtcTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LtcTopLayout.createSequentialGroup()
                .addGroup(LtcTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LtcMinimize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(LtcTopLayout.createSequentialGroup()
                        .addComponent(LtcClose, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(LtcTopLayout.createSequentialGroup()
                .addGroup(LtcTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(LtcBack, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(LtcRefresh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(LtcMainTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        LtcTitle.setBackground(new java.awt.Color(247, 147, 26));
        LtcTitle.setFont(new java.awt.Font("Segoe UI Semilight", 0, 55)); // NOI18N
        LtcTitle.setForeground(new java.awt.Color(255, 255, 255));
        LtcTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LtcTitle.setText("Litecoin (Ltc)");
        LtcTitle.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        LtcTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        LtcConversion.setBackground(new java.awt.Color(247, 147, 26));
        LtcConversion.setFont(new java.awt.Font("Segoe UI Semilight", 0, 48)); // NOI18N
        LtcConversion.setForeground(new java.awt.Color(255, 255, 255));
        LtcConversion.setText("Conversão:");
        LtcConversion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        LtcVChoose.setFont(new java.awt.Font("Source Sans Pro", 0, 20)); // NOI18N
        LtcVChoose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "brl", "usd", "eur", "jpy", "gbp", "cad", "mxn" }));
        LtcVChoose.setToolTipText("Escolha uma moeda");
        LtcVChoose.setBorder(null);
        LtcVChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LtcVChooseActionPerformed(evt);
            }
        });

        LtcEnter.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        LtcEnter.setForeground(new java.awt.Color(204, 204, 204));
        LtcEnter.setText("Digite o valor aqui");
        LtcEnter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LtcEnterMouseClicked(evt);
            }
        });
        LtcEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LtcEnterActionPerformed(evt);
            }
        });

        LtcCChoose.setFont(new java.awt.Font("Source Sans Pro", 0, 16)); // NOI18N
        LtcCChoose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "brl", "usd", "eur", "jpy", "gbp", "cad", "mxn" }));
        LtcCChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LtcCChooseActionPerformed(evt);
            }
        });

        LtcConvert.setFont(new java.awt.Font("Source Sans Pro", 0, 12)); // NOI18N
        LtcConvert.setText("Converter");
        LtcConvert.setBorderPainted(false);
        LtcConvert.setDefaultCapable(false);
        LtcConvert.setFocusPainted(false);
        LtcConvert.setRequestFocusEnabled(false);
        LtcConvert.setRolloverEnabled(false);
        LtcConvert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LtcConvertActionPerformed(evt);
            }
        });

        LtcClear.setFont(new java.awt.Font("Source Sans Pro", 0, 12)); // NOI18N
        LtcClear.setText("Limpar");
        LtcClear.setBorderPainted(false);
        LtcClear.setDefaultCapable(false);
        LtcClear.setFocusPainted(false);
        LtcClear.setRequestFocusEnabled(false);
        LtcClear.setRolloverEnabled(false);
        LtcClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LtcClearActionPerformed(evt);
            }
        });

        LtcResult.setEditable(false);
        LtcResult.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        LtcResult.setForeground(new java.awt.Color(204, 204, 204));
        LtcResult.setText("O Resultado aparecerá aqui");
        LtcResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LtcResultActionPerformed(evt);
            }
        });

        LtcValue.setBackground(new java.awt.Color(247, 147, 26));
        LtcValue.setFont(new java.awt.Font("Segoe UI Semilight", 0, 36)); // NOI18N
        LtcValue.setForeground(new java.awt.Color(255, 255, 255));
        LtcValue.setText("1 Ltc ≈ ");
        LtcValue.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        LtcHistory.setBackground(new java.awt.Color(247, 147, 26));
        LtcHistory.setFont(new java.awt.Font("Segoe UI Semibold", 0, 34)); // NOI18N
        LtcHistory.setForeground(new java.awt.Color(255, 255, 255));
        LtcHistory.setText("<html> Info : O Litecoin é uma criptomoeda que foi criada em 2011 por Charlie Lee, que recentemente vendeu toda a sua reserva da moeda. <br> Segundo Charlie Lee, o Litecoin não é competidor direto do Bitcoin mas sim um complemento a ele.");
        LtcHistory.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        LtcHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        LtcCG.setBackground(new java.awt.Color(0, 0, 255));
        LtcCG.setFont(new java.awt.Font("Segoe UI Light", 0, 52)); // NOI18N
        LtcCG.setText("Página do CoinGecko");
        LtcCG.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        LtcCG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LtcCGMouseClicked(evt);
            }
        });

        LtcCGLogo.setBackground(new java.awt.Color(0, 0, 255));
        LtcCGLogo.setFont(new java.awt.Font("Oswald", 0, 45)); // NOI18N
        LtcCGLogo.setForeground(new java.awt.Color(0, 0, 255));
        LtcCGLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        LtcCGLogo.setOpaque(true);
        LtcCGLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LtcCGLogoMouseClicked(evt);
            }
        });

        LtcOfSiteLogo.setBackground(new java.awt.Color(0, 0, 255));
        LtcOfSiteLogo.setFont(new java.awt.Font("Oswald", 0, 45)); // NOI18N
        LtcOfSiteLogo.setForeground(new java.awt.Color(0, 0, 255));
        LtcOfSiteLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        LtcOfSiteLogo.setOpaque(true);
        LtcOfSiteLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LtcOfSiteLogoMouseClicked(evt);
            }
        });

        LtcForumLogo.setBackground(new java.awt.Color(0, 0, 255));
        LtcForumLogo.setFont(new java.awt.Font("Oswald", 0, 45)); // NOI18N
        LtcForumLogo.setForeground(new java.awt.Color(0, 0, 255));
        LtcForumLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        LtcForumLogo.setOpaque(true);
        LtcForumLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LtcForumLogoMouseClicked(evt);
            }
        });

        LtcCyLogo.setBackground(new java.awt.Color(0, 0, 255));
        LtcCyLogo.setFont(new java.awt.Font("Oswald", 0, 45)); // NOI18N
        LtcCyLogo.setForeground(new java.awt.Color(0, 0, 255));
        LtcCyLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        LtcCyLogo.setOpaque(true);
        LtcCyLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LtcCyLogoMouseClicked(evt);
            }
        });

        LtcUtile.setBackground(new java.awt.Color(0, 0, 255));
        LtcUtile.setFont(new java.awt.Font("Segoe UI Light", 0, 60)); // NOI18N
        LtcUtile.setText("Links Úteis - Litecoin : ");
        LtcUtile.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        LtcUtile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LtcUtileMouseClicked(evt);
            }
        });

        LtcForum.setBackground(new java.awt.Color(0, 0, 255));
        LtcForum.setFont(new java.awt.Font("Segoe UI Light", 0, 52)); // NOI18N
        LtcForum.setText("Fórum Oficial");
        LtcForum.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        LtcForum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LtcForumMouseClicked(evt);
            }
        });

        LtcOfSite.setBackground(new java.awt.Color(0, 0, 255));
        LtcOfSite.setFont(new java.awt.Font("Segoe UI Light", 0, 52)); // NOI18N
        LtcOfSite.setText("Site Oficial");
        LtcOfSite.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        LtcOfSite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LtcOfSiteMouseClicked(evt);
            }
        });

        LtcCy.setBackground(new java.awt.Color(0, 0, 255));
        LtcCy.setFont(new java.awt.Font("Segoe UI Light", 0, 51)); // NOI18N
        LtcCy.setText("Transações ao Vivo");
        LtcCy.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        LtcCy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LtcCyMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout LtcSidePanelLayout = new javax.swing.GroupLayout(LtcSidePanel);
        LtcSidePanel.setLayout(LtcSidePanelLayout);
        LtcSidePanelLayout.setHorizontalGroup(
            LtcSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LtcSidePanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(LtcSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LtcUtile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(LtcSidePanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(LtcSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(LtcSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(LtcSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(LtcSidePanelLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(LtcCGLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(LtcSidePanelLayout.createSequentialGroup()
                                        .addComponent(LtcOfSiteLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(LtcSidePanelLayout.createSequentialGroup()
                                    .addComponent(LtcForumLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)))
                            .addGroup(LtcSidePanelLayout.createSequentialGroup()
                                .addComponent(LtcCyLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(LtcSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LtcCy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LtcForum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LtcOfSite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LtcCG, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)))))
        );
        LtcSidePanelLayout.setVerticalGroup(
            LtcSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LtcSidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LtcUtile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(64, 64, 64)
                .addGroup(LtcSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LtcCGLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LtcCG, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(LtcSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LtcOfSiteLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LtcOfSite, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(LtcSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LtcForumLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LtcForum, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(LtcSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LtcCy, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LtcCyLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(199, 199, 199))
        );

        XmrBG6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bitknow/resources/Final7.png"))); // NOI18N
        XmrBG6.setPreferredSize(new java.awt.Dimension(1268, 677));

        javax.swing.GroupLayout LtcPanelLayout = new javax.swing.GroupLayout(LtcPanel);
        LtcPanel.setLayout(LtcPanelLayout);
        LtcPanelLayout.setHorizontalGroup(
            LtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LtcPanelLayout.createSequentialGroup()
                .addGroup(LtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LtcPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(LtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LtcTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(LtcPanelLayout.createSequentialGroup()
                                .addComponent(LtcValue, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LtcVChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(LtcConversion)
                            .addGroup(LtcPanelLayout.createSequentialGroup()
                                .addComponent(LtcResult, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LtcConvert)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(LtcClear, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(LtcPanelLayout.createSequentialGroup()
                                .addComponent(LtcEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LtcCChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(LtcHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(LtcSidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LtcTop, javax.swing.GroupLayout.DEFAULT_SIZE, 1286, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(LtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LtcPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(XmrBG6, javax.swing.GroupLayout.PREFERRED_SIZE, 1276, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        LtcPanelLayout.setVerticalGroup(
            LtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LtcPanelLayout.createSequentialGroup()
                .addComponent(LtcTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LtcSidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 694, Short.MAX_VALUE)
                    .addGroup(LtcPanelLayout.createSequentialGroup()
                        .addComponent(LtcTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(LtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LtcVChoose)
                            .addComponent(LtcValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LtcHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LtcConversion, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(LtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LtcEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LtcCChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(LtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LtcResult, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LtcConvert, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LtcClear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(LtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LtcPanelLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(XmrBG6, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(16, Short.MAX_VALUE)))
        );

        Root.add(LtcPanel, "LtcPanel");

        XmrPanel.setBackground(new java.awt.Color(15, 15, 15));
        XmrPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        XmrPanel.setMaximumSize(new java.awt.Dimension(1280, 720));
        XmrPanel.setMinimumSize(new java.awt.Dimension(1280, 720));

        XmrTop.setBackground(new java.awt.Color(255, 255, 255));
        XmrTop.setMinimumSize(new java.awt.Dimension(1276, 30));
        XmrTop.setName(""); // NOI18N
        XmrTop.setPreferredSize(new java.awt.Dimension(815, 30));

        XmrClose.setBackground(new java.awt.Color(255, 255, 255));
        XmrClose.setFont(new java.awt.Font("Oswald", 0, 24)); // NOI18N
        XmrClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        XmrClose.setText("X");
        XmrClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                XmrCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                XmrCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                XmrCloseMouseExited(evt);
            }
        });

        XmrBack.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        XmrBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bitknow/resources/BackIconBlack.png"))); // NOI18N
        XmrBack.setContentAreaFilled(false);
        XmrBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XmrBackActionPerformed(evt);
            }
        });

        XmrRefresh.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        XmrRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bitknow/resources/RefreshBlack.png"))); // NOI18N
        XmrRefresh.setContentAreaFilled(false);
        XmrRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XmrRefreshActionPerformed(evt);
            }
        });

        XmrMinimize.setBackground(new java.awt.Color(255, 255, 255));
        XmrMinimize.setFont(new java.awt.Font("Oswald", 0, 48)); // NOI18N
        XmrMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        XmrMinimize.setText("-");
        XmrMinimize.setMaximumSize(new java.awt.Dimension(12, 30));
        XmrMinimize.setMinimumSize(new java.awt.Dimension(12, 30));
        XmrMinimize.setPreferredSize(new java.awt.Dimension(12, 30));
        XmrMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                XmrMinimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                XmrMinimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                XmrMinimizeMouseExited(evt);
            }
        });

        XmrMainTitle.setFont(new java.awt.Font("Segoe UI Semibold", 0, 19)); // NOI18N
        XmrMainTitle.setText("BitKnow - Monero");

        javax.swing.GroupLayout XmrTopLayout = new javax.swing.GroupLayout(XmrTop);
        XmrTop.setLayout(XmrTopLayout);
        XmrTopLayout.setHorizontalGroup(
            XmrTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, XmrTopLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(XmrBack, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(XmrRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(473, 473, 473)
                .addComponent(XmrMainTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(XmrMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(XmrClose)
                .addContainerGap())
        );
        XmrTopLayout.setVerticalGroup(
            XmrTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, XmrTopLayout.createSequentialGroup()
                .addGroup(XmrTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(XmrMainTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(XmrBack, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(XmrMinimize, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, XmrTopLayout.createSequentialGroup()
                        .addComponent(XmrClose, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(XmrRefresh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        XmrTitle.setBackground(new java.awt.Color(247, 147, 26));
        XmrTitle.setFont(new java.awt.Font("Segoe UI Semilight", 0, 55)); // NOI18N
        XmrTitle.setForeground(new java.awt.Color(255, 255, 255));
        XmrTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        XmrTitle.setText("Monero (Xmr)");
        XmrTitle.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        XmrTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        XmrConversion.setBackground(new java.awt.Color(247, 147, 26));
        XmrConversion.setFont(new java.awt.Font("Segoe UI Semilight", 0, 48)); // NOI18N
        XmrConversion.setForeground(new java.awt.Color(255, 255, 255));
        XmrConversion.setText("Conversão:");
        XmrConversion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        XmrVChoose.setFont(new java.awt.Font("Source Sans Pro", 0, 20)); // NOI18N
        XmrVChoose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "brl", "usd", "eur", "jpy", "gbp", "cad", "mxn" }));
        XmrVChoose.setToolTipText("Escolha uma moeda");
        XmrVChoose.setBorder(null);
        XmrVChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XmrVChooseActionPerformed(evt);
            }
        });

        XmrEnter.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        XmrEnter.setForeground(new java.awt.Color(204, 204, 204));
        XmrEnter.setText("Digite o valor aqui");
        XmrEnter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                XmrEnterMouseClicked(evt);
            }
        });
        XmrEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XmrEnterActionPerformed(evt);
            }
        });

        XmrCChoose.setFont(new java.awt.Font("Source Sans Pro", 0, 16)); // NOI18N
        XmrCChoose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "brl", "usd", "eur", "jpy", "gbp", "cad", "mxn" }));
        XmrCChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XmrCChooseActionPerformed(evt);
            }
        });

        XmrConvert.setFont(new java.awt.Font("Source Sans Pro", 0, 12)); // NOI18N
        XmrConvert.setText("Converter");
        XmrConvert.setBorderPainted(false);
        XmrConvert.setDefaultCapable(false);
        XmrConvert.setFocusPainted(false);
        XmrConvert.setRequestFocusEnabled(false);
        XmrConvert.setRolloverEnabled(false);
        XmrConvert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XmrConvertActionPerformed(evt);
            }
        });

        XmrClear.setFont(new java.awt.Font("Source Sans Pro", 0, 12)); // NOI18N
        XmrClear.setText("Limpar");
        XmrClear.setBorderPainted(false);
        XmrClear.setDefaultCapable(false);
        XmrClear.setFocusPainted(false);
        XmrClear.setRequestFocusEnabled(false);
        XmrClear.setRolloverEnabled(false);
        XmrClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XmrClearActionPerformed(evt);
            }
        });

        XmrResult.setEditable(false);
        XmrResult.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        XmrResult.setForeground(new java.awt.Color(204, 204, 204));
        XmrResult.setText("O Resultado aparecerá aqui");
        XmrResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XmrResultActionPerformed(evt);
            }
        });

        XmrValue.setBackground(new java.awt.Color(247, 147, 26));
        XmrValue.setFont(new java.awt.Font("Segoe UI Semilight", 0, 36)); // NOI18N
        XmrValue.setForeground(new java.awt.Color(255, 255, 255));
        XmrValue.setText("1 Xmr ≈ ");
        XmrValue.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        XmrHistory.setBackground(new java.awt.Color(247, 147, 26));
        XmrHistory.setFont(new java.awt.Font("Segoe UI Semibold", 0, 33)); // NOI18N
        XmrHistory.setForeground(new java.awt.Color(255, 255, 255));
        XmrHistory.setText("<html> Info: Monero é uma nova criptomoeda baseada em um protocolo conhecido como Cryptonote, um dos mais seguros\nsistemas monetários digitais. Criada em 2014 por um usário chamado \"thankful_for_today\" e originalmente chamada de BitMonero.");
        XmrHistory.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        XmrHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        XmrCG.setBackground(new java.awt.Color(0, 0, 255));
        XmrCG.setFont(new java.awt.Font("Segoe UI Light", 0, 52)); // NOI18N
        XmrCG.setText("Página do CoinGecko");
        XmrCG.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        XmrCG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                XmrCGMouseClicked(evt);
            }
        });

        XmrCGLogo.setBackground(new java.awt.Color(0, 0, 255));
        XmrCGLogo.setFont(new java.awt.Font("Oswald", 0, 45)); // NOI18N
        XmrCGLogo.setForeground(new java.awt.Color(0, 0, 255));
        XmrCGLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        XmrCGLogo.setOpaque(true);
        XmrCGLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                XmrCGLogoMouseClicked(evt);
            }
        });

        XmrOfSiteLogo.setBackground(new java.awt.Color(0, 0, 255));
        XmrOfSiteLogo.setFont(new java.awt.Font("Oswald", 0, 45)); // NOI18N
        XmrOfSiteLogo.setForeground(new java.awt.Color(0, 0, 255));
        XmrOfSiteLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        XmrOfSiteLogo.setOpaque(true);
        XmrOfSiteLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                XmrOfSiteLogoMouseClicked(evt);
            }
        });

        XmrForumLogo.setBackground(new java.awt.Color(0, 0, 255));
        XmrForumLogo.setFont(new java.awt.Font("Oswald", 0, 45)); // NOI18N
        XmrForumLogo.setForeground(new java.awt.Color(0, 0, 255));
        XmrForumLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        XmrForumLogo.setOpaque(true);
        XmrForumLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                XmrForumLogoMouseClicked(evt);
            }
        });

        XmrUtile.setBackground(new java.awt.Color(0, 0, 255));
        XmrUtile.setFont(new java.awt.Font("Segoe UI Light", 0, 60)); // NOI18N
        XmrUtile.setText("Links Úteis - Monero : ");
        XmrUtile.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        XmrUtile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                XmrUtileMouseClicked(evt);
            }
        });

        XmrForum.setBackground(new java.awt.Color(0, 0, 255));
        XmrForum.setFont(new java.awt.Font("Segoe UI Light", 0, 52)); // NOI18N
        XmrForum.setText("Fórum Oficial");
        XmrForum.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        XmrForum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                XmrForumMouseClicked(evt);
            }
        });

        XmrOfSite.setBackground(new java.awt.Color(0, 0, 255));
        XmrOfSite.setFont(new java.awt.Font("Segoe UI Light", 0, 52)); // NOI18N
        XmrOfSite.setText("Site Oficial");
        XmrOfSite.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        XmrOfSite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                XmrOfSiteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout XmrSidePanelLayout = new javax.swing.GroupLayout(XmrSidePanel);
        XmrSidePanel.setLayout(XmrSidePanelLayout);
        XmrSidePanelLayout.setHorizontalGroup(
            XmrSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(XmrSidePanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(XmrSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(XmrUtile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(XmrSidePanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(XmrSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(XmrSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(XmrSidePanelLayout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(XmrCGLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18))
                                .addGroup(XmrSidePanelLayout.createSequentialGroup()
                                    .addComponent(XmrOfSiteLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)))
                            .addGroup(XmrSidePanelLayout.createSequentialGroup()
                                .addComponent(XmrForumLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(XmrSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(XmrForum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(XmrOfSite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(XmrCG, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)))))
        );
        XmrSidePanelLayout.setVerticalGroup(
            XmrSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(XmrSidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(XmrUtile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(64, 64, 64)
                .addGroup(XmrSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(XmrCGLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(XmrCG, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(XmrSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(XmrOfSiteLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(XmrOfSite, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(XmrSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(XmrForumLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(XmrForum, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(329, 329, 329))
        );

        XmrBG7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bitknow/resources/Final7.png"))); // NOI18N
        XmrBG7.setPreferredSize(new java.awt.Dimension(1268, 677));

        javax.swing.GroupLayout XmrPanelLayout = new javax.swing.GroupLayout(XmrPanel);
        XmrPanel.setLayout(XmrPanelLayout);
        XmrPanelLayout.setHorizontalGroup(
            XmrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(XmrPanelLayout.createSequentialGroup()
                .addGroup(XmrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, XmrPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(XmrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(XmrTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(XmrPanelLayout.createSequentialGroup()
                                .addComponent(XmrValue, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(XmrVChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(XmrPanelLayout.createSequentialGroup()
                                .addComponent(XmrResult, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(XmrConvert)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(XmrClear, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(XmrPanelLayout.createSequentialGroup()
                                .addGroup(XmrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(XmrConversion)
                                    .addComponent(XmrEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(XmrCChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(XmrHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(XmrSidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(XmrTop, javax.swing.GroupLayout.DEFAULT_SIZE, 1286, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(XmrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(XmrPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(XmrBG7, javax.swing.GroupLayout.PREFERRED_SIZE, 1276, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        XmrPanelLayout.setVerticalGroup(
            XmrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(XmrPanelLayout.createSequentialGroup()
                .addComponent(XmrTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(XmrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(XmrSidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 691, Short.MAX_VALUE)
                    .addGroup(XmrPanelLayout.createSequentialGroup()
                        .addComponent(XmrTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(XmrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(XmrVChoose)
                            .addComponent(XmrValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(XmrHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(XmrConversion, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(XmrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(XmrEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(XmrCChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(XmrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(XmrResult, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(XmrConvert, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(XmrClear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(XmrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(XmrPanelLayout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addComponent(XmrBG7, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        Root.add(XmrPanel, "XmrPanel");

        DogePanel.setBackground(new java.awt.Color(225, 179, 3));
        DogePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        DogePanel.setMaximumSize(new java.awt.Dimension(1280, 720));
        DogePanel.setMinimumSize(new java.awt.Dimension(1280, 720));

        DogeTop.setBackground(new java.awt.Color(255, 255, 255));
        DogeTop.setMinimumSize(new java.awt.Dimension(1276, 30));
        DogeTop.setName(""); // NOI18N
        DogeTop.setPreferredSize(new java.awt.Dimension(815, 30));

        DogeClose.setBackground(new java.awt.Color(255, 255, 255));
        DogeClose.setFont(new java.awt.Font("Oswald", 0, 24)); // NOI18N
        DogeClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DogeClose.setText("X");
        DogeClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DogeCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DogeCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DogeCloseMouseExited(evt);
            }
        });

        DogeBack.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        DogeBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bitknow/resources/BackIconBlack.png"))); // NOI18N
        DogeBack.setContentAreaFilled(false);
        DogeBack.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DogeBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DogeBackActionPerformed(evt);
            }
        });

        DogeRefresh.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        DogeRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bitknow/resources/RefreshBlack.png"))); // NOI18N
        DogeRefresh.setContentAreaFilled(false);
        DogeRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DogeRefreshActionPerformed(evt);
            }
        });

        DogeMinimize.setBackground(new java.awt.Color(255, 255, 255));
        DogeMinimize.setFont(new java.awt.Font("Oswald", 0, 48)); // NOI18N
        DogeMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DogeMinimize.setText("-");
        DogeMinimize.setMaximumSize(new java.awt.Dimension(12, 30));
        DogeMinimize.setMinimumSize(new java.awt.Dimension(12, 30));
        DogeMinimize.setPreferredSize(new java.awt.Dimension(12, 30));
        DogeMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DogeMinimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DogeMinimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DogeMinimizeMouseExited(evt);
            }
        });

        DogeMainTitle.setFont(new java.awt.Font("Segoe UI Semibold", 0, 19)); // NOI18N
        DogeMainTitle.setText("BitKnow - Dogecoin");

        javax.swing.GroupLayout DogeTopLayout = new javax.swing.GroupLayout(DogeTop);
        DogeTop.setLayout(DogeTopLayout);
        DogeTopLayout.setHorizontalGroup(
            DogeTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DogeTopLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(DogeBack, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DogeRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(472, 472, 472)
                .addComponent(DogeMainTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 474, Short.MAX_VALUE)
                .addComponent(DogeMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DogeClose)
                .addContainerGap())
        );
        DogeTopLayout.setVerticalGroup(
            DogeTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DogeTopLayout.createSequentialGroup()
                .addGroup(DogeTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DogeMinimize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(DogeTopLayout.createSequentialGroup()
                        .addComponent(DogeClose, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(DogeTopLayout.createSequentialGroup()
                .addGroup(DogeTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(DogeBack, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(DogeRefresh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(DogeMainTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        DogeTitle.setBackground(new java.awt.Color(247, 147, 26));
        DogeTitle.setFont(new java.awt.Font("Segoe UI Semilight", 0, 55)); // NOI18N
        DogeTitle.setForeground(new java.awt.Color(255, 255, 255));
        DogeTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DogeTitle.setText("Dogecoin (Doge)");
        DogeTitle.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        DogeTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        DogeConversion.setBackground(new java.awt.Color(247, 147, 26));
        DogeConversion.setFont(new java.awt.Font("Segoe UI Semilight", 0, 48)); // NOI18N
        DogeConversion.setForeground(new java.awt.Color(255, 255, 255));
        DogeConversion.setText("Conversão:");
        DogeConversion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        DogeVChoose.setFont(new java.awt.Font("Source Sans Pro", 0, 20)); // NOI18N
        DogeVChoose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "brl", "usd", "eur", "jpy", "gbp", "cad", "mxn" }));
        DogeVChoose.setToolTipText("Escolha uma moeda");
        DogeVChoose.setBorder(null);
        DogeVChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DogeVChooseActionPerformed(evt);
            }
        });

        DogeEnter.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        DogeEnter.setForeground(new java.awt.Color(204, 204, 204));
        DogeEnter.setText("Digite o valor aqui");
        DogeEnter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DogeEnterMouseClicked(evt);
            }
        });
        DogeEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DogeEnterActionPerformed(evt);
            }
        });

        DogeCChoose.setFont(new java.awt.Font("Source Sans Pro", 0, 16)); // NOI18N
        DogeCChoose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "brl", "usd", "eur", "jpy", "gbp", "cad", "mxn" }));
        DogeCChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DogeCChooseActionPerformed(evt);
            }
        });

        DogeConvert.setFont(new java.awt.Font("Source Sans Pro", 0, 12)); // NOI18N
        DogeConvert.setText("Converter");
        DogeConvert.setBorderPainted(false);
        DogeConvert.setDefaultCapable(false);
        DogeConvert.setFocusPainted(false);
        DogeConvert.setRequestFocusEnabled(false);
        DogeConvert.setRolloverEnabled(false);
        DogeConvert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DogeConvertActionPerformed(evt);
            }
        });

        DogeClear.setFont(new java.awt.Font("Source Sans Pro", 0, 12)); // NOI18N
        DogeClear.setText("Limpar");
        DogeClear.setBorderPainted(false);
        DogeClear.setDefaultCapable(false);
        DogeClear.setFocusPainted(false);
        DogeClear.setRequestFocusEnabled(false);
        DogeClear.setRolloverEnabled(false);
        DogeClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DogeClearActionPerformed(evt);
            }
        });

        DogeResult.setEditable(false);
        DogeResult.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        DogeResult.setForeground(new java.awt.Color(204, 204, 204));
        DogeResult.setText("O Resultado aparecerá aqui");
        DogeResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DogeResultActionPerformed(evt);
            }
        });

        DogeValue.setBackground(new java.awt.Color(247, 147, 26));
        DogeValue.setFont(new java.awt.Font("Segoe UI Semilight", 0, 36)); // NOI18N
        DogeValue.setForeground(new java.awt.Color(255, 255, 255));
        DogeValue.setText("1 Doge ≈ ");
        DogeValue.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        DogeHistory.setBackground(new java.awt.Color(247, 147, 26));
        DogeHistory.setFont(new java.awt.Font("Segoe UI Semibold", 0, 26)); // NOI18N
        DogeHistory.setForeground(new java.awt.Color(255, 255, 255));
        DogeHistory.setText("<html> Info : Dogecoin é uma criptomoeda baseada no popular meme da internet Doge, é uma moeda inflacionada\ne esse é seu propósito, valer pouco e ter uma moeda divertida que pode servir como \"gorjeta virtual\". <br>\nA moeda foi lançada realmente com o propósito de ser uma piada por Billy Markus em 2013, mas acabou se tornando\numa moeda muito utilizada e muito conhecida.");
        DogeHistory.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        DogeHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        DogeCG.setBackground(new java.awt.Color(0, 0, 255));
        DogeCG.setFont(new java.awt.Font("Segoe UI Light", 0, 52)); // NOI18N
        DogeCG.setText("Página do CoinGecko");
        DogeCG.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DogeCG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DogeCGMouseClicked(evt);
            }
        });

        DogeCGLogo.setBackground(new java.awt.Color(0, 0, 255));
        DogeCGLogo.setFont(new java.awt.Font("Oswald", 0, 45)); // NOI18N
        DogeCGLogo.setForeground(new java.awt.Color(0, 0, 255));
        DogeCGLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DogeCGLogo.setOpaque(true);
        DogeCGLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DogeCGLogoMouseClicked(evt);
            }
        });

        DogeOfSiteLogo.setBackground(new java.awt.Color(0, 0, 255));
        DogeOfSiteLogo.setFont(new java.awt.Font("Oswald", 0, 45)); // NOI18N
        DogeOfSiteLogo.setForeground(new java.awt.Color(0, 0, 255));
        DogeOfSiteLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DogeOfSiteLogo.setOpaque(true);
        DogeOfSiteLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DogeOfSiteLogoMouseClicked(evt);
            }
        });

        DogeForumLogo.setBackground(new java.awt.Color(0, 0, 255));
        DogeForumLogo.setFont(new java.awt.Font("Oswald", 0, 45)); // NOI18N
        DogeForumLogo.setForeground(new java.awt.Color(0, 0, 255));
        DogeForumLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DogeForumLogo.setOpaque(true);
        DogeForumLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DogeForumLogoMouseClicked(evt);
            }
        });

        DogeUtile.setBackground(new java.awt.Color(0, 0, 255));
        DogeUtile.setFont(new java.awt.Font("Segoe UI Light", 0, 60)); // NOI18N
        DogeUtile.setText("Links Úteis - Dogecoin :");
        DogeUtile.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DogeUtile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DogeUtileMouseClicked(evt);
            }
        });

        DogeForum.setBackground(new java.awt.Color(0, 0, 255));
        DogeForum.setFont(new java.awt.Font("Segoe UI Light", 0, 52)); // NOI18N
        DogeForum.setText("Fórum Oficial");
        DogeForum.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DogeForum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DogeForumMouseClicked(evt);
            }
        });

        DogeOfSite.setBackground(new java.awt.Color(0, 0, 255));
        DogeOfSite.setFont(new java.awt.Font("Segoe UI Light", 0, 52)); // NOI18N
        DogeOfSite.setText("Site Oficial");
        DogeOfSite.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DogeOfSite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DogeOfSiteMouseClicked(evt);
            }
        });

        DogeCy.setBackground(new java.awt.Color(0, 0, 255));
        DogeCy.setFont(new java.awt.Font("Segoe UI Light", 0, 51)); // NOI18N
        DogeCy.setText("Transações ao Vivo");
        DogeCy.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DogeCy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DogeCyMouseClicked(evt);
            }
        });

        DogeCyLogo.setBackground(new java.awt.Color(0, 0, 255));
        DogeCyLogo.setFont(new java.awt.Font("Oswald", 0, 45)); // NOI18N
        DogeCyLogo.setForeground(new java.awt.Color(0, 0, 255));
        DogeCyLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DogeCyLogo.setOpaque(true);
        DogeCyLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DogeCyLogoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout DogeSidePanelLayout = new javax.swing.GroupLayout(DogeSidePanel);
        DogeSidePanel.setLayout(DogeSidePanelLayout);
        DogeSidePanelLayout.setHorizontalGroup(
            DogeSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DogeSidePanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(DogeSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DogeUtile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DogeSidePanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(DogeSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DogeSidePanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(DogeCGLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(DogeSidePanelLayout.createSequentialGroup()
                                .addGroup(DogeSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DogeOfSiteLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DogeForumLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DogeCyLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(DogeSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(DogeSidePanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(DogeCy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(DogeForum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DogeOfSite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DogeCG, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)))))
        );
        DogeSidePanelLayout.setVerticalGroup(
            DogeSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DogeSidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DogeUtile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(64, 64, 64)
                .addGroup(DogeSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DogeCGLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DogeCG, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DogeSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DogeOfSiteLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DogeOfSite, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DogeSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DogeForumLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DogeForum, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DogeSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DogeCy, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DogeCyLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(211, 211, 211))
        );

        XmrBG8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bitknow/resources/Final7.png"))); // NOI18N
        XmrBG8.setPreferredSize(new java.awt.Dimension(1268, 677));

        javax.swing.GroupLayout DogePanelLayout = new javax.swing.GroupLayout(DogePanel);
        DogePanel.setLayout(DogePanelLayout);
        DogePanelLayout.setHorizontalGroup(
            DogePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DogePanelLayout.createSequentialGroup()
                .addGroup(DogePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DogePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(DogePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DogePanelLayout.createSequentialGroup()
                                .addComponent(DogeValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(DogeVChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(DogePanelLayout.createSequentialGroup()
                                .addComponent(DogeResult, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(DogeConvert)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DogeClear, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(DogePanelLayout.createSequentialGroup()
                                .addGroup(DogePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DogeConversion)
                                    .addComponent(DogeEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DogeCChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(DogeHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DogeTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(DogeSidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(DogeTop, javax.swing.GroupLayout.DEFAULT_SIZE, 1276, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(DogePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DogePanelLayout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(XmrBG8, javax.swing.GroupLayout.PREFERRED_SIZE, 1276, Short.MAX_VALUE)
                    .addGap(5, 5, 5)))
        );
        DogePanelLayout.setVerticalGroup(
            DogePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DogePanelLayout.createSequentialGroup()
                .addComponent(DogeTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DogePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DogeSidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 691, Short.MAX_VALUE)
                    .addGroup(DogePanelLayout.createSequentialGroup()
                        .addComponent(DogeTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DogePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DogeVChoose)
                            .addComponent(DogeValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DogeHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DogeConversion, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(DogePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DogeEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DogeCChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DogePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DogeResult, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DogeConvert, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DogeClear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(DogePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DogePanelLayout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(XmrBG8, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(15, Short.MAX_VALUE)))
        );

        Root.add(DogePanel, "DogePanel");

        DashPanel.setBackground(new java.awt.Color(0, 140, 227));
        DashPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        DashPanel.setMaximumSize(new java.awt.Dimension(1280, 720));
        DashPanel.setMinimumSize(new java.awt.Dimension(1280, 720));

        DashTop.setBackground(new java.awt.Color(255, 255, 255));
        DashTop.setMinimumSize(new java.awt.Dimension(1276, 30));
        DashTop.setName(""); // NOI18N
        DashTop.setPreferredSize(new java.awt.Dimension(815, 30));

        DashClose.setBackground(new java.awt.Color(255, 255, 255));
        DashClose.setFont(new java.awt.Font("Oswald", 0, 24)); // NOI18N
        DashClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashClose.setText("X");
        DashClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashCloseMouseExited(evt);
            }
        });

        DashBack.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        DashBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bitknow/resources/BackIconBlack.png"))); // NOI18N
        DashBack.setContentAreaFilled(false);
        DashBack.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DashBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DashBackActionPerformed(evt);
            }
        });

        DashRefresh.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        DashRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bitknow/resources/RefreshBlack.png"))); // NOI18N
        DashRefresh.setContentAreaFilled(false);
        DashRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DashRefreshActionPerformed(evt);
            }
        });

        DashMinimize.setBackground(new java.awt.Color(255, 255, 255));
        DashMinimize.setFont(new java.awt.Font("Oswald", 0, 48)); // NOI18N
        DashMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashMinimize.setText("-");
        DashMinimize.setMaximumSize(new java.awt.Dimension(12, 30));
        DashMinimize.setMinimumSize(new java.awt.Dimension(12, 30));
        DashMinimize.setPreferredSize(new java.awt.Dimension(12, 30));
        DashMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashMinimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashMinimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashMinimizeMouseExited(evt);
            }
        });

        DashMainTitle.setFont(new java.awt.Font("Segoe UI Semibold", 0, 19)); // NOI18N
        DashMainTitle.setText("BitKnow - Dash");

        javax.swing.GroupLayout DashTopLayout = new javax.swing.GroupLayout(DashTop);
        DashTop.setLayout(DashTopLayout);
        DashTopLayout.setHorizontalGroup(
            DashTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashTopLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(DashBack, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DashRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(483, 483, 483)
                .addComponent(DashMainTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DashMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DashClose)
                .addContainerGap())
        );
        DashTopLayout.setVerticalGroup(
            DashTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashTopLayout.createSequentialGroup()
                .addGroup(DashTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DashMinimize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(DashTopLayout.createSequentialGroup()
                        .addComponent(DashClose, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(DashTopLayout.createSequentialGroup()
                .addGroup(DashTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(DashBack, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(DashRefresh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(DashMainTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        DashTitle.setBackground(new java.awt.Color(247, 147, 26));
        DashTitle.setFont(new java.awt.Font("Segoe UI Semilight", 0, 55)); // NOI18N
        DashTitle.setForeground(new java.awt.Color(255, 255, 255));
        DashTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DashTitle.setText("Dash (Dash)");
        DashTitle.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        DashTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        DashConversion.setBackground(new java.awt.Color(247, 147, 26));
        DashConversion.setFont(new java.awt.Font("Segoe UI Semilight", 0, 48)); // NOI18N
        DashConversion.setForeground(new java.awt.Color(255, 255, 255));
        DashConversion.setText("Conversão:");
        DashConversion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        DashVChoose.setFont(new java.awt.Font("Source Sans Pro", 0, 20)); // NOI18N
        DashVChoose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "brl", "usd", "eur", "jpy", "gbp", "cad", "mxn" }));
        DashVChoose.setToolTipText("Escolha uma moeda");
        DashVChoose.setBorder(null);
        DashVChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DashVChooseActionPerformed(evt);
            }
        });

        DashEnter.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        DashEnter.setForeground(new java.awt.Color(204, 204, 204));
        DashEnter.setText("Digite o valor aqui");
        DashEnter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashEnterMouseClicked(evt);
            }
        });
        DashEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DashEnterActionPerformed(evt);
            }
        });

        DashCChoose.setFont(new java.awt.Font("Source Sans Pro", 0, 16)); // NOI18N
        DashCChoose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "brl", "usd", "eur", "jpy", "gbp", "cad", "mxn" }));
        DashCChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DashCChooseActionPerformed(evt);
            }
        });

        DashConvert.setFont(new java.awt.Font("Source Sans Pro", 0, 12)); // NOI18N
        DashConvert.setText("Converter");
        DashConvert.setBorderPainted(false);
        DashConvert.setDefaultCapable(false);
        DashConvert.setFocusPainted(false);
        DashConvert.setRequestFocusEnabled(false);
        DashConvert.setRolloverEnabled(false);
        DashConvert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DashConvertActionPerformed(evt);
            }
        });

        DashClear.setFont(new java.awt.Font("Source Sans Pro", 0, 12)); // NOI18N
        DashClear.setText("Limpar");
        DashClear.setBorderPainted(false);
        DashClear.setDefaultCapable(false);
        DashClear.setRequestFocusEnabled(false);
        DashClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DashClearActionPerformed(evt);
            }
        });

        DashResult.setEditable(false);
        DashResult.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        DashResult.setForeground(new java.awt.Color(204, 204, 204));
        DashResult.setText("O Resultado aparecerá aqui");
        DashResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DashResultActionPerformed(evt);
            }
        });

        DashValue.setBackground(new java.awt.Color(247, 147, 26));
        DashValue.setFont(new java.awt.Font("Segoe UI Semilight", 0, 36)); // NOI18N
        DashValue.setForeground(new java.awt.Color(255, 255, 255));
        DashValue.setText("1 Dash ≈ ");
        DashValue.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        DashHistory.setBackground(new java.awt.Color(247, 147, 26));
        DashHistory.setFont(new java.awt.Font("Segoe UI Semibold", 0, 29)); // NOI18N
        DashHistory.setForeground(new java.awt.Color(255, 255, 255));
        DashHistory.setText("<html> Info : Dash (Formalmente conhecida como DarkCoin até 2015) é uma moeda que foca em privacidade e anonimato,\nToda transação Dash se torna anônima na rede por conta de uma tecnologia desenvolvida pela equipe de desenvolvimento\nDash chamada DarkSend. <br> Dash (Na Época chamada DarkCoin) foi lançada em 2014 por Evan Duffield.");
        DashHistory.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        DashHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        DashCG.setBackground(new java.awt.Color(0, 0, 255));
        DashCG.setFont(new java.awt.Font("Segoe UI Light", 0, 52)); // NOI18N
        DashCG.setText("Página do CoinGecko");
        DashCG.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DashCG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashCGMouseClicked(evt);
            }
        });

        DashCGLogo.setBackground(new java.awt.Color(0, 0, 255));
        DashCGLogo.setFont(new java.awt.Font("Oswald", 0, 45)); // NOI18N
        DashCGLogo.setForeground(new java.awt.Color(0, 0, 255));
        DashCGLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DashCGLogo.setOpaque(true);
        DashCGLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashCGLogoMouseClicked(evt);
            }
        });

        DashOfSiteLogo.setBackground(new java.awt.Color(0, 0, 255));
        DashOfSiteLogo.setFont(new java.awt.Font("Oswald", 0, 45)); // NOI18N
        DashOfSiteLogo.setForeground(new java.awt.Color(0, 0, 255));
        DashOfSiteLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DashOfSiteLogo.setOpaque(true);
        DashOfSiteLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashOfSiteLogoMouseClicked(evt);
            }
        });

        DashForumLogo.setBackground(new java.awt.Color(0, 0, 255));
        DashForumLogo.setFont(new java.awt.Font("Oswald", 0, 45)); // NOI18N
        DashForumLogo.setForeground(new java.awt.Color(0, 0, 255));
        DashForumLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DashForumLogo.setOpaque(true);
        DashForumLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashForumLogoMouseClicked(evt);
            }
        });

        DashUtile.setBackground(new java.awt.Color(0, 0, 255));
        DashUtile.setFont(new java.awt.Font("Segoe UI Light", 0, 60)); // NOI18N
        DashUtile.setText("Links Úteis - Dash :");
        DashUtile.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DashUtile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashUtileMouseClicked(evt);
            }
        });

        DashForum.setBackground(new java.awt.Color(0, 0, 255));
        DashForum.setFont(new java.awt.Font("Segoe UI Light", 0, 52)); // NOI18N
        DashForum.setText("Fórum Oficial");
        DashForum.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DashForum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashForumMouseClicked(evt);
            }
        });

        DashOfSite.setBackground(new java.awt.Color(0, 0, 255));
        DashOfSite.setFont(new java.awt.Font("Segoe UI Light", 0, 52)); // NOI18N
        DashOfSite.setText("Site Oficial");
        DashOfSite.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DashOfSite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashOfSiteMouseClicked(evt);
            }
        });

        DashCy.setBackground(new java.awt.Color(0, 0, 255));
        DashCy.setFont(new java.awt.Font("Segoe UI Light", 0, 51)); // NOI18N
        DashCy.setText("Transações ao Vivo");
        DashCy.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DashCy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashCyMouseClicked(evt);
            }
        });

        DashCyLogo.setBackground(new java.awt.Color(0, 0, 255));
        DashCyLogo.setFont(new java.awt.Font("Oswald", 0, 45)); // NOI18N
        DashCyLogo.setForeground(new java.awt.Color(0, 0, 255));
        DashCyLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DashCyLogo.setOpaque(true);
        DashCyLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashCyLogoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout DashSidePanelLayout = new javax.swing.GroupLayout(DashSidePanel);
        DashSidePanel.setLayout(DashSidePanelLayout);
        DashSidePanelLayout.setHorizontalGroup(
            DashSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashSidePanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(DashSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DashUtile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashSidePanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(DashSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DashSidePanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(DashCGLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(DashSidePanelLayout.createSequentialGroup()
                                .addGroup(DashSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DashOfSiteLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DashForumLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DashCyLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(DashSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(DashSidePanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(DashCy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(DashForum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DashOfSite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DashCG, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)))))
        );
        DashSidePanelLayout.setVerticalGroup(
            DashSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashSidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DashUtile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(64, 64, 64)
                .addGroup(DashSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DashCGLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DashCG, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DashSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DashOfSiteLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DashOfSite, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DashSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DashForumLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DashForum, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DashSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DashCy, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DashCyLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(211, 211, 211))
        );

        XmrBG9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bitknow/resources/Final7.png"))); // NOI18N
        XmrBG9.setPreferredSize(new java.awt.Dimension(1268, 677));

        javax.swing.GroupLayout DashPanelLayout = new javax.swing.GroupLayout(DashPanel);
        DashPanel.setLayout(DashPanelLayout);
        DashPanelLayout.setHorizontalGroup(
            DashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashPanelLayout.createSequentialGroup()
                .addGroup(DashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(DashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DashPanelLayout.createSequentialGroup()
                                .addComponent(DashValue, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(DashVChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(DashPanelLayout.createSequentialGroup()
                                .addComponent(DashResult, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(DashConvert)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DashClear, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(DashPanelLayout.createSequentialGroup()
                                .addGroup(DashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DashConversion)
                                    .addComponent(DashEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DashCChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(DashHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DashTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(DashSidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(DashTop, javax.swing.GroupLayout.DEFAULT_SIZE, 1276, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(DashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashPanelLayout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(XmrBG9, javax.swing.GroupLayout.PREFERRED_SIZE, 1276, Short.MAX_VALUE)
                    .addGap(5, 5, 5)))
        );
        DashPanelLayout.setVerticalGroup(
            DashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashPanelLayout.createSequentialGroup()
                .addComponent(DashTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DashSidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 691, Short.MAX_VALUE)
                    .addGroup(DashPanelLayout.createSequentialGroup()
                        .addComponent(DashTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DashVChoose)
                            .addComponent(DashValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DashHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DashConversion, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(DashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DashEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DashCChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DashResult, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DashConvert, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DashClear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(DashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashPanelLayout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(XmrBG9, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(15, Short.MAX_VALUE)))
        );

        Root.add(DashPanel, "DashPanel");

        BchPanel.setBackground(new java.awt.Color(141, 195, 81));
        BchPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        BchPanel.setMaximumSize(new java.awt.Dimension(1280, 720));
        BchPanel.setMinimumSize(new java.awt.Dimension(1280, 720));

        BchTop.setBackground(new java.awt.Color(255, 255, 255));
        BchTop.setMinimumSize(new java.awt.Dimension(1276, 30));
        BchTop.setName(""); // NOI18N
        BchTop.setPreferredSize(new java.awt.Dimension(815, 30));

        BchClose.setBackground(new java.awt.Color(255, 255, 255));
        BchClose.setFont(new java.awt.Font("Oswald", 0, 24)); // NOI18N
        BchClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BchClose.setText("X");
        BchClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BchCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BchCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BchCloseMouseExited(evt);
            }
        });

        BchBack.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        BchBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bitknow/resources/BackIconBlack.png"))); // NOI18N
        BchBack.setContentAreaFilled(false);
        BchBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BchBackActionPerformed(evt);
            }
        });

        BchRefresh.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        BchRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bitknow/resources/RefreshBlack.png"))); // NOI18N
        BchRefresh.setContentAreaFilled(false);
        BchRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BchRefreshActionPerformed(evt);
            }
        });

        BchMinimize.setBackground(new java.awt.Color(255, 255, 255));
        BchMinimize.setFont(new java.awt.Font("Oswald", 0, 48)); // NOI18N
        BchMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BchMinimize.setText("-");
        BchMinimize.setMaximumSize(new java.awt.Dimension(12, 30));
        BchMinimize.setMinimumSize(new java.awt.Dimension(12, 30));
        BchMinimize.setPreferredSize(new java.awt.Dimension(12, 30));
        BchMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BchMinimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BchMinimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BchMinimizeMouseExited(evt);
            }
        });

        BchMainTitle.setFont(new java.awt.Font("Segoe UI Semibold", 0, 19)); // NOI18N
        BchMainTitle.setText("BitKnow - BtcCash");

        javax.swing.GroupLayout BchTopLayout = new javax.swing.GroupLayout(BchTop);
        BchTop.setLayout(BchTopLayout);
        BchTopLayout.setHorizontalGroup(
            BchTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BchTopLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(BchBack, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BchRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(473, 473, 473)
                .addComponent(BchMainTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BchMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BchClose)
                .addContainerGap())
        );
        BchTopLayout.setVerticalGroup(
            BchTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BchTopLayout.createSequentialGroup()
                .addGroup(BchTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BchMainTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BchBack, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(BchMinimize, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, BchTopLayout.createSequentialGroup()
                        .addComponent(BchClose, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(BchRefresh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        BchTitle.setBackground(new java.awt.Color(247, 147, 26));
        BchTitle.setFont(new java.awt.Font("Segoe UI Semilight", 0, 55)); // NOI18N
        BchTitle.setForeground(new java.awt.Color(255, 255, 255));
        BchTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BchTitle.setText("Bitcoin Cash (Bch)");
        BchTitle.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        BchTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        BchConversion.setBackground(new java.awt.Color(247, 147, 26));
        BchConversion.setFont(new java.awt.Font("Segoe UI Semilight", 0, 48)); // NOI18N
        BchConversion.setForeground(new java.awt.Color(255, 255, 255));
        BchConversion.setText("Conversão:");
        BchConversion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        BchVChoose.setFont(new java.awt.Font("Source Sans Pro", 0, 20)); // NOI18N
        BchVChoose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "brl", "usd", "eur", "jpy", "gbp", "cad", "mxn" }));
        BchVChoose.setToolTipText("Escolha uma moeda");
        BchVChoose.setBorder(null);
        BchVChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BchVChooseActionPerformed(evt);
            }
        });

        BchEnter.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        BchEnter.setForeground(new java.awt.Color(204, 204, 204));
        BchEnter.setText("Digite o valor aqui");
        BchEnter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BchEnterMouseClicked(evt);
            }
        });
        BchEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BchEnterActionPerformed(evt);
            }
        });

        BchCChoose.setFont(new java.awt.Font("Source Sans Pro", 0, 16)); // NOI18N
        BchCChoose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "brl", "usd", "eur", "jpy", "gbp", "cad", "mxn" }));
        BchCChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BchCChooseActionPerformed(evt);
            }
        });

        BchConvert.setFont(new java.awt.Font("Source Sans Pro", 0, 12)); // NOI18N
        BchConvert.setText("Converter");
        BchConvert.setBorderPainted(false);
        BchConvert.setDefaultCapable(false);
        BchConvert.setFocusPainted(false);
        BchConvert.setRequestFocusEnabled(false);
        BchConvert.setRolloverEnabled(false);
        BchConvert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BchConvertActionPerformed(evt);
            }
        });

        BchClear.setFont(new java.awt.Font("Source Sans Pro", 0, 12)); // NOI18N
        BchClear.setText("Limpar");
        BchClear.setBorderPainted(false);
        BchClear.setDefaultCapable(false);
        BchClear.setFocusPainted(false);
        BchClear.setRequestFocusEnabled(false);
        BchClear.setRolloverEnabled(false);
        BchClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BchClearActionPerformed(evt);
            }
        });

        BchResult.setEditable(false);
        BchResult.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        BchResult.setForeground(new java.awt.Color(204, 204, 204));
        BchResult.setText("O Resultado aparecerá aqui");
        BchResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BchResultActionPerformed(evt);
            }
        });

        BchValue.setBackground(new java.awt.Color(247, 147, 26));
        BchValue.setFont(new java.awt.Font("Segoe UI Semilight", 0, 36)); // NOI18N
        BchValue.setForeground(new java.awt.Color(255, 255, 255));
        BchValue.setText("1 Bch ≈ ");
        BchValue.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        BchHistory.setBackground(new java.awt.Color(247, 147, 26));
        BchHistory.setFont(new java.awt.Font("Segoe UI Semibold", 0, 28)); // NOI18N
        BchHistory.setForeground(new java.awt.Color(255, 255, 255));
        BchHistory.setText("<html> Info : BitcoinCash é uma moeda que foi criada em 2017 por um processo de separação do Bitcoin, durante a criação da\nmoeda, todos os usuários do bitcoin tiveram suas reservas privadas duplicadas e as duplicadas nomeadas de \"Bitcoin Cash\", que\né uma moeda a parte do Bitcoin e que possui técnicas,protocolos e configurações diferentes.");
        BchHistory.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        BchHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        BchCG.setBackground(new java.awt.Color(0, 0, 255));
        BchCG.setFont(new java.awt.Font("Segoe UI Light", 0, 52)); // NOI18N
        BchCG.setText("Página do CoinGecko");
        BchCG.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BchCG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BchCGMouseClicked(evt);
            }
        });

        BchCGLogo.setBackground(new java.awt.Color(0, 0, 255));
        BchCGLogo.setFont(new java.awt.Font("Oswald", 0, 45)); // NOI18N
        BchCGLogo.setForeground(new java.awt.Color(0, 0, 255));
        BchCGLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BchCGLogo.setOpaque(true);
        BchCGLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BchCGLogoMouseClicked(evt);
            }
        });

        BchOfSiteLogo.setBackground(new java.awt.Color(0, 0, 255));
        BchOfSiteLogo.setFont(new java.awt.Font("Oswald", 0, 45)); // NOI18N
        BchOfSiteLogo.setForeground(new java.awt.Color(0, 0, 255));
        BchOfSiteLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BchOfSiteLogo.setOpaque(true);
        BchOfSiteLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BchOfSiteLogoMouseClicked(evt);
            }
        });

        BchForumLogo.setBackground(new java.awt.Color(0, 0, 255));
        BchForumLogo.setFont(new java.awt.Font("Oswald", 0, 45)); // NOI18N
        BchForumLogo.setForeground(new java.awt.Color(0, 0, 255));
        BchForumLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BchForumLogo.setOpaque(true);
        BchForumLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BchForumLogoMouseClicked(evt);
            }
        });

        BchUtile.setBackground(new java.awt.Color(0, 0, 255));
        BchUtile.setFont(new java.awt.Font("Segoe UI Light", 0, 56)); // NOI18N
        BchUtile.setText("Links Úteis - BitcoinCash :");
        BchUtile.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BchUtile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BchUtileMouseClicked(evt);
            }
        });

        BchForum.setBackground(new java.awt.Color(0, 0, 255));
        BchForum.setFont(new java.awt.Font("Segoe UI Light", 0, 52)); // NOI18N
        BchForum.setText("Fórum Oficial");
        BchForum.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BchForum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BchForumMouseClicked(evt);
            }
        });

        BchOfSite.setBackground(new java.awt.Color(0, 0, 255));
        BchOfSite.setFont(new java.awt.Font("Segoe UI Light", 0, 52)); // NOI18N
        BchOfSite.setText("Site Oficial");
        BchOfSite.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BchOfSite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BchOfSiteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout BchSidePanelLayout = new javax.swing.GroupLayout(BchSidePanel);
        BchSidePanel.setLayout(BchSidePanelLayout);
        BchSidePanelLayout.setHorizontalGroup(
            BchSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BchSidePanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(BchSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BchUtile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(BchSidePanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(BchSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BchSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(BchSidePanelLayout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(BchCGLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18))
                                .addGroup(BchSidePanelLayout.createSequentialGroup()
                                    .addComponent(BchOfSiteLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)))
                            .addGroup(BchSidePanelLayout.createSequentialGroup()
                                .addComponent(BchForumLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(BchSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BchForum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BchOfSite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BchCG, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)))))
        );
        BchSidePanelLayout.setVerticalGroup(
            BchSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BchSidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BchUtile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(64, 64, 64)
                .addGroup(BchSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BchCGLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BchCG, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BchSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BchOfSiteLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BchOfSite, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BchSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BchForumLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BchForum, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(329, 329, 329))
        );

        XmrBG10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bitknow/resources/Final7.png"))); // NOI18N
        XmrBG10.setPreferredSize(new java.awt.Dimension(1268, 677));

        javax.swing.GroupLayout BchPanelLayout = new javax.swing.GroupLayout(BchPanel);
        BchPanel.setLayout(BchPanelLayout);
        BchPanelLayout.setHorizontalGroup(
            BchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BchPanelLayout.createSequentialGroup()
                .addGroup(BchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BchPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(BchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BchPanelLayout.createSequentialGroup()
                                .addComponent(BchResult, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BchConvert)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BchClear, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BchPanelLayout.createSequentialGroup()
                                .addGroup(BchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BchConversion)
                                    .addComponent(BchEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BchCChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BchHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(BchPanelLayout.createSequentialGroup()
                                .addGroup(BchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(BchValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BchTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE))
                                .addGap(12, 12, 12)
                                .addComponent(BchVChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BchSidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BchTop, javax.swing.GroupLayout.DEFAULT_SIZE, 1286, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(BchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BchPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(XmrBG10, javax.swing.GroupLayout.PREFERRED_SIZE, 1276, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        BchPanelLayout.setVerticalGroup(
            BchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BchPanelLayout.createSequentialGroup()
                .addComponent(BchTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BchSidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 691, Short.MAX_VALUE)
                    .addGroup(BchPanelLayout.createSequentialGroup()
                        .addComponent(BchTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(BchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BchVChoose)
                            .addComponent(BchValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BchHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BchConversion, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(BchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BchEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BchCChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(BchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BchResult, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BchConvert, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BchClear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(BchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BchPanelLayout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addComponent(XmrBG10, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        Root.add(BchPanel, "BchPanel");

        EthPanel.setBackground(new java.awt.Color(60, 60, 61));
        EthPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        EthPanel.setMaximumSize(new java.awt.Dimension(1280, 720));
        EthPanel.setMinimumSize(new java.awt.Dimension(1280, 720));

        EthTop.setBackground(new java.awt.Color(255, 255, 255));
        EthTop.setMinimumSize(new java.awt.Dimension(1276, 30));
        EthTop.setName(""); // NOI18N
        EthTop.setPreferredSize(new java.awt.Dimension(815, 30));

        EthClose.setBackground(new java.awt.Color(255, 255, 255));
        EthClose.setFont(new java.awt.Font("Oswald", 0, 24)); // NOI18N
        EthClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EthClose.setText("X");
        EthClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EthCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EthCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EthCloseMouseExited(evt);
            }
        });

        EthBack.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        EthBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bitknow/resources/BackIconBlack.png"))); // NOI18N
        EthBack.setContentAreaFilled(false);
        EthBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EthBackActionPerformed(evt);
            }
        });

        EthRefresh.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        EthRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bitknow/resources/RefreshBlack.png"))); // NOI18N
        EthRefresh.setContentAreaFilled(false);
        EthRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EthRefreshActionPerformed(evt);
            }
        });

        EthMinimize.setBackground(new java.awt.Color(255, 255, 255));
        EthMinimize.setFont(new java.awt.Font("Oswald", 0, 48)); // NOI18N
        EthMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EthMinimize.setText("-");
        EthMinimize.setMaximumSize(new java.awt.Dimension(12, 30));
        EthMinimize.setMinimumSize(new java.awt.Dimension(12, 30));
        EthMinimize.setPreferredSize(new java.awt.Dimension(12, 30));
        EthMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EthMinimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EthMinimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EthMinimizeMouseExited(evt);
            }
        });

        EthMainTitle.setFont(new java.awt.Font("Segoe UI Semibold", 0, 19)); // NOI18N
        EthMainTitle.setText("BitKnow - Ethereum");

        javax.swing.GroupLayout EthTopLayout = new javax.swing.GroupLayout(EthTop);
        EthTop.setLayout(EthTopLayout);
        EthTopLayout.setHorizontalGroup(
            EthTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EthTopLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(EthBack, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(EthRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(473, 473, 473)
                .addComponent(EthMainTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(EthMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EthClose)
                .addContainerGap())
        );
        EthTopLayout.setVerticalGroup(
            EthTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EthTopLayout.createSequentialGroup()
                .addGroup(EthTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(EthMainTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EthBack, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(EthMinimize, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, EthTopLayout.createSequentialGroup()
                        .addComponent(EthClose, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(EthRefresh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        EthTitle.setBackground(new java.awt.Color(247, 147, 26));
        EthTitle.setFont(new java.awt.Font("Segoe UI Semilight", 0, 55)); // NOI18N
        EthTitle.setForeground(new java.awt.Color(255, 255, 255));
        EthTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        EthTitle.setText("Ethereum (Eth)");
        EthTitle.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        EthTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        EthConversion.setBackground(new java.awt.Color(247, 147, 26));
        EthConversion.setFont(new java.awt.Font("Segoe UI Semilight", 0, 48)); // NOI18N
        EthConversion.setForeground(new java.awt.Color(255, 255, 255));
        EthConversion.setText("Conversão:");
        EthConversion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        EthVChoose.setFont(new java.awt.Font("Source Sans Pro", 0, 20)); // NOI18N
        EthVChoose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "brl", "usd", "eur", "jpy", "gbp", "cad", "mxn" }));
        EthVChoose.setToolTipText("Escolha uma moeda");
        EthVChoose.setBorder(null);
        EthVChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EthVChooseActionPerformed(evt);
            }
        });

        EthEnter.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        EthEnter.setForeground(new java.awt.Color(204, 204, 204));
        EthEnter.setText("Digite o valor aqui");
        EthEnter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EthEnterMouseClicked(evt);
            }
        });
        EthEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EthEnterActionPerformed(evt);
            }
        });

        EthCChoose.setFont(new java.awt.Font("Source Sans Pro", 0, 16)); // NOI18N
        EthCChoose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "brl", "usd", "eur", "jpy", "gbp", "cad", "mxn" }));
        EthCChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EthCChooseActionPerformed(evt);
            }
        });

        EthConvert.setFont(new java.awt.Font("Source Sans Pro", 0, 12)); // NOI18N
        EthConvert.setText("Converter");
        EthConvert.setBorderPainted(false);
        EthConvert.setDefaultCapable(false);
        EthConvert.setFocusPainted(false);
        EthConvert.setRequestFocusEnabled(false);
        EthConvert.setRolloverEnabled(false);
        EthConvert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EthConvertActionPerformed(evt);
            }
        });

        EthClear.setFont(new java.awt.Font("Source Sans Pro", 0, 12)); // NOI18N
        EthClear.setText("Limpar");
        EthClear.setBorderPainted(false);
        EthClear.setDefaultCapable(false);
        EthClear.setFocusPainted(false);
        EthClear.setRequestFocusEnabled(false);
        EthClear.setRolloverEnabled(false);
        EthClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EthClearActionPerformed(evt);
            }
        });

        EthResult.setEditable(false);
        EthResult.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        EthResult.setForeground(new java.awt.Color(204, 204, 204));
        EthResult.setText("O Resultado aparecerá aqui");
        EthResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EthResultActionPerformed(evt);
            }
        });

        EthValue.setBackground(new java.awt.Color(247, 147, 26));
        EthValue.setFont(new java.awt.Font("Segoe UI Semilight", 0, 36)); // NOI18N
        EthValue.setForeground(new java.awt.Color(255, 255, 255));
        EthValue.setText("1 Eth ≈ ");
        EthValue.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        EthHistory.setBackground(new java.awt.Color(247, 147, 26));
        EthHistory.setFont(new java.awt.Font("Segoe UI Semibold", 0, 25)); // NOI18N
        EthHistory.setForeground(new java.awt.Color(255, 255, 255));
        EthHistory.setText("<html> Info : Ethereum foi criada por Vitalik Buterin e lançado em 2015 <br>\nNa verdade, o Ethereum é mais que uma criptomoeda, Ele se trata de uma plataforma de computação compartilhada mundial que\npermite a verificação de Transações, permitindo até o desenvolvimento de aplicativos descentralizados\ncom a tecnologia. A moeda virtual utilizada no Ethereum é na verdade chamada de Ether</html>");
        EthHistory.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        EthHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        EthCG.setBackground(new java.awt.Color(0, 0, 255));
        EthCG.setFont(new java.awt.Font("Segoe UI Light", 0, 52)); // NOI18N
        EthCG.setText("Página do CoinGecko");
        EthCG.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        EthCG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EthCGMouseClicked(evt);
            }
        });

        EthCGLogo.setBackground(new java.awt.Color(0, 0, 255));
        EthCGLogo.setFont(new java.awt.Font("Oswald", 0, 45)); // NOI18N
        EthCGLogo.setForeground(new java.awt.Color(0, 0, 255));
        EthCGLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        EthCGLogo.setOpaque(true);
        EthCGLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EthCGLogoMouseClicked(evt);
            }
        });

        EthOfSiteLogo.setBackground(new java.awt.Color(0, 0, 255));
        EthOfSiteLogo.setFont(new java.awt.Font("Oswald", 0, 45)); // NOI18N
        EthOfSiteLogo.setForeground(new java.awt.Color(0, 0, 255));
        EthOfSiteLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        EthOfSiteLogo.setOpaque(true);
        EthOfSiteLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EthOfSiteLogoMouseClicked(evt);
            }
        });

        EthForumLogo.setBackground(new java.awt.Color(0, 0, 255));
        EthForumLogo.setFont(new java.awt.Font("Oswald", 0, 45)); // NOI18N
        EthForumLogo.setForeground(new java.awt.Color(0, 0, 255));
        EthForumLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        EthForumLogo.setOpaque(true);
        EthForumLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EthForumLogoMouseClicked(evt);
            }
        });

        EthUtile.setBackground(new java.awt.Color(0, 0, 255));
        EthUtile.setFont(new java.awt.Font("Segoe UI Light", 0, 56)); // NOI18N
        EthUtile.setText("Links Úteis - BitcoinCash :");
        EthUtile.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        EthUtile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EthUtileMouseClicked(evt);
            }
        });

        EthForum.setBackground(new java.awt.Color(0, 0, 255));
        EthForum.setFont(new java.awt.Font("Segoe UI Light", 0, 52)); // NOI18N
        EthForum.setText("Fórum Oficial");
        EthForum.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        EthForum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EthForumMouseClicked(evt);
            }
        });

        EthOfSite.setBackground(new java.awt.Color(0, 0, 255));
        EthOfSite.setFont(new java.awt.Font("Segoe UI Light", 0, 52)); // NOI18N
        EthOfSite.setText("Site Oficial");
        EthOfSite.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        EthOfSite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EthOfSiteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout EthSidePanelLayout = new javax.swing.GroupLayout(EthSidePanel);
        EthSidePanel.setLayout(EthSidePanelLayout);
        EthSidePanelLayout.setHorizontalGroup(
            EthSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EthSidePanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(EthSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EthUtile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(EthSidePanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(EthSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EthSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(EthSidePanelLayout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(EthCGLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18))
                                .addGroup(EthSidePanelLayout.createSequentialGroup()
                                    .addComponent(EthOfSiteLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)))
                            .addGroup(EthSidePanelLayout.createSequentialGroup()
                                .addComponent(EthForumLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(EthSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(EthForum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(EthOfSite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(EthCG, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)))))
        );
        EthSidePanelLayout.setVerticalGroup(
            EthSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EthSidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(EthUtile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(64, 64, 64)
                .addGroup(EthSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(EthCGLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EthCG, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(EthSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(EthOfSiteLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EthOfSite, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(EthSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EthForumLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EthForum, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(329, 329, 329))
        );

        XmrBG11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bitknow/resources/Final7.png"))); // NOI18N
        XmrBG11.setPreferredSize(new java.awt.Dimension(1268, 677));

        javax.swing.GroupLayout EthPanelLayout = new javax.swing.GroupLayout(EthPanel);
        EthPanel.setLayout(EthPanelLayout);
        EthPanelLayout.setHorizontalGroup(
            EthPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EthPanelLayout.createSequentialGroup()
                .addGroup(EthPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EthPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(EthPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EthPanelLayout.createSequentialGroup()
                                .addComponent(EthResult, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(EthConvert)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EthClear, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(EthPanelLayout.createSequentialGroup()
                                .addGroup(EthPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(EthConversion)
                                    .addComponent(EthEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EthCChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(EthHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(EthPanelLayout.createSequentialGroup()
                                .addGroup(EthPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(EthValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(EthTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE))
                                .addGap(12, 12, 12)
                                .addComponent(EthVChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EthSidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(EthTop, javax.swing.GroupLayout.DEFAULT_SIZE, 1286, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(EthPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(EthPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(XmrBG11, javax.swing.GroupLayout.PREFERRED_SIZE, 1276, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        EthPanelLayout.setVerticalGroup(
            EthPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EthPanelLayout.createSequentialGroup()
                .addComponent(EthTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EthPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EthSidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 691, Short.MAX_VALUE)
                    .addGroup(EthPanelLayout.createSequentialGroup()
                        .addComponent(EthTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(EthPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(EthVChoose)
                            .addComponent(EthValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EthHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EthConversion, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(EthPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EthEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EthCChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(EthPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EthResult, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EthConvert, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EthClear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(EthPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(EthPanelLayout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addComponent(XmrBG11, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        Root.add(EthPanel, "EthPanel");

        EtcPanel.setBackground(new java.awt.Color(79, 221, 153));
        EtcPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        EtcPanel.setMaximumSize(new java.awt.Dimension(1280, 720));
        EtcPanel.setMinimumSize(new java.awt.Dimension(1280, 720));

        EtcTop.setBackground(new java.awt.Color(255, 255, 255));
        EtcTop.setMinimumSize(new java.awt.Dimension(1276, 30));
        EtcTop.setName(""); // NOI18N
        EtcTop.setPreferredSize(new java.awt.Dimension(815, 30));

        EtcClose.setBackground(new java.awt.Color(255, 255, 255));
        EtcClose.setFont(new java.awt.Font("Oswald", 0, 24)); // NOI18N
        EtcClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EtcClose.setText("X");
        EtcClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EtcCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EtcCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EtcCloseMouseExited(evt);
            }
        });

        EtcBack.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        EtcBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bitknow/resources/BackIconBlack.png"))); // NOI18N
        EtcBack.setContentAreaFilled(false);
        EtcBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EtcBackActionPerformed(evt);
            }
        });

        EtcRefresh.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        EtcRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bitknow/resources/RefreshBlack.png"))); // NOI18N
        EtcRefresh.setContentAreaFilled(false);
        EtcRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EtcRefreshActionPerformed(evt);
            }
        });

        EtcMinimize.setBackground(new java.awt.Color(255, 255, 255));
        EtcMinimize.setFont(new java.awt.Font("Oswald", 0, 48)); // NOI18N
        EtcMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EtcMinimize.setText("-");
        EtcMinimize.setMaximumSize(new java.awt.Dimension(12, 30));
        EtcMinimize.setMinimumSize(new java.awt.Dimension(12, 30));
        EtcMinimize.setPreferredSize(new java.awt.Dimension(12, 30));
        EtcMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EtcMinimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EtcMinimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EtcMinimizeMouseExited(evt);
            }
        });

        EtcMainTitle.setFont(new java.awt.Font("Segoe UI Semibold", 0, 19)); // NOI18N
        EtcMainTitle.setText("BitKnow - Ethereum Classic");

        javax.swing.GroupLayout EtcTopLayout = new javax.swing.GroupLayout(EtcTop);
        EtcTop.setLayout(EtcTopLayout);
        EtcTopLayout.setHorizontalGroup(
            EtcTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EtcTopLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(EtcBack, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(EtcRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(EtcMainTitle)
                .addGap(439, 439, 439)
                .addComponent(EtcMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EtcClose)
                .addContainerGap())
        );
        EtcTopLayout.setVerticalGroup(
            EtcTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EtcTopLayout.createSequentialGroup()
                .addGroup(EtcTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(EtcMainTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EtcBack, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(EtcMinimize, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, EtcTopLayout.createSequentialGroup()
                        .addComponent(EtcClose, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(EtcRefresh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        EtcTitle.setBackground(new java.awt.Color(247, 147, 26));
        EtcTitle.setFont(new java.awt.Font("Segoe UI Semilight", 0, 55)); // NOI18N
        EtcTitle.setForeground(new java.awt.Color(255, 255, 255));
        EtcTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        EtcTitle.setText("Ethereum Classic (Etc)");
        EtcTitle.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        EtcTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        EtcConversion.setBackground(new java.awt.Color(247, 147, 26));
        EtcConversion.setFont(new java.awt.Font("Segoe UI Semilight", 0, 48)); // NOI18N
        EtcConversion.setForeground(new java.awt.Color(255, 255, 255));
        EtcConversion.setText("Conversão:");
        EtcConversion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        EtcVChoose.setFont(new java.awt.Font("Source Sans Pro", 0, 20)); // NOI18N
        EtcVChoose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "brl", "usd", "eur", "jpy", "gbp", "cad", "mxn" }));
        EtcVChoose.setToolTipText("Escolha uma moeda");
        EtcVChoose.setBorder(null);
        EtcVChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EtcVChooseActionPerformed(evt);
            }
        });

        EtcEnter.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        EtcEnter.setForeground(new java.awt.Color(204, 204, 204));
        EtcEnter.setText("Digite o valor aqui");
        EtcEnter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EtcEnterMouseClicked(evt);
            }
        });
        EtcEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EtcEnterActionPerformed(evt);
            }
        });

        EtcCChoose.setFont(new java.awt.Font("Source Sans Pro", 0, 16)); // NOI18N
        EtcCChoose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "brl", "usd", "eur", "jpy", "gbp", "cad", "mxn" }));
        EtcCChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EtcCChooseActionPerformed(evt);
            }
        });

        EtcConvert.setFont(new java.awt.Font("Source Sans Pro", 0, 12)); // NOI18N
        EtcConvert.setText("Converter");
        EtcConvert.setBorderPainted(false);
        EtcConvert.setDefaultCapable(false);
        EtcConvert.setFocusPainted(false);
        EtcConvert.setRequestFocusEnabled(false);
        EtcConvert.setRolloverEnabled(false);
        EtcConvert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EtcConvertActionPerformed(evt);
            }
        });

        EtcClear.setFont(new java.awt.Font("Source Sans Pro", 0, 12)); // NOI18N
        EtcClear.setText("Limpar");
        EtcClear.setBorderPainted(false);
        EtcClear.setDefaultCapable(false);
        EtcClear.setFocusPainted(false);
        EtcClear.setRequestFocusEnabled(false);
        EtcClear.setRolloverEnabled(false);
        EtcClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EtcClearActionPerformed(evt);
            }
        });

        EtcResult.setEditable(false);
        EtcResult.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        EtcResult.setForeground(new java.awt.Color(204, 204, 204));
        EtcResult.setText("O Resultado aparecerá aqui");
        EtcResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EtcResultActionPerformed(evt);
            }
        });

        EtcValue.setBackground(new java.awt.Color(247, 147, 26));
        EtcValue.setFont(new java.awt.Font("Segoe UI Semilight", 0, 36)); // NOI18N
        EtcValue.setForeground(new java.awt.Color(255, 255, 255));
        EtcValue.setText("1 Etc ≈ ");
        EtcValue.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        EtcHistory.setBackground(new java.awt.Color(247, 147, 26));
        EtcHistory.setFont(new java.awt.Font("Segoe UI Semibold", 0, 30)); // NOI18N
        EtcHistory.setForeground(new java.awt.Color(255, 255, 255));
        EtcHistory.setText("<html> Info : Assim como o Ethereum, o Ethereum Classic é uma plataforma que permite verificação de transações e que age com o Ether <br>\nNa verdade, o Ethereum Classic é o Ethereum Original que foi criado em 2015 por Vitalik Buterin, porém que foi dividido em 2 palatormas em 2016.");
        EtcHistory.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        EtcHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        EtcCG.setBackground(new java.awt.Color(0, 0, 255));
        EtcCG.setFont(new java.awt.Font("Segoe UI Light", 0, 52)); // NOI18N
        EtcCG.setText("Página do CoinGecko");
        EtcCG.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        EtcCG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EtcCGMouseClicked(evt);
            }
        });

        EtcCGLogo.setBackground(new java.awt.Color(0, 0, 255));
        EtcCGLogo.setFont(new java.awt.Font("Oswald", 0, 45)); // NOI18N
        EtcCGLogo.setForeground(new java.awt.Color(0, 0, 255));
        EtcCGLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        EtcCGLogo.setOpaque(true);
        EtcCGLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EtcCGLogoMouseClicked(evt);
            }
        });

        EtcOfSiteLogo.setBackground(new java.awt.Color(0, 0, 255));
        EtcOfSiteLogo.setFont(new java.awt.Font("Oswald", 0, 45)); // NOI18N
        EtcOfSiteLogo.setForeground(new java.awt.Color(0, 0, 255));
        EtcOfSiteLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        EtcOfSiteLogo.setOpaque(true);
        EtcOfSiteLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EtcOfSiteLogoMouseClicked(evt);
            }
        });

        EtcForumLogo.setBackground(new java.awt.Color(0, 0, 255));
        EtcForumLogo.setFont(new java.awt.Font("Oswald", 0, 45)); // NOI18N
        EtcForumLogo.setForeground(new java.awt.Color(0, 0, 255));
        EtcForumLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        EtcForumLogo.setOpaque(true);
        EtcForumLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EtcForumLogoMouseClicked(evt);
            }
        });

        EtcUtile.setBackground(new java.awt.Color(0, 0, 255));
        EtcUtile.setFont(new java.awt.Font("Segoe UI Light", 0, 47)); // NOI18N
        EtcUtile.setText("Links Úteis - Ethereum Classic :");
        EtcUtile.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        EtcUtile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EtcUtileMouseClicked(evt);
            }
        });

        EtcForum.setBackground(new java.awt.Color(0, 0, 255));
        EtcForum.setFont(new java.awt.Font("Segoe UI Light", 0, 52)); // NOI18N
        EtcForum.setText("Fórum Oficial");
        EtcForum.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        EtcForum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EtcForumMouseClicked(evt);
            }
        });

        EtcOfSite.setBackground(new java.awt.Color(0, 0, 255));
        EtcOfSite.setFont(new java.awt.Font("Segoe UI Light", 0, 52)); // NOI18N
        EtcOfSite.setText("Site Oficial");
        EtcOfSite.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        EtcOfSite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EtcOfSiteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout EtcSidePanelLayout = new javax.swing.GroupLayout(EtcSidePanel);
        EtcSidePanel.setLayout(EtcSidePanelLayout);
        EtcSidePanelLayout.setHorizontalGroup(
            EtcSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EtcSidePanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(EtcSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EtcUtile, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                    .addGroup(EtcSidePanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(EtcSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EtcSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(EtcSidePanelLayout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(EtcCGLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18))
                                .addGroup(EtcSidePanelLayout.createSequentialGroup()
                                    .addComponent(EtcOfSiteLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)))
                            .addGroup(EtcSidePanelLayout.createSequentialGroup()
                                .addComponent(EtcForumLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(EtcSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(EtcForum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(EtcOfSite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(EtcCG, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)))))
        );
        EtcSidePanelLayout.setVerticalGroup(
            EtcSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EtcSidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(EtcUtile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(64, 64, 64)
                .addGroup(EtcSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(EtcCGLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EtcCG, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(EtcSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(EtcOfSiteLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EtcOfSite, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(EtcSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EtcForumLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EtcForum, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(329, 329, 329))
        );

        XmrBG12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bitknow/resources/Final7.png"))); // NOI18N
        XmrBG12.setPreferredSize(new java.awt.Dimension(1268, 677));

        javax.swing.GroupLayout EtcPanelLayout = new javax.swing.GroupLayout(EtcPanel);
        EtcPanel.setLayout(EtcPanelLayout);
        EtcPanelLayout.setHorizontalGroup(
            EtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EtcPanelLayout.createSequentialGroup()
                .addGroup(EtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EtcPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(EtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EtcPanelLayout.createSequentialGroup()
                                .addComponent(EtcResult, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(EtcConvert)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EtcClear, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(EtcPanelLayout.createSequentialGroup()
                                .addGroup(EtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(EtcConversion)
                                    .addComponent(EtcEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EtcCChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(EtcHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(EtcPanelLayout.createSequentialGroup()
                                .addGroup(EtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(EtcValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(EtcTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE))
                                .addGap(12, 12, 12)
                                .addComponent(EtcVChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EtcSidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(EtcTop, javax.swing.GroupLayout.DEFAULT_SIZE, 1286, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(EtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(EtcPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(XmrBG12, javax.swing.GroupLayout.PREFERRED_SIZE, 1276, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        EtcPanelLayout.setVerticalGroup(
            EtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EtcPanelLayout.createSequentialGroup()
                .addComponent(EtcTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EtcSidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 691, Short.MAX_VALUE)
                    .addGroup(EtcPanelLayout.createSequentialGroup()
                        .addComponent(EtcTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(EtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(EtcVChoose)
                            .addComponent(EtcValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EtcHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EtcConversion, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(EtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EtcEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EtcCChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(EtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EtcResult, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EtcConvert, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EtcClear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(EtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(EtcPanelLayout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addComponent(XmrBG12, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        Root.add(EtcPanel, "EtcPanel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Root, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Root, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtcResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtcResultActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtcResultActionPerformed

    private void BtcConvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtcConvertActionPerformed
        Convert(BtcCChoose,BtcEnter,BtcResult,"Btc");
    }//GEN-LAST:event_BtcConvertActionPerformed

    private void BtcCChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtcCChooseActionPerformed
        CChoose(BtcCChoose);
    }//GEN-LAST:event_BtcCChooseActionPerformed

    private void BtcEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtcEnterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtcEnterActionPerformed

    private void BtcEnterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtcEnterMouseClicked
        BtcEnter.setText("");
        BtcEnter.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_BtcEnterMouseClicked

    private void BtcVChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtcVChooseActionPerformed
        VChoose(BtcVChoose);
        testConnection(coin);
        BtcValue.setText("1 Btc ≈ ");
        Bitcoin(SelectedCurrency);
    }//GEN-LAST:event_BtcVChooseActionPerformed

    private void BtcRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtcRefreshActionPerformed
        testConnection("bitcoin");
        BtcValue.setText("1 Btc ≈ ");
        Bitcoin(SelectedCurrency);
    }//GEN-LAST:event_BtcRefreshActionPerformed

    private void MenuCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuCloseMouseEntered
        MenuClose.setForeground(Color.RED);
    }//GEN-LAST:event_MenuCloseMouseEntered

    private void MenuCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_MenuCloseMouseClicked

    private void MenuCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuCloseMouseExited
        MenuClose.setForeground(Color.BLACK);
    }//GEN-LAST:event_MenuCloseMouseExited

    private void BtcCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtcCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_BtcCloseMouseClicked

    private void BtcCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtcCloseMouseEntered
       BtcClose.setForeground(Color.red);
    }//GEN-LAST:event_BtcCloseMouseEntered

    private void BtcCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtcCloseMouseExited
         BtcClose.setForeground(Color.black);
    }//GEN-LAST:event_BtcCloseMouseExited

    private void BtcBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtcBackActionPerformed
        Back(BtcValue,BtcEnter,BtcResult);
    }//GEN-LAST:event_BtcBackActionPerformed

    private void BtcClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtcClearActionPerformed
       Clear(BtcEnter,BtcResult);
    }//GEN-LAST:event_BtcClearActionPerformed

    private void MenuMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuMinimizeMouseClicked
        setExtendedState(MainApp.ICONIFIED);
    }//GEN-LAST:event_MenuMinimizeMouseClicked

    private void MenuMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuMinimizeMouseEntered
        MenuMinimize.setForeground(Color.red);
    }//GEN-LAST:event_MenuMinimizeMouseEntered

    private void MenuMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuMinimizeMouseExited
        MenuMinimize.setForeground(Color.black);
    }//GEN-LAST:event_MenuMinimizeMouseExited

    private void ProxyConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProxyConfigActionPerformed
        ProxyConfiguration p = new ProxyConfiguration();
        p.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ProxyConfigActionPerformed

    private void BtcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtcMouseClicked
       cl = (CardLayout) Root.getLayout();
        coin = "bitcoin";
       
        loadingProgressBar(new Runnable() {
            @Override
            public void run() {
               MenuProgress.setVisible(true);
                testConnection(coin);
                MenuProgress.setValue(150);
                try {
                    Thread.sleep(500);
                    MenuProgress.setValue(0);
                } catch (Exception e) {
                    e.printStackTrace();
                } 
                Bitcoin("brl");
                cl.show(Root,"BtcPanel");
                valueProgress = false;
                
            }
        }, MenuProgress);
    }//GEN-LAST:event_BtcMouseClicked

    private void Utile1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Utile1MouseClicked
        HyperLink h = new HyperLink("https://canaltech.com.br/criptomoedas/o-que-e-e-como-funciona-o-bitcoin/");
    }//GEN-LAST:event_Utile1MouseClicked

    private void Utile2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Utile2MouseClicked
        HyperLink h = new HyperLink("https://canaltech.com.br/internet/como-comprar-e-vender-bitcoins-a-criptomoeda-virtual/");
    }//GEN-LAST:event_Utile2MouseClicked

    private void Utile1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Utile1MouseEntered
        Utile1.setForeground(Color.red);
    }//GEN-LAST:event_Utile1MouseEntered

    private void Utile1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Utile1MouseExited
        Utile1.setForeground(Color.blue);
    }//GEN-LAST:event_Utile1MouseExited

    private void Utile2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Utile2MouseEntered
        Utile2.setForeground(Color.red);
    }//GEN-LAST:event_Utile2MouseEntered

    private void Utile2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Utile2MouseExited
        Utile2.setForeground(Color.blue);
    }//GEN-LAST:event_Utile2MouseExited

    private void BtcCGLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtcCGLogoMouseClicked
        HyperLink h = new HyperLink("https://www.coingecko.com/pt/gráficos_de_preços/bitcoin/usd");
    }//GEN-LAST:event_BtcCGLogoMouseClicked

    private void BtcCGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtcCGMouseClicked
        HyperLink h = new HyperLink("https://www.coingecko.com/pt/gráficos_de_preços/bitcoin/usd");
    }//GEN-LAST:event_BtcCGMouseClicked

    private void BtcOfSiteLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtcOfSiteLogoMouseClicked
         HyperLink h = new HyperLink("https://bitcoin.org/en/");
    }//GEN-LAST:event_BtcOfSiteLogoMouseClicked

    private void BtcForumLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtcForumLogoMouseClicked
        HyperLink h = new HyperLink("https://bitcointalk.org");
    }//GEN-LAST:event_BtcForumLogoMouseClicked

    private void BtcCyLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtcCyLogoMouseClicked
        HyperLink h = new HyperLink("https://live.blockcypher.com/btc/");
    }//GEN-LAST:event_BtcCyLogoMouseClicked

    private void BtcForumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtcForumMouseClicked
        HyperLink h = new HyperLink("https://bitcointalk.org");
    }//GEN-LAST:event_BtcForumMouseClicked

    private void BtcOfSiteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtcOfSiteMouseClicked
        HyperLink h = new HyperLink("https://bitcoin.org/en/"); // TODO add your handling code here:
    }//GEN-LAST:event_BtcOfSiteMouseClicked

    private void BtcCyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtcCyMouseClicked
       HyperLink h = new HyperLink("https://live.blockcypher.com/btc/");
    }//GEN-LAST:event_BtcCyMouseClicked

    private void BtcUtileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtcUtileMouseClicked

    }//GEN-LAST:event_BtcUtileMouseClicked

    private void InfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InfoActionPerformed
   easteregg ++;
        if (easteregg < 5) {
        JOptionPane.showMessageDialog(null,"BitKnow™" + "\n" +
        "Versão : 1.6/2018" + "\n" + 
        "Desenvolvido por : Rafael Silva" + "\n" +
        "Powered by CoinGecko API" + "\n","Informações da Aplicação", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(icon));
        } else if (easteregg >= 5) {
        JOptionPane.showMessageDialog(null,"BitKnow™" + "\n" +
        "Versão : 1.6/2018" + "\n" + 
        "Desenvolvido por : Rafael Silva" + "\n" +
        "Powered by CoinGecko API" + "\n" + 
        "TERCEIRA QUESTÃO LETRA A) EM !!!" +
        "\n" + "BOOORA MEU FIII !!!!", "Informações da Aplicação", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(icon));
        }
        
    }//GEN-LAST:event_InfoActionPerformed

    private void LtcCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LtcCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_LtcCloseMouseClicked

    private void LtcCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LtcCloseMouseEntered
        LtcClose.setForeground(Color.red);
    }//GEN-LAST:event_LtcCloseMouseEntered

    private void LtcCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LtcCloseMouseExited
        LtcClose.setForeground(Color.black);
    }//GEN-LAST:event_LtcCloseMouseExited

    private void LtcBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LtcBackActionPerformed
        Back(LtcValue,LtcEnter,LtcResult);
    }//GEN-LAST:event_LtcBackActionPerformed

    private void LtcRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LtcRefreshActionPerformed
        testConnection("litecoin");
        LtcValue.setText("1 Ltc ≈ ");
        Bitcoin(SelectedCurrency);    
    }//GEN-LAST:event_LtcRefreshActionPerformed

    private void LtcVChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LtcVChooseActionPerformed
         VChoose(LtcVChoose);
        testConnection(coin);
        LtcValue.setText("1 Ltc ≈ ");
        Litecoin(SelectedCurrency);
    }//GEN-LAST:event_LtcVChooseActionPerformed

    private void LtcEnterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LtcEnterMouseClicked
        LtcEnter.setText("");
        LtcEnter.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_LtcEnterMouseClicked

    private void LtcEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LtcEnterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LtcEnterActionPerformed

    private void LtcCChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LtcCChooseActionPerformed
        CChoose(LtcCChoose);
    }//GEN-LAST:event_LtcCChooseActionPerformed

    private void LtcConvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LtcConvertActionPerformed
       Convert(LtcCChoose,LtcEnter,LtcResult,"Ltc");
    }//GEN-LAST:event_LtcConvertActionPerformed

    private void LtcClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LtcClearActionPerformed
        Clear(LtcEnter,LtcResult);
    }//GEN-LAST:event_LtcClearActionPerformed

    private void LtcResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LtcResultActionPerformed
    }//GEN-LAST:event_LtcResultActionPerformed

    private void LtcCGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LtcCGMouseClicked
        HyperLink h = new HyperLink("https://www.coingecko.com/pt/moedas/litecoin");
    }//GEN-LAST:event_LtcCGMouseClicked

    private void LtcCGLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LtcCGLogoMouseClicked
      HyperLink h = new HyperLink("https://www.coingecko.com/pt/moedas/litecoin");
    }//GEN-LAST:event_LtcCGLogoMouseClicked

    private void LtcOfSiteLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LtcOfSiteLogoMouseClicked
      HyperLink h = new HyperLink("https://litecoin.org");
    }//GEN-LAST:event_LtcOfSiteLogoMouseClicked

    private void LtcForumLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LtcForumLogoMouseClicked
        HyperLink h = new HyperLink("https://litecointalk.org");
    }//GEN-LAST:event_LtcForumLogoMouseClicked

    private void LtcCyLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LtcCyLogoMouseClicked
       HyperLink h = new HyperLink("https://live.blockcypher.com/ltc/");
    }//GEN-LAST:event_LtcCyLogoMouseClicked

    private void LtcUtileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LtcUtileMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_LtcUtileMouseClicked

    private void LtcForumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LtcForumMouseClicked
      HyperLink h = new HyperLink("https://litecointalk.org");
    }//GEN-LAST:event_LtcForumMouseClicked

    private void LtcOfSiteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LtcOfSiteMouseClicked
       HyperLink h = new HyperLink("https://litecoin.org");
    }//GEN-LAST:event_LtcOfSiteMouseClicked

    private void LtcCyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LtcCyMouseClicked
        HyperLink h = new HyperLink("https://live.blockcypher.com/ltc/");
    }//GEN-LAST:event_LtcCyMouseClicked

    private void LtcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LtcMouseClicked
        cl = (CardLayout) Root.getLayout();
        coin = "litecoin";
       
        loadingProgressBar(new Runnable() {
            @Override
            public void run() {
               MenuProgress.setVisible(true);
                testConnection(coin);
                MenuProgress.setValue(150);
                try {
                    Thread.sleep(500);
                    MenuProgress.setValue(0);
                } catch (Exception e) {
                    e.printStackTrace();
                } 
                Litecoin("brl");
                cl.show(Root,"LtcPanel");
                valueProgress = false;
                
            }
        }, MenuProgress);
    }//GEN-LAST:event_LtcMouseClicked

    private void BtcMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtcMinimizeMouseClicked
          setExtendedState(MainApp.ICONIFIED);
    }//GEN-LAST:event_BtcMinimizeMouseClicked

    private void BtcMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtcMinimizeMouseEntered
        BtcMinimize.setForeground(Color.red);
    }//GEN-LAST:event_BtcMinimizeMouseEntered

    private void BtcMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtcMinimizeMouseExited
          BtcMinimize.setForeground(Color.black);
    }//GEN-LAST:event_BtcMinimizeMouseExited

    private void LtcMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LtcMinimizeMouseClicked
        setExtendedState(MainApp.ICONIFIED);
    }//GEN-LAST:event_LtcMinimizeMouseClicked

    private void LtcMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LtcMinimizeMouseEntered
        LtcMinimize.setForeground(Color.red);
    }//GEN-LAST:event_LtcMinimizeMouseEntered

    private void LtcMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LtcMinimizeMouseExited
        LtcMinimize.setForeground(Color.black);
    }//GEN-LAST:event_LtcMinimizeMouseExited

    private void XmrCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XmrCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_XmrCloseMouseClicked

    private void XmrCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XmrCloseMouseEntered
        XmrClose.setForeground(Color.red);
    }//GEN-LAST:event_XmrCloseMouseEntered

    private void XmrCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XmrCloseMouseExited
        XmrClose.setForeground(Color.black);
    }//GEN-LAST:event_XmrCloseMouseExited

    private void XmrBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XmrBackActionPerformed
        Back(XmrValue,XmrEnter,XmrResult);
    }//GEN-LAST:event_XmrBackActionPerformed

    private void XmrRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XmrRefreshActionPerformed
        testConnection("monero");
        XmrValue.setText("1 Xmr ≈ ");
        Monero(SelectedCurrency);    
    }//GEN-LAST:event_XmrRefreshActionPerformed

    private void XmrMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XmrMinimizeMouseClicked
       setExtendedState(MainApp.ICONIFIED);
    }//GEN-LAST:event_XmrMinimizeMouseClicked

    private void XmrMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XmrMinimizeMouseEntered
       XmrMinimize.setForeground(Color.red);
    }//GEN-LAST:event_XmrMinimizeMouseEntered

    private void XmrMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XmrMinimizeMouseExited
        XmrMinimize.setForeground(Color.black);
    }//GEN-LAST:event_XmrMinimizeMouseExited

    private void XmrVChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XmrVChooseActionPerformed
        VChoose(XmrVChoose);
        testConnection(coin);
        XmrValue.setText("1 Xmr ≈ ");
        Monero(SelectedCurrency);
    }//GEN-LAST:event_XmrVChooseActionPerformed

    private void XmrEnterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XmrEnterMouseClicked
    XmrEnter.setText("");
    XmrEnter.setForeground(new Color(0,0,0));           
    }//GEN-LAST:event_XmrEnterMouseClicked

    private void XmrEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XmrEnterActionPerformed
        XmrEnter.setText("");
        XmrEnter.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_XmrEnterActionPerformed

    private void XmrCChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XmrCChooseActionPerformed
        CChoose(XmrCChoose);
    }//GEN-LAST:event_XmrCChooseActionPerformed

    private void XmrConvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XmrConvertActionPerformed
        Convert(XmrCChoose,XmrEnter,XmrResult,"Xmr");
    }//GEN-LAST:event_XmrConvertActionPerformed

    private void XmrClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XmrClearActionPerformed
        Clear(XmrEnter,XmrResult);
    }//GEN-LAST:event_XmrClearActionPerformed

    private void XmrResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XmrResultActionPerformed
    }//GEN-LAST:event_XmrResultActionPerformed

    private void XmrCGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XmrCGMouseClicked
        HyperLink h = new HyperLink("https://www.coingecko.com/en/coins/monero");
    }//GEN-LAST:event_XmrCGMouseClicked

    private void XmrCGLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XmrCGLogoMouseClicked
        HyperLink h = new HyperLink("https://www.coingecko.com/en/coins/monero");
    }//GEN-LAST:event_XmrCGLogoMouseClicked

    private void XmrOfSiteLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XmrOfSiteLogoMouseClicked
     HyperLink h = new HyperLink("https://getmonero.org");
    }//GEN-LAST:event_XmrOfSiteLogoMouseClicked

    private void XmrForumLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XmrForumLogoMouseClicked
      HyperLink h = new HyperLink("https://forum.getmonero.org");
    }//GEN-LAST:event_XmrForumLogoMouseClicked

    private void XmrUtileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XmrUtileMouseClicked
    }//GEN-LAST:event_XmrUtileMouseClicked

    private void XmrForumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XmrForumMouseClicked
      HyperLink h = new HyperLink("https://forum.getmonero.org");
    }//GEN-LAST:event_XmrForumMouseClicked

    private void XmrOfSiteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XmrOfSiteMouseClicked
        HyperLink h = new HyperLink("https://getmonero.org");
    }//GEN-LAST:event_XmrOfSiteMouseClicked

    private void XmrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XmrMouseClicked
        cl = (CardLayout) Root.getLayout();
        coin = "monero";

        loadingProgressBar(new Runnable() {
            @Override
            public void run() {
                MenuProgress.setVisible(true);
                testConnection(coin);
                MenuProgress.setValue(150);
                try {
                    Thread.sleep(500);
                    MenuProgress.setValue(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Monero("brl");
                cl.show(Root,"XmrPanel");
                valueProgress = false;

            }
        }, MenuProgress);
    }//GEN-LAST:event_XmrMouseClicked

    private void DogeCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DogeCloseMouseClicked
       System.exit(0);
    }//GEN-LAST:event_DogeCloseMouseClicked

    private void DogeCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DogeCloseMouseEntered
        DogeClose.setForeground(Color.red);
    }//GEN-LAST:event_DogeCloseMouseEntered

    private void DogeCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DogeCloseMouseExited
        DogeClose.setForeground(Color.black);
    }//GEN-LAST:event_DogeCloseMouseExited

    private void DogeBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DogeBackActionPerformed
        Back(DogeValue,DogeEnter,DogeResult);
    }//GEN-LAST:event_DogeBackActionPerformed

    private void DogeRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DogeRefreshActionPerformed
        testConnection("dogecoin");
        DogeValue.setText("1 Doge ≈ ");
        Dogecoin(SelectedCurrency);    
    }//GEN-LAST:event_DogeRefreshActionPerformed

    private void DogeMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DogeMinimizeMouseClicked
        setExtendedState(MainApp.ICONIFIED);
    }//GEN-LAST:event_DogeMinimizeMouseClicked

    private void DogeMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DogeMinimizeMouseEntered
       DogeMinimize.setForeground(Color.red);
    }//GEN-LAST:event_DogeMinimizeMouseEntered

    private void DogeMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DogeMinimizeMouseExited
       DogeMinimize.setForeground(Color.black);
    }//GEN-LAST:event_DogeMinimizeMouseExited

    private void DogeVChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DogeVChooseActionPerformed
        VChoose(DogeVChoose);
          testConnection(coin);
        DogeValue.setText("1 Doge ≈ ");
        Dogecoin(SelectedCurrency);
    }//GEN-LAST:event_DogeVChooseActionPerformed

    private void DogeEnterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DogeEnterMouseClicked
        DogeEnter.setText("");
        DogeEnter.setForeground(Color.black);
    }//GEN-LAST:event_DogeEnterMouseClicked

    private void DogeEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DogeEnterActionPerformed
    }//GEN-LAST:event_DogeEnterActionPerformed

    private void DogeCChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DogeCChooseActionPerformed
        CChoose(DogeCChoose);
    }//GEN-LAST:event_DogeCChooseActionPerformed

    private void DogeConvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DogeConvertActionPerformed
        Convert(DogeCChoose,DogeEnter,DogeResult,"Doge");
    }//GEN-LAST:event_DogeConvertActionPerformed

    private void DogeClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DogeClearActionPerformed
        Clear(DogeEnter,DogeResult);
    }//GEN-LAST:event_DogeClearActionPerformed

    private void DogeResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DogeResultActionPerformed
    }//GEN-LAST:event_DogeResultActionPerformed

    private void DogeCGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DogeCGMouseClicked
        HyperLink h = new HyperLink("https://www.coingecko.com/pt/moedas/dogecoin");
    }//GEN-LAST:event_DogeCGMouseClicked

    private void DogeCGLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DogeCGLogoMouseClicked
        HyperLink h = new HyperLink("https://www.coingecko.com/pt/moedas/dogecoin");
    }//GEN-LAST:event_DogeCGLogoMouseClicked

    private void DogeOfSiteLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DogeOfSiteLogoMouseClicked
      HyperLink h = new HyperLink("https://dogecoin.com");
    }//GEN-LAST:event_DogeOfSiteLogoMouseClicked

    private void DogeForumLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DogeForumLogoMouseClicked
       HyperLink h = new HyperLink("https://www.reddit.com/r/dogecoin/");
    }//GEN-LAST:event_DogeForumLogoMouseClicked

    private void DogeUtileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DogeUtileMouseClicked
    }//GEN-LAST:event_DogeUtileMouseClicked

    private void DogeForumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DogeForumMouseClicked
       HyperLink h = new HyperLink("https://www.reddit.com/r/dogecoin/");
    }//GEN-LAST:event_DogeForumMouseClicked

    private void DogeOfSiteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DogeOfSiteMouseClicked
       HyperLink h = new HyperLink("https://dogecoin.com");
    }//GEN-LAST:event_DogeOfSiteMouseClicked

    private void DogeCyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DogeCyMouseClicked
      HyperLink h = new HyperLink("https://live.blockcypher.com/doge/");
    }//GEN-LAST:event_DogeCyMouseClicked

    private void DogeCyLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DogeCyLogoMouseClicked
    HyperLink h = new HyperLink("https://live.blockcypher.com/doge/");
    }//GEN-LAST:event_DogeCyLogoMouseClicked

    private void DogeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DogeMouseClicked
         cl = (CardLayout) Root.getLayout();
        coin = "dogecoin";

        loadingProgressBar(new Runnable() {
            @Override
            public void run() {
                MenuProgress.setVisible(true);
                testConnection(coin);
                MenuProgress.setValue(150);
                try {
                    Thread.sleep(500);
                    MenuProgress.setValue(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Dogecoin("brl");
                cl.show(Root,"DogePanel");
                valueProgress = false;

            }
        }, MenuProgress);
    }//GEN-LAST:event_DogeMouseClicked

    private void DashCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_DashCloseMouseClicked

    private void DashCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashCloseMouseEntered
        DashClose.setForeground(Color.red);
    }//GEN-LAST:event_DashCloseMouseEntered

    private void DashCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashCloseMouseExited
        DashClose.setForeground(Color.black);
    }//GEN-LAST:event_DashCloseMouseExited

    private void DashBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashBackActionPerformed
        Back(DashValue,DashEnter,DashResult);
    }//GEN-LAST:event_DashBackActionPerformed

    private void DashRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashRefreshActionPerformed
       testConnection("dash");
        DogeValue.setText("1 Dash ≈ ");
        Dash(SelectedCurrency);    
    }//GEN-LAST:event_DashRefreshActionPerformed

    private void DashMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashMinimizeMouseClicked
        setExtendedState(MainApp.ICONIFIED);
    }//GEN-LAST:event_DashMinimizeMouseClicked

    private void DashMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashMinimizeMouseEntered
       DashMinimize.setForeground(Color.red);
    }//GEN-LAST:event_DashMinimizeMouseEntered

    private void DashMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashMinimizeMouseExited
        DashMinimize.setForeground(Color.black);
    }//GEN-LAST:event_DashMinimizeMouseExited

    private void DashVChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashVChooseActionPerformed
        VChoose(DashVChoose);
        testConnection(coin);
        DashValue.setText("1 Dash ≈ ");
        Dash(SelectedCurrency);
    }//GEN-LAST:event_DashVChooseActionPerformed

    private void DashEnterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashEnterMouseClicked
        DashEnter.setText("");
        DashEnter.setForeground(Color.black);
    }//GEN-LAST:event_DashEnterMouseClicked

    private void DashEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashEnterActionPerformed
    }//GEN-LAST:event_DashEnterActionPerformed

    private void DashCChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashCChooseActionPerformed
        CChoose(DashCChoose);
    }//GEN-LAST:event_DashCChooseActionPerformed

    private void DashConvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashConvertActionPerformed
        Convert(DashCChoose,DashEnter,DashResult,"Dash");
    }//GEN-LAST:event_DashConvertActionPerformed

    private void DashClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashClearActionPerformed
        Clear(DashEnter,DashResult);
    }//GEN-LAST:event_DashClearActionPerformed

    private void DashResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashResultActionPerformed
    }//GEN-LAST:event_DashResultActionPerformed

    private void DashCGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashCGMouseClicked
        HyperLink h = new HyperLink("https://www.coingecko.com/pt/gráficos_de_preços/dash/usd");
    }//GEN-LAST:event_DashCGMouseClicked

    private void DashCGLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashCGLogoMouseClicked
         HyperLink h = new HyperLink("https://www.coingecko.com/pt/gráficos_de_preços/dash/usd");
    }//GEN-LAST:event_DashCGLogoMouseClicked

    private void DashOfSiteLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashOfSiteLogoMouseClicked
        HyperLink h = new HyperLink("https://www.dash.org");
    }//GEN-LAST:event_DashOfSiteLogoMouseClicked

    private void DashForumLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashForumLogoMouseClicked
         HyperLink h = new HyperLink("https://www.dash.org/forum/");
    }//GEN-LAST:event_DashForumLogoMouseClicked

    private void DashUtileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashUtileMouseClicked
    }//GEN-LAST:event_DashUtileMouseClicked

    private void DashForumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashForumMouseClicked
        HyperLink h = new HyperLink("https://www.dash.org/forum/");
    }//GEN-LAST:event_DashForumMouseClicked

    private void DashOfSiteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashOfSiteMouseClicked
        HyperLink h = new HyperLink("https://www.dash.org");
    }//GEN-LAST:event_DashOfSiteMouseClicked

    private void DashCyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashCyMouseClicked
        HyperLink h = new HyperLink("https://live.blockcypher.com/dash/");
    }//GEN-LAST:event_DashCyMouseClicked

    private void DashCyLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashCyLogoMouseClicked
       HyperLink h = new HyperLink("https://live.blockcypher.com/dash/");
    }//GEN-LAST:event_DashCyLogoMouseClicked

    private void DashMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashMouseClicked
        cl = (CardLayout) Root.getLayout();
        coin = "dash";

        loadingProgressBar(new Runnable() {
            @Override
            public void run() {
                MenuProgress.setVisible(true);
                testConnection(coin);
                MenuProgress.setValue(150);
                try {
                    Thread.sleep(500);
                    MenuProgress.setValue(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Dash("brl");
                cl.show(Root,"DashPanel");
                valueProgress = false;

            }
        }, MenuProgress);
    }//GEN-LAST:event_DashMouseClicked

    private void BchCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BchCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_BchCloseMouseClicked

    private void BchCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BchCloseMouseEntered
        BchClose.setForeground(Color.red);
    }//GEN-LAST:event_BchCloseMouseEntered

    private void BchCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BchCloseMouseExited
        BchClose.setForeground(Color.black);
    }//GEN-LAST:event_BchCloseMouseExited

    private void BchBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BchBackActionPerformed
        Back(BchValue,BchEnter,BchResult);
    }//GEN-LAST:event_BchBackActionPerformed

    private void BchRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BchRefreshActionPerformed
        testConnection("bitcoin-cash");
        BchValue.setText("1 Bch ≈ ");
        BitcoinCash(SelectedCurrency);   
    }//GEN-LAST:event_BchRefreshActionPerformed

    private void BchMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BchMinimizeMouseClicked
        setExtendedState(MainApp.ICONIFIED);
    }//GEN-LAST:event_BchMinimizeMouseClicked

    private void BchMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BchMinimizeMouseEntered
        BchMinimize.setForeground(Color.red);
    }//GEN-LAST:event_BchMinimizeMouseEntered

    private void BchMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BchMinimizeMouseExited
        BchMinimize.setForeground(Color.black);
    }//GEN-LAST:event_BchMinimizeMouseExited

    private void BchVChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BchVChooseActionPerformed
        VChoose(BchVChoose);
        testConnection(coin);
        BchValue.setText("1 Bch ≈ ");
        BitcoinCash(SelectedCurrency);
    }//GEN-LAST:event_BchVChooseActionPerformed

    private void BchEnterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BchEnterMouseClicked
        BchEnter.setText("");
        BchEnter.setForeground(Color.black);
    }//GEN-LAST:event_BchEnterMouseClicked

    private void BchEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BchEnterActionPerformed
    }//GEN-LAST:event_BchEnterActionPerformed

    private void BchCChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BchCChooseActionPerformed
        CChoose(BchCChoose);
    }//GEN-LAST:event_BchCChooseActionPerformed

    private void BchConvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BchConvertActionPerformed
        Convert(BchCChoose,BchEnter,BchResult,"Bch");
    }//GEN-LAST:event_BchConvertActionPerformed

    private void BchClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BchClearActionPerformed
        Clear(BtcEnter,BtcResult);
    }//GEN-LAST:event_BchClearActionPerformed

    private void BchResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BchResultActionPerformed
    }//GEN-LAST:event_BchResultActionPerformed

    private void BchCGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BchCGMouseClicked
        HyperLink h = new HyperLink("https://www.coingecko.com/pt/gráficos_de_preços/bitcoin-cash/usd");
    }//GEN-LAST:event_BchCGMouseClicked

    private void BchCGLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BchCGLogoMouseClicked
         HyperLink h = new HyperLink("https://www.coingecko.com/pt/gráficos_de_preços/bitcoin-cash/usd");
    }//GEN-LAST:event_BchCGLogoMouseClicked

    private void BchOfSiteLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BchOfSiteLogoMouseClicked
       HyperLink h = new HyperLink("www.bitcoincash.org/");
    }//GEN-LAST:event_BchOfSiteLogoMouseClicked

    private void BchForumLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BchForumLogoMouseClicked
       HyperLink h = new HyperLink("https://bitco.in/forum/forums/bitcoin-abc.25/");
    }//GEN-LAST:event_BchForumLogoMouseClicked

    private void BchUtileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BchUtileMouseClicked
    }//GEN-LAST:event_BchUtileMouseClicked

    private void BchForumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BchForumMouseClicked
        HyperLink h = new HyperLink("https://bitco.in/forum/forums/bitcoin-abc.25/");
    }//GEN-LAST:event_BchForumMouseClicked

    private void BchOfSiteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BchOfSiteMouseClicked
      HyperLink h = new HyperLink("www.bitcoincash.org/");
    }//GEN-LAST:event_BchOfSiteMouseClicked

    private void BchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BchMouseClicked
         cl = (CardLayout) Root.getLayout();
        coin = "bitcoin-cash";

        loadingProgressBar(new Runnable() {
            @Override
            public void run() {
                MenuProgress.setVisible(true);
                testConnection(coin);
                MenuProgress.setValue(150);
                try {
                    Thread.sleep(500);
                    MenuProgress.setValue(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                BitcoinCash("brl");
                cl.show(Root,"BchPanel");
                valueProgress = false;

            }
        }, MenuProgress);
    }//GEN-LAST:event_BchMouseClicked

    private void EthCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EthCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_EthCloseMouseClicked

    private void EthCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EthCloseMouseEntered
        EthClose.setForeground(Color.red);
    }//GEN-LAST:event_EthCloseMouseEntered

    private void EthCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EthCloseMouseExited
        EthClose.setForeground(Color.black);
    }//GEN-LAST:event_EthCloseMouseExited

    private void EthBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EthBackActionPerformed
        Back(EthValue,EthEnter,EthResult);
    }//GEN-LAST:event_EthBackActionPerformed

    private void EthRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EthRefreshActionPerformed
        testConnection("ethereum");
        EthValue.setText("1 Eth ≈ ");
        Ethereum(SelectedCurrency);  
    }//GEN-LAST:event_EthRefreshActionPerformed

    private void EthMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EthMinimizeMouseClicked
        setExtendedState(MainApp.ICONIFIED);
    }//GEN-LAST:event_EthMinimizeMouseClicked

    private void EthMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EthMinimizeMouseEntered
        EthMinimize.setForeground(Color.red);
    }//GEN-LAST:event_EthMinimizeMouseEntered

    private void EthMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EthMinimizeMouseExited
        EthMinimize.setForeground(Color.black);
    }//GEN-LAST:event_EthMinimizeMouseExited

    private void EthVChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EthVChooseActionPerformed
        VChoose(EthVChoose);
        testConnection(coin);
        EthValue.setText("1 Eth ≈ ");
        Ethereum(SelectedCurrency);
    }//GEN-LAST:event_EthVChooseActionPerformed

    private void EthEnterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EthEnterMouseClicked
        EthEnter.setText("");
        EthEnter.setForeground(Color.black);
    }//GEN-LAST:event_EthEnterMouseClicked

    private void EthEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EthEnterActionPerformed
    }//GEN-LAST:event_EthEnterActionPerformed

    private void EthCChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EthCChooseActionPerformed
        CChoose(EthCChoose);
    }//GEN-LAST:event_EthCChooseActionPerformed

    private void EthConvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EthConvertActionPerformed
        Convert(EthCChoose,EthEnter,EthResult,"Eth");
    }//GEN-LAST:event_EthConvertActionPerformed

    private void EthClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EthClearActionPerformed
        Clear(EthEnter,EthResult);
    }//GEN-LAST:event_EthClearActionPerformed

    private void EthResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EthResultActionPerformed
    }//GEN-LAST:event_EthResultActionPerformed

    private void EthCGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EthCGMouseClicked
        HyperLink h = new HyperLink("https://www.coingecko.com/pt/moedas/ethereum");
    }//GEN-LAST:event_EthCGMouseClicked

    private void EthCGLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EthCGLogoMouseClicked
       HyperLink h = new HyperLink("https://www.coingecko.com/pt/moedas/ethereum");
    }//GEN-LAST:event_EthCGLogoMouseClicked

    private void EthOfSiteLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EthOfSiteLogoMouseClicked
       HyperLink h = new HyperLink("https://www.ethereum.org");
    }//GEN-LAST:event_EthOfSiteLogoMouseClicked

    private void EthForumLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EthForumLogoMouseClicked
      HyperLink h = new HyperLink("https://forum.ethereum.org");
    }//GEN-LAST:event_EthForumLogoMouseClicked

    private void EthUtileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EthUtileMouseClicked
    }//GEN-LAST:event_EthUtileMouseClicked

    private void EthForumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EthForumMouseClicked
        HyperLink h = new HyperLink("https://forum.ethereum.org");
    }//GEN-LAST:event_EthForumMouseClicked

    private void EthOfSiteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EthOfSiteMouseClicked
       HyperLink h = new HyperLink("https://www.ethereum.org");
    }//GEN-LAST:event_EthOfSiteMouseClicked

    private void EthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EthMouseClicked
        cl = (CardLayout) Root.getLayout();
        coin = "ethereum";

        loadingProgressBar(new Runnable() {
            @Override
            public void run() {
                MenuProgress.setVisible(true);
                testConnection(coin);
                MenuProgress.setValue(150);
                try {
                    Thread.sleep(500);
                    MenuProgress.setValue(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Ethereum("brl");
                cl.show(Root,"EthPanel");
                valueProgress = false;

            }
        }, MenuProgress);
    }//GEN-LAST:event_EthMouseClicked

    private void EtcCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EtcCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_EtcCloseMouseClicked

    private void EtcCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EtcCloseMouseEntered
        EtcClose.setForeground(Color.red);
    }//GEN-LAST:event_EtcCloseMouseEntered

    private void EtcCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EtcCloseMouseExited
       EtcClose.setForeground(Color.black);
    }//GEN-LAST:event_EtcCloseMouseExited

    private void EtcBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EtcBackActionPerformed
        Back(EtcValue,EtcEnter,EtcResult);
    }//GEN-LAST:event_EtcBackActionPerformed

    private void EtcRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EtcRefreshActionPerformed
         testConnection("ethereum-classic");
        EtcValue.setText("1 Etc ≈ ");
        EthereumClassic(SelectedCurrency); 
    }//GEN-LAST:event_EtcRefreshActionPerformed

    private void EtcMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EtcMinimizeMouseClicked
        setExtendedState(MainApp.ICONIFIED);
    }//GEN-LAST:event_EtcMinimizeMouseClicked

    private void EtcMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EtcMinimizeMouseEntered
        EtcMinimize.setForeground(Color.red);
    }//GEN-LAST:event_EtcMinimizeMouseEntered

    private void EtcMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EtcMinimizeMouseExited
       EtcMinimize.setForeground(Color.black);
    }//GEN-LAST:event_EtcMinimizeMouseExited

    private void EtcVChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EtcVChooseActionPerformed
         VChoose(EtcVChoose);
        testConnection(coin);
        EtcValue.setText("1 Etc ≈ ");
        EthereumClassic(SelectedCurrency);
    }//GEN-LAST:event_EtcVChooseActionPerformed

    private void EtcEnterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EtcEnterMouseClicked
        EtcEnter.setText("");
        EtcEnter.setForeground(Color.black);
    }//GEN-LAST:event_EtcEnterMouseClicked

    private void EtcEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EtcEnterActionPerformed
    }//GEN-LAST:event_EtcEnterActionPerformed

    private void EtcCChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EtcCChooseActionPerformed
        CChoose(EtcCChoose);
    }//GEN-LAST:event_EtcCChooseActionPerformed

    private void EtcConvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EtcConvertActionPerformed
       Convert(EtcCChoose,EtcEnter,EtcResult,"Etc");
    }//GEN-LAST:event_EtcConvertActionPerformed

    private void EtcClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EtcClearActionPerformed
        Clear(EtcEnter,EtcResult);
    }//GEN-LAST:event_EtcClearActionPerformed

    private void EtcResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EtcResultActionPerformed
    }//GEN-LAST:event_EtcResultActionPerformed

    private void EtcCGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EtcCGMouseClicked
        HyperLink h = new HyperLink("https://www.coingecko.com/pt/gráficos_de_preços/ethereum-classic/usd");
    }//GEN-LAST:event_EtcCGMouseClicked

    private void EtcCGLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EtcCGLogoMouseClicked
        HyperLink h = new HyperLink("https://www.coingecko.com/pt/gráficos_de_preços/ethereum-classic/usd");
    }//GEN-LAST:event_EtcCGLogoMouseClicked

    private void EtcOfSiteLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EtcOfSiteLogoMouseClicked
        HyperLink h = new HyperLink("https://ethereumclassic.org");
    }//GEN-LAST:event_EtcOfSiteLogoMouseClicked

    private void EtcForumLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EtcForumLogoMouseClicked
       HyperLink h = new HyperLink("https://forum.ethereumclassic.org");
    }//GEN-LAST:event_EtcForumLogoMouseClicked

    private void EtcUtileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EtcUtileMouseClicked
    }//GEN-LAST:event_EtcUtileMouseClicked

    private void EtcForumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EtcForumMouseClicked
        HyperLink h = new HyperLink("https://forum.ethereumclassic.org");
    }//GEN-LAST:event_EtcForumMouseClicked

    private void EtcOfSiteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EtcOfSiteMouseClicked
        HyperLink h = new HyperLink("https://ethereumclassic.org");
    }//GEN-LAST:event_EtcOfSiteMouseClicked

    private void EtcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EtcMouseClicked
          cl = (CardLayout) Root.getLayout();
        coin = "ethereum-classic";

        loadingProgressBar(new Runnable() {
            @Override
            public void run() {
                MenuProgress.setVisible(true);
                testConnection(coin);
                MenuProgress.setValue(150);
                try {
                    Thread.sleep(500);
                    MenuProgress.setValue(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                EthereumClassic("brl");
                cl.show(Root,"EtcPanel");
                valueProgress = false;

            }
        }, MenuProgress);
    }//GEN-LAST:event_EtcMouseClicked

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
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                new MainApp(true).setVisible(true);
           
            }
        });
    }
    public void testConnection(String coin) {
      
    try {    
       if (!proxyServer.equalsIgnoreCase("") && !proxyPort.equalsIgnoreCase("")) {
       System.setProperty("https.proxyHost", this.proxyServer);
        System.setProperty("http.proxyHost", this.proxyServer);
        System.setProperty("https.proxyPort", this.proxyPort);
        System.setProperty("http.proxyPort", this.proxyPort);
        System.setProperty("jdk.http.auth.tunneling.disabledSchemes","");
        if (!proxyUser.equalsIgnoreCase("")&& !proxyPassword.equalsIgnoreCase("")) {
        System.setProperty("http.proxyUser",this.proxyUser);
        System.setProperty("http.proxyPassword",this.proxyPassword);
        Authenticator.setDefault(new ProxyAuthenticator(this.proxyUser, this.proxyPassword));
        }
       }
        //Request HTTPS
      String url = "https://api.coingecko.com/api/v3/coins/"+coin;
        System.out.println(url);
        URL link = new URL(url);
        URLConnection connection = link.openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        connection.connect();
        
        BufferedReader ler = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String input = ler.readLine();
        j = new JSONObject(input);
        ler.close();
        
    } catch (IOException e) {
        MenuProgress.setVisible(false);
        JOptionPane.showMessageDialog(null, "Houve um erro na conexão, verifique sua conectividade e tente novamente");
        e.printStackTrace();
    }
    } 
    
    
    
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Bch;
    private javax.swing.JButton BchBack;
    private javax.swing.JComboBox<String> BchCChoose;
    private javax.swing.JLabel BchCG;
    private javax.swing.JLabel BchCGLogo;
    private javax.swing.JButton BchClear;
    private javax.swing.JLabel BchClose;
    private javax.swing.JLabel BchConversion;
    private javax.swing.JButton BchConvert;
    private javax.swing.JTextField BchEnter;
    private javax.swing.JLabel BchForum;
    private javax.swing.JLabel BchForumLogo;
    private javax.swing.JLabel BchHistory;
    private javax.swing.JLabel BchMainTitle;
    private javax.swing.JLabel BchMinimize;
    private javax.swing.JLabel BchOfSite;
    private javax.swing.JLabel BchOfSiteLogo;
    private javax.swing.JPanel BchPanel;
    private javax.swing.JButton BchRefresh;
    private javax.swing.JTextField BchResult;
    private javax.swing.JPanel BchSidePanel;
    private javax.swing.JLabel BchTitle;
    private javax.swing.JPanel BchTop;
    private javax.swing.JLabel BchUtile;
    private javax.swing.JComboBox<String> BchVChoose;
    private javax.swing.JLabel BchValue;
    private javax.swing.JLabel Btc;
    private javax.swing.JButton BtcBack;
    private javax.swing.JComboBox<String> BtcCChoose;
    private javax.swing.JLabel BtcCG;
    private javax.swing.JLabel BtcCGLogo;
    private javax.swing.JButton BtcClear;
    private javax.swing.JLabel BtcClose;
    private javax.swing.JLabel BtcConversion;
    private javax.swing.JButton BtcConvert;
    private javax.swing.JLabel BtcCy;
    private javax.swing.JLabel BtcCyLogo;
    private javax.swing.JTextField BtcEnter;
    private javax.swing.JLabel BtcForum;
    private javax.swing.JLabel BtcForumLogo;
    private javax.swing.JLabel BtcHistory;
    private javax.swing.JLabel BtcMainTitle;
    private javax.swing.JLabel BtcMainTitle1;
    private javax.swing.JLabel BtcMinimize;
    private javax.swing.JLabel BtcOfSite;
    private javax.swing.JLabel BtcOfSiteLogo;
    private javax.swing.JPanel BtcPanel;
    private javax.swing.JButton BtcRefresh;
    private javax.swing.JTextField BtcResult;
    private javax.swing.JPanel BtcSidePanel;
    private javax.swing.JLabel BtcTitle;
    private javax.swing.JPanel BtcTop;
    private javax.swing.JLabel BtcUtile;
    private javax.swing.JComboBox<String> BtcVChoose;
    private javax.swing.JLabel BtcValue;
    private javax.swing.JLabel CoinSelection;
    private javax.swing.JLabel Dash;
    private javax.swing.JButton DashBack;
    private javax.swing.JComboBox<String> DashCChoose;
    private javax.swing.JLabel DashCG;
    private javax.swing.JLabel DashCGLogo;
    private javax.swing.JButton DashClear;
    private javax.swing.JLabel DashClose;
    private javax.swing.JLabel DashConversion;
    private javax.swing.JButton DashConvert;
    private javax.swing.JLabel DashCy;
    private javax.swing.JLabel DashCyLogo;
    private javax.swing.JTextField DashEnter;
    private javax.swing.JLabel DashForum;
    private javax.swing.JLabel DashForumLogo;
    private javax.swing.JLabel DashHistory;
    private javax.swing.JLabel DashMainTitle;
    private javax.swing.JLabel DashMinimize;
    private javax.swing.JLabel DashOfSite;
    private javax.swing.JLabel DashOfSiteLogo;
    private javax.swing.JPanel DashPanel;
    private javax.swing.JButton DashRefresh;
    private javax.swing.JTextField DashResult;
    private javax.swing.JPanel DashSidePanel;
    private javax.swing.JLabel DashTitle;
    private javax.swing.JPanel DashTop;
    private javax.swing.JLabel DashUtile;
    private javax.swing.JComboBox<String> DashVChoose;
    private javax.swing.JLabel DashValue;
    private javax.swing.JLabel Doge;
    private javax.swing.JButton DogeBack;
    private javax.swing.JComboBox<String> DogeCChoose;
    private javax.swing.JLabel DogeCG;
    private javax.swing.JLabel DogeCGLogo;
    private javax.swing.JButton DogeClear;
    private javax.swing.JLabel DogeClose;
    private javax.swing.JLabel DogeConversion;
    private javax.swing.JButton DogeConvert;
    private javax.swing.JLabel DogeCy;
    private javax.swing.JLabel DogeCyLogo;
    private javax.swing.JTextField DogeEnter;
    private javax.swing.JLabel DogeForum;
    private javax.swing.JLabel DogeForumLogo;
    private javax.swing.JLabel DogeHistory;
    private javax.swing.JLabel DogeMainTitle;
    private javax.swing.JLabel DogeMinimize;
    private javax.swing.JLabel DogeOfSite;
    private javax.swing.JLabel DogeOfSiteLogo;
    private javax.swing.JPanel DogePanel;
    private javax.swing.JButton DogeRefresh;
    private javax.swing.JTextField DogeResult;
    private javax.swing.JPanel DogeSidePanel;
    private javax.swing.JLabel DogeTitle;
    private javax.swing.JPanel DogeTop;
    private javax.swing.JLabel DogeUtile;
    private javax.swing.JComboBox<String> DogeVChoose;
    private javax.swing.JLabel DogeValue;
    private javax.swing.JLabel Etc;
    private javax.swing.JButton EtcBack;
    private javax.swing.JComboBox<String> EtcCChoose;
    private javax.swing.JLabel EtcCG;
    private javax.swing.JLabel EtcCGLogo;
    private javax.swing.JButton EtcClear;
    private javax.swing.JLabel EtcClose;
    private javax.swing.JLabel EtcConversion;
    private javax.swing.JButton EtcConvert;
    private javax.swing.JTextField EtcEnter;
    private javax.swing.JLabel EtcForum;
    private javax.swing.JLabel EtcForumLogo;
    private javax.swing.JLabel EtcHistory;
    private javax.swing.JLabel EtcMainTitle;
    private javax.swing.JLabel EtcMinimize;
    private javax.swing.JLabel EtcOfSite;
    private javax.swing.JLabel EtcOfSiteLogo;
    private javax.swing.JPanel EtcPanel;
    private javax.swing.JButton EtcRefresh;
    private javax.swing.JTextField EtcResult;
    private javax.swing.JPanel EtcSidePanel;
    private javax.swing.JLabel EtcTitle;
    private javax.swing.JPanel EtcTop;
    private javax.swing.JLabel EtcUtile;
    private javax.swing.JComboBox<String> EtcVChoose;
    private javax.swing.JLabel EtcValue;
    private javax.swing.JLabel Eth;
    private javax.swing.JButton EthBack;
    private javax.swing.JComboBox<String> EthCChoose;
    private javax.swing.JLabel EthCG;
    private javax.swing.JLabel EthCGLogo;
    private javax.swing.JButton EthClear;
    private javax.swing.JLabel EthClose;
    private javax.swing.JLabel EthConversion;
    private javax.swing.JButton EthConvert;
    private javax.swing.JTextField EthEnter;
    private javax.swing.JLabel EthForum;
    private javax.swing.JLabel EthForumLogo;
    private javax.swing.JLabel EthHistory;
    private javax.swing.JLabel EthMainTitle;
    private javax.swing.JLabel EthMinimize;
    private javax.swing.JLabel EthOfSite;
    private javax.swing.JLabel EthOfSiteLogo;
    private javax.swing.JPanel EthPanel;
    private javax.swing.JButton EthRefresh;
    private javax.swing.JTextField EthResult;
    private javax.swing.JPanel EthSidePanel;
    private javax.swing.JLabel EthTitle;
    private javax.swing.JPanel EthTop;
    private javax.swing.JLabel EthUtile;
    private javax.swing.JComboBox<String> EthVChoose;
    private javax.swing.JLabel EthValue;
    private javax.swing.JButton Info;
    private javax.swing.JLabel Ltc;
    private javax.swing.JButton LtcBack;
    private javax.swing.JComboBox<String> LtcCChoose;
    private javax.swing.JLabel LtcCG;
    private javax.swing.JLabel LtcCGLogo;
    private javax.swing.JButton LtcClear;
    private javax.swing.JLabel LtcClose;
    private javax.swing.JLabel LtcConversion;
    private javax.swing.JButton LtcConvert;
    private javax.swing.JLabel LtcCy;
    private javax.swing.JLabel LtcCyLogo;
    private javax.swing.JTextField LtcEnter;
    private javax.swing.JLabel LtcForum;
    private javax.swing.JLabel LtcForumLogo;
    private javax.swing.JLabel LtcHistory;
    private javax.swing.JLabel LtcMainTitle;
    private javax.swing.JLabel LtcMinimize;
    private javax.swing.JLabel LtcOfSite;
    private javax.swing.JLabel LtcOfSiteLogo;
    private javax.swing.JPanel LtcPanel;
    private javax.swing.JButton LtcRefresh;
    private javax.swing.JTextField LtcResult;
    private javax.swing.JPanel LtcSidePanel;
    private javax.swing.JLabel LtcTitle;
    private javax.swing.JPanel LtcTop;
    private javax.swing.JLabel LtcUtile;
    private javax.swing.JComboBox<String> LtcVChoose;
    private javax.swing.JLabel LtcValue;
    private javax.swing.JPanel Menu;
    private javax.swing.JLabel MenuBG;
    private javax.swing.JLabel MenuClose;
    private javax.swing.JLabel MenuMinimize;
    private javax.swing.JProgressBar MenuProgress;
    private javax.swing.JPanel MenuTop;
    private javax.swing.JButton ProxyConfig;
    private javax.swing.JPanel Root;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JLabel Utile1;
    private javax.swing.JLabel Utile2;
    private javax.swing.JLabel UtileTitle;
    private javax.swing.JLabel Xmr;
    private javax.swing.JLabel XmrBG10;
    private javax.swing.JLabel XmrBG11;
    private javax.swing.JLabel XmrBG12;
    private javax.swing.JLabel XmrBG4;
    private javax.swing.JLabel XmrBG6;
    private javax.swing.JLabel XmrBG7;
    private javax.swing.JLabel XmrBG8;
    private javax.swing.JLabel XmrBG9;
    private javax.swing.JButton XmrBack;
    private javax.swing.JComboBox<String> XmrCChoose;
    private javax.swing.JLabel XmrCG;
    private javax.swing.JLabel XmrCGLogo;
    private javax.swing.JButton XmrClear;
    private javax.swing.JLabel XmrClose;
    private javax.swing.JLabel XmrConversion;
    private javax.swing.JButton XmrConvert;
    private javax.swing.JTextField XmrEnter;
    private javax.swing.JLabel XmrForum;
    private javax.swing.JLabel XmrForumLogo;
    private javax.swing.JLabel XmrHistory;
    private javax.swing.JLabel XmrMainTitle;
    private javax.swing.JLabel XmrMinimize;
    private javax.swing.JLabel XmrOfSite;
    private javax.swing.JLabel XmrOfSiteLogo;
    private javax.swing.JPanel XmrPanel;
    private javax.swing.JButton XmrRefresh;
    private javax.swing.JTextField XmrResult;
    private javax.swing.JPanel XmrSidePanel;
    private javax.swing.JLabel XmrTitle;
    private javax.swing.JPanel XmrTop;
    private javax.swing.JLabel XmrUtile;
    private javax.swing.JComboBox<String> XmrVChoose;
    private javax.swing.JLabel XmrValue;
    // End of variables declaration//GEN-END:variables

    private void InputStreamReader(InputStream openStream) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void Bitcoin(String currency) {
        if (BtcValue.getText().equalsIgnoreCase("1 Btc ≈ ") || BtcValue.getText().equalsIgnoreCase("")) {
        DecimalFormat f = new DecimalFormat("##.######"); 
        Double s = j.getJSONObject("market_data").getJSONObject("current_price").getDouble(currency);
        BtcValue.setText(BtcValue.getText()+ CurrencySymbol + f.format(s));

        }
    }
       
    public void Litecoin(String currency) {
        if (LtcValue.getText().equalsIgnoreCase("1 Ltc ≈ ") || LtcValue.getText().equalsIgnoreCase("")) {
        DecimalFormat f = new DecimalFormat("##.#####"); 
        Double s = j.getJSONObject("market_data").getJSONObject("current_price").getDouble(currency);
        LtcValue.setText(LtcValue.getText()+ CurrencySymbol + f.format(s));
        }
    }
    public void Monero(String currency) {
        if (XmrValue.getText().equalsIgnoreCase("1 Xmr ≈ ") || XmrValue.getText().equalsIgnoreCase("")) {
        DecimalFormat f = new DecimalFormat("##.#####"); 
        Double s = j.getJSONObject("market_data").getJSONObject("current_price").getDouble(currency);
        XmrValue.setText(XmrValue.getText()+ CurrencySymbol + f.format(s));
        }
    }
    public void Dogecoin(String currency) {
        if (DogeValue.getText().equalsIgnoreCase("1 Doge ≈ ") || DogeValue.getText().equalsIgnoreCase("")) {
        DecimalFormat f = new DecimalFormat("##.#####"); 
        Double s = j.getJSONObject("market_data").getJSONObject("current_price").getDouble(currency);
        DogeValue.setText(DogeValue.getText()+ CurrencySymbol + f.format(s));
        }
    }
    
     public void Dash(String currency) {
        if (DashValue.getText().equalsIgnoreCase("1 Dash ≈ ") || DashValue.getText().equalsIgnoreCase("")) {
        DecimalFormat f = new DecimalFormat("##.#####"); 
        Double s = j.getJSONObject("market_data").getJSONObject("current_price").getDouble(currency);
        DashValue.setText(DashValue.getText()+ CurrencySymbol + f.format(s));
        }
    }
     
      public void BitcoinCash(String currency) {
        if (BchValue.getText().equalsIgnoreCase("1 Bch ≈ ") || BchValue.getText().equalsIgnoreCase("")) {
        DecimalFormat f = new DecimalFormat("##.#####"); 
        Double s = j.getJSONObject("market_data").getJSONObject("current_price").getDouble(currency);
        BchValue.setText(BchValue.getText()+ CurrencySymbol + f.format(s));
        }
    }
        public void Ethereum(String currency) {
        if (EthValue.getText().equalsIgnoreCase("1 Eth ≈ ") || EthValue.getText().equalsIgnoreCase("")) {
        DecimalFormat f = new DecimalFormat("##.#####"); 
        Double s = j.getJSONObject("market_data").getJSONObject("current_price").getDouble(currency);
        EthValue.setText(EthValue.getText()+ CurrencySymbol + f.format(s));
        }
    }
        
          public void EthereumClassic(String currency) {
        if (EtcValue.getText().equalsIgnoreCase("1 Etc ≈ ") || EtcValue.getText().equalsIgnoreCase("")) {
        DecimalFormat f = new DecimalFormat("##.#####"); 
        Double s = j.getJSONObject("market_data").getJSONObject("current_price").getDouble(currency);
        EtcValue.setText(EtcValue.getText()+ CurrencySymbol + f.format(s));
        }
    }
    
    private boolean valueProgress;
    public void loadingProgressBar(Runnable r, JProgressBar p){
        valueProgress = true;
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(valueProgress){
                    try {
                        Thread.sleep(200);
                        Random random = new Random();
                        int x = random.nextInt(3);
                        p.setValue(p.getValue() + x);
                        
                    } catch (Exception e) {
                    }
                }
            }
        });
        t1.start();
        Thread t2 = new Thread(r);
        t2.start();
    }
    public void setIcon() {
      icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/bitknow/resources/Icon2.png"));
      setIconImage(icon); 
    }
    
    public void VChoose(JComboBox escolha) {
           SelectedCurrency = String.valueOf(escolha.getSelectedItem());
        if (SelectedCurrency.equalsIgnoreCase("brl")) {
            CurrencySymbol = "R$ ";
        } else if (SelectedCurrency.equalsIgnoreCase("usd")) {
            CurrencySymbol = "US$ ";
        } else if (SelectedCurrency.equalsIgnoreCase("eur")) {
            CurrencySymbol = "€ ";
        } else if (SelectedCurrency.equalsIgnoreCase("jpy")) {
            CurrencySymbol = "¥ ";
        } else if (SelectedCurrency.equalsIgnoreCase("gbp")) {
            CurrencySymbol = "£ ";
        } else if (SelectedCurrency.equalsIgnoreCase("cad")) {
            CurrencySymbol = "C$ ";
        } else if (SelectedCurrency.equalsIgnoreCase("mxn")) {
            CurrencySymbol = "Mex$ ";
        }
    }
    public void CChoose(JComboBox jb) {
        ConversionCurrency = String.valueOf(jb.getSelectedItem()); 
        System.out.println(ConversionCurrency);
        testConnection(coin);
        DecimalFormat f = new DecimalFormat("##.#####"); 
        Double s = j.getJSONObject("market_data").getJSONObject("current_price").getDouble(ConversionCurrency);
        f.format(s);
        ConversionCurrencyValue = s;
    }
    public void Clear(JTextField enter, JTextField result) {
        enter.setForeground(new Color(204,204,204));
        enter.setText("Digite o valor aqui");
        result.setForeground(new Color(204,204,204));
        result.setText("O Resultado aparecerá aqui");
    }
    public void Back(JLabel value, JTextField enter, JTextField result) {
        cl.show(Root,"Menu");
        BtcValue.setText("1 Btc ≈ ");
        CurrencySymbol = "R$ ";
        Clear(enter,result);
        MenuProgress.setVisible(false);
        MenuProgress.setValue(0);
   }
    
    public void Convert(JComboBox c, JTextField enter, JTextField result, String simbol) {
        int x;           
        if (c.getSelectedIndex() != 0) {
            String s = enter.getText();
            for (int i = 0; i < s.length(); i++) {
                  try {
                Double d = Double.parseDouble(String.valueOf(s.charAt(i)));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,"Houve um erro, assegure-se que escreveu apenas números");
                return;
            }
            }
            ConversionResult = (Double.parseDouble(enter.getText()) / ConversionCurrencyValue);
        } else {
            JOptionPane.showMessageDialog(null,"É necessário escolher uma moeda pra conversão");
            return;
        }
        result.setForeground(new Color(0,0,0));
        result.setText(String.valueOf(ConversionResult) + " " + simbol);
    }
    public void chamaSplash() {
        Splash s = new Splash();
    }
}
