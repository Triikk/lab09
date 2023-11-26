package it.unibo.mvc;

import java.util.List;

/**
 * This class models a simple controller responsible
 * for I/O access.
 */
public interface Controller {

    /**
     * Set the next string to print
     * @param string the next string to print
     * @throws NullPointerException if the string provided is null
     */
    void setString(String string);

    /**
     * Returns the next string to print
     */
    String getString();

    /**
     * @return a list of the printed strings
    */
    List<String> getPrintedStrings();

    /**
     * Prints the current string
     * @throws IllegalStateException if the current string is unset
     */
    void print();
}
