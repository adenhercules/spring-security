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
public class DAOException extends Exception {

    /**
     * Creates a new instance of <code>DAOException</code> without detail
     * message.
     */
    public DAOException() {
    }

    /**
     * Constructs an instance of <code>DAOException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public DAOException(String msg) {
        super(msg);
    }
}