/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IEFile;

import javax.swing.JFileChooser;

/**
 *
 * @author FPTDNSB
 */
public class IESaveChooser extends JFileChooser {

    public IESaveChooser() {
        this.setFileSelectionMode(DIRECTORIES_ONLY);
    }
}
