package com.mycompany.sistem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CommentTest {

    @Test
    public void testGetComment() {
        Comment comment = new Comment("Buku bagus!", "Senin, 01 Juni 2026");
        assertEquals("Buku bagus!", comment.getComment());
    }

    @Test
    public void testGetTanggal() {
        Comment comment = new Comment("Buku bagus!", "Senin, 01 Juni 2026");
        assertEquals("Senin, 01 Juni 2026", comment.getTanggal());
    }

    @Test
    public void testConstructorNotNull() {
        Comment comment = new Comment("Oke", "01-06-2026");
        assertNotNull(comment);
    }
}