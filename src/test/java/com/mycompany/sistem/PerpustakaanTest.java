package com.mycompany.sistem;

import com.mycompany.book.Novel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PerpustakaanTest {

    private Perpustakaan perpus;
    private Novel novel;

    @BeforeEach
    public void setUp() {
        perpus = new Perpustakaan();
        novel = new Novel("N001", "Harry Potter", "Fantasi", "J.K. Rowling", "Gramedia", 100000, 1997, 4.9);
    }

    @Test
    public void testTambahBuku() {
        perpus.tambahBuku(0, novel);
        assertEquals(1, perpus.koleksiBuku.size());
    }

    @Test
    public void testHapusBuku_Success() throws Exception {
        perpus.tambahBuku(0, novel);
        perpus.hapusBuku(0);
        assertEquals(0, perpus.koleksiBuku.size());
    }

    @Test
    public void testHapusBuku_IndexTidakValid() {
        assertThrows(Exception.class, () -> perpus.hapusBuku(99));
    }

    @Test
    public void testCariBuku_Ketemu() {
        perpus.tambahBuku(0, novel);
        assertEquals(0, perpus.cariBuku("Harry Potter"));
    }

    @Test
    public void testCariBuku_TidakKetemu() {
        assertEquals(-1, perpus.cariBuku("Buku Tidak Ada"));
    }
}