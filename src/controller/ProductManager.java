package controller;

import models.Customer;
import models.Product;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    private static ProductManager INSTANCE;

    private ProductManager(){

    }
    public static ProductManager getINSTANCE(){
        if(INSTANCE == null) INSTANCE  = new ProductManager();
        return INSTANCE;
    }

    private List<Product> productList = new ArrayList<>();

    public ProductManager(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public boolean checkIdProduct(Product product){
        boolean check = false;
        for (Product p: productList
        ) {
            if(p.getProductID().equals(product.getProductID()))
                check = true;
        }
        return check;
    }

    public void displayListProduct(){
        if(productList.isEmpty())
            System.out.println("Không có sản phẩm nào");
        else {
            for (Product p : productList
            ) {
                System.out.println(p.toString());
            }
        }
    }

    public void createProduct() {
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
            if(checkIdProduct(product) == true){
                System.err.println("ID của sản phẩm đã tồn tại, xin vui lòng nhập lại");
                createProduct();
            }else {
                productList.add(product);
                System.out.println("Đã tạo mới thành công");
            }
        } catch (InputMismatchException e) {
            System.err.println("Bạn đã nhập sai thông tin ! Xin vui lòng nhập lại");
            createProduct();
        }
    }

    public Product findProductById(String id){
        Product product = null;
        for (Product p: productList
        ) {
            if(p.getProductID().equals(id))
                product = p;
        }
        return product;
    }

    public void editProductById(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập id sản phẩm: ");
        String id = scanner.nextLine();
        Product product = findProductById(id);
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

    public void deleteProductById(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập id sản phẩm");
        String productId = scanner.nextLine();
        Product product = findProductById(productId);
        if(product == null){
            System.out.println("Không có khách hàng có id " + productId);
        }else {
            productList.remove(product);
            System.out.println("Đã xóa thành công");
        }
    }

    public void menuProduct(){
        Scanner scanner = new Scanner(System.in);
        int choose;
        try {
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
                        displayListProduct();
                        break;
                    case 0:
                        break;
                }
            }
            while (choose != 0);
        }
        catch (Exception e){
            System.out.println("Bạn đã nhập sai vui lòng nhập lại !");
            menuProduct();
        }
    }
}
