/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IEFile;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author FPTDNSB
 */
public class IEFileChooser extends JFileChooser {

    public IEFileChooser() {
        this.addChoosableFileFilter(new ImageFilter());     
    }
    public boolean acceptImageOnly(File f) {
        if (f.isDirectory()) {
            return true;
        }
        String extension = Utils.getExtension(f);
        if (extension != null) {
            if (extension.equals(Utils.jpeg)
                    || extension.equals(Utils.jpg)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

}
