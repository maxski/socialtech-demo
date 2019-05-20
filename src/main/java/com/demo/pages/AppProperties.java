package com.demo.pages;

import org.aeonbits.owner.Config;

/**
 * Application properties
 */
public interface AppProperties extends Config {

    @Key("app.url")
    @DefaultValue("https://rozetka.com.ua/ua/")
    String appUrl();

    @Key("page.load.timeout")
    @DefaultValue("30000")
    long pageLoadTimeout();

    @Key("proxy")
    String proxy();

    @Key("email.base.url")
    @DefaultValue("https://api.mailslurp.com/")
    String emailBaseUrl();

    @Key("email.auth.param")
    @DefaultValue("x-api-key")
    String emailAuthParam();

    @Key("email.auth.value")
    @DefaultValue("32b39ba9a810e72ebfdd53d6a9d1ef37ce7d6846b224255e1c1968c7adc9d5d9")
    String emailAuthValue();
}
