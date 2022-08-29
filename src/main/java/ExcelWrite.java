import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;


public class ExcelWrite {
    public static void main(String[] args){
        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet sheet = workbook.createSheet("Employee Details");

        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[]{ "ID", "Name", "City" });
        data.put("2", new Object[]{ 1, "John", "New York" });
        data.put("3", new Object[]{ 2, "David", "New Jersey" });
        data.put("4", new Object[]{ 3, "Michael", "Chicago" });
        data.put("5", new Object[]{ 4, "Andy", "Phoenix" });
        Set<String> keySet = data.keySet();
        int rowNum = 0;
        for(String key : keySet){
            Row row = sheet.createRow(rowNum++);
            Object[] objArr = data.get(key);
            int cellNum = 0;
            for (Object obj : objArr){
                Cell cell = row.createCell(cellNum++);
                if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if (obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }

        try{
            FileOutputStream out = new FileOutputStream(new File("kentang.xlsx"));
            workbook.write(out);
            out.close();
            workbook.close();
            System.out.println("File Written successfully on disk");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
