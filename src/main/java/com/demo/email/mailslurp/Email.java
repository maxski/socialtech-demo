package com.demo.email.mailslurp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Deserialized email from inbox
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Email {

    public String id;
}
