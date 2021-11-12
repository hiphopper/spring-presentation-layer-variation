package com.gsk.presentation.lucy.config.listener;

import com.nhncorp.lucy.security.xss.event.AttributeListener;
import com.nhncorp.lucy.security.xss.markup.Attribute;

import java.util.regex.Pattern;

public class WhiteDomainListener implements AttributeListener {
    final Pattern URL_PATTERN = Pattern.compile("(?i)['\"]?\\s*(http|https)://.+");
    final Pattern WHITE_DOMAINS = Pattern.compile("(?i)['\"]?\\s*(http|https)://www\\.kgs\\.com.*");

    @Override
    public void handleAttribute(Attribute attr) {
        if(attr.isDisabled()
                || !URL_PATTERN.matcher(attr.getValue()).matches()) return;

        if(!WHITE_DOMAINS.matcher(attr.getValue()).matches()) {
            attr.setEnabled(false);
        }
    }
}
