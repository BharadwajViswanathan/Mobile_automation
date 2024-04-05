package andoird.com.Learning;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.testng.annotations.Test;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Capcha {

	
	@Test(enabled =false)
	private static void cap() throws TesseractException {
		Tesseract data=new  Tesseract();
		data.setDatapath("D:\\Tess4J\\tessdata");
		String str = data.doOCR(new File("C:\\Users\\bharadwaj.viswanatha\\git\\mobileautomationlearning\\Appium_Learning\\src\\main\\resources\\image1.jpeg"));
	System.out.println("Done");
		System.out.println(str+" text");
	}
	

	    public static void main() {
	        File imageFile = new File("C:\\Users\\bharadwaj.viswanatha\\git\\mobileautomationlearning\\Appium_Learning\\src\\main\\resources\\image1.jpg"); // Change path to your image file

	        ITesseract tess = new Tesseract();
	        tess.setDatapath("D:\\\\Tess4J\\\\tessdata"); // Change path to the tessdata directory
	        tess.setLanguage("eng"); // Set the language (English in this example)

	        try {
	            String extractedText = tess.doOCR(imageFile);
	            System.out.println("Extracted Text:");
	            System.out.println(extractedText);
	        } catch (TesseractException e) {
	            System.err.println(e.getMessage());
	        }
	    }
	    
	    static final int DELTA = 3;

	    public static boolean isEligible(BufferedImage img, int x, int y){

	        int left  = x-1;
	        while (  left < 0 &&  x -left < 2* DELTA) {
	            if( img.getRGB(left,y) == Color.WHITE.getRGB()) {
	                break;
	            }
	            left --;
	        }
	        if( left < 0) {
	            return false;
	        }
	        int right = x + 1;

	        while ( right < img.getWidth() && right - left < 2 * DELTA) {
	            if( img.getRGB(right,y) == Color.WHITE.getRGB()) {
	                break;
	            }
	            right++;
	        }
	        if( right > img.getWidth()) {
	            return false;
	        }
	        int top = y -1;
	        while (top >0 && y - top < 2 * DELTA) {
	            if( img.getRGB(x,top) == Color.WHITE.getRGB()) {
	                break;
	            }
	            top --;
	        }
	        if( top < 0) {
	            return false;
	        }
	        int bottom = y+1;
	        while (bottom < img.getHeight() && bottom -top < 2* DELTA) {
	            if( img.getRGB( x,bottom) == Color.WHITE.getRGB()) {
	                break;
	            }
	            bottom++;
	        }
	        if( bottom > img.getHeight()) {
	            return false;
	        }


	        int width = right -left;
	        int height =  bottom - top;
	        if( width >= DELTA && height >= DELTA) {
	            return true;
	        }
	        return false;

	    }

	    public static BufferedImage cleanImage(BufferedImage source){
	        BufferedImage clone = new BufferedImage(source.getWidth(),
	                source.getHeight(), source.getType());
	        Graphics2D g2d = clone.createGraphics();
	        g2d.drawImage(source, 0, 0, null);
	        g2d.dispose();
	        for(int i=0;i<clone.getWidth();i++){
	            for(int j=0;j<clone.getHeight();j++){
	                int rgb = clone.getRGB(i,j);
	                if( rgb == Color.WHITE.getRGB()){
	                    continue;
	                }
	                if( isEligible(clone, i,j)) {
	                    continue;
	                }
	                else {
	                    clone.setRGB(i,j,Color.WHITE.getRGB());
	                }

	            }
	        }

	        return clone;

	    }
	    
	    public static void main(String[] args) throws IOException, TesseractException {
	    BufferedImage image = ImageIO.read( new File("C:\\Users\\bharadwaj.viswanatha\\git\\mobileautomationlearning\\Appium_Learning\\src\\main\\resources\\image1.jpeg"));
	    BufferedImage clean = cleanImage(image);
	    ImageIO.write(clean, "png",new File("sample/clean.png"));
	    Tesseract tesseract = new Tesseract();
	    tesseract.setDatapath("D:\\Tess4J\\tessdata");
	    String result = tesseract.doOCR( clean);
	    }
	    
	    public static String cleanResult(String result){
	        StringBuilder sb = new StringBuilder();
	        for(int i =0;i<result.length();i++){
	            if( Character.isAlphabetic( result.charAt(i)) || Character.isDigit( result.charAt(i))) {
	                sb.append( result.charAt(i));
	            }
	        }
	        return sb.toString();
	    }
	}


