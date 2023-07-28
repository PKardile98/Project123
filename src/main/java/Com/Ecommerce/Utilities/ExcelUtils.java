package Com.Ecommerce.Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static FileInputStream Fi;
	public static XSSFWorkbook Wb;
	public static XSSFSheet XS_sheet;
	public static XSSFRow X_row;
	public static XSSFCell X_cell;

	public static int GetRowcount(String Xfile, String Xsheet) throws IOException { // To find out the row count

		Fi = new FileInputStream(Xfile);
		Wb = new XSSFWorkbook(Fi);
		XS_sheet = Wb.getSheet(Xsheet);
		int Row_count = XS_sheet.getLastRowNum();
		Wb.close();
		Fi.close();

		return Row_count;

	}

	public static int GetCellcount(String Xfile, String Xsheet, int rownum) throws IOException { // To find out the
																									// column count

		Fi = new FileInputStream(Xfile);
		Wb = new XSSFWorkbook(Fi);
		XS_sheet = Wb.getSheet(Xsheet);
		X_row = XS_sheet.getRow(rownum);
		int Cell_count = X_row.getLastCellNum(); // With row we count the cell no.
		Wb.close();
		Fi.close();

		return Cell_count;

	}

	public static String GetCelldata(String Xfile, String Xsheet, int rownum, int colnum) throws IOException {
		Fi = new FileInputStream(Xfile);
		Wb = new XSSFWorkbook(Fi);
		XS_sheet = Wb.getSheet(Xsheet);
		X_row = XS_sheet.getRow(rownum);
		X_cell = X_row.getCell(colnum);

		String data;

		try {
			DataFormatter Formatter = new DataFormatter();

			String Celldata = Formatter.formatCellValue(X_cell);

			return Celldata;
		} catch (Exception e) {
			data = "";
		}

		Wb.close();
		Fi.close();

		return data;

	}

}
