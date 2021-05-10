package controller;

import models.Customer;
import storage.FileCustomer;

import java.io.IOException;
import java.util.*;

public class CustomerManager {
    static FileCustomer fileCustomer = FileCustomer.getINSTANCE();

    private static CustomerManager INSTANCE;

    private CustomerManager(){

    }
    public static CustomerManager getINSTANCE(){
        if(INSTANCE == null) INSTANCE  = new CustomerManager();
        return INSTANCE;
    }

    private static List<Customer> customerList = new ArrayList<>();


    public boolean checkIdCustomer(Customer customer){
        boolean check = false;
        for (Customer c:customerList
             ) {
            if(c.getId().equals(customer.getId()))
                check = true;
        }
        return check;
    }

    public void displayListCustomer(){
        if(customerList.isEmpty())
            System.out.println("Không có khách hàng trong danh sách");
        else {
            for (Customer c : customerList
            ) {
                System.out.println(c.toString());
            }
        }
    }

    public void addCustomer(Customer customer){
        customerList.add(customer);
        try {
            fileCustomer.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public Customer findCustomerById(String id){
        Customer customer = null;
        for (Customer c:customerList
        ) {
            if(c.getId().equals(id))
                customer = c;
        }
        return customer;
    }


    public void removeCustomer(Customer customer){
        customerList.remove(customer);
        try {
            fileCustomer.writeFile(customerList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Customer> getCustomerList() {
        FileCustomer fileCustomer = FileCustomer.getINSTANCE();
        try {
            customerList = fileCustomer.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    public static void setCustomerList(List<Customer> customerList) {
        CustomerManager.customerList = customerList;
    }

    //
//    public void sortCustomerById{
//
//        customerList.sort();
//    }
}
