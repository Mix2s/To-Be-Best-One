package com.hui.client.service;

import javax.swing.*;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: yuisama
 * @Date: 2019-08-17 11:53
 * @Description:
 */
public class FriendList {
    private JPanel friendListPanel;
    private JScrollPane friendPanel;
    private JButton createGroupBtn;
    private JScrollPane groupPanel;
    private String myName;
    private Connect2Server connect2Server;
    private Set<String> names;

    private class DaemonTask implements Runnable {
        private Scanner scanner = new Scanner(connect2Server.getIn());
        @Override
        public void run() {
            while (true) {
                if (scanner.hasNextLine()) {
                    String strFromServer = scanner.nextLine();
                    if (strFromServer.startsWith("newLogin:")){
                        // 好友上线提醒
                        String newFriend = strFromServer.split(":")[1];
                        JOptionPane.showMessageDialog(null,
                                newFriend+"上线了!","上线提醒",
                                JOptionPane.INFORMATION_MESSAGE);
                        names.add(newFriend);
                        // 再次刷新好友列表
                        reloadFriendList();
                    }
                }
            }
        }
    }

    public FriendList(String myName,
                      Connect2Server connect2Server,
                      Set<String> names) {
        this.myName = myName;
        this.connect2Server = connect2Server;
        this.names = names;
        JFrame frame = new JFrame(myName);
        frame.setContentPane(friendListPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        reloadFriendList();
        // 新启动一个后台线程不断监听服务器发来的信息
        Thread daemonThread = new Thread(new DaemonTask());
        daemonThread.setDaemon(true);
        daemonThread.start();
    }

    public void reloadFriendList() {
        JPanel friendLabelPanel = new JPanel();
        JLabel[] labels = new JLabel [names.size()];
        // 迭代遍历set集合
        Iterator<String> iterator = names.iterator();
        // 设置标签为纵向对其
        friendLabelPanel.setLayout(new BoxLayout(friendLabelPanel,
                BoxLayout.Y_AXIS));
        int i = 0;
        while (iterator.hasNext()) {
            String labelName = iterator.next();
            labels [i] = new JLabel(labelName);
            friendLabelPanel.add(labels[i]);
            i++;
        }
        this.friendPanel.setViewportView(friendLabelPanel);
        // 设置滚动条为垂直滚动条
        this.friendPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.friendPanel.revalidate();
    }
}
