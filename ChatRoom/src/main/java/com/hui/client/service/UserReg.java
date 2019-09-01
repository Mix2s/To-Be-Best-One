package com.hui.client.service;

import com.hui.client.dao.AccountDao;
import com.hui.client.po.User;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class UserReg {
    private JPanel regPanel;
    private JTextField userNameText;
    private JPasswordField passwordText;
    private JButton confimBtn;

    private AccountDao accountDao  = new AccountDao();

    public UserReg(){
        JFrame frame = new JFrame("用户注册");
        frame.setContentPane(regPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

        confimBtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = userNameText.getText();
                String password = String.valueOf(
                        passwordText.getPassword());

                User user = new User();
                user.setUserName(userName);
                user.setPassword(password);
                if(accountDao.userReg(user)){
                    JOptionPane.showMessageDialog(null,
                            "注册成功","成功信息",JOptionPane.INFORMATION_MESSAGE);
                    frame.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"注册失败",
                    "错误信息",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
