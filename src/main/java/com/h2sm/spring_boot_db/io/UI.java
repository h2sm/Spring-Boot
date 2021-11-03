package com.h2sm.spring_boot_db.io;

import java.util.Collection;

public interface UI {
    String getKeyboard();
    void show(String str);
    void show(Collection<?> t);
    void showLocalized(String str);
    void setLocale(String loc);
    String returnLocalized(String s);
}
