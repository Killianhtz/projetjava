package model;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExampleTest {
	
    private Example Element;
	
    /**
     * Instantiation
     * @throws Exception
     */
    
    @Before
    public void setUp() throws Exception {
        Element = new Example("O",0,11);
     
    }

    @After
    public void tearDown() throws Exception {
    }
     
    
    /**
     * test if we get the right element
     */
    
    @Test
    public void testGetElement() {
        final String expected = "O";
       
        assertEquals(expected, this.Element.getElement());
         
    }
    
    /**
     * test if we get the right coordinate X
     */

    @Test
    public void testGetX() {
        final int expected = 0;
        assertEquals(expected, this.Element.getX());
        
    }
    
    
    /**
     * test if we get the right coordinate Y
     */

    @Test
    public void testGetY() {
        final int expected = 11;
        assertEquals(expected, this.Element.getY()); 
    }
    
    /**
     * test if the element is right set
     */
    
   
    @Test
    public void testSetElement() {
        String expected = "O";
        assertEquals(expected, this.Element.getElement());
        expected = "O";
        this.Element.setElement(expected);
        assertEquals(expected, this.Element.getElement());
        
     /**
      * tests whether the ToString function returns the correct values   
      */
        
    }

    @Test
    public void testToString() {
        final String expected = "O;0;11";
        assertEquals(expected, this.Element.toString());
       
    }
    
   

}
