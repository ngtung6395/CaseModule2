package views;

import controller.CustomerManager;
import controller.CustomerService;
import controller.ProductManager;
import models.Customer;
import models.OrderDetail;
import models.Product;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
                    menuCustomer();
                    break;
                case 2:
                    menuProduct();
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

    public static void menuCustomer() {
        Scanner scanner = new Scanner(System.in);
        int choose;

            do {
                System.out.println("Menu ");
                System.out.println("1. Tạo mới khách hàng");
                System.out.println("2. Sửa thông tin khách hàng");
                System.out.println("3. Xóa khách hàng");
                System.out.println("4. Hiện thị danh sách khách hàng");
                System.out.println("0. Quay lại menu");
                System.out.println("Mời bạn nhập lựa chọn");
                choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        createCustomer();
                        break;
                    case 2:
                        editCustomerById();
                        break;
                    case 3:
                        deleteCustomerById();
                        break;
                    case 4:
                        customerManager.displayListCustomer();
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

    public static void deleteCustomerById(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập id khách hàng");
        String id = scanner.nextLine();
        Customer customer = customerManager.findCustomerById(id);
        if(customer == null){
            System.out.println("Không có khách hàng có id " + id);
        }else {
            customerManager.removeCustomer(customer);
            System.out.println("Đã xóa thành công");
        }
    }

    public static void createCustomer() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Mời bạn nhập tên: ");
            String name = scanner.nextLine();
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Mời bạn nhập tuổi: ");
            int age = scanner2.nextInt();
            Scanner scanner3 = new Scanner(System.in);
            System.out.println("Mời bạn nhập địa chỉ: ");
            String address = scanner3.nextLine();
            Scanner scanner4 = new Scanner(System.in);
            System.out.println("Mời bạn nhập id: ");
            String id = scanner4.nextLine();
            Scanner scanner5 = new Scanner(System.in);
            System.out.println("Mời bạn nhập số điện thoại: ");
            String phoneNumber = scanner5.nextLine();
            Scanner scanner6 = new Scanner(System.in);
            System.out.println("Mời bạn nhập email: ");
            String email = scanner6.nextLine();
            Customer customer = new Customer(name, age, address, id, phoneNumber, email);
            if(customerManager.checkIdCustomer(customer) == true){
                System.err.println("ID của người dùng đã tồn tại, xin vui lòng nhập lại");
                createCustomer();
            }else {
                customerManager.addCustomer(customer);
                System.out.println("Đã tạo mới thành công");
            }
        } catch (InputMismatchException e) {
            System.err.println("Bạn đã nhập sai thông tin ! Xin vui lòng nhập lại");
            createCustomer();
        }
    }


    public static void editCustomerById(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập id khách hàng: ");
        String id = scanner.nextLine();
        Customer customer = customerManager.findCustomerById(id);
        if(customer == null)
            System.out.println("Không tồn tại khách hàng có id " + id);
        else{
            try{
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Mời bạn nhập tên khách hàng: ");
                String newName = scanner1.nextLine();
                customer.setName(newName);
                Scanner scanner2 = new Scanner(System.in);
                System.out.println("Mời bạn nhập tuổi: ");
                int newAge = Integer.parseInt(scanner2.nextLine());
                customer.setAge(newAge);
                Scanner scanner3 = new Scanner(System.in);
                System.out.println("Mời bạn địa chỉ: ");
                String newAddress = scanner3.nextLine();
                customer.setAddress(newAddress);
                Scanner scanner4 = new Scanner(System.in);
                System.out.println("Mời bạn nhập số điện thoại: ");
                String newPhoneNumber = scanner4.nextLine();
                customer.setPhoneNumber(newPhoneNumber);
                Scanner scanner5 = new Scanner(System.in);
                System.out.println("Mời bạn nhập email: ");
                String newEmail = scanner5.nextLine();
                customer.setEmail(newEmail);
            }
            catch (InputMismatchException e){
                System.err.println("Bạn đã nhập sai thông tin ! Xin vui lòng nhập lại !");
                editCustomerById();
            }
        }
    }

    public static void menuProduct(){
        Scanner scanner = new Scanner(System.in);
        int choose;
            do {
                System.out.println("Menu ");
                System.out.println("1. Tạo mới sản phẩm");
                System.out.println("2. Sửa thông tin sản phẩm");
                System.out.println("3. Xóa sản phẩm");
                System.out.println("4. Hiện thị danh sách sản phẩm");
                System.out.println("0. Quay lại menu");
                System.out.println("Mời bạn nhập lựa chọn");
                choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        createProduct();
                        break;
                    case 2:
                        editProductById();
                        break;
                    case 3:
                        deleteProductById();
                        break;
                    case 4:
                        productManager.displayListProduct();
                        break;
                    case 0:
                        break;
                }
            }
            while (choose != 0);
    }

    public static void createProduct() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Mời bạn nhập tên sản phẩm: ");
            String productName = scanner.nextLine();
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Mời bạn mã sản phẩm: ");
            String productID = scanner2.nextLine();
            Scanner scanner3 = new Scanner(System.in);
            System.out.println("Mời bạn thông tin sản phẩm: ");
            String description = scanner3.nextLine();
            Scanner scanner4 = new Scanner(System.in);
            System.out.println("Mời bạn nhập số lượng sản phẩm: ");
            int quantity = Integer.parseInt(scanner4.nextLine());
            Scanner scanner5 = new Scanner(System.in);
            System.out.println("Mời bạn nhập giá sản phẩm: ");
            double price = scanner5.nextDouble();
            Product product = new Product(productName,productID,description,quantity,price);
            if(productManager.checkIdProduct(product) == true){
                System.err.println("ID của sản phẩm đã tồn tại, xin vui lòng nhập lại");
                createProduct();
            }else {
                productManager.addProduct(product);
                System.out.println("Đã tạo mới thành công");
            }
        } catch (InputMismatchException e) {
            System.err.println("Bạn đã nhập sai thông tin ! Xin vui lòng nhập lại");
            createProduct();
        }
    }

    public static void deleteProductById(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập id sản phẩm");
        String productId = scanner.nextLine();
        Product product = productManager.findProductById(productId);
        if(product == null){
            System.out.println("Không có khách hàng có id " + productId);
        }else {
            productManager.removeProduct(product);
            System.out.println("Đã xóa thành công");
        }
    }

    public static void editProductById(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập id sản phẩm: ");
        String id = scanner.nextLine();
        Product product = productManager.findProductById(id);
        if(product == null)
            System.out.println("Không tồn tại khách hàng có id " + id);
        else{
            try{
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Mời bạn nhập tên sản phẩm: ");
                String newProductName = scanner1.nextLine();
                product.setProductName(newProductName);
                Scanner scanner2 = new Scanner(System.in);
                System.out.println("Mời bạn nhập thông tin sản phẩm: ");
                String newDescription = scanner2.nextLine();
                product.setDescription(newDescription);
                Scanner scanner3 = new Scanner(System.in);
                System.out.println("Mời bạn nhập số lượng sản phẩm: ");
                int newQuantity = Integer.parseInt(scanner3.nextLine());
                product.setQuanity(newQuantity);
                Scanner scanner4 = new Scanner(System.in);
                System.out.println("Mời bạn nhập giá sản phẩm: ");
                double newPrice = scanner4.nextDouble();
                product.setPrice(newPrice);
            }
            catch (InputMismatchException e){
                System.err.println("Bạn đã nhập sai thông tin ! Xin vui lòng nhập lại !");
                editProductById();
            }
        }
    }
}
