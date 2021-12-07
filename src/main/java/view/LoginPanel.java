package view;

import cn.hutool.core.util.StrUtil;
import controller.LoginController;
import controller.ActionController;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends AbstractPanel {

    private JLabel stuIdLabel = new JLabel("Student ID:");
    private JLabel stuPwdLabel = new JLabel("Password:");
    private JTextField stuIdText = new JTextField();
    private JPasswordField stuPwdText = new JPasswordField();
    private JButton loginBtn = new JButton("Login");

    private ActionController actionController;

    private LoginController loginController;

    public LoginPanel(ActionController actionController) {
        this.actionController = actionController;
        this.actionController.attach("login", this);
        init();
    }


    private void init() {
        // set panel view
        this.setSize(400, 300);
        this.setLayout(null);

        // set studentID label and fieldtext
        stuIdLabel.setBounds(200, 100, 100, 30);
        this.add(stuIdLabel, BorderLayout.CENTER);
        stuIdText.setBounds(400, 100, 200, 30);
        this.add(stuIdText, BorderLayout.CENTER);

        // set student password label and textfield
        stuPwdLabel.setBounds(200, 150, 100, 30);
        this.add(stuPwdLabel, BorderLayout.CENTER);
        stuPwdText.setBounds(400, 150, 200, 30);
        this.add(stuPwdText);

        //set login button
        loginBtn.setBounds(400, 200, 100, 30);
        this.add(loginBtn);

        // command and action
        loginBtn.setActionCommand("login:login");
        //add action listener to the button
        loginBtn.addActionListener(actionController);

    }

    @Override
    public void doAction(String command) {
        // do the command requested
        System.out.println("login panel do " + command + " command");
        switch (command) {
            case "login":
                doLogin();
                break;
            default:
                break;
        }
    }
    //call the Controller to do  the request
    private void doLogin() {
        String ret = loginController.doLogin(stuIdText.getText(), new String(stuPwdText.getPassword()));
        //if the error msg returned is blank,student login in successfully
        if (StrUtil.isBlank(ret)) {
            actionController.switchView("course");
        } else {
            JOptionPane.showMessageDialog(this, ret,
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public LoginController getLoginController() {
        return loginController;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

}
