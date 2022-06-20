package com.yzg.office.excel;

import cn.hutool.core.util.StrUtil;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STFldCharType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHighlightColor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Test2 {

    private static Map<String, Integer> seqMap = new HashMap<String, Integer>(){
        {
            put("①", 1);
            put("②", 2);
            put("③", 3);
            put("④", 4);
            put("⑤", 5);
            put("⑥", 6);
            put("⑦", 7);
            put("⑧", 8);
            put("⑨", 9);
            put("⑩", 10);
        }
    };
    public static void main(String[] args) throws IOException {
        InputStream is = null;
        is = new FileInputStream("D:\\IdeaProjects\\code\\com\\yzg\\office\\excel\\短文两篇——爱莲说.docx");

        XWPFDocument doc = new XWPFDocument(is);

        List<XWPFTable> tables = doc.getTables();
        for (XWPFTable table : tables) {
            List<XWPFTableRow> rows = table.getRows();
            Article article = new Article();
            for (int tableRowIndex = 1; tableRowIndex < rows.size(); tableRowIndex++) {
                XWPFTableRow tableRow = rows.get(tableRowIndex);
                List<XWPFTableCell> tableCells = tableRow.getTableCells();
                for (int cellIndex = 0; cellIndex < tableCells.size(); cellIndex++) {

                    XWPFTableCell cell = tableCells.get(cellIndex);
                    String cellText = cell.getText();
                    //文章段落节点
                    List<ArticlePara> articleParas;
                    if (cellIndex == 0) {
                        //原文
                        articleParas = article.getOriginalParas();
                    } else if (cellIndex == 1) {
                        //译文
                        articleParas = article.getTranslationParas();
                    } else {
                        continue;
                    }

                    List<XWPFParagraph> paragraphs = cell.getParagraphs();
                    //段落翻译点索引
                    int translationIndex = 0;
                    int paraIndex = 0;
                    for (XWPFParagraph para : paragraphs) {
                        //文章段落
                        String paraText = para.getText();
                        if (StrUtil.isBlank(paraText)) {
                            //跳过空段落
                            continue;
                        }
                        ArticlePara articlePara = new ArticlePara();

                        articlePara.setText(paraText);
                        articlePara.setParaIndex(paraIndex);

                        List<XWPFRun> runs = para.getRuns();
                        List<TextNode> nodes = articlePara.getTextNodes();
                        //域代码内容
                        StringBuilder fieldCodes = null;
                        //段落节点索引
                        int index = 0;
                        //行索引
                        int rowIndex = 0;
                        //上一个彩色段落节点的颜色
                        String preColor = null;

                        for (int runsIndex = 0; runsIndex < runs.size(); runsIndex++) {
                            XWPFRun run = runs.get(runsIndex);
                            String text = run.text();
                            if (text.length() == 1 && seqMap.containsKey(text)) {
                                //翻译点带圈序号
                                Integer seq = seqMap.get(text);
                                System.out.println("seq = "+ seq);
                                nodes.get(nodes.size() - 1).setNoteIndex(seq);
                                continue;
                            }

                            CTR ctr = run.getCTR();
                            List<CTText> instrTextList = ctr.getInstrTextList();
                            List<CTFldChar> fldCharList = ctr.getFldCharList();
                            for (CTFldChar ctFldChar : fldCharList) {
                                STFldCharType.Enum fldCharType = ctFldChar.getFldCharType();
                                if (STFldCharType.BEGIN == fldCharType) {
                                    //域代码开始
                                    fieldCodes = new StringBuilder();
                                }
                                if (STFldCharType.END == fldCharType) {
                                    //域代码结束
                                    if (fieldCodes != null) {
                                        String fldCode = fieldCodes.toString().trim();
                                        System.out.println("fldCode = " + fldCode);
                                        //EQ \o\ac(○,xxx)
                                        if (fldCode.startsWith("EQ \\o\\ac(") && fldCode.endsWith(")")) {
                                            //翻译点带圈数字
                                            Integer seq = Integer.valueOf(fldCode.substring(11, fldCode.length() - 1));
                                            System.out.println("seq = "+ seq);
                                            nodes.get(nodes.size() - 1).setNoteIndex(seq);
                                            continue;
                                        }
                                    }
                                }
                            }
                            for (CTText ctText : instrTextList) {
                                String stringValue = ctText.getStringValue();
                                if (fieldCodes != null) {
                                    //添加域代码
                                    fieldCodes.append(stringValue);
                                }
                            }

                            if (StrUtil.isNotBlank(text)) {
                                TextNode node = new TextNode();

                                node.setIndex(index++);
                                node.setParaIndex(paraIndex);
                                node.setText(run.text());
                                node.setItalic(run.isItalic());
                                node.setBold(run.isBold());
                                node.setVerticalAlignment(String.valueOf(run.getVerticalAlignment()));
                                node.setColor(run.getColor());
                                node.setFontFamily(run.getFontFamily());
                                node.setFontSize(run.getFontSize());
                                node.setStyle(run.getStyle());
                                node.setFontName(run.getFontName());
                                node.setUnderline(String.valueOf(run.getUnderline()));
                                node.setUnderlineColor(run.getUnderlineColor());
                                node.setTextHighlightColor(String.valueOf(STHighlightColor.Enum.forString(run.getTextHightlightColor().toString())));
                                //行号
                                node.setRowIndex(rowIndex);
                                if (UnderlinePatterns.NONE.toString().equals(node.getUnderline())) {
                                    //没有下划线，rowIndex + 1；
                                    rowIndex++;
                                }
                                if (!Objects.isNull(node.getColor())
                                        && !"000000".equals(node.getColor())
                                        && !"auto".equals(node.getColor())) {
                                    //彩色字体，翻译点
                                    if (node.getColor().equals(preColor)) {
                                        //连续2个颜色相同的段落翻译点，视为同一个翻译点
                                        node.setTranslationIndex(translationIndex);
                                    } else {
                                        //颜色不同，新的翻译点
                                        node.setTranslationIndex(++translationIndex);
                                    }
                                    preColor = node.getColor();
                                }

                                nodes.add(node);
                                System.out.println(node);
                            }

                        }
                        articleParas.add(articlePara);
                        System.out.println(nodes);
                        paraIndex++;
                    }
                }
            }
        }

    }
}
