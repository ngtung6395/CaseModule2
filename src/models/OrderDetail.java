package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderDetail {
    private String orderId;
    private List<Product> purchaseList = new ArrayList<>();
    private Customer customer;
    private String invoiceCreatedDate;


    public OrderDetail(String orderId, List<Product> purchaseList, Customer customer, String invoiceCreatedDate) {
        this.orderId = orderId;
        this.purchaseList = purchaseList;
        this.customer = customer;
        this.invoiceCreatedDate = invoiceCreatedDate;
    }

    public OrderDetail() {
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

    public String getInvoiceCreatedDate() {
        return invoiceCreatedDate;
    }

    public void setInvoiceCreatedDate(String invoiceCreatedDate) {
        this.invoiceCreatedDate = invoiceCreatedDate;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderId='" + orderId + '\'' +
                ", purchaseList=" + purchaseList +
                ", customer=" + customer +
                ", invoiceCreatedDate='" + invoiceCreatedDate + '\'' +
                '}';
    }
}
