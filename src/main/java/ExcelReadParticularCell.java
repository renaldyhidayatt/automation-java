import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReadParticularCell {

    public static void main(String[] args){
        ExcelReadParticularCell rc = new ExcelReadParticularCell();

        String value = null;
        Workbook wb = null;

        try{
            FileInputStream fis = new FileInputStream("kentang.xlsx");
            wb = new XSSFWorkbook(fis);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();;
        }
        Sheet sheet = wb.getSheetAt(1);
        Row row = sheet.getRow(3);
        Cell cell = row.getCell(2);

        System.out.println(cell);
    }
}
