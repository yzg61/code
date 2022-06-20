package com.yzg.test;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelPicUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.word.WordUtil;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Test {

    public static void main(String[] args) {

        File file = new File("D:\\IdeaProjects\\code\\5.教材改编题的匹配表--周茜4.13（截图文件）(1).xlsx");

        ExcelReader reader = ExcelUtil.getReader(file);
        XSSFWorkbook workbook = (XSSFWorkbook) reader.getWorkbook();

        int sheets = workbook.getNumberOfSheets();

        final XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFDrawing drawing;
        for (POIXMLDocumentPart dr : sheet.getRelations()) {
            if (dr instanceof XSSFDrawing) {
                drawing = (XSSFDrawing) dr;
                final List<XSSFShape> shapes = drawing.getShapes();
                XSSFPicture pic;
                CTMarker ctMarker;
                for (XSSFShape shape : shapes) {
                    pic = (XSSFPicture) shape;
                    ctMarker = pic.getPreferredSize().getFrom();

                    String location = StrUtil.format("{}_{}", ctMarker.getRow(), ctMarker.getCol());
                }
            }
        }


    }
}
