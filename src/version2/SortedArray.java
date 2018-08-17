/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package version2;

import static java.lang.Math.round;
import static java.util.Arrays.*;

/**
 *
 * @author FPTDNSB
 */
public class SortedArray {

    public int[] arr;
    public int num;

    public SortedArray(int _size) {
        arr = new int[_size];
        num = 0;
    }

    public void add(int x) {
        arr[num++] = x;
    }

    public int getMax() {
        sort(arr);
        return arr[num - 1];
    }

    public int getMin() {
        sort(arr,0,num-1);
        return arr[0];
    }

    public int getMedian() {
        sort(arr);
        return arr[num / 2 + 1];
    }
}
