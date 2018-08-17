/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package version2;

import java.awt.Color;
import static java.lang.Math.round;

/**
 *
 * @author FPTDNSB
 */
public class RBGHolder {

    public int alpha;
    public int r;
    public int b;
    public int g;
    public int grayLevel;

    public RBGHolder(Color _rgb) {
        this.alpha = _rgb.getAlpha();
        this.r = _rgb.getRed();
        this.g = _rgb.getGreen();
        this.b = _rgb.getBlue();
        this.grayLevel =(int) round((r * 0.299 + g * 0.587 + b * 0.114));
    }

}
