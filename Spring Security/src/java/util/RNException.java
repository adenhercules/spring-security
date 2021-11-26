/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author AdenH
 */
public class RNException extends Exception {

    /**
     * Creates a new instance of <code>RNException</code> without detail
     * message.
     */
    public RNException() {
    }

    /**
     * Constructs an instance of <code>RNException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public RNException(String msg) {
        super(msg);
    }
}
