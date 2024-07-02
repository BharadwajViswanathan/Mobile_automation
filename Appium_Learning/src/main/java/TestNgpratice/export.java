//package TestNgpratice;
//
//import org.apache.poi.ss.usermodel.Workbook;
//
//public class export {
//public static void main(String[] args) {
//	
//
//	Workbook workbook = new Workbook();
//
//	// Obtaining the reference of the worksheet
//	Worksheet worksheet = workbook.getNumberOfSheets().get(0);
//
//	// Creating an array containing names as string values
//	String[] names = new String[] { "Laurence Chen", "Roman Korchagin", "Kyle Huang" };
//
//	// Exporting the array of names to first row and first column vertically
//	worksheet.getCells().importArray(names, 0, 0, true);
//
//	// Saving the Excel file
//	workbook.save("C:\\Files\\output.xlsx");
//}
//}
