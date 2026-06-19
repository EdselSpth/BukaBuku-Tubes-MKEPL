package com.mycompany.account;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    public void testGetUsername() {
        Account account = new Account("User123", "Password123");
        assertEquals("User123", account.getUsername());
    }

    @Test
    public void testGetPassword() {
        Account account = new Account("User123", "Password123");
        assertEquals("Password123", account.getPassword());
    }

    @Test
    public void testConstructor() {
        Account account = new Account("TestUser", "TestPass");
        assertNotNull(account);
    }
}