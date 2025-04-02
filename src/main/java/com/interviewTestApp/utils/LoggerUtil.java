package com.interviewTestApp.utils;

import io.qameta.allure.Attachment;

public class LoggerUtil {
    @Attachment(value = "{0}", type = "text/plain")
    public static String attachTextLog(String message) {
        return message;
    }
}
