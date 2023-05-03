import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DataDriven {
    public ArrayList<String> getExcelData(String environment) throws IOException {

        ArrayList <String> array = new ArrayList<String>();
        FileInputStream file = new FileInputStream("C:\\Users\\bhupe\\Downloads\\data.xlsx");
        //this will get access to the excel file
        XSSFWorkbook myWorkBook = new XSSFWorkbook (file);
        int sheetCount=myWorkBook.getNumberOfSheets();
        for(int  i=0; i<sheetCount;i++){
            if(myWorkBook.getSheetName(i).equalsIgnoreCase("LoginCredentials")){

                XSSFSheet sheet= myWorkBook.getSheetAt(i);
                //Identify Environment column by scanning entire row
                //sheet is collection of rows
                Iterator<Row> rows =sheet.iterator();

                //get the first row of the sheet
                Row firstrow= rows.next();
                //row is collection of cells
                Iterator <Cell> cel= firstrow.cellIterator();
                int k=0;
                int column = 0;
                while(cel.hasNext()){
                    Cell value=cel.next();
                    if(value.getStringCellValue().equalsIgnoreCase("Environment")){
                        column =k;

                    }
                    k ++;

                }
                System.out.println(column);
                while(rows.hasNext()){
                    Row r=   rows.next();
                    if(r.getCell(column).getStringCellValue().equalsIgnoreCase(environment)){
                        Iterator <Cell> cv=r.cellIterator();
                        while(cv.hasNext()){
                            Cell cell= cv.next();
                            String cellValue=cell.getStringCellValue();
                            array.add(cellValue);

                        }

                    }
                }

            }


        }
        return array;
    }
    public static void main(String[] args) throws IOException {

    }
}
