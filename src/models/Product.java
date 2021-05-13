package models;

import storage.FileProduct;

import java.io.Serializable;

public class Product implements Serializable {
    private String productName;
    private String productID;
    private String description;
    private int quanity;
    private double price;

    public Product() {
    }

    public Product(String productName, String productID, String description, int quanity, double price) {
        this.productName = productName;
        this.productID = productID;
        this.description = description;
        this.quanity = quanity;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productID='" + productID + '\'' +
                ", description='" + description + '\'' +
                ", quanity=" + quanity +
                ", price=" + price +
                '}';
    }
}
