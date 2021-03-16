/*
* Class name: IllegalStateException
*
* Version info: jdk 1.8
*
* Copyright notice:
* 
* Author info: Arpit Garg
*
* Creation date: 13/Mar/2021
*
* Last updated By: Arpit Garg
*
* Last updated Date: 13/Mar/2021
*
* Description: give description of the Exception
*/
package com.nagarro.customqueueimplementation.exception;

public class IllegalStateException extends RuntimeException{
    private static final String EXCEPTION = "Exception: ";

    /**
     * used to give the error message if any exception occurs
     * 
     * @param exceptionMessage
     */
    public IllegalStateException(String exceptionMessage) {
        System.out.println(EXCEPTION + exceptionMessage);
    }
}
