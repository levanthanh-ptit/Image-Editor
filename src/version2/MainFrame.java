/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package version2;

import IEFile.*;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author FPTDNSB
 */
public class MainFrame extends javax.swing.JFrame {

    final IEFileChooser fc;
    final IESaveChooser saveC;
    public ImageProcessor imageProcessor;
    public ThreshChooser threshChooser;
    public PowerChooser powerChooser;
    public SettingFrame settingFrame;
    public MaxSizeWindows maxSizeWindows;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        this.fc = new IEFileChooser();
        this.saveC = new IESaveChooser();
        threshChooser = new ThreshChooser(this);
        powerChooser = new PowerChooser(this);
        settingFrame = new SettingFrame(imageProcessor);
        maxSizeWindows = new MaxSizeWindows(this);
        this.imageProcessor = new ImageProcessor(threshChooser.jSlider1.getValue(), powerChooser.jSlider1.getValue());
        initComponents();

    }

//Create a file chooser
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelBefore = new javax.swing.JLabel();
        jLabelAfter = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        jMeItHistogramE = new javax.swing.JMenuItem();
        jMeItNegative = new javax.swing.JMenuItem();
        jMeItThresholding = new javax.swing.JMenuItem();
        jMeItLogarithmic = new javax.swing.JMenuItem();
        jMeItPower = new javax.swing.JMenuItem();
        jMeItAverageFilter = new javax.swing.JMenuItem();
        jMeItLaplacian = new javax.swing.JMenuItem();
        jMeItVarientLaplacian = new javax.swing.JMenuItem();
        jMeItSobelOpertor = new javax.swing.JMenuItem();
        jMeItGeometricMean = new javax.swing.JMenuItem();
        jMeItHarmonicMean = new javax.swing.JMenuItem();
        jMeItMaxFilter = new javax.swing.JMenuItem();
        jMeItMinFilter = new javax.swing.JMenuItem();
        jMeItMedian = new javax.swing.JMenuItem();
        jMeItAdaptiveMedian = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMeItSetting = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentsMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1300, 700));
        setMinimumSize(new java.awt.Dimension(1300, 700));
        setPreferredSize(new java.awt.Dimension(1300, 700));
        setResizable(false);
        setSize(new java.awt.Dimension(1300, 700));

        jLabelBefore.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBefore.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelBefore.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabelAfter.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAfter.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelAfter.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Open");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Save");
        saveMenuItem.setEnabled(false);
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('E');
        editMenu.setText("Edit");
        editMenu.setEnabled(false);

        jMeItHistogramE.setMnemonic('H');
        jMeItHistogramE.setText("Histogram Equalizer");
        jMeItHistogramE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMeItHistogramEActionPerformed(evt);
            }
        });
        editMenu.add(jMeItHistogramE);

        jMeItNegative.setText("Negative");
        jMeItNegative.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMeItNegativeActionPerformed(evt);
            }
        });
        editMenu.add(jMeItNegative);

        jMeItThresholding.setText("Thresholding");
        jMeItThresholding.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMeItThresholdingActionPerformed(evt);
            }
        });
        editMenu.add(jMeItThresholding);

        jMeItLogarithmic.setText("Logarithmic");
        jMeItLogarithmic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMeItLogarithmicActionPerformed(evt);
            }
        });
        editMenu.add(jMeItLogarithmic);

        jMeItPower.setText("Power");
        jMeItPower.setToolTipText("");
        jMeItPower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMeItPowerActionPerformed(evt);
            }
        });
        editMenu.add(jMeItPower);

        jMeItAverageFilter.setText("Average filter");
        jMeItAverageFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMeItAverageFilterActionPerformed(evt);
            }
        });
        editMenu.add(jMeItAverageFilter);

        jMeItLaplacian.setText("Laplacian filter");
        jMeItLaplacian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMeItLaplacianActionPerformed(evt);
            }
        });
        editMenu.add(jMeItLaplacian);

        jMeItVarientLaplacian.setText("Variant Laplacian");
        jMeItVarientLaplacian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMeItVarientLaplacianActionPerformed(evt);
            }
        });
        editMenu.add(jMeItVarientLaplacian);

        jMeItSobelOpertor.setText("Sobel Operator");
        jMeItSobelOpertor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMeItSobelOpertorActionPerformed(evt);
            }
        });
        editMenu.add(jMeItSobelOpertor);

        jMeItGeometricMean.setText("Geometric Mean");
        jMeItGeometricMean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMeItGeometricMeanActionPerformed(evt);
            }
        });
        editMenu.add(jMeItGeometricMean);

        jMeItHarmonicMean.setText("Harmonic Mean");
        jMeItHarmonicMean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMeItHarmonicMeanActionPerformed(evt);
            }
        });
        editMenu.add(jMeItHarmonicMean);

        jMeItMaxFilter.setText("Max filter");
        jMeItMaxFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMeItMaxFilterActionPerformed(evt);
            }
        });
        editMenu.add(jMeItMaxFilter);

        jMeItMinFilter.setText("Min filter");
        jMeItMinFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMeItMinFilterActionPerformed(evt);
            }
        });
        editMenu.add(jMeItMinFilter);

        jMeItMedian.setText("Median filter");
        jMeItMedian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMeItMedianActionPerformed(evt);
            }
        });
        editMenu.add(jMeItMedian);

        jMeItAdaptiveMedian.setText("Adaptive Median");
        jMeItAdaptiveMedian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMeItAdaptiveMedianActionPerformed(evt);
            }
        });
        editMenu.add(jMeItAdaptiveMedian);
        editMenu.add(jSeparator1);

        jMeItSetting.setText("Setting");
        jMeItSetting.setEnabled(false);
        jMeItSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMeItSettingActionPerformed(evt);
            }
        });
        editMenu.add(jMeItSetting);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentsMenuItem.setMnemonic('c');
        contentsMenuItem.setText("Contents");
        helpMenu.add(contentsMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelBefore, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelAfter, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelBefore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelAfter, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed

        int returnVal = fc.showOpenDialog(MainFrame.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            imageProcessor.readImage(fc.getSelectedFile());
            System.out.println("read path: " + imageProcessor.filePath_input);
            if (this.imageProcessor.bufferSource != null) {

                jLabelBefore.setIcon(new ImageIcon(imageProcessor.bufferSource));
            }
            editMenu.setEnabled(true);
            saveMenuItem.setEnabled(true);
            jMeItSetting.setEnabled(true);
        }


    }//GEN-LAST:event_openMenuItemActionPerformed

    private void jMeItHistogramEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMeItHistogramEActionPerformed
        imageProcessor.balanceHistogram();
        jLabelAfter.setIcon(new ImageIcon(imageProcessor.bufferedOutput));
    }//GEN-LAST:event_jMeItHistogramEActionPerformed

    private void jMeItLaplacianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMeItLaplacianActionPerformed
        imageProcessor.filterLaplacian();
        jLabelAfter.setIcon(new ImageIcon(imageProcessor.bufferedOutput));
    }//GEN-LAST:event_jMeItLaplacianActionPerformed

    private void jMeItVarientLaplacianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMeItVarientLaplacianActionPerformed
        imageProcessor.filterVariantLaplacian();
        jLabelAfter.setIcon(new ImageIcon(imageProcessor.bufferedOutput));
    }//GEN-LAST:event_jMeItVarientLaplacianActionPerformed

    private void jMeItAverageFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMeItAverageFilterActionPerformed
        imageProcessor.averageFilter();
        jLabelAfter.setIcon(new ImageIcon(imageProcessor.bufferedOutput));
    }//GEN-LAST:event_jMeItAverageFilterActionPerformed

    private void jMeItNegativeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMeItNegativeActionPerformed
        imageProcessor.negative();
        jLabelAfter.setIcon(new ImageIcon(imageProcessor.bufferedOutput));
    }//GEN-LAST:event_jMeItNegativeActionPerformed

    private void jMeItThresholdingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMeItThresholdingActionPerformed
        threshChooser.setVisible(true);
    }//GEN-LAST:event_jMeItThresholdingActionPerformed

    private void jMeItPowerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMeItPowerActionPerformed
        powerChooser.setVisible(true);
    }//GEN-LAST:event_jMeItPowerActionPerformed

    private void jMeItLogarithmicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMeItLogarithmicActionPerformed
        imageProcessor.logarithmic();
        jLabelAfter.setIcon(new ImageIcon(imageProcessor.bufferedOutput));
    }//GEN-LAST:event_jMeItLogarithmicActionPerformed

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed

        int returnVal = saveC.showOpenDialog(MainFrame.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            imageProcessor.writeImage(saveC.getSelectedFile().getPath());
        }


    }//GEN-LAST:event_saveMenuItemActionPerformed

    private void jMeItSobelOpertorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMeItSobelOpertorActionPerformed
        imageProcessor.sobelOperator();
        jLabelAfter.setIcon(new ImageIcon(imageProcessor.bufferedOutput));
    }//GEN-LAST:event_jMeItSobelOpertorActionPerformed

    private void jMeItGeometricMeanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMeItGeometricMeanActionPerformed
        imageProcessor.geometricMean();
        jLabelAfter.setIcon(new ImageIcon(imageProcessor.bufferedOutput));
    }//GEN-LAST:event_jMeItGeometricMeanActionPerformed

    private void jMeItHarmonicMeanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMeItHarmonicMeanActionPerformed
        imageProcessor.hamonicMean();
        jLabelAfter.setIcon(new ImageIcon(imageProcessor.bufferedOutput));
    }//GEN-LAST:event_jMeItHarmonicMeanActionPerformed

    private void jMeItSettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMeItSettingActionPerformed
        settingFrame.setVisible(true);
    }//GEN-LAST:event_jMeItSettingActionPerformed

    private void jMeItMedianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMeItMedianActionPerformed
        imageProcessor.medianFilter();
        jLabelAfter.setIcon(new ImageIcon(imageProcessor.bufferedOutput));
    }//GEN-LAST:event_jMeItMedianActionPerformed

    private void jMeItMaxFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMeItMaxFilterActionPerformed
        imageProcessor.maxFilter();
        jLabelAfter.setIcon(new ImageIcon(imageProcessor.bufferedOutput));
    }//GEN-LAST:event_jMeItMaxFilterActionPerformed

    private void jMeItMinFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMeItMinFilterActionPerformed
        imageProcessor.minFilter();
        jLabelAfter.setIcon(new ImageIcon(imageProcessor.bufferedOutput));
    }//GEN-LAST:event_jMeItMinFilterActionPerformed

    private void jMeItAdaptiveMedianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMeItAdaptiveMedianActionPerformed
        maxSizeWindows.setVisible(true);
    }//GEN-LAST:event_jMeItAdaptiveMedianActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentsMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    public javax.swing.JLabel jLabelAfter;
    private javax.swing.JLabel jLabelBefore;
    private javax.swing.JMenuItem jMeItAdaptiveMedian;
    private javax.swing.JMenuItem jMeItAverageFilter;
    private javax.swing.JMenuItem jMeItGeometricMean;
    private javax.swing.JMenuItem jMeItHarmonicMean;
    private javax.swing.JMenuItem jMeItHistogramE;
    private javax.swing.JMenuItem jMeItLaplacian;
    private javax.swing.JMenuItem jMeItLogarithmic;
    private javax.swing.JMenuItem jMeItMaxFilter;
    private javax.swing.JMenuItem jMeItMedian;
    private javax.swing.JMenuItem jMeItMinFilter;
    private javax.swing.JMenuItem jMeItNegative;
    private javax.swing.JMenuItem jMeItPower;
    private javax.swing.JMenuItem jMeItSetting;
    private javax.swing.JMenuItem jMeItSobelOpertor;
    private javax.swing.JMenuItem jMeItThresholding;
    private javax.swing.JMenuItem jMeItVarientLaplacian;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

}