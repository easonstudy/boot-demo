package com.guo.bootcanal.web;

import org.apache.commons.lang.exception.NestableRuntimeException;

public class TestException extends NestableRuntimeException {

    public TestException() {
    }

    public TestException(String errorCode) {
        super(errorCode);
    }

    public TestException(String var1, String var2) {
        super(var1 + ":" + var2);
    }

    public TestException(Throwable cause) {
        super(cause);
    }

    public TestException(String errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    public TestException(String var1, String var2, Throwable cause) {
        super(var1 + ":" + var2, cause);
    }

}
