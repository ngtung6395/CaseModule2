package storage;


import models.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileCustomer {
    private static FileCustomer INSTANCE;

    private FileCustomer(){

    }
    public static FileCustomer getINSTANCE(){
        if(INSTANCE == null) INSTANCE  = new FileCustomer();
        return INSTANCE;
    }


    public static List<Customer> readFile() throws IOException, ClassNotFoundException {
        File file = new File("listCustomer.dat");
        if(!file.exists()){
            file.createNewFile();
        }
        if (file.length() >0){
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            List<Customer> list = (List<Customer>) object;
            objectInputStream.close();
            fileInputStream.close();
            return list;
        }
        else return new ArrayList<>();
    }


    public void writeFile(List<Customer> gradeList) throws IOException{
        File file = new File("listCustomer.dat");
        if (!file.exists()){
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(gradeList);
        objectOutputStream.close();
        fileOutputStream.close();
    }
}
