package com.yzg.office.excel;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 文章段落
 */
@Data
public class ArticlePara {

    private Integer paraIndex;

    private List<TextNode> textNodes = new ArrayList<>();

    private String text;

}
