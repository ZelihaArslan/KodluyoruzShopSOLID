package com.kodluyoruz.homeworkthree.page;

import com.kodluyoruz.homeworkthree.model.cart.Cart;
import com.kodluyoruz.homeworkthree.model.categories.Category;
import com.kodluyoruz.homeworkthree.model.checkout.Bill;
import com.kodluyoruz.homeworkthree.service.CheckoutService;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Data
public class PageCheckout {
    private final CheckoutService checkoutService;
    private final Scanner scanner;
    private MenuPage menuPage;
    private final PagePayment pagePayment;
    private Bill bill;
    public void run(Cart cart, Category category) {

        bill=checkoutService.checkout(cart);
        System.out.print("Please select page [FIRST PAGE,PAYMENT]: ");

        String option1=scanner.nextLine();
        if(option1.equals("FIRST PAGE")){
            menuPage.run(category);
            return;
        }
        else if(option1.equals("PAYMENT")){
            pagePayment.run(bill);
        }
    }

}
