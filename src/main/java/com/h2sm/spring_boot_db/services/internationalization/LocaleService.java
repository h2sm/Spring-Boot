package com.h2sm.spring_boot_db.services.internationalization;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Locale;

@RequiredArgsConstructor
@Service
public class LocaleService {
    @Getter
    private Locale current = Locale.forLanguageTag("ru");

    public void setLocale(String loc) {
        current = Locale.forLanguageTag(loc);
    }
}
