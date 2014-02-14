/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rav.ws;

import javax.xml.ws.WebFault;

/**
 *
 * @author ravindu
 */
@WebFault(name = "TabonaException")
public class TsmsException extends Exception {

    private static final long serialVersionUID = -6647544772732631047L;
    private MyServiceFault fault;
    private String message;

    public TsmsException() {
    }

//    public TabonaException(String message) {
//        super(message);
//        super.setStackTrace(null);
//        this.message = message;
//    }
    public TsmsException(MyServiceFault fault) {
        super(fault.getFaultString());
        this.fault = fault;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return message;
    }

    public TsmsException(String message, MyServiceFault faultInfo) {
        super(message);
        this.fault = faultInfo;
    }

    /**
     * * * @param message
     * @param faultInfo
     * @param cause
     */
    public TsmsException(String message, MyServiceFault faultInfo, Throwable cause) {
        super(message, cause);
        this.fault = faultInfo;
    }

    /**
     * * * @return
     */
    public MyServiceFault getFaultInfo() {
        return fault;
    }

    /**
     * * @param message
     */
    public TsmsException(String message) {
        super(message); 
    }
}
