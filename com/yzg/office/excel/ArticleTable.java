package com.yzg.office.excel;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 文章
 */
@Data
public class ArticleTable {

    private Integer index;

    private List<ArticlePara> articleParas = new ArrayList<>();

    private String title;

    private String center;

    private String exp;
}
