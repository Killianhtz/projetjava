package model;

/**
 * <h1>The Class Example.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class Example {

    /** The type of Element */
    private String Element;

    /** The position x */
    private int X;
    
    /** The position y */
    private int Y;

    /**
     * Instantiates a new example.
     *
     * @param Element        
     * @param X
     * @param Y
     */
    public Example(final String Element, final int X, final int Y) {
        super();
        this.Element = Element;
        this.X = X;
        this.Y = Y;
    }

    /**
     * Gets the Element.
     *
     * @return the Element
     */
    public String getElement() {
        return this.Element;
    }

    /**
     * Gets the position X.
     *
     * @return the position X
     */
    public int getX() {
        return this.X;
    }

    /**
     * Gets the position Y.
     *
     * @return the position Y
     */
    public int getY() {
        return this.Y;
    }

    /**
     * Sets the Element.
     *
     * @param Element
     *            the new Element
     */
    public void setElement(final String Element) {
        this.Element = Element;
    }

    /**
     * Sets the position X.
     *
     * @param X
     *            the new pos X
     */
    public void setX(final int X) {
        this.X = X;
    }

    /**
     * Sets the position Y.
     *
     * @param Y
     *            the new pos Y
     */
    public void setY(final int Y) {
        this.Y = Y;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.getElement() + ";" + this.getX() + ";" + this.getY();
    }
}
