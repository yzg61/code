package com.yzg.office.excel;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Article {

    private Integer num;

    private Integer type;

    private String className;

    private String title;

    private String author;


    private List<ArticlePara> originalParas = new ArrayList<>();

    private List<ArticlePara> translationParas = new ArrayList<>();

}
