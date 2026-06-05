package com.mycompany.sistem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookManagementTest {

    private BookManagement bm;

    @BeforeEach
    public void setUp() {
        bm = new BookManagement();
    }

    @Test
    public void testGetBook() {
        assertNotNull(bm.getBook(0));
    }

    @Test
    public void testCariBuku_Ketemu() {
        assertEquals(0, bm.cariBuku("Bungo Stray Dogs"));
    }

    @Test
    public void testCariBuku_TidakKetemu() {
        assertEquals(-1, bm.cariBuku("Buku Tidak Ada"));
    }

    @Test
    public void testJumlahBukuAwal() {
        assertEquals(11, bm.books.size());
    }
}