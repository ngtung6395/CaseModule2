package views;

import controller.CustomerManager;
import controller.CustomerService;
import controller.ProductManager;
import models.OrderDetail;
import models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientDemo {
    static final CustomerManager customerManager = CustomerManager.getINSTANCE();
    static final ProductManager productManager = ProductManager.getINSTANCE();
    static final CustomerService customerService = CustomerService.getINSTANCE();
    public static void main(String[] args) {
        mainMenu();

    }

    public static void mainMenu(){
        Scanner scanner = new Scanner(System.in);
        int choose;
        do {
            System.out.println("Menu");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("0. Thoát khỏi chương trình");
            System.out.println("Mời bạn nhập lựa chọn ");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    menuAdmin();
                    break;
                case 2:
                    menuUser();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Bạn nhập sai vui lòng nhập lại !");
                    break;
            }
        }
        while (choose != 0);


    }

    public static void menuAdmin() {
        Scanner scanner = new Scanner(System.in);
        int choose;
        do {
            System.out.println("Menu");
            System.out.println("1. Nhập thông tin về khách hàng");
            System.out.println("2. Nhập thông tin về sản phẩm");
            System.out.println("0. Quay lại menu");
            System.out.println("Mời bạn nhập lựa chọn ");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    customerManager.menuCustomer();
                    break;
                case 2:
                    productManager.menuProduct();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Bạn nhập sai vui lòng nhập lại !");
                    break;
            }
        }
        while (choose != 0);
    }

    public static void menuUser(){
        Scanner scanner = new Scanner(System.in);
        int choose;
        do {
            System.out.println("Menu");
            System.out.println("1. Hiện thị danh sách sản phẩm");
            System.out.println("2. Đặt hàng");
            System.out.println("3. Thanh toán");
            System.out.println("0. Quay lại menu");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    productManager.displayListProduct();
                    break;
                case 2:
                    customerService.Order();
                    break;
                case 3:
                    customerService.getAmount();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Bạn nhập sai vui lòng nhập lại !");
                    break;
            }
        }
        while (choose != 0);
    }
}
