import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;


public class DataProviderMain {
    DataFormatter formatter = new DataFormatter();
    @Test(dataProvider="driveTest")
    public void testCaseData(String tenant, String email, String password){
        System.out.println("Tenant is: "+tenant +" username: "+email +" password: "+password);
    }
     @DataProvider(name= "driveTest" )
    public Object[][] getData() throws IOException {
//        Object[][] data= {{"soundcore","q1@soundcore.com","q1"},{"soundcore","d1@soundcore.com","d1"},{"soundcore","bhupendra@soundcore.com","bhupendra"}};
//        return data;
         FileInputStream fileLocation= new FileInputStream("C:\\Users\\bhupe\\Downloads\\developLogin.xlsx");
         XSSFWorkbook workBook = new XSSFWorkbook(fileLocation);
         //select first sheet
        XSSFSheet sheet= workBook.getSheetAt(0);
        //get total number of rows
        int rows=sheet.getPhysicalNumberOfRows();
       //get first row
        XSSFRow row= sheet.getRow(0);
        //get total column count for row
        int columnCount=row.getLastCellNum();
        //allocating memory for arraylist
        Object data [][]= new Object[rows-1][columnCount];
        for(int i=0;i<rows-1;i++){
            //get first first row
            row = sheet.getRow(i+1);
            for (int j=0;j<columnCount;j++){
               XSSFCell cell= row.getCell(j);
                data [i][j]=formatter.formatCellValue(cell);
            }
        }
        return data;
     }
}
