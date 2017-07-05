
package queen;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class Chessboard extends javax.swing.JPanel {

    private JLabel[][] allLabels;
    public final static int labelSize = 40;
    private final int size;
    
    public Chessboard(int size) {
        initComponents();
        this.size = size;
        allLabels = new JLabel[this.size][this.size];
        for (int i = 0 ; i < this.size ; i++){
            for (int j = 0 ; j < this.size ; j++){
                allLabels[i][j] = new JLabel("", JLabel.CENTER);
                allLabels[i][j].setBounds(labelSize*j, labelSize*i,labelSize, labelSize);
                allLabels[i][j].setOpaque(true);
                allLabels[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                 
                if (!(j % 2 == 0 && i % 2 == 0) && !(j % 2 != 0 && i % 2 != 0))
                    allLabels[i][j].setBackground(Color.lightGray);
                else 
                    allLabels[i][j].setBackground(Color.WHITE);
                this.add(allLabels[i][j]);
            }
        }
    }
    
    public void placeQueens(int[] arr){
            //System.out.println(arr.length);
        for (int i = 0 ; i < arr.length ; i++){
            allLabels[i][arr[i]].setText("Q");
            System.out.println(arr[i]);
        
        }
    }
    
    
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 445, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
