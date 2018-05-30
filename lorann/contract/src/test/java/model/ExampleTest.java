package model;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExampleTest {
    private Example example;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        this.example = new Example("V",0,11);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetElement() {
        final String expected = "V";
        assertEquals(expected, this.example.getElement());
    }

    @Test
    public void testGetX() {
        final int expected = 0;
        assertEquals(expected, this.example.getX());
    }

    @Test
    public void testGetY() {
        final int expected = 11;
        assertEquals(expected, this.example.getY());
    }
    @Test
    public void testSetElement() {
        String expected = "V";
        assertEquals(expected, this.example.getElement());
        expected = "V";
        this.example.setElement(expected);
        assertEquals(expected, this.example.getElement());
    }

    @Test
    public void testToString() {
        final String expected = "1 : Example test";
        assertEquals(expected, this.example.toString());
    }
    
   

}
