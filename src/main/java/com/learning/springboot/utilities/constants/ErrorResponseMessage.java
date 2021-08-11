package com.learning.springboot.utilities.constants;

import java.util.Formatter;

public final class ErrorResponseMessage {

    public ErrorResponseMessage() {
    }

    public static final String USER_IS_NOT_EXIST = "The %s that you're trying to find, is not exist in our system";

    public static final String INTERNAL_SERVER_ERROR = "There is an internal server error, please check with the system administrator or developer team";

    public static final String BAD_REQUEST_ERROR = "You made bad request to the server, please check with the system administrator or developer team for further help";

    public static String format(String format, Object... args) {
        return new Formatter().format(format, args).toString();
    }
}
