package com.h2sm.spring_boot_db.io;

import com.h2sm.spring_boot_db.services.internationalization.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.Scanner;

@Service
public class UserInterfaceImpl implements UI {
    private final Scanner scanner = new Scanner(System.in);
    private final PrintWriter writer = new PrintWriter(System.out);
    @Autowired
    private MessageService ms;

    @Override
    public String getKeyboard() {
        return scanner.next();
    }

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
        show(ms.localize(str));
    }

    @Override
    public void setLocale(String loc) {
        ms.setLocale(loc);
    }

    @Override
    public String returnLocalized(String s) {
        return ms.localize(s);
    }

}
