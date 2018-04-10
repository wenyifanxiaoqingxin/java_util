package Demo.Test.Excl;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;

public class ExclTest {

    public static void main(String[] args) throws IOException, WriteException {

        CreateExcl createExcl = new CreateExcl();
        createExcl.CreatExcl();
    }



}
