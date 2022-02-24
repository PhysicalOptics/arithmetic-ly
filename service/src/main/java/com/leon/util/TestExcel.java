package com.leon.util;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
  * ClassName:    TestExcel
  * @Description: 
  * @Author:      liyang
  * @Date:        2021/12/16
  * version     1.0.0
 */
public class TestExcel {

    public static void main(String[] args){
        ExcelReader reader = ExcelUtil.getReader("d:/test.xlsx");
        //List<Map<String, Object>> maps = reader.readAll();
        //System.out.println(examples);

        List<List<Object>> read = reader.read(2, reader.getRowCount());
        ArrayList<Example> examples = new ArrayList<>();
        for (List<Object> objects : read) {
            Example example = new Example();
            example.setName(objects.get(0).toString());
            example.setExample(objects.get(1).toString());
            examples.add(example);
        }
        System.out.println(JSONUtil.toJsonStr(examples));
    }
}


class Example{
    private String name;
    private String example;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }
}