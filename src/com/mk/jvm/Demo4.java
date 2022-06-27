package com.mk.jvm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Demo4 {

    public static void main(String[] args) {
        automaticallyCloseResource();
        new ArrayList<>();
//        new Runnable()
    }

    public static void automaticallyCloseResource() {
        File file = new File("./tmp.txt");
        try (FileInputStream inputStream = new FileInputStream(file);) {
            // use the inputStream to read a file
        } catch (FileNotFoundException e) {
            System.out.println("Error FIle");
        } catch (IOException e) {
            System.out.println("error IOE");
        }
    }
}
