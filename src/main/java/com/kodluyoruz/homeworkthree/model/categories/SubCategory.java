package com.kodluyoruz.homeworkthree.model.categories;
import java.util.ArrayList;
import java.util.List;

import com.kodluyoruz.homeworkthree.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;


@Data
public class SubCategory extends MainCategory{
    private List<Product> productList=new ArrayList<>();
    private String subCategoryName;

    public SubCategory(String mainName, String subCategoryName) {
        super(mainName);
        this.subCategoryName = subCategoryName;
    }
    public void addProduct(Product product){
        productList.add(product);
    }

}
