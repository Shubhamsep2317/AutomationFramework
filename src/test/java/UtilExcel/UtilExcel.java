package UtilExcel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class UtilExcel {

    static Workbook workbook;
    static Sheet sheet;

    public static String SHEET_Path=System.getProperty("user.dir")+"/"+"src/main/Resources/Invalid_Login_Data_1.xlsx";

    public static Object[][] getExcelDataUtil(String sheetname){

        FileInputStream fileInputStream=null;

        try {
            fileInputStream=new FileInputStream(SHEET_Path);
            workbook= WorkbookFactory.create(fileInputStream);
            sheet=workbook.getSheet(sheetname);
        } catch (IOException e) {
            System.out.println("File not Found");
        }
         Object[][]data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for(int i=0;i<sheet.getLastRowNum();i++){
            for(int j=0;j<sheet.getRow(0).getLastCellNum();j++){
                data[i][j]=sheet.getRow(i+1).getCell(j).toString();
            }
        }
        return data;
    }

}
