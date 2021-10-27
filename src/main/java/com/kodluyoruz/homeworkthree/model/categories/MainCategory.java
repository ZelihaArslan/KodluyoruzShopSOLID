package com.kodluyoruz.homeworkthree.model.categories;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class MainCategory extends Category {
    private String mainName;
    private List<SubCategory> subCategoryList=new ArrayList<>();

    public MainCategory(String mainName) {
        this.mainName = mainName;
    }
    public void addCategory(SubCategory subCategory){
        subCategoryList.add(subCategory);
    }
}
