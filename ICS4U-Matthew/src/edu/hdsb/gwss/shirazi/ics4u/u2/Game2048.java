/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.shirazi.ics4u.u2;

import java.awt.event.KeyEvent;
import java.util.Scanner;
import javax.swing.JLabel;

/**
 *
 * @author 1shirazimat
 */
public class Game2048 extends javax.swing.JFrame {

    private static final int EMPTY = 0;

    private final JLabel[][] squares;
    private int[][] values;

    /**
     * Creates new form Game2048
     */
    public Game2048() {
        initComponents();

        // CREAATE ARRAY
        squares = new JLabel[4][4];

        // COLUMN 1
        squares[0][0] = jLabel00;
        squares[1][0] = jLabel10;
        squares[2][0] = jLabel20;
        squares[3][0] = jLabel30;

        // COLUMN 2
        squares[0][1] = jLabel01;
        squares[1][1] = jLabel11;
        squares[2][1] = jLabel21;
        squares[3][1] = jLabel31;

        // COLUMN 3
        squares[0][2] = jLabel02;
        squares[1][2] = jLabel12;
        squares[2][2] = jLabel22;
        squares[3][2] = jLabel32;

        // COLUMN 4
        squares[0][3] = jLabel03;
        squares[1][3] = jLabel13;
        squares[2][3] = jLabel23;
        squares[3][3] = jLabel33;

        // TEST DATA
//        values[0][0] = 2;
//        values[0][1] = 2;
//
//        // TEST DATA
//        values[1][0] = 2;
//        values[1][2] = 2;
//
//        // TEST DATA
//        values[2][1] = 2;
//        values[2][3] = 2;
//
//        // TEST DATA
//        values[3][1] = 2;
//        values[3][3] = 2;
//        values[3][3] = 2;

        // CLEAR GAMEBOARD
        clearBoard();
        updateBoard();
    }

    public void clearBoard() {

        values = new int[4][4];

        for (int r = 0; r < squares.length; r++) {
            for (int c = 0; c < squares[r].length; c++) {
                squares[r][c].setText("");
            }
        }
        placeRandomTwo();
        placeRandomTwo();
    }

    private void placeRandomTwo() {

        boolean placed = false;

        int r, c;
        while (!placed) {
            r = (int) (Math.random() * 4);
            c = (int) (Math.random() * 4);

            if (values[r][c] == EMPTY) {
                values[r][c] = 2;
                squares[r][c].setText("2");
                placed = true;
            }
        }       
    }

    private void updateBoard() {
        // values array --> update jLabels
        for (int row = 0; row < squares.length; row++) {
            for (int col = 0; col < squares[row].length; col++) {

                if (values[row][col] != 2) {
                    values[row][col] = 0;
                    squares[row][col].setText("" + values[row][col]);
                }
            }
        }
    }

    private void mergeLeft() {
        // Add numbers if they are same\
        
    for (int pass = 1; pass < 4; pass++) {
            
        for (int row = 0; row < squares.length; row++) {

            for (int col = squares.length-1; col > -1; col--) {

            if ( values[row][col] > 0 && (values[row][col - 1] == values[row][col]) ) {
                values[row][col - 1] = values[row][col - 1] *2;
                values[row][col] = 0;
                squares[row][col - 1].setText("" + values[row][col - 1]);
                squares[row][col].setText("" + values[row][col]);
           }    
          }
         }
        }
       }
    
    private void mergeRight() {
        // Add numbers if they are same
        for (int row = 0; row < values.length - 1; row++) {

            for (int pass = 0; pass < (values.length - 1) - row; pass++) {

                for (int col = 1; col < (values.length - 1); col++) {

                    if (values[row][col] != 0 && values[row][col] == values[row][col + 1]) {
                        values[row][col] = values[row][col] + values[row][col];
                        squares[row][col].setText("" + values[row][col]);
                    }
                }
            }
        }
    }

    public void shiftRight() {
        for (int i = 0; i < 4; i++) {
            for (int row = 0; row < squares.length; row++) {

                for (int col = 0; col < squares.length-1; col++) {

                    if (values[row][col+1] == 0) {
                        values[row][col + 1] = values[row][col];
                        values[row][col] = 0;

                        squares[row][col + 1].setText("" + values[row][col + 1]);
                        squares[row][col].setText("" + 0);
                    }
                }
            }
        }
    }
    
