package com.hui.client.service;

import com.hui.utils.CommUtil;
import com.hui.vo.MessageVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CreateGroupGUI {
    private JPanel createGroupPanel;
    private JPanel friendLabelPanel;
    private JTextField groupNameText;
    private JButton conformBtn;

    private String myName;
    private Set<String> friends;
    private Connect2Server connect2Server;
    private FriendList friendList;

    public CreateGroupGUI(String myName,
                          Set<String> friends,
                          Connect2Server connect2Server,
                          FriendList friendList){
        this.myName = myName;
        this.friends = friends;
        this.connect2Server = connect2Server;
        this.friendList = friendList;
        JFrame frame = new JFrame("创建群组");
        frame.setContentPane(createGroupPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        friendLabelPanel.setLayout(new BoxLayout(friendLabelPanel,BoxLayout.Y_AXIS));
        Iterator<String> iterator = friends.iterator();
        while(iterator.hasNext()){
            String labelName = iterator.next();
            JCheckBox checkBox = new JCheckBox(labelName);
            friendLabelPanel.add(checkBox);
        }

        // 点击提交按钮提交信息到服务端
        conformBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 1.判断哪些好友选中加入群聊
                Set<String> selectedFriends = new HashSet<>();
                Component[] comps = friendLabelPanel.getComponents();
                for (Component comp : comps) {
                    JCheckBox checkBox = (JCheckBox) comp;
                    if (checkBox.isSelected()) {
                        String labelName = checkBox.getText();
                        selectedFriends.add(labelName);
                    }
                }
                selectedFriends.add(myName);
                // 2.获取群名输入框输入的群名称
                String groupName = groupNameText.getText();
                // 3.将群名+选中好友信息发送到服务端
                // type:3
                // content:groupName
                // to:[user1,user2,user3...]
                MessageVO messageVO = new MessageVO();
                messageVO.setType("3");
                messageVO.setContent(groupName);
                messageVO.setTo(CommUtil.object2Json(selectedFriends));
                try {
                    PrintStream out = new PrintStream(connect2Server.getOut(),
                            true,"UTF-8");
                    out.println(CommUtil.object2Json(messageVO));
                } catch (UnsupportedEncodingException ex) {
                    ex.printStackTrace();
                }
                // 4.将当前创建群界面隐藏,刷新好友列表界面的群列表
                frame.setVisible(false);
                // addGroupInfo
                // loadGroup
                friendList.addGroup(groupName,selectedFriends);
                friendList.loadGroupList();
            }
        });
    }
}
