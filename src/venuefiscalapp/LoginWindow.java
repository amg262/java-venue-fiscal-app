
package venuefiscalapp;

import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JOptionPane;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Login GUI that precedes the Garage Main GUI, and its functionality
 * is to have a login system for users to prevent any fraud, illegal use, etc.
 * If the User and pass doesn't match anything in the file, the user will not be
 * allowed into the system.
 * 
 * 
 * Users and Pass for Login System:
 * ------------------------------
 * user: admin
 * pass: java
 *
 * 
 * @author Andy
 */
public class LoginWindow extends javax.swing.JFrame {

    /**
     * Creates new form LoginWindow
     */
    public LoginWindow() {
        initComponents();
        this.setBounds(600, 300, 340, 230); //Setting positions
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "GoonDaddy Industries", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Aharoni", 0, 12))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("User: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Password: ");

        btnLogin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("GDI");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        String inputUser = txtUser.getText();
        String inputPassword = txtPassword.getText();
        final String ERR = "Invalid: User or Pass";
        final String WEL = "Welcome,    ";
        //No magic numbers
        final String LOGIN_WIN_XML = "loginWindowConfig.xml";
        final String MAIN_WIN_BEAN = "mainWindow";
        
        
        
        User u = new User(inputUser, inputPassword);
        
        //Dependency Injection!
        final AbstractApplicationContext context = 
                new ClassPathXmlApplicationContext(new String[] {LOGIN_WIN_XML});
        
        //Both of these eliminate previous hard dependency on concrete classes
        //and can be changed at anytime in the loginWindowConfig
        MainWindow mw = (MainWindow)context.getBean(MAIN_WIN_BEAN);
        
        try {
            //this only runs when User is valid
            JOptionPane.showMessageDialog(rootPane, WEL + u.getUser().getName());
            setVisible(false); //make login window go away
            mw.setVisible(true); //make garage UI appear
            
            
        //Validation
        if (inputUser == null || inputUser.length() == 0){
            throw new IllegalArgumentException();
        }
        if (inputPassword == null || inputPassword.length() == 0){
            throw new IllegalArgumentException();
        }

        //GUIS job to Output
        }catch (NullPointerException npe){
            JOptionPane.showMessageDialog(this, ERR);
        }catch (IllegalArgumentException iae){
            JOptionPane.showMessageDialog(this, ERR);
        }catch (IllegalUserInfoException iuie){
            JOptionPane.showMessageDialog(this, iuie.getMessage(), null, JOptionPane.ERROR_MESSAGE);
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }   
    }//GEN-LAST:event_btnLoginActionPerformed

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "LoginWindow{" + "btnLogin=" + btnLogin + ", jLabel2="
                + jLabel2 + ", jLabel3=" + jLabel3 + ", jPanel1="
                + jPanel1 + ", txtPassword=" + txtPassword + ", txtUser="
                + txtUser + '}';
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
