package com.interviewTestApp.utils;

import org.aeonbits.owner.Config;

@Config.Sources(value = "classpath:config.properties")
public interface FrameworkConfig extends Config {

    @Key("base.url")
    String baseUrl();

}
