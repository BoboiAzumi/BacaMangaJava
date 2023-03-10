/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package MangaSwing;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import libmanga.Manga.MangaItem;
import libtool.HTTPConnect;

/**
 *
 * @author naufal
 */
public class ListCustomRender extends javax.swing.JPanel implements ListCellRenderer<MangaItem> {

    /**
     * Creates new form ListCustomRender
     */
    HTTPConnect HC = new HTTPConnect();
    public ListCustomRender() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public Component getListCellRendererComponent(JList<? extends MangaItem> jlist, MangaItem e, int i, boolean isSelected, boolean hasFocus) {
        Image img = e.getImg();
        if(img != null){
            setup(e, jlist, isSelected);
            try {
                jLabel1.setIcon(new ImageIcon(resizeImage(img, 48, 71)));
            } catch (IOException ex) {
                Logger.getLogger(ListCustomRender.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            setup(e, jlist, isSelected);
            try {
                img = ImageIO.read(new File("img/ErrorImage.png"));
                jLabel1.setIcon(new ImageIcon(resizeImage(img, 48, 71)));
            } catch (IOException ex) {
                Logger.getLogger(ListCustomRender.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this;
    }
    
    public void setup(MangaItem e, JList<? extends MangaItem> jlist, boolean isSelected){
        jLabel4.setText(e.getJudul());
        jLabel2.setText(e.getMangaType());
        jLabel3.setText(e.getScore());
        
        if(isSelected){
            jLabel2.setBackground(jlist.getSelectionBackground());
            jLabel3.setBackground(jlist.getSelectionBackground());
            jLabel4.setBackground(jlist.getSelectionBackground());
            setBackground(jlist.getSelectionBackground());
        }
        else{
            jLabel2.setBackground(jlist.getBackground());
            jLabel3.setBackground(jlist.getBackground());
            jLabel4.setBackground(jlist.getBackground());
            setBackground(jlist.getBackground());
        }
    }
    
    public BufferedImage resizeImage(Image originalImage, int targetWidth, int targetHeight) throws IOException {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return resizedImage;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
