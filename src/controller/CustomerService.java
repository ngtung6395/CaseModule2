package controller;

import models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerService {
    private static CustomerService INSTANCE;

    private CustomerService(){

    }
    public static CustomerService getINSTANCE(){
        if(INSTANCE == null) INSTANCE  = new CustomerService();
        return INSTANCE;
    }

    private List<Product> listOrder = new ArrayList<>();

    public List Order(){
        System.out.println("Mời bạn nhập mã sản phẩm: ");
        Scanner scanner = new Scanner(System.in);
        String productId = scanner.nextLine();
        System.out.println("Mời bạn nhập số lượng muốn mua: ");
        Scanner scanner1 = new Scanner(System.in);
        int quantity = Integer.parseInt(scanner1.nextLine());
        Product product;
        for (Product p: ProductManager.getINSTANCE().getProductList()
             ) {
            if(p.getProductID().equals(productId)){
                product = p;
//                product.setQuanity(quantity);
                listOrder.add(product);
            }
            else {
                System.out.println("Sản phẩm không tồn tại trong danh sách sản phẩm");
            }
        }
       return listOrder;
    }

    public void getAmount(){
        double totalPrice = 0;
        if(listOrder.isEmpty()){
            System.out.println("Chưa có sản phẩm nào trong giỏ hàng của bạn");
        }
        else {

            for (int i = 0; i < listOrder.size(); i++) {
                totalPrice += (listOrder.get(i).getPrice()*listOrder.get(i).getQuanity());
            }
            System.out.println("Số tiền bạn phải trả là " + totalPrice);
        }
        listOrder.clear();
    }
}
