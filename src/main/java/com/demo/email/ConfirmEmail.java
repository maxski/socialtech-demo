package com.demo.email;

import io.restassured.path.xml.XmlPath;

/**
 * Class describes actions with confirmation email
 */
public class ConfirmEmail {

    private String contentBody;

    public ConfirmEmail(String body) {
        contentBody = body;
    }

    /**
     * Get confirm registration link from email
     * @return String
     */
    public String getConfirmRegistrationLink() {
        return new XmlPath(XmlPath.CompatibilityMode.HTML, contentBody)
                .get("**.findAll { it.@href =~ 'authorize' }.@href");
    }
}
