
package venuefiscalapp;

/**
 * Custom exception for user info. This covers all user info, so if something
 * is entered that is deemed incorrect, this will be throw.
 * 
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
public class IllegalUserInfoException extends Exception {

    //No magic numbers
    private static final String ERR = "Invalid: User information";

    /**
     *
     */
    public IllegalUserInfoException() {
        super(ERR);
    }

    /**
     *
     * @param ERR
     */
    public IllegalUserInfoException(String ERR) {
        super(ERR);
    }

    /**
     *
     * @param ERR
     * @param thrwbl
     */
    public IllegalUserInfoException(String ERR, Throwable thrwbl) {
        super(ERR, thrwbl);
    }

    /**
     *
     * @param thrwbl
     */
    public IllegalUserInfoException(Throwable thrwbl) {
        super(thrwbl);
    }
    
    
}
