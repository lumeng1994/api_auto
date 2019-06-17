package utils;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;
import pojo.Case;
import pojo.WriteToExcel;

import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtil {
    public static Map<String,Integer> caseIdGetRow = new HashMap<String, Integer>();
    public static Map<String,Integer> nameGetCell = new HashMap<String, Integer>();
    public  static List<WriteToExcel> writeToSave = new ArrayList<WriteToExcel>();
    public static <T> List<T>  readExcel(Class<T> clazz, int index){
        File file = new File("src\\main\\resources\\excelConfig\\cases_v8.xlsx");
        List list = new ArrayList();
        try {
            InputStream is = new FileInputStream(file);
            Workbook workbook = WorkbookFactory.create(is);
            Sheet sheet = workbook.getSheetAt(index);
            int rowNum = sheet.getLastRowNum();
            int cellum = sheet.getRow(0).getLastCellNum();
            for(int i = 1; i <= rowNum; i++){
                Row row = sheet.getRow(i);
                Object obj = clazz.newInstance();
                for (int j = 0; j < cellum;j++){
                    if(row == null){
                        continue;
                    }
                    Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    cell.setCellType(CellType.STRING);
                    String value = cell.getStringCellValue();
                    Map<Integer,Object> map = indexGetName(sheet);
                    String methodName = "set"+ map.get(j);
                    Method method = clazz.getMethod(methodName,String.class);
                    method.invoke(obj,value);

                    if(j==0){
                        caseIdGetRow.put(value,i);
                    }
                }
                list.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Map<Integer,Object> indexGetName(Sheet sheet){
        int cellNum = sheet.getRow(0).getLastCellNum();
        Map<Integer,Object> map = new HashMap<Integer, Object>();
        for(int i = 0; i < cellNum; i++){
            Cell cell = sheet.getRow(0).getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            cell.setCellType(CellType.STRING);
            String value = cell.getStringCellValue();
            String values = value.substring(0,value.lastIndexOf("("));
            map.put(i,values);
            nameGetCell.put(values,i);
        }
        return map;
    }

    public static void excAllWrite() {
        File file = new File("src\\main\\resources\\excelConfig\\cases_v8.xlsx");
        InputStream is = null;
        OutputStream os = null;
        List<WriteToExcel> lists = writeToSave;
        try {
            is = new FileInputStream(file);
            Workbook workbook = WorkbookFactory.create(is);
        for(WriteToExcel writeToExcel:lists){
          String caseId = writeToExcel.getCaseId();
          String cellName = writeToExcel.getCellName();
          String content = writeToExcel.getValiResult();
            Sheet sheet = workbook.getSheetAt(1);
            int RowNum = ExcelUtil.caseIdGetRow.get(caseId);
            Row row = sheet.getRow(RowNum);
            int cellNum = ExcelUtil.nameGetCell.get(cellName);
            Cell cell = row.getCell(cellNum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            cell.setCellType(CellType.STRING);
            cell.setCellValue(content);
        }
        os = new FileOutputStream(file);
        workbook.write(os);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void saveAllWrite(String caseId,String cellName,String content){
        WriteToExcel writeToExcel = new WriteToExcel(caseId,cellName,content);
        writeToSave.add(writeToExcel);
    }

//    @Test
//    public void test(){
//        List<Case> lists = readExcel(Case.class,1);
//        for (Case api:lists){
//            System.out.println(api.toString());
//        }
//    }
}
