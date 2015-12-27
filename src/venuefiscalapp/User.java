
package venuefiscalapp;

import java.util.Objects;

/**
 * This User class is the basis for how one logs into the software.
 * It stores a username, password, and email all inside a User object. It has methods
 * on returning these properties from the User object, and a method to search through
 * the faux database to see if the user exists.
 * 
 * @author Andy
 */
public class User {
    
    private String username;
    private String password;
    private String email;
    private User user;
    private String name;


    /**
     *
     * @param username
     * @param password
     * @param email
     * @param name
     */
    public User(String username, String password, String email, String name) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
    }
    
    /**
     * 
     * @param inputUser
     * @param inputPassword
     */
    public User(String inputUser, String inputPassword){
        this.username = inputUser;
        this.password = inputPassword;
    }

    /**
     * Returns the String username attached to the user object in the
     * user database.
     * 
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username attached to the user object, if the entry is null
     * or empty, throws an exception.
     * 
     * @param username the username to set
     * @throws IllegalUserInfoException  
     */
    public void setUsername(String username) throws IllegalUserInfoException {
        if (username == null || username.length() < 4){
            throw new IllegalUserInfoException();
        }
        this.username = username;
    }

    /**
     * Returns the string password attached to username and user object
     * 
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the User password if the entry isn't empty or null; otherwise
     * throws an exception
     * 
     * @param password the password to set
     * @throws IllegalUserInfoException  
     */
    public void setPassword(String password) throws IllegalUserInfoException {
        if (password == null || password.length() < 4){
            throw new IllegalUserInfoException();
        }
        this.password = password;
    }

    /**
     * Returns email attached to the User object.
     * 
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email for the User object if it is not null or empty, otherwise
     * throws an exception.
     * 
     * @param email the email to set
     * @throws IllegalUserInfoException  
     */
    public void setEmail(String email) throws IllegalUserInfoException {
        if (email == null || email.length() < 4){
            throw new IllegalUserInfoException();
        }
        this.email = email;
    }

    /**
     * Runs the UserLoginDatabase method to search for the User passing
     * in both the username and password. Returns the object if it is found.
     * 
     * @return the user
     * @throws IllegalUserInfoException  
     */
    public User getUser() throws IllegalUserInfoException {
        UserLoginDatabase uld = new UserLoginDatabase();
        return uld.searchForUser(username, password);
    }

    /**
     * Allows User to be set, as long as the entry isn't null, otherwise
     * it throws an exception.
     * 
     * @param user the user to set
     * @throws IllegalUserInfoException  
     */
    public void setUser(User user) throws IllegalUserInfoException {
        if (user == null){
            throw new IllegalUserInfoException();
        }
        this.user = user;
    }
    
    
    /**
     * Method that returns the persons Name attached to the User object
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Can be used to manually set the persons Name for a User object.
     * Throws exception if input is not valid.
     * 
     * @param name the name to set
     * @throws IllegalUserInfoException  
     */
    public void setName(String name) throws IllegalUserInfoException {
        if (name == null || name.length() < 3){
            throw new IllegalUserInfoException();
        }
        this.name = name;
    }

    
    
    
    /**
     * HashCode method that checks on username AND email, so they both can not be
     * the same
     * 
     * @return hash
     */
    @Override
    public final int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.username);
        hash = 17 * hash + Objects.hashCode(this.email);
        return hash;
    }
    
    /**
     * Equals method that checks on username AND email, so they both can not be
     * the same
     * 
     * @param obj
     * @return boolean
     */
    @Override
    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    /**
     * Overridden toString() method that returns all information belonging to User
     * and User information.
     * 
     * @return toString();
     */
    @Override
    public String toString() {
        return "User{" + "username=" + username 
                + ", password=" + password + ", email="
                + email + ", user=" + user + '}';
    }
}
