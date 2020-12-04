package com.alex.controller;

import com.alex.utils.AlexExcelUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/alex")
public class AlexExcelController {

    public static final String sheet1name = "月统计数据";

    public static final String sheet2name = "月统计数据图";

    @RequestMapping("/outexcel")
    public Map<String,Object> outexcel(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException {
        Map<String,Object> map = new HashMap<>();
        //sheet名称
        String sheetname = AlexExcelUtils.getmonth() + sheet1name;
        // table标题
        String tabtitle = "李家岩水库水情监测" + AlexExcelUtils.getyearandmonth() + "月报";
        String loadname = "李家岩水库水情监测" + AlexExcelUtils.getmonth() + "月月报【四川恒宣】.xlsx";
        String excelmodelname = "alexmodel.xlsx";
        FileInputStream elin = new FileInputStream(new File(excelmodelname));
        Workbook wbook = null;
        try {
            //因为是xlsx后缀所以用XSSF
            wbook = new XSSFWorkbook(elin);
            //读取sheet0中的内容
            Sheet sheet = wbook.getSheetAt(0);
            //在相应的表格内插入数据


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return map;
    }

}



