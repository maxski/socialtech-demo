package com.demo.email.mailslurp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Deserialized email details
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmailContent {

    public String subject;
    public String body;
}
