/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.me.mvc.excecoes;

import javax.servlet.ServletException;

/**
 *
 * @author Di-notbook4
 */
public class ActionMvcException extends ServletException {

    public ActionMvcException(String message) {
        super(message);
    }
    
    public ActionMvcException(String message, Throwable rootCause) {
        super(message, rootCause);
    }

   
}
