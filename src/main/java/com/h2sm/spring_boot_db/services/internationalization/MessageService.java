package com.h2sm.spring_boot_db.services.internationalization;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MessageService {
    private final MessageSource messageSource;
    private final LocaleService localeService;

    public String localize(String code) {
        return messageSource.getMessage(code, new Object[0], localeService.getCurrent());
    }

    public String localize(String code, Object... params) {
        return messageSource.getMessage(code, params, localeService.getCurrent());
    }
    public void setLocale(String loc){
        localeService.setLocale(loc);
    }

}
