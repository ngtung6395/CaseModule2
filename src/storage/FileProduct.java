package storage;

import models.Customer;
import models.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileProduct {
    private static FileProduct INSTANCE;

    private FileProduct(){

    }
    public static FileProduct getINSTANCE(){
        if(INSTANCE == null) INSTANCE  = new FileProduct();
        return INSTANCE;
    }


    public List<Product> readFile() throws IOException, ClassNotFoundException {
        File file = new File("listProduct.dat");
        if(!file.exists()){
            file.createNewFile();
        }
        if (file.length() >0){
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            List<Product> list = (List<Product>) object;
            objectInputStream.close();
            fileInputStream.close();
            return list;
        }
        else return new ArrayList<>();
    }

    public void writeFile(List<Product> productList) throws IOException{
        File file = new File("listProduct.dat");
        if (!file.exists()){
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(productList);
        objectOutputStream.close();
        fileOutputStream.close();
    }
}
