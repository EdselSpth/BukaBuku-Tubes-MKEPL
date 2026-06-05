package com.mycompany.sistem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReadBookTest {

    @Test
    public void testBacaBuku() {
        ReadBook rb = new ReadBook();
        assertDoesNotThrow(() -> rb.bacaBuku());
    }

    @Test
    public void testSearchBuku() {
        ReadBook rb = new ReadBook();
        assertDoesNotThrow(() -> rb.searchBuku());
    }
}