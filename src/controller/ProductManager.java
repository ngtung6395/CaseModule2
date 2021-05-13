package controller;

import models.Customer;
import models.Product;
import storage.FileProduct;

import java.io.IOException;
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


    FileProduct fileProduct = FileProduct.getINSTANCE();

    public static List<Product> productList = new ArrayList<>();

    public static List<Product> getProductList() {
        FileProduct fileProduct = FileProduct.getINSTANCE();
        try {
            productList = fileProduct.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public static void setProductList(List<Product> productList) {
        ProductManager.productList = productList;
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

    public void addProduct(Product product){
        productList.add(product);
        try {
            fileProduct.writeFile(productList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeProduct(Product product){
        productList.remove(product);
        try {
            fileProduct.writeFile(productList);
        } catch (IOException e) {
            e.printStackTrace();
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

}
