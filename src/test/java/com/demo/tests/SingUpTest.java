package com.demo.tests;

import com.demo.email.ConfirmEmail;
import com.demo.email.EmailService;
import com.demo.email.MailSlurpEmailService;
import com.demo.pages.account.ProfilePage;
import com.demo.pages.auth.SignUpPage;
import com.demo.pages.main.HeaderPage;
import com.demo.pages.auth.SignInPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Tests for verifying Sing Up scenarios
 */
public class SingUpTest extends BaseTest {

    EmailService emailService;

    @DataProvider(name = "email")
    Object[][] getEmailData() {
        emailService = new MailSlurpEmailService(props);

        String email = emailService.create();
        String name = email.substring(0, email.indexOf("@"));

        return new Object[][]{
                {name, email, "1234asdASD"}
        };

    }

    @Test(dataProvider = "email", description = "Sing Up using confirmation letter")
    public void singUp(String name, String email, String password) {

        driver.openUrl(props.appUrl());

        HeaderPage headerPage = new HeaderPage();
        SignInPage signInPage = headerPage.clickSignIn();
        SignUpPage signUpPage = signInPage.clickSingUp();

        signUpPage.typeName(name)
                .typeEmail(email)
                .typePassword(password);
        ProfilePage profilePage = signUpPage.clickSignUp();
        profilePage.awaitConfirmation();

        ConfirmEmail confirmEmail = new ConfirmEmail(emailService.getEmailContent());
        driver.openUrl(confirmEmail.getConfirmRegistrationLink());

        profilePage = new ProfilePage();
        Assert.assertEquals(email, profilePage.getEmailText(), "Email displayed incorrectly");
    }

}
