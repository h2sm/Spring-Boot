package com.h2sm.spring_boot_db.io;

import com.h2sm.spring_boot_db.models.Achievement;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.Scanner;

public class UIimpl implements UI {
    private final Scanner scanner = new Scanner(System.in);
    private final PrintWriter writer = new PrintWriter(System.out);


    @Override
    public void show(String str) {
        writer.println(str);
        writer.flush();
    }

    @Override
    public void show(Collection<Object> t) {
        t.forEach((k) -> System.out.println(k.toString()));
    }

    @Override
    public void showLocalized(String str) {

    }

}
