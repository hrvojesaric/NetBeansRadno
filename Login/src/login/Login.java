/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

/**
 *
 * @author Dino
 */

public class Login extends JFrame
{
    JLabel pageTitle, emailLabel, passwordLabel;
    JTextField emailInput;
    JButton btn1;
    JPasswordField passwordInput;

    Login()
    {
        setTitle("Login");
        setVisible(true);
        setSize(800, 800);
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pageTitle = new JLabel("Login");
        pageTitle.setForeground(Color.blue);
        pageTitle.setFont(new Font("Serif", Font.BOLD, 20));

        emailLabel = new JLabel("Enter Email:");
        passwordLabel = new JLabel("Enter Password:");
        emailInput = new JTextField();
        passwordInput = new JPasswordField();
        btn1 = new JButton("Submit");

        pageTitle.setBounds(100, 30, 400, 30);
        emailLabel.setBounds(80, 70, 200, 30);
        passwordLabel.setBounds(80, 110, 200, 30);
        emailInput.setBounds(300, 70, 200, 30);
        passwordInput.setBounds(300, 110, 200, 30);
        btn1.setBounds(150, 160, 100, 30);

        add(pageTitle);
        add(emailLabel);
        add(emailInput);
        add(passwordLabel);
        add(passwordInput);
        add(btn1);
       // btn1.addActionListener(this);
        btn1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                    doLogin();
                    System.out.println("BTN KLIK1");
            }
        });
    }

    
    public void doLogin(){
        System.out.println("LOGIN");
        String str1 = emailInput.getText();
        String password = new String(this.passwordInput.getPassword());
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        // validacija
        
        // 
        System.out.println("Email:" + str1);
        System.out.println("Password:" +password);
        System.out.println("Password hashed:" +hashed);
    }

}
