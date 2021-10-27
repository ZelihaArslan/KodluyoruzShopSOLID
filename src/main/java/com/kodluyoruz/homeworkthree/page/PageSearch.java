package com.kodluyoruz.homeworkthree.page;

import com.kodluyoruz.homeworkthree.model.Product;
import com.kodluyoruz.homeworkthree.model.cart.Cart;
import com.kodluyoruz.homeworkthree.model.cart.CartItem;
import com.kodluyoruz.homeworkthree.model.categories.Category;
import com.kodluyoruz.homeworkthree.model.categories.MainCategory;
import com.kodluyoruz.homeworkthree.model.categories.SubCategory;
import com.kodluyoruz.homeworkthree.model.checkout.Bill;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PageSearch {
    private final Scanner scanner;
    private Product product=null;
    private final Cart cart;
    private Bill bill;
    private final PageCheckout pageCheckout;
    private final MenuPage menuPage;
    public void run(Category category) {
        int i = 0;
        do {
            System.out.print("SEARCH: ");
            String scan = scanner.nextLine();
            List<Product> productList = new ArrayList<>();
            List<MainCategory> mainCategoryList = category.getMainCategoryList().stream().
                    filter(mainCategory -> mainCategory.toString().contains(scan)).collect(Collectors.toList());


            for (MainCategory mainCategory : mainCategoryList) {
                for (SubCategory sub : mainCategory.getSubCategoryList()) {
                    for (Product product : sub.getProductList()) {
                        if (product.getName().contains(scan)) {
                            System.out.println(product.getName() + ": " + i);
                            productList.add(product);
                            i++;
                        }
                    }
                }
            }
            if (i > 0) {
                System.out.print("PLEASE SELECT PRODUCT: ");
                int pr = Integer.parseInt(scanner.nextLine());

                for (int j = 0; j < productList.size(); j++) {
                    if (pr == j) {
                        System.out.println("Product Description: " + productList.get(j).getDescription());
                        product = productList.get(pr);
                    }
                }
                if (product != null) {
                    System.out.print("HOW MANY: ");
                    int quantity = Integer.parseInt(scanner.nextLine());


                    CartItem cartItem = CartItem.builder()
                            .product(product)
                            .quantity(quantity)
                            .build();
                    cart.AddItem(cartItem);

                    System.out.print("Please select page [FIRST PAGE,CHECKOUT]: ");

                    String option = scanner.nextLine();
                    if (option.equals("FIRST PAGE")) {
                        menuPage.run(category);
                        return;
                    } else if (option.equals("CHECKOUT")) {
                        pageCheckout.run(cart, category);

                    }


                }
            }
        } while (i==0);
    }

}
