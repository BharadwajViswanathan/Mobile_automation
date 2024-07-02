package wordreader;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class Wordcopypaste {
	    public static void main(String[] args) {
	  
	        String sourceFilePath = "source.docx";
	        String destinationFilePath = "destination.docx";
	        copyText(sourceFilePath, destinationFilePath);
	    }

	    public static void copyText(String sourceFilePath, String destinationFilePath) {
	        try {
	     
	            FileInputStream fis = new FileInputStream(sourceFilePath);
	            XWPFDocument sourceDoc = new XWPFDocument(fis);

	            // Create a new document for pasting
	            XWPFDocument destinationDoc = new XWPFDocument();

	            // Iterate through paragraphs in source document
	            for (XWPFParagraph paragraph : sourceDoc.getParagraphs()) {
	                // Get text from source paragraph
	                String text = paragraph.getText();
	                
	                // Create a new paragraph in destination document
	                XWPFParagraph newParagraph = destinationDoc.createParagraph();
	                // Set text in new paragraph
	                newParagraph.createRun().setText(text);
	            }

	            // Write the destination document to file
	            FileOutputStream fos = new FileOutputStream(destinationFilePath);
	            destinationDoc.write(fos);

	            // Close streams
	            fis.close();
	            fos.close();

	            System.out.println("Text copied from '" + sourceFilePath + "' to '" + destinationFilePath + "' successfully.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}