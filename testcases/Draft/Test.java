package Draft;

import utilities.ExcelConfig;

public class Test {
    public static void main(String[] args) {
        ExcelConfig excelConfig = ExcelConfig.getExcelData();
        excelConfig.switchToSheet("employeeDataExcel");

        String firstName = excelConfig.getCellData("FirstName", 1);
        String lastName = excelConfig.getCellData("LastName", 1);

        System.out.println(lastName);
        System.out.println(firstName);
    }
}
