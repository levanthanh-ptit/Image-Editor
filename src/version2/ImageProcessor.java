/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package version2;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.Math.pow;
import static java.lang.Math.round;

import javax.imageio.ImageIO;
import static version2.ImageProcessor.IMAGE_TYPE.*;

public class ImageProcessor {

    public enum IMAGE_TYPE {
        SOURCE, BORDERED
    };
    public BufferedImage bufferSource;
    public BufferedImage bufferedOutput;
    public BufferedImage bufferBordered;
    public int[][] imgArr;
    public int[][] imgArrBordered;
    public int width;
    public int height;
    public int widthBorder;
    public int heightBorder;
    public String filePath_input;
    public double powerLevel;
    public int thresholdLevel;
    public File input_File;
    public File process_File;

    public enum TYPE_BORDER {
        WHITE, DUPLICATE, BLACK
    };

    public ImageProcessor(int _thresholdLevel, double _powerLevel) {
        this.powerLevel = _powerLevel;
        this.thresholdLevel = _thresholdLevel;
    }

    public void writeImage(String _filePath_output) {
        File outputImage = new File(_filePath_output);
        try {
            ImageIO.write(bufferedOutput, "jpg", outputImage);
        } catch (IOException e) {
        }
        System.out.println(_filePath_output);
    }

    public void readImage(File _file) {
        input_File = new File(_file.getPath());
        BufferedImage buffer;
        try {
            buffer = ImageIO.read(input_File);
            BufferedImage b = addBorder(buffer, TYPE_BORDER.DUPLICATE);
            bufferBordered = coverToGray(b, BORDERED);
            bufferSource = coverToGray(buffer, SOURCE);
            bufferedOutput = coverToGray(buffer, null);
        } catch (IOException e) {
        }
        width = bufferSource.getWidth();
        height = bufferSource.getHeight();
        filePath_input = _file.getPath();

    }

    public BufferedImage addBorder(BufferedImage buffer, TYPE_BORDER type_border) {
        BufferedImage retValue;
        widthBorder = buffer.getWidth() + 2;
        heightBorder = buffer.getHeight() + 2;
        int[][] imgArrB = new int[heightBorder][widthBorder];
        for (int i = 1; i < heightBorder - 1; i++) {
            for (int j = 1; j < widthBorder - 1; j++) {
                RBGHolder h = new RBGHolder(new Color(buffer.getRGB(j - 1, i - 1)));
                imgArrB[i][j] = h.grayLevel;
            }
        }
        if (null != type_border) {
            switch (type_border) {
                case WHITE:
                    for (int i = 0; i < widthBorder; i++) {
                        imgArrB[0][i] = 255;
                        imgArrB[heightBorder - 1][i] = 255;
                    }
                    for (int i = 1; i < heightBorder - 1; i++) {
                        imgArrB[i][0] = 255;
                        imgArrB[i][widthBorder - 1] = 255;
                    }
                    break;
                case BLACK:
                    for (int i = 0; i < widthBorder; i++) {
                        imgArrB[0][i] = 0;
                        imgArrB[heightBorder - 1][i] = 0;
                    }
                    for (int i = 1; i < heightBorder - 1; i++) {
                        imgArrB[i][0] = 0;
                        imgArrB[i][widthBorder - 1] = 0;
                    }
                    break;
                case DUPLICATE:
                    for (int i = 1; i < heightBorder - 1; i++) {
                        imgArrB[i][0] = imgArrB[i][1];
                        imgArrB[i][widthBorder - 1] = imgArrB[i][widthBorder - 2];
                    }
                    for (int i = 0; i < widthBorder; i++) {
                        imgArrB[0][i] = imgArrB[1][i];
                        imgArrB[heightBorder - 1][i] = imgArrB[heightBorder - 2][i];
                    }
                    break;
                default:
                    break;
            }
        }
        retValue = new BufferedImage(widthBorder, heightBorder, buffer.getType());

        for (int y = 0; y < heightBorder; y++) {
            for (int x = 0; x < widthBorder; x++) {
                int g = imgArrB[y][x];
                Color c = new Color(g, g, g);
                retValue.setRGB(x, y, c.getRGB());
            }
        }
        return retValue;
    }

