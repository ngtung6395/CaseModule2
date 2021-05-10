package controller;

import models.Customer;

import java.util.*;

public class CustomerManager {

    private static CustomerManager INSTANCE;

    private CustomerManager(){

    }
    public static CustomerManager getINSTANCE(){
        if(INSTANCE == null) INSTANCE  = new CustomerManager();
        return INSTANCE;
    }

    private List<Customer> customerList = new ArrayList<>();

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

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

    public void createCustomer() {
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
            if(checkIdCustomer(customer) == true){
                System.err.println("ID của người dùng đã tồn tại, xin vui lòng nhập lại");
                createCustomer();
            }else {
                customerList.add(customer);
                System.out.println("Đã tạo mới thành công");
            }
        } catch (InputMismatchException e) {
            System.err.println("Bạn đã nhập sai thông tin ! Xin vui lòng nhập lại");
            createCustomer();
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

    public void editCustomerById(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập id khách hàng: ");
        String id = scanner.nextLine();
        Customer customer = findCustomerById(id);
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

    public void deleteCustomerById(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập id khách hàng");
        String id = scanner.nextLine();
        Customer customer = findCustomerById(id);
        if(customer == null){
            System.out.println("Không có khách hàng có id " + id);
        }else {
            customerList.remove(customer);
            System.out.println("Đã xóa thành công");
        }
    }

    public void menuCustomer(){
        Scanner scanner = new Scanner(System.in);
        int choose;
        try {
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
                        displayListCustomer();
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
        catch (Exception e){
            System.out.println("Bạn đã nhập sai vui lòng nhập lại !");
            menuCustomer();
        }
    }
//
//    public void sortCustomerById{
//
//        customerList.sort();
//    }
}
