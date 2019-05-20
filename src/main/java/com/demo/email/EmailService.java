package com.demo.email;

/**
 * Define work with EmailService
 */
public interface EmailService {

    /**
     * Create instant email inbox
     * @return String, email
     */
    String create();

    /**
     * Check email inbox and get letter content body
     * @return, String, email content body
     */
    String getEmailContent();

}
