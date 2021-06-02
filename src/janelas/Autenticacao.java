package janelas;

import bancodados.model.AdministradorDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Autenticacao {
    private  JFrame frame;
    private JPanel panel;
    private JLabel lblUser;
    private JTextField txtUser;
    private JLabel lblPassWord;
    private JTextField txtPassWord;
    private JButton btnLogar;
    private final int X_LAYOUT = 200;
    private final int Y_LAYOUT = 20;

    public void build(){
        init();
    }

    private void init(){
        frame = new JFrame();
        panel = new JPanel();

        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);

        panel.setLayout(null);

        lblUserInit();
        txtUserInit();
        lblPasswordInit();
        txtPasswordInit();
        btnLogarInit();

    }


    private void lblUserInit(){
        lblUser = new JLabel("Usuário");
        lblUser.setVisible(true);
        lblUser.setBounds(X_LAYOUT, Y_LAYOUT, 50, 30);
        panel.add(lblUser);
    }
    private void txtUserInit(){
        txtUser = new JTextField(20);
        txtUser.setVisible(true);
        txtUser.setBounds(X_LAYOUT - 50, Y_LAYOUT * 3, 150, 25);
        panel.add(txtUser);
    }

    private void lblPasswordInit(){
        lblPassWord = new JLabel("Senha");
        lblPassWord.setVisible(true);
        lblPassWord.setBounds(X_LAYOUT, Y_LAYOUT * 5, 50, 30);
        panel.add(lblPassWord);
    }

    private void txtPasswordInit(){
        txtPassWord = new JTextField(20);
        txtPassWord.setVisible(true);
        txtPassWord.setBounds(X_LAYOUT - 50, Y_LAYOUT * 7, 150, 25);
        panel.add(txtPassWord);
    }

    private void btnLogarInit(){
        AdministradorDAO dao = new AdministradorDAO();
        btnLogar = new JButton("Logar");
        btnLogar.setVisible(true);
        btnLogar.setBounds(X_LAYOUT - 50, Y_LAYOUT * 11, 150, 25);
        btnLogar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        panel.add(btnLogar);
    }


}
