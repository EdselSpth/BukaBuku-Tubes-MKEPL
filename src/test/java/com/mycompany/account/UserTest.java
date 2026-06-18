package com.mycompany.account;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class UserTest {
    private final InputStream standardIn = System.in;
    private ByteArrayInputStream testIn;
    private User user;

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @AfterEach
    public void tearDown() {
        System.setIn(standardIn);
    }

    @Test
    public void testLoginValidation_Success() {
        provideInput("User123\nUser123\n");
        user = new User();
        assertTrue(user.loginValidation(), "Login seharusnya berhasil untuk kredensial yang valid");
    }

    @Test
    public void testLoginValidation_Failure() {
        provideInput("SalahUsername\nSalahPassword\n");
        user = new User();
        assertFalse(user.loginValidation(), "Login seharusnya gagal untuk kredensial yang tidak terdaftar");
    }

    @Test
    public void testLoginValidation_WrongPassword() {
        provideInput("User123\nPasswordSalah\n");
        user = new User();
        assertFalse(user.loginValidation(), "Login seharusnya gagal untuk password yang salah");
    }

    @Test
    public void testMenuInside_InvalidPasswordThrowsException() {
        user = new User();
        assertDoesNotThrow(() -> {
            user.menuInside(false);
        });
    }

    @Test
    public void testMenuInside_SuccessAndExit() {
        provideInput("5\n");
        user = new User();
        user.username = "User123";
        assertDoesNotThrow(() -> {
            user.menuInside(true);
        });
    }
}