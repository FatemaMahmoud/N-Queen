
package queen;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;



public class QueenFrame extends javax.swing.JFrame {

    private ArrayList <int []> allSolutions;
    private int boardSize;
    private ArrayList<ArrayList<Integer>> prev;
    
    public QueenFrame() {
        initComponents();
        allSolutions = new ArrayList<>();
        prev = new ArrayList<>();
        this.getContentPane().setBackground(Color.white);
        this.setLocation(500, 100);
    }
    
    private void findSol(){
        allSolutions.add(new int [this.boardSize]);
        allSolutions.get(allSolutions.size()-1)[0] = 0;
        
        outer:
        for (int i = 1 ; i < this.boardSize ; i++){
            
            while (!place(i)){
                //backtrack
                if (i - 1 == 0){
                    allSolutions.get(allSolutions.size()-1)[0]++; 
                    if (allSolutions.get(allSolutions.size()-1)[0] == this.boardSize){
                        allSolutions.remove(allSolutions.size()-1);
                        break outer;
                    }
                }
                else
                    i--;
            }
            if (i == this.boardSize-1){
                prev.add(new ArrayList<>(Arrays.asList(intToInteger(allSolutions.get(allSolutions.size()-1))))); ///////read on boxing and unboxing
                allSolutions.add(Arrays.copyOf(allSolutions.get(allSolutions.size()-1), this.boardSize));
                i-= 2;
            }
        }
        
    }
    
    private Integer[] intToInteger(int[] arr){
        Integer[] ints = new Integer[arr.length];
        for (int i = 0 ; i < arr.length ; i++){
            ints[i] = arr[i];
        }
        return ints;
        
    }
    private boolean place(int index){
   
        for (int i = 0 ; i < this.boardSize ; i++){
            for (int j = 0 ; j < index ; j++){
                if (allSolutions.get(allSolutions.size()-1)[j] == i)
                    break;
               
                if (j == index -1){
                    if(checkDiag(index, i)){
                        allSolutions.get(allSolutions.size()-1)[index] = i;
                        if(checkPrev(index))
                            return true;
                    }
                }
            }
        }
        addPrev(index);
        return false;
    }
    
    private boolean checkDiag(int row, int col){
        
        for (int i = 0 ; i < row ; i++){
            if (Math.abs(row - i) == Math.abs(col - allSolutions.get(allSolutions.size()-1)[i]))
                return false;
        }
        return true;     
    }
    
    private boolean checkPrev(int index){
        
        boolean equal = false;
        if (prev.isEmpty())
            return true;
        else {
            for (int i = 0 ; i < prev.size() ; i++){
                if (!(index+1 == prev.get(i).size())) {
                } 
                else {
                    for (int j = 0 ; j < prev.get(i).size() ; j++){
                        if (allSolutions.get(allSolutions.size()-1)[j] != prev.get(i).get(j)){
                            equal = false;
                            break;
                        }
                        else
                            equal = true;
                    }
                    if (equal)
                        return false;
                }
            }
            
        }
        return true;
    }
    
    public void addPrev(int index){
        
        prev.add(new ArrayList<>());
        for (int i = 0; i < index ; i++)
            prev.get(prev.size()-1).add(allSolutions.get(allSolutions.size()-1)[i]);
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        boardSizeField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        solPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        boardSizeField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Number of Solutions:");

        boardSizeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boardSizeFieldActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText("N Queen Problem");

        jButton1.setBackground(new java.awt.Color(204, 0, 0));
        jButton1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Show All Solutions");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Solutions' Panel", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT Condensed", 1, 24), new java.awt.Color(204, 0, 0))); // NOI18N
        jScrollPane1.setForeground(new java.awt.Color(204, 0, 0));

        solPanel.setBackground(new java.awt.Color(255, 255, 255));
        solPanel.setPreferredSize(new java.awt.Dimension(583, 500));

        javax.swing.GroupLayout solPanelLayout = new javax.swing.GroupLayout(solPanel);
        solPanel.setLayout(solPanelLayout);
        solPanelLayout.setHorizontalGroup(
            solPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 583, Short.MAX_VALUE)
        );
        solPanelLayout.setVerticalGroup(
            solPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(solPanel);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Size of the chessboard: ");

        boardSizeField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boardSizeField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(boardSizeField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boardSizeField1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)
                        .addComponent(boardSizeField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(boardSizeField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boardSizeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boardSizeFieldActionPerformed
        
    }//GEN-LAST:event_boardSizeFieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.boardSize = Integer.parseInt(this.boardSizeField.getText());
        findSol();
        this.boardSizeField1.setText(this.allSolutions.size() + "");
//        if (boardSize*Chessboard.labelSize + 20 <= this.solPanel.getSize().width)
//            this.solPanel.setPreferredSize(new Dimension(boardSize*Chessboard.labelSize + 20, boardSize*Chessboard.labelSize + 20));
//        else if (boardSize*Chessboard.labelSize + 20 <= this.solPanel.getSize().height)
//            this.solPanel.setPreferredSize(new Dimension(this.solPanel.getSize().width, boardSize*Chessboard.labelSize + 20));
        int inWidth = this.solPanel.getSize().width / (20 + Chessboard.labelSize*this.boardSize);
//        int inHeight = this.solPanel.getSize().height / (20 + Chessboard.labelSize*this.boardSize);
        for (int i = 0 ; i < allSolutions.size() ; i++){
            this.solPanel.setPreferredSize(new Dimension(this.solPanel.getPreferredSize().width, this.solPanel.getPreferredSize().getSize().height + (boardSize*Chessboard.labelSize + 20)));
            Chessboard cb = new Chessboard(this.boardSize);
            cb.setBounds(10*(i%inWidth + 1)+Chessboard.labelSize*this.boardSize*(i%inWidth), 10*(i/inWidth)+Chessboard.labelSize*this.boardSize*(i/inWidth), Chessboard.labelSize*this.boardSize, Chessboard.labelSize*this.boardSize);
            cb.placeQueens(allSolutions.get(i));
            this.solPanel.add(cb);
            this.solPanel.repaint();

        }      
}//GEN-LAST:event_jButton1ActionPerformed

    private void boardSizeField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boardSizeField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boardSizeField1ActionPerformed

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
            java.util.logging.Logger.getLogger(QueenFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QueenFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QueenFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QueenFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QueenFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField boardSizeField;
    private javax.swing.JTextField boardSizeField1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel solPanel;
    // End of variables declaration//GEN-END:variables
}
