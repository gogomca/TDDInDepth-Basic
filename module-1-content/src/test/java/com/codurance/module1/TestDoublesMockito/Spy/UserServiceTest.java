package com.codurance.module1.TestDoublesMockito.Spy;

import com.codurance.module1.TestDoubles.Spy.EmailSender;
import com.codurance.module1.TestDoubles.Spy.UserService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class UserServiceTest {
    /**
     * We want to verify that an email is sent when a new user registers.
     */
    @Test
    public void send_welcome_email_after_a_user_creates_an_account() {
        EmailSender emailSender = mock(EmailSender.class);
        UserService userService = new UserService(emailSender);

        userService.registerUser("test@example.com");

        verify(emailSender).sendEmail("test@example.com", "Welcome!");
    }

}