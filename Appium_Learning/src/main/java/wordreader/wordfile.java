package wordreader;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
public class wordfile {
	    public static void main(String[] args) {
	        // Write to Word file
	        writeToWord("output.docx");
	    }

	    public static void writeToWord(String filePath) {
	        try {
	            XWPFDocument docx = new XWPFDocument();

	            // Create a new paragraph
	            XWPFParagraph paragraph = docx.createParagraph();
	            XWPFRun run = paragraph.createRun();
	            run.setText("I completed .");

	            // Write the document to the specified file path
	            FileOutputStream fos = new FileOutputStream(filePath);
	            docx.write(fos);
	            fos.close();
	            
	            System.out.println("Word file created successfully at: " + filePath);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
