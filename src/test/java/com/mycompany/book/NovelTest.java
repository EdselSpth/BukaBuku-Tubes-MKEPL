package com.mycompany.book;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NovelTest {

    @Test
    public void testGetGenre() {
        Novel novel = new Novel("N001", "Harry Potter", "Fantasi", "J.K. Rowling", "Gramedia", 100000, 1997, 4.9);
        assertEquals("Fantasi", novel.getGenre());
    }

    @Test
    public void testSetGenre() {
        Novel novel = new Novel("N001", "Harry Potter", "Fantasi", "J.K. Rowling", "Gramedia", 100000, 1997, 4.9);
        novel.setGenre("Petualangan");
        assertEquals("Petualangan", novel.getGenre());
    }

    @Test
    public void testHarga() {
        Novel novel = new Novel("N001", "Harry Potter", "Fantasi", "J.K. Rowling", "Gramedia", 100000, 1997, 4.9);
        assertEquals(100000, novel.harga());
    }

    @Test
    public void testGetKategori() {
        Novel novel = new Novel("N001", "Harry Potter", "Fantasi", "J.K. Rowling", "Gramedia", 100000, 1997, 4.9);
        assertEquals("Novel", novel.getKategori());
    }
}