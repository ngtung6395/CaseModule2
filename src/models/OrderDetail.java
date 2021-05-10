package models;

import java.util.ArrayList;
import java.util.List;

public class OrderDetail {
    private String orderId;
    private List<Product> purchaseList = new ArrayList<>();
    private Customer customer;

    public OrderDetail() {
    }

    public OrderDetail(String orderId, List<Product> purchaseList, Customer customer) {
        this.orderId = orderId;
        this.purchaseList = purchaseList;
        this.customer = customer;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<Product> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<Product> purchaseList) {
        this.purchaseList = purchaseList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


}