    public BufferedImage coverToGray(BufferedImage buffer, IMAGE_TYPE image_type) {
        BufferedImage retValue;
        int widthB = buffer.getWidth();
        int heightB = buffer.getHeight();
        int[][] imgArrB = new int[heightB][widthB];
        if (null == image_type) {
            for (int i = 0; i < heightB; i++) {
                for (int j = 0; j < widthB; j++) {
                    RBGHolder h = new RBGHolder(new Color(buffer.getRGB(j, i)));
                    imgArrB[i][j] = h.grayLevel;
                }
            }
        } else {
            switch (image_type) {
                case SOURCE:
                    this.imgArr = new int[heightB][widthB];
                    for (int i = 0; i < heightB; i++) {
                        for (int j = 0; j < widthB; j++) {
                            RBGHolder h = new RBGHolder(new Color(buffer.getRGB(j, i)));
                            imgArrB[i][j] = h.grayLevel;
                            imgArr[i][j] = h.grayLevel;
                        }
                    }
                    break;
                case BORDERED:
                    this.imgArrBordered = new int[heightB][widthB];
                    for (int i = 0; i < heightB; i++) {
                        for (int j = 0; j < widthB; j++) {
                            RBGHolder h = new RBGHolder(new Color(buffer.getRGB(j, i)));
                            imgArrB[i][j] = h.grayLevel;
                            imgArrBordered[i][j] = h.grayLevel;
                        }
                    }
                    break;
                default:
                    for (int i = 0; i < heightB; i++) {
                        for (int j = 0; j < widthB; j++) {
                            RBGHolder h = new RBGHolder(new Color(buffer.getRGB(j, i)));
                            imgArrB[i][j] = h.grayLevel;
                        }
                    }
                    break;
            }
        }
        retValue = new BufferedImage(widthB, heightB, buffer.getType());
        for (int y = 0; y < heightB; y++) {
            for (int x = 0; x < widthB; x++) {
                int g = imgArrB[y][x];

                Color c = new Color(g, g, g);
                retValue.setRGB(x, y, c.getRGB());
            }
        }
        return retValue;
    }

    public void filterLaplacian() {
        int[][] imgArrOutput = new int[heightBorder][widthBorder];
        for (int y = 1; y < heightBorder - 1; y++) {
            for (int x = 1; x < widthBorder - 1; x++) {
                int val = 5 * imgArrBordered[y][x]
                        - imgArrBordered[y - 1][x]
                        - imgArrBordered[y + 1][x]
                        - imgArrBordered[y][x - 1]
                        - imgArrBordered[y][x + 1];
                if (val < 0) {
                    val = 0;
                }
                if (val > 255) {
                    val = 255;
                }
                imgArrOutput[y][x] = val;
            }
        }
        bufferedOutput = new BufferedImage(width, height, bufferBordered.getType());
        for (int y = 1; y < heightBorder - 1; y++) {
            for (int x = 1; x < widthBorder - 1; x++) {
                int g = imgArrOutput[y][x];
                Color c = new Color(g, g, g);
                bufferedOutput.setRGB(x - 1, y - 1, c.getRGB());
            }
        }
    }

    public void filterVariantLaplacian() {
        int[][] imgArrOutput = new int[heightBorder][widthBorder];
        for (int y = 1; y < heightBorder - 1; y++) {
            for (int x = 1; x < widthBorder - 1; x++) {
                int val = 9 * imgArrBordered[y][x]
                        - imgArrBordered[y - 1][x]
                        - imgArrBordered[y + 1][x]
                        - imgArrBordered[y][x - 1]
                        - imgArrBordered[y][x + 1]
                        - imgArrBordered[y - 1][x - 1]
                        - imgArrBordered[y - 1][x + 1]
                        - imgArrBordered[y + 1][x - 1]
                        - imgArrBordered[y + 1][x + 1];
                if (val < 0) {
                    val = 0;
                }
                if (val > 255) {
                    val = 255;
                }
                imgArrOutput[y][x] = val;
            }
        }
        bufferedOutput = new BufferedImage(width, height, bufferBordered.getType());
        for (int y = 1; y < heightBorder - 1; y++) {
            for (int x = 1; x < widthBorder - 1; x++) {
                int g = imgArrOutput[y][x];
                Color c = new Color(g, g, g);
                bufferedOutput.setRGB(x - 1, y - 1, c.getRGB());
            }
        }
    }