    public void shiftLeft() {
        for (int i = 0; i < 4; i++) {
            for (int row = 0; row < squares.length; row++) {

                for (int col = squares.length-1; col > 0; col--) {

                    if (values[row][col-1] == 0) {
                        values[row][col - 1] = values[row][col];
                        values[row][col] = 0;

                        squares[row][col - 1].setText("" + values[row][col - 1]);
                        squares[row][col].setText("" + 0);
                    }
                }
            }

        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel36 = new javax.swing.JLabel();
        jPanelTop = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelGameBoard = new javax.swing.JPanel();
        jLabel00 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel01 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel02 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel03 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();

        jLabel36.setBackground(new java.awt.Color(51, 102, 255));
        jLabel36.setFont(new java.awt.Font("Traditional Arabic", 0, 30)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("1024");
        jLabel36.setOpaque(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("2048 Shirazi");
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanelTop.setBackground(new java.awt.Color(0, 51, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("2048");

        javax.swing.GroupLayout jPanelTopLayout = new javax.swing.GroupLayout(jPanelTop);
        jPanelTop.setLayout(jPanelTopLayout);
        jPanelTopLayout.setHorizontalGroup(
            jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTopLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTopLayout.setVerticalGroup(
            jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTopLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanelGameBoard.setBackground(new java.awt.Color(0, 153, 204));
        jPanelGameBoard.setToolTipText("");
        jPanelGameBoard.setName(""); // NOI18N

        jLabel00.setBackground(new java.awt.Color(0, 51, 204));
        jLabel00.setFont(new java.awt.Font("Traditional Arabic", 0, 30)); // NOI18N
        jLabel00.setForeground(new java.awt.Color(255, 255, 255));
        jLabel00.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel00.setText("1024");
        jLabel00.setOpaque(true);

        jLabel10.setBackground(new java.awt.Color(0, 51, 204));
        jLabel10.setFont(new java.awt.Font("Traditional Arabic", 0, 30)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("1024");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)));
        jLabel10.setOpaque(true);

        jLabel20.setBackground(new java.awt.Color(0, 51, 204));
        jLabel20.setFont(new java.awt.Font("Traditional Arabic", 0, 30)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("1024");
        jLabel20.setOpaque(true);

        jLabel30.setBackground(new java.awt.Color(0, 51, 204));
        jLabel30.setFont(new java.awt.Font("Traditional Arabic", 0, 30)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("1024");
        jLabel30.setOpaque(true);

        jLabel01.setBackground(new java.awt.Color(0, 51, 204));
        jLabel01.setFont(new java.awt.Font("Traditional Arabic", 0, 30)); // NOI18N
        jLabel01.setForeground(new java.awt.Color(255, 255, 255));
        jLabel01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel01.setText("1024");
        jLabel01.setOpaque(true);

        jLabel11.setBackground(new java.awt.Color(0, 51, 204));
        jLabel11.setFont(new java.awt.Font("Traditional Arabic", 0, 30)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("1024");
        jLabel11.setOpaque(true);

        jLabel21.setBackground(new java.awt.Color(0, 51, 204));
        jLabel21.setFont(new java.awt.Font("Traditional Arabic", 0, 30)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("1024");
        jLabel21.setOpaque(true);

        jLabel31.setBackground(new java.awt.Color(0, 51, 204));
        jLabel31.setFont(new java.awt.Font("Traditional Arabic", 0, 30)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("1024");
        jLabel31.setOpaque(true);

        jLabel02.setBackground(new java.awt.Color(0, 51, 204));
        jLabel02.setFont(new java.awt.Font("Traditional Arabic", 0, 30)); // NOI18N
        jLabel02.setForeground(new java.awt.Color(255, 255, 255));
        jLabel02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel02.setText("1024");
        jLabel02.setOpaque(true);

        jLabel12.setBackground(new java.awt.Color(0, 51, 204));
        jLabel12.setFont(new java.awt.Font("Traditional Arabic", 0, 30)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("1024");
        jLabel12.setOpaque(true);

        jLabel22.setBackground(new java.awt.Color(0, 51, 204));
        jLabel22.setFont(new java.awt.Font("Traditional Arabic", 0, 30)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("1024");
        jLabel22.setOpaque(true);

        jLabel23.setBackground(new java.awt.Color(0, 51, 204));
        jLabel23.setFont(new java.awt.Font("Traditional Arabic", 0, 30)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("1024");
        jLabel23.setOpaque(true);

        jLabel32.setBackground(new java.awt.Color(0, 51, 204));
        jLabel32.setFont(new java.awt.Font("Traditional Arabic", 0, 30)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("1024");
        jLabel32.setOpaque(true);

        jLabel13.setBackground(new java.awt.Color(0, 51, 204));
        jLabel13.setFont(new java.awt.Font("Traditional Arabic", 0, 30)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("1024");
        jLabel13.setOpaque(true);

        jLabel03.setBackground(new java.awt.Color(0, 51, 204));
        jLabel03.setFont(new java.awt.Font("Traditional Arabic", 0, 30)); // NOI18N
        jLabel03.setForeground(new java.awt.Color(255, 255, 255));
        jLabel03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel03.setText("1024");
        jLabel03.setOpaque(true);

        jLabel33.setBackground(new java.awt.Color(0, 51, 204));
        jLabel33.setFont(new java.awt.Font("Traditional Arabic", 0, 30)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("1024");
        jLabel33.setOpaque(true);

        javax.swing.GroupLayout jPanelGameBoardLayout = new javax.swing.GroupLayout(jPanelGameBoard);
        jPanelGameBoard.setLayout(jPanelGameBoardLayout);
        jPanelGameBoardLayout.setHorizontalGroup(
            jPanelGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGameBoardLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanelGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGameBoardLayout.createSequentialGroup()
                        .addGroup(jPanelGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelGameBoardLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGameBoardLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanelGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGameBoardLayout.createSequentialGroup()
                                        .addGroup(jPanelGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanelGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGameBoardLayout.createSequentialGroup()
                                        .addComponent(jLabel01, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel02, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(jLabel00, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGameBoardLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelGameBoardLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel03, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelGameBoardLayout.setVerticalGroup(
            jPanelGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGameBoardLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanelGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel03, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel02, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel01, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel00, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelGameBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanelTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanelGameBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        System.out.print("KEY PRESSED: ");
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_UP:
                System.out.println("UP");
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("DOWN");
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("LEFT");
                shiftLeft();
                mergeLeft();
                shiftLeft();
                placeRandomTwo();
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("RIGHT");
                shiftRight();
//                mergeRight();
                shiftRight();
                placeRandomTwo();
                break;
        }
    }//GEN-LAST:event_formKeyPressed

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
            java.util.logging.Logger.getLogger(Game2048.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game2048.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game2048.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game2048.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game2048().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel00;
    private javax.swing.JLabel jLabel01;
    private javax.swing.JLabel jLabel02;
    private javax.swing.JLabel jLabel03;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JPanel jPanelGameBoard;
    private javax.swing.JPanel jPanelTop;
    // End of variables declaration//GEN-END:variables
}
