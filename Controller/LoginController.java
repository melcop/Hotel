package Controller;

import Models.User;
import Database.ManagerConnection;
import javax.swing.JOptionPane;
import View.GUI;
import view.LoginGUI;

/**
 *
 * @author Mikkel
 */
public class LoginController {

    private String username;
    private String password;
    private ManagerConnection managerConnection;
    private LoginGUI loginGUI;

    /**
     *
     * @param handler
     * @param loginGUI
     */
    public LoginController(ManagerConnection handler, LoginGUI loginGUI) {
        this.managerConnection = handler;
        this.loginGUI = loginGUI;
    }

    /**
     *
     * @param username
     * @param password
     */
    public void handleLogin(String username, String password) {
        this.username = username;
        this.password = password;
       // her kalder den på getUser() metoden fra managerConnection klassen
        User user = managerConnection.getUser(username, password);
        if (user == null) {
            JOptionPane.showMessageDialog(null, " forkert brugernavn/ password");
        } else {
            loginGUI.dispose();
            GUI gui = new GUI();
            gui.setVisible(true);
            
           
        } 
    }
}
