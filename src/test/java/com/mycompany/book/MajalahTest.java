package com.mycompany.book;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MajalahTest {

    @Test
    public void testGetJenisMajalah() {
        Majalah majalah = new Majalah("MJL001", "Chips", "Teknologi", "Dedy Irvan", "Chips Company", 90000, 2007, 9.5);
        assertEquals("Teknologi", majalah.getJenisMajalah());
    }

    @Test
    public void testSetJenisMajalah() {
        Majalah majalah = new Majalah("MJL001", "Chips", "Teknologi", "Dedy Irvan", "Chips Company", 90000, 2007, 9.5);
        majalah.setJenisMajalah("Fashion");
        assertEquals("Fashion", majalah.getJenisMajalah());
    }

    @Test
    public void testHarga() {
        Majalah majalah = new Majalah("MJL001", "Chips", "Teknologi", "Dedy Irvan", "Chips Company", 90000, 2007, 9.5);
        assertEquals(90000, majalah.harga());
    }

    @Test
    public void testGetKategori() {
        Majalah majalah = new Majalah("MJL001", "Chips", "Teknologi", "Dedy Irvan", "Chips Company", 90000, 2007, 9.5);
        assertEquals("Majalah", majalah.getKategori());
    }
}