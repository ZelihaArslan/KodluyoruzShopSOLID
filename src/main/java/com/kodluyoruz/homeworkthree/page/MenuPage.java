package com.kodluyoruz.homeworkthree.page;

import com.kodluyoruz.homeworkthree.model.Product;
import com.kodluyoruz.homeworkthree.model.cart.Cart;
import com.kodluyoruz.homeworkthree.model.cart.CartItem;
import com.kodluyoruz.homeworkthree.model.categories.Category;
import com.kodluyoruz.homeworkthree.model.categories.MainCategory;
import com.kodluyoruz.homeworkthree.model.categories.SubCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class MenuPage {
    private final Scanner scanner;
    private final PageCheckout pageCheckout;
    private final PagePayment pagePayment;
    private Product product;
    private final Cart cart;
    public void run(Category categories) {

        List<MainCategory> mainCategoryList=categories.getMainCategoryList();
        System.out.println("---MAIN MENU---");
        for (MainCategory item:mainCategoryList)
        {
            System.out.println(item.getMainName());
        }
        System.out.print("PLEASE SELECT CATEGORY: ");
        String category=scanner.nextLine();

        for (MainCategory item:mainCategoryList) {
            if(item.getMainName().equals(category)){
                for (SubCategory iter:item.getSubCategoryList()) {
                    System.out.println(iter.getSubCategoryName());
                }
            }
        }


        System.out.print("PLEASE SELECT SUBCATEGORY: ");
        String subCategory=scanner.nextLine();



        for (MainCategory item:mainCategoryList) {
            int i=0;
            if(item.getMainName().equals(category)){
                for (SubCategory iter:item.getSubCategoryList()) {
                    if(iter.getSubCategoryName().equals(subCategory)){
                        for (Product product:iter.getProductList()) {
                            System.out.println(product.getName()+"  : "+i);
                            i++;
                        }
                    }
                }
            }
        }

        System.out.print("PLEASE SELECT PRODUCT: ");
        int pr=Integer.parseInt(scanner.nextLine());

        for (MainCategory item:mainCategoryList) {
            if(item.getMainName().equals(category)){
                for (SubCategory iter:item.getSubCategoryList()){
                    if(iter.getSubCategoryName().equals(subCategory)){
                        System.out.println("Product Description: "+iter.getProductList().get(pr).getDescription());
                        product=iter.getProductList().get(pr);

                    }
                }
            }
        }

        System.out.print("HOW MANY: ");
        int quantity =Integer.parseInt(scanner.nextLine());


        CartItem cartItem=CartItem.builder()
                .product(product)
                .quantity(quantity)
                .build();
        cart.AddItem(cartItem);

        System.out.print("Please select page [FIRST PAGE,CHECKOUT]: ");

        String option=scanner.nextLine();
        if(option.equals("FIRST PAGE")){
            this.run(categories);
            return;
        }
        else if(option.equals("CHECKOUT")){
            pageCheckout.run(cart,categories);

        }





    }


}