    public void balanceHistogram() {
        int[] histogramArray = new int[256];
        for (int i = 0; i < 256; i++) {
            histogramArray[i] = 0;
        }
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                histogramArray[imgArr[y][x]]++;
            }
        }
        int histogramHeight = histogramArray[0];
        for (int i = 1; i < 256; i++) {
            if (histogramArray[i] > histogramHeight) {
                histogramHeight = histogramArray[i];
            }
        }
        int[] sumOfHist = new int[256];
        sumOfHist[0] = histogramArray[0];
        for (int i = 1; i < 256; i++) {
            sumOfHist[i] = sumOfHist[i - 1] + histogramArray[i];
        }
        //create 2D array of output pixels
        int[][] imgArrOutput = new int[height][width];
        int area = height * width;
        int dm = 255;
        int k;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                k = imgArr[y][x];
                imgArrOutput[y][x] = dm * sumOfHist[k] / area;
            }
        }
        bufferedOutput = new BufferedImage(width, height, bufferSource.getType());
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int g = imgArrOutput[y][x];
                Color c = new Color(g, g, g);
                bufferedOutput.setRGB(x, y, c.getRGB());
            }
        }
    }

    public void negative() {
        int[][] imgArrOutput = new int[height][width];
        int dm = 255;
        int k;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                k = imgArr[y][x];
                imgArrOutput[y][x] = dm - k;
            }
        }
        bufferedOutput = new BufferedImage(width, height, bufferSource.getType());
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int g = imgArrOutput[y][x];
                Color c = new Color(g, g, g, 0);
                bufferedOutput.setRGB(x, y, c.getRGB());
            }
        }
    }

    public void thresholding(int threshold) {
        int[][] imgArrOutput = new int[height][width];
        int dm = 255;
        int k;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                k = imgArr[y][x];
                if (k <= threshold) {
                    imgArrOutput[y][x] = 0;
                } else {
                    imgArrOutput[y][x] = dm;
                }
            }
        }
        bufferedOutput = new BufferedImage(width, height, bufferSource.getType());
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int g = imgArrOutput[y][x];
                Color c = new Color(g, g, g, 0);
                bufferedOutput.setRGB(x, y, c.getRGB());
            }
        }
    }

    public void logarithmic() {
        int[][] imgArrOutput = new int[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                double k = imgArr[y][x];
                double val = Math.log(k / 255 + 1) * 255;
                imgArrOutput[y][x] = (int) val;
            }
        }
        //prepare everything to write output image
        bufferedOutput = new BufferedImage(width, height, bufferSource.getType());

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int g = imgArrOutput[y][x];
                Color c = new Color(g, g, g, 0);
                bufferedOutput.setRGB(x, y, c.getRGB());
            }
        }
    }

    public void power(double power) {
        int[][] imgArrOutput = new int[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                double k = imgArr[y][x];
                double val = pow(k / 255, power) * 255;
                if (val > 255) {
                    val = 255;
                }
                imgArrOutput[y][x] = (int) round(val);
            }
        }
        //prepare everything to write output image
        bufferedOutput = new BufferedImage(width, height, bufferSource.getType());
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int g = imgArrOutput[y][x];
                Color c = new Color(g, g, g, 0);
                bufferedOutput.setRGB(x, y, c.getRGB());
            }
        }

    }

    public void averageFilter() {
        int[][] imgArrOutput = new int[heightBorder][widthBorder];
        for (int y = 1; y < heightBorder - 1; y++) {
            for (int x = 1; x < widthBorder - 1; x++) {
                int sum = 0;
                for (int i = y - 1; i < y + 2; i++) {
                    for (int j = x - 1; j < x + 2; j++) {
                        sum += imgArrBordered[i][j];
                    }
                }
                imgArrOutput[y][x] = round(sum / 9);
            }
        }
        bufferedOutput = new BufferedImage(width, height, bufferBordered.getType());
        for (int y = 1; y < heightBorder - 1; y++) {
            for (int x = 1; x < widthBorder - 1; x++) {
                int g = imgArrOutput[y][x];
                Color c = new Color(g, g, g);
                bufferedOutput.setRGB(x - 1, y - 1, c.getRGB());
            }
        }
    }

    public void sobelOperator() {
        int[][] imgArrOutput = new int[heightBorder][widthBorder];
        for (int y = 1; y < heightBorder - 1; y++) {
            for (int x = 1; x < widthBorder - 1; x++) {
                int val =
                        - 2 * imgArrBordered[y - 1][x - 1]
                        - 2 * imgArrBordered[y - 1][x]
                        - 2 * imgArrBordered[y][x - 1]
                        + 2 * imgArrBordered[y][x + 1]
                        + 2 * imgArrBordered[y + 1][x]
                        + 2 * imgArrBordered[y + 1][x + 1];
                if(val<0) val =0;
                if(val>255) val = 255;
                imgArrOutput[y][x] = val;
            }
        }
        bufferedOutput = new BufferedImage(width, height, bufferBordered.getType());
        for (int y = 1; y < heightBorder - 1; y++) {
            for (int x = 1; x < widthBorder - 1; x++) {
                int g = imgArrOutput[y][x];
                Color c = new Color(g, g, g);
                bufferedOutput.setRGB(x - 1, y - 1, c.getRGB());
            }
        }
    }

    public void geometricMean() {
        int[][] imgArrOutput = new int[heightBorder][widthBorder];
        for (int y = 1; y < heightBorder - 1; y++) {
            for (int x = 1; x < widthBorder - 1; x++) {
                double sum = 1;
                for (int i = y - 1; i < y + 2; i++) {
                    for (int j = x - 1; j < x + 2; j++) {
                        sum *= pow(imgArrBordered[i][j], (double) 1 / 9);
                    }
                }
                imgArrOutput[y][x] = (int) round(sum);
            }
        }
        bufferedOutput = new BufferedImage(width, height, bufferBordered.getType());
        for (int y = 1; y < heightBorder - 1; y++) {
            for (int x = 1; x < widthBorder - 1; x++) {
                int g = imgArrOutput[y][x];
                Color c = new Color(g, g, g);
                bufferedOutput.setRGB(x - 1, y - 1, c.getRGB());
            }
        }
    }

    public void hamonicMean() {
        int[][] imgArrOutput = new int[heightBorder][widthBorder];
        for (int y = 1; y < heightBorder - 1; y++) {
            for (int x = 1; x < widthBorder - 1; x++) {
                double sum = 0;
                for (int i = y - 1; i < y + 2; i++) {
                    for (int j = x - 1; j < x + 2; j++) {
                        sum += 1 / (double) imgArrBordered[y][x];
                    }
                }
                imgArrOutput[y][x] = (int) round(9 / sum);
            }
        }
        bufferedOutput = new BufferedImage(width, height, bufferBordered.getType());
        for (int y = 1; y < heightBorder - 1; y++) {
            for (int x = 1; x < widthBorder - 1; x++) {
                int g = imgArrOutput[y][x];
                Color c = new Color(g, g, g);
                bufferedOutput.setRGB(x - 1, y - 1, c.getRGB());
            }
        }
    }

    public void medianFilter() {
        int[][] imgArrOutput = new int[heightBorder][widthBorder];
        for (int y = 1; y < heightBorder - 1; y++) {
            for (int x = 1; x < widthBorder - 1; x++) {
                SortedArray medArr = new SortedArray(9);
                for (int i = y - 1; i < y + 2; i++) {
                    for (int j = x - 1; j < x + 2; j++) {
                        medArr.add(imgArrBordered[i][j]);
                    }
                }
                imgArrOutput[y][x] = medArr.getMedian();
            }
        }
        bufferedOutput = new BufferedImage(width, height, bufferBordered.getType());
        for (int y = 1; y < heightBorder - 1; y++) {
            for (int x = 1; x < widthBorder - 1; x++) {
                int g = imgArrOutput[y][x];
                Color c = new Color(g, g, g);
                bufferedOutput.setRGB(x - 1, y - 1, c.getRGB());
            }
        }
    }

    public void minFilter() {
        int[][] imgArrOutput = new int[heightBorder][widthBorder];
        for (int y = 1; y < heightBorder - 1; y++) {
            for (int x = 1; x < widthBorder - 1; x++) {
                SortedArray medArr = new SortedArray(9);
                for (int i = y - 1; i < y + 2; i++) {
                    for (int j = x - 1; j < x + 2; j++) {
                        medArr.add(imgArrBordered[i][j]);
                    }
                }
                imgArrOutput[y][x] = medArr.getMin();
            }
        }
        bufferedOutput = new BufferedImage(width, height, bufferBordered.getType());
        for (int y = 1; y < heightBorder - 1; y++) {
            for (int x = 1; x < widthBorder - 1; x++) {
                int g = imgArrOutput[y][x];
                Color c = new Color(g, g, g);
                bufferedOutput.setRGB(x - 1, y - 1, c.getRGB());
            }
        }
    }

    public void maxFilter() {
        int[][] imgArrOutput = new int[heightBorder][widthBorder];
        for (int y = 1; y < heightBorder - 1; y++) {
            for (int x = 1; x < widthBorder - 1; x++) {
                SortedArray medArr = new SortedArray(9);
                for (int i = y - 1; i < y + 2; i++) {
                    for (int j = x - 1; j < x + 2; j++) {
                        medArr.add(imgArrBordered[i][j]);
                    }
                }
                imgArrOutput[y][x] = medArr.getMax();
            }
        }
        bufferedOutput = new BufferedImage(width, height, bufferBordered.getType());
        for (int y = 1; y < heightBorder - 1; y++) {
            for (int x = 1; x < widthBorder - 1; x++) {
                int g = imgArrOutput[y][x];
                Color c = new Color(g, g, g);
                bufferedOutput.setRGB(x - 1, y - 1, c.getRGB());
            }
        }
    }

    public void adaptiveMadianFilter(int maxSize) {
        int[][] imgArrOutput = new int[heightBorder][widthBorder];
        for (int y = 1; y < heightBorder - 1; y++) {
            for (int x = 1; x < widthBorder - 1; x++) {
                int dx = (x < widthBorder - x - 1 ? x : widthBorder - x - 1);
                int dy = (y < heightBorder - y - 1 ? y : heightBorder - y - 1);
                int maxWindowsSize = (int) pow((dx < dy ? dx : dy) * 2 + 1, 2);
                if (maxWindowsSize > maxSize * maxSize) {
                    maxWindowsSize = maxSize * maxSize;
                }
                int frameSize = 3;

                boolean fk = true;
                while (fk) {
                    SortedArray medArr = new SortedArray(frameSize * frameSize);
                    for (int i = y - frameSize / 2; i <= y + frameSize / 2; i++) {
                        for (int j = x - frameSize / 2; j <= x + frameSize / 2; j++) {
                            medArr.add(imgArrBordered[i][j]);
                        }
                    }
                    if (medArr.getMin() < medArr.getMedian() && medArr.getMedian() < medArr.getMax()) {
                        if (medArr.getMin() < imgArrBordered[y][x] && imgArrBordered[y][x] < medArr.getMax()) {
                            imgArrOutput[y][x] = imgArrBordered[y][x];
                            fk = false;
                        } else {
                            imgArrOutput[y][x] = medArr.getMedian();
                            fk = false;
                        }

                    } else {
                        frameSize += 2;
                        if ((frameSize * frameSize) > maxWindowsSize) {
                            imgArrOutput[y][x] = medArr.getMedian();
                            fk = false;
                        }
                    }
                }
            }
        }
        bufferedOutput = new BufferedImage(width, height, bufferBordered.getType());
        for (int y = 1; y < heightBorder - 1; y++) {
            for (int x = 1; x < widthBorder - 1; x++) {
                int g = imgArrOutput[y][x];
                Color c = new Color(g, g, g);
                bufferedOutput.setRGB(x - 1, y - 1, c.getRGB());
            }
        }
    }
//    public static void main(String[] args) {
//        ImageProcessor image = new ImageProcessor();
//        image.readImage("D://XULYANH//photo4.jpg");
//        image.balanceHistogram();
//        image.writeImage("D://XULYANH//photo4His.jpg");
//        image.negative();
//        image.writeImage("D://XULYANH//photo4Neg.jpg");
//        image.logarithm();
//        image.writeImage("D://XULYANH//photo4Log.jpg");
//        image.power(0.5);
//        image.writeImage("D://XULYANH//photo4Pow.jpg");
//        image.thresholding(80);
//        image.writeImage("D://XULYANH//photo4Thres.jpg");
//        image.filterLaplacian();
//        image.writeImage("D://XULYANH//photo4FilterLaplacian.jpg");
//        image.filterVariantLaplacian();
//        image.writeImage("D://XULYANH//photo4FilterVarientLaplacian.jpg");
//    }
}
