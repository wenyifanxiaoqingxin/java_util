package Demo.Test.Excl;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;

public class CreateExcl {


    //创建excl
    public void CreatExcl() throws IOException, WriteException {


        File exclFile = new File("/Users/crionline/Desktop/jxl1.xls");

        WritableWorkbook workbook = Workbook.createWorkbook(exclFile);
        WritableSheet sheet = workbook.createSheet("sheet1",0);


        sheet.addCell((new Label(0,0,"学校编号")));
        sheet.addCell((new Label(1,0,"学校名称")));
        sheet.addCell((new Label(2,0,"学校所在城市")));

        sheet.addCell((new Label(0,1,"10001")));
        sheet.addCell((new Label(1,1,"北京大学")));
        sheet.addCell((new Label(2,1,"北京市")));

        sheet.addCell((new Label(0,2,"10002")));
        sheet.addCell((new Label(1,2,"中国人民大学")));
        sheet.addCell((new Label(2,2,"北京市")));

        sheet.addCell((new Label(0,3,"10003")));
        sheet.addCell((new Label(1,3,"清华大学")));
        sheet.addCell((new Label(2,3,"北京市")));

        sheet.addCell((new Label(0,4,"10004")));
        sheet.addCell((new Label(1,4,"清华大学")));
        sheet.addCell((new Label(2,4,"北京市")));

        sheet.addCell((new Label(0,5,"10005")));
        sheet.addCell((new Label(1,5,"清华大学")));
        sheet.addCell((new Label(2,5,"北京市")));

        sheet.addCell((new Label(0,6,"10006")));
        sheet.addCell((new Label(1,6,"清华大学")));
        sheet.addCell((new Label(2,6,"北京市")));

        workbook.write();
        workbook.close();
    }

//    //读取excl
//    public void readExcl() throws IOException, BiffException {
//
//        File file = new File("/Users/crionline/Desktop/jxl.xls");
//
//        Workbook workbook =Workbook.getWorkbook(file);
//        Sheet[] sheets = workbook.getSheets();
//
//        if(sheets!=null){
//
//            for(Sheet sheet: sheets){
//                int rows = sheet.getRows();
//                int cols = sheet.getColumns();
//
//                for(int row=0;row<rows;row++){
//
//                    for(int col=0;col<cols;col++){
//
//                        System.out.printf("%10s",sheet.getCell(row,col).getContents());
//                    }
//
//                    System.out.println();
//                }
//            }
//        }
//    }
}
