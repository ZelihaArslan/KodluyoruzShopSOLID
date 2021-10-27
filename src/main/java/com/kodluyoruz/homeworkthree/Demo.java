package com.kodluyoruz.homeworkthree;
import com.kodluyoruz.homeworkthree.page.*;
import com.kodluyoruz.homeworkthree.model.Product;
import com.kodluyoruz.homeworkthree.model.categories.Category;
import com.kodluyoruz.homeworkthree.model.categories.MainCategory;
import com.kodluyoruz.homeworkthree.model.categories.SubCategory;
import com.kodluyoruz.homeworkthree.model.enums.PageType;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class Demo implements CommandLineRunner {
    private final Scanner scanner;
    private final MenuPage menuPage;
    private final PageSearch pageSearch;

    @Override
    public void run(String... args) throws Exception {
        Product p=Product.builder().name("Apple").unitPrice(10).description("meyve").build();
        Product p1=Product.builder().name("Pear").unitPrice(10).description("meyve").build();
        Product p2=Product.builder().name("Grape").unitPrice(12).description("meyve").build();

        SubCategory s=new SubCategory("F","Fruit");
        s.addProduct(p);
        s.addProduct(p1);
        s.addProduct(p2);

        Product p3=Product.builder().name("Tomato").unitPrice(15).description("sebze").build();
        Product p4=Product.builder().name("Pepper").unitPrice(11).description("sebze").build();
        Product p5=Product.builder().name("Egglant").unitPrice(17).description("sebze").build();
        SubCategory s1=new SubCategory("V","Vegetables");
        s1.addProduct(p3);
        s1.addProduct(p4);
        s1.addProduct(p5);
        MainCategory mc=new MainCategory("Fruit and Veggies");
        mc.addCategory(s);
        mc.addCategory(s1);

        Product p6=Product.builder().name("Lays").unitPrice(5).description("Atıştırmalık").build();
        Product p7=Product.builder().name("Doritos").unitPrice(5).description("Atıştırmalık").build();
        Product p8=Product.builder().name("Ruffles").unitPrice(5).description("Atıştırmalık").build();
        SubCategory s2=new SubCategory("S","Chips");
        s2.addProduct(p6);
        s2.addProduct(p7);
        s2.addProduct(p8);

        Product p9=Product.builder().name("Tadelle").unitPrice(4).description("Çikolata").build();
        Product p10=Product.builder().name("Albeni").unitPrice(3).description("Çikolata").build();
        Product p11=Product.builder().name("Metro").unitPrice(3).description("Çikolata").build();
        Product p12=Product.builder().name("Hobby").unitPrice(2).description("Çikolata").build();
        SubCategory s3=new SubCategory("Snack","Chocolata");
        s3.addProduct(p9);
        s3.addProduct(p10);
        s3.addProduct(p11);
        s3.addProduct(p12);

        MainCategory mc2=new MainCategory("Snack");
        mc2.addCategory(s2);
        mc2.addCategory(s3);

        Product p13=Product.builder().name("Full-Fat").unitPrice(58).description("Süt").build();
        Product p14=Product.builder().name("Low-Fat").unitPrice(45).description("Süt").build();
        Product p15=Product.builder().name("Lacto-Free").unitPrice(60).description("Süt").build();
        SubCategory s4= new SubCategory("Breakfast","Milk");
        s4.addProduct(p13);
        s4.addProduct(p14);
        s4.addProduct(p15);

        Product p16=Product.builder().name("Cheddar").unitPrice(25).description("Kahvaltılık").build();
        Product p17=Product.builder().name("Cheese").unitPrice(60).description("Kahvaltılık").build();
        Product p18=Product.builder().name("Salami").unitPrice(70).description("Kahvaltılık").build();
        Product p19=Product.builder().name("Susage").unitPrice(90).description("Kahvaltılık").build();
        Product p20=Product.builder().name("Olive").unitPrice(100).description("Kahvaltılık").build();

        SubCategory s5= new SubCategory("Breakfast","Delicatessen");
        s5.addProduct(p16);
        s5.addProduct(p17);
        s5.addProduct(p18);
        s5.addProduct(p19);
        s5.addProduct(p20);

        MainCategory mc3=new MainCategory("Breakfast");
        mc3.addCategory(s4);
        mc3.addCategory(s5);

       Category category =new Category();
       category.addCategory(mc);
       category.addCategory(mc2);
       category.addCategory(mc3);

        System.out.print("Please select page  "+ Arrays.toString(PageType.values())+" : ");
        String pageType= scanner.nextLine();

        if(pageType.equals("MENU")){
            menuPage.run(category);
        }else{
            pageSearch.run(category);
        }



    }
}
