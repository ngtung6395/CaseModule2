package controller;

import models.Customer;
import models.OrderDetail;
import models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerService {
    private static Scanner scanner = new Scanner(System.in);
    private static CustomerService INSTANCE;
    private List<OrderDetail> listOrder = new ArrayList<>();

    private List<Product> listProduct = new ArrayList<>();

    private CustomerService(){

    }
    public static CustomerService getINSTANCE(){
        if(INSTANCE == null) INSTANCE  = new CustomerService();
        return INSTANCE;
    }
    public void addProductToOrderDetail(){

    }
    public void createNewOrderDetail(){
        OrderDetail orderDetail = new OrderDetail();
        System.out.println("Mời bạn nhập id hóa đơn");
        String orderId = scanner.nextLine();
        orderDetail.setOrderId(orderId);
        System.out.println("Nhập khách hàng theo id");
        String id = scanner.nextLine();
        for (Customer c: CustomerManager.customerList
             ) {
            if(id.equals(c.getId())){
                orderDetail.setCustomer(c);
            }
        }
        System.out.println("Mời nhập id sản phẩm");
        String idProduct = scanner.nextLine();
        System.out.println("Mời nhập số lượng");
        int quanity = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < ProductManager.productList.size(); i++) {
            if(ProductManager.productList.get(i).getProductID().equals(idProduct))

                    listProduct.add(ProductManager.productList.get(i));
            ProductManager.productList.get(i).setQuanity(ProductManager.productList.get(i).getQuanity()-quanity);
        }
        for (int i = 0; i < listProduct.size(); i++) {

            if(listProduct.get(i).getProductID().equals(id)){
                listProduct.get(i).setQuanity(quanity);
            }
        }
        orderDetail.setPurchaseList(listProduct);
        System.out.println("Mời bạn nhập ngày tạo hóa đơn");
        String date = scanner.nextLine();
        orderDetail.setInvoiceCreatedDate(date);
        listOrder.add(orderDetail);
    }

    public void purchase(){
        double total = 0;
        for (int i = 0; i < listProduct.size() ; i++) {
            total += listProduct.get(i).getPrice()*listProduct.get(i).getQuanity();
        }
        System.out.println("Số tiền bạn phải thanh toán là: " + total);
        listProduct.clear();
    }
    public void addOrder(OrderDetail orderDetail){
        listOrder.add(orderDetail);
    }

    public void displayInvoice(){
        if(listOrder.isEmpty()){
            System.out.println("Không có hóa đơn nào ");
        }
        for (OrderDetail o:listOrder
             ) {
            System.out.println(o.toString());
        }
    }


}
