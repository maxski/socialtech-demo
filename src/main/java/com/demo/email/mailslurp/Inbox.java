package com.demo.email.mailslurp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Deserialized email inbox object
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Inbox {

    public String id;
    public String emailAddress;
}
