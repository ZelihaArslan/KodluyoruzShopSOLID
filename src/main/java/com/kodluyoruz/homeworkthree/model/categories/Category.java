package com.kodluyoruz.homeworkthree.model.categories;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class Category {
    private List<MainCategory>mainCategoryList=new ArrayList<>();

    public void addCategory(MainCategory mainCategory){
        mainCategoryList.add(mainCategory);
    }


}
