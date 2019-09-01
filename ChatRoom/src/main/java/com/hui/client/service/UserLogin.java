package com.hui.client.service;

import com.hui.client.dao.AccountDao;
import com.hui.client.po.User;
import com.hui.utils.CommUtil;
import com.hui.vo.MessageVO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.Set;

public class UserLogin {
    private JPanel loginPanel;
    private JTextField userNameText;
    private JButton regBtn;
    private JButton loginBtn;
    private JPasswordField passwordText;
    private JFrame frame;
    private AccountDao accountDao = new AccountDao();
    public UserLogin(){
        frame = new JFrame("用户登录");
        frame.setContentPane(loginPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        regBtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UserReg();
            }
        });

        loginBtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = userNameText.getText();
                String password = String.valueOf(
                        passwordText.getPassword()
                );
                User user = accountDao.userLogin(userName,password);
                if(user!=null){
                    JOptionPane.showMessageDialog(null,"登录信息",
                    "提示信息",JOptionPane.INFORMATION_MESSAGE);
                    Connect2Server connect2Server = new Connect2Server();
                    MessageVO messageVO = new MessageVO();
                    messageVO.setType("1");
                    messageVO.setTo(userName);
                    String mesJson = CommUtil.object2Json(messageVO);
                    try{
                        PrintStream out = new PrintStream(connect2Server.getOut(),true,"UTF-8");
                        out.println(mesJson);
                        Scanner in = new Scanner(connect2Server.getIn());
                        if(in.hasNextLine()){
                            String jsoStr = in.nextLine();
                            MessageVO mesFromServer = (MessageVO) CommUtil.json2Object(jsoStr,MessageVO.class);
                            Set<String> users = (Set<String>) CommUtil.json2Object(mesFromServer.getContent(),Set.class);
                            System.out.println("在线好友"+users);
                            frame.setVisible(false);
                            new FriendList(userName,users,connect2Server);
                        }
                    }catch (UnsupportedEncodingException ex){
                        ex.printStackTrace();
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"登录失败",
                    "错误信息",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
