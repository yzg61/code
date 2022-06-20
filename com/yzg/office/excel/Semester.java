package com.yzg.office.excel;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 学期
 */
@Data
public class Semester {

    private String title;

    private List<ArticleTable> articleTables = new ArrayList<>();

}
