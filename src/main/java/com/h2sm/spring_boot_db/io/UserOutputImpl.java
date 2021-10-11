package com.h2sm.spring_boot_db.io;

import com.h2sm.spring_boot_db.models.Achievements;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.util.Scanner;

@Service
public class UserOutputImpl implements UserOutput {
    private final Scanner scanner = new Scanner(System.in);
    private final PrintWriter writer = new PrintWriter(System.out);

    @Override
    public void show(String str) {
        writer.println(str);
        writer.flush();
    }

    @Override
    public void show(Achievements a) {

    }
}
