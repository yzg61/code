package com.yzg.office.excel;

import lombok.Data;

/**
 * 文字节点
 */
@Data
public class TextNode {


    private Integer paraIndex;

    private Integer rowIndex;

    private Integer index;

    private Integer translationIndex;

    private Integer noteIndex;

    private String text;

    private String color;

    private String fontName;

    private int fontSize;

    private String fontFamily;

    private String textHighlightColor;

    private String style;

    private String underline;

    private String underlineColor;

    private Boolean italic;

    private Boolean bold;

    private String verticalAlignment;


}
