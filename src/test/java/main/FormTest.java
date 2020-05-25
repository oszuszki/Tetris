package main;

import Tetris.Form;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormTest {

    Form testform = new Form(4);

    @BeforeEach
    void setUp() {

        System.out.println("Before Test: OK");
    }

    @Test
    void testGetName() {
        assertEquals(null, testform.getName());
        System.out.println("TestGetName Test: OK");
    }

    @Test
    void testChangeFormT() {
        assertEquals(2, testform.changeFormT());
    }


}