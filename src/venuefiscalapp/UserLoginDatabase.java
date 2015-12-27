
package venuefiscalapp;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Faux database class that instantiates User objects, where they are added to a
 * Set (so none could be duplicated) and it then can be searched through and return
 * the User object based on the passed in criteria.
 * 
 * @author Andy
 */
public class UserLoginDatabase {
    
    private User username;
    private String ADMIN = "admin";
    private String ADMIN_PASS = "java";
    private String ADMIN_EMAIL = "amgunn1@hotmail";
    private String ADMIN_NAME = "Administrator";
            
    
    private User admin = new User(ADMIN, ADMIN_PASS, ADMIN_EMAIL, ADMIN_NAME);
    
    /**
     * Takes the users input password and username and checks to see if the username
     * and password both match. Has to have password match the usernames password
     * in the file. Throws exception if after searching, the entry comes back null.
     * 
     * @param inputUser
     * @param inputPassword
     * @return username
     * @throws IllegalUserInfoException  
     */
    public User searchForUser(String inputUser, String inputPassword) throws IllegalUserInfoException{
        Set<User> userSet = new HashSet<>();
        userSet.add(admin);

        username = null;

        for (User u: userSet){
            if (inputUser.equals(u.getUsername()) && inputPassword.equals(u.getPassword())){
                setUsername(u);
            } else if (username == null){
                throw new IllegalUserInfoException();
            }
        }
        return username;
    }
    
    /**
     * Returns the User object where the username and password, among other
     * information is stored.
     * 
     * @return the user
     */
    public User getUsername() {
        return username;
    }

    /**
     * Sets the username object 
     * 
     * @param user the user to set
     * @throws IllegalUserInfoException  
     */
    public void setUsername(User user) throws IllegalUserInfoException {
        if (user == null){
            throw new IllegalUserInfoException();
        }
        this.username = user;
    }
    
    /**
     * 
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.username);
        return hash;
    }

    /**
     * 
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserLoginDatabase other = (UserLoginDatabase) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "UserLoginDatabase{" + "username=" + username
                + ", ADMIN=" + ADMIN + ", ADMIN_PASS=" + ADMIN_PASS
                + ", ADMIN_EMAIL=" + ADMIN_EMAIL + ", ADMIN_NAME="
                + ADMIN_NAME + ", admin=" + admin + '}';
    }
    
    
}
