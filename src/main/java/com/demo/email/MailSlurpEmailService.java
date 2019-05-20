package com.demo.email;


import com.demo.email.mailslurp.Email;
import com.demo.email.mailslurp.EmailContent;
import com.demo.email.mailslurp.Inbox;
import com.demo.pages.AppProperties;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.sleep;
import static io.restassured.RestAssured.given;


/**
 * EmailService implementation by MailSlurp instant email service
 * Details: https://docs.mailslurp.com/
 */
public class MailSlurpEmailService implements EmailService {

    Inbox inbox;
    RequestSpecification requestSpecification;
    AppProperties props;

    public MailSlurpEmailService(AppProperties props) {
        this.props = props;
        initRequestSpecification();
    }

    @Override
    public String create() {
        if (inbox == null) {
            inbox = requestSpecification.post("/inboxes").as(Inbox.class);
            Assert.assertNotNull(inbox.emailAddress, "No inbox created");
        }
        return inbox.emailAddress;
    }


    @Override
    public String getEmailContent() {
        String emailContent;
        List<Email> list = getEmails();
        String path = "/emails/" + list.get(0).id;

        emailContent = requestSpecification.get(path).as(EmailContent.class).body;
        Assert.assertFalse(emailContent == null
                , "No appropriate email content body");

        return emailContent;
    }

    /**
     * Get emails from inbox
     * @return List, emails list
     */
    private List<Email> getEmails() {
        List<Email> list = new ArrayList<>();
        String path = "/inboxes/" + inbox.id + "/emails";

        for (int i = 0; i < 30; i++) {
            list = Arrays.asList(requestSpecification.get(path).as(Email[].class));
            if (!list.isEmpty()) break;
            sleep(1000);
        }

        Assert.assertFalse(list.isEmpty(), "No email received");
        return list;
    }

    private void initRequestSpecification() {
        requestSpecification = given()
                .relaxedHTTPSValidation()
                .baseUri(props.emailBaseUrl())
                .header(props.emailAuthParam(), props.emailAuthValue())
                .log().uri();

        if (props.proxy() != null) {
            requestSpecification.proxy(props.proxy());
        }
    }
}
