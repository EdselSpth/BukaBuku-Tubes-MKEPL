package com.mycompany.account;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class AdminTest {
    private final InputStream standardIn = System.in;
    private ByteArrayInputStream testIn;
    private Admin admin;

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
        provideInput("Admin123\nAdmin123\n");
        admin = new Admin();
        assertTrue(admin.loginValidation(), "Login seharusnya berhasil untuk kredensial yang valid");
    }

    @Test
    public void testLoginValidation_Failure() {
        provideInput("SalahUsername\nSalahPassword\n");
        admin = new Admin();
        assertFalse(admin.loginValidation(), "Login seharusnya gagal untuk kredensial yang tidak terdaftar");
    }

    @Test
    public void testLoginValidation_WrongPassword() {
        provideInput("SelametKopling\nPasswordSalah\n");
        admin = new Admin();
        assertFalse(admin.loginValidation(), "Login seharusnya gagal untuk password yang salah");
    }

    @Test
    public void testMenuInside_InvalidPasswordThrowsException() {
        admin = new Admin();
        Exception exception = assertThrows(Exception.class, () -> {
            admin.menuInside(false);
        });
        assertEquals("Username atau Password Salah", exception.getMessage());
    }

    @Test
    public void testMenuInside_SuccessAndExit() {
        provideInput("4\n");
        admin = new Admin();
        admin.username = "Admin123";
        assertDoesNotThrow(() -> {
            admin.menuInside(true);
        });
    }
}