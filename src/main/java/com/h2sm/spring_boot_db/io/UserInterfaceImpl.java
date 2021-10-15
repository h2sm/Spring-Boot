package com.h2sm.spring_boot_db.io;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.Scanner;

public class UserInterfaceImpl implements UI {
    private final Scanner scanner = new Scanner(System.in);
    private final PrintWriter writer = new PrintWriter(System.out);


    @Override
    public void show(String str) {
        writer.println(str);
        writer.flush();
    }

    @Override
    public void show(Collection<?> t) {
        t.forEach(System.out::println);
    }

    @Override
    public void showLocalized(String str) {

    }

}
