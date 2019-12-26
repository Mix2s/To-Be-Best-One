package com.hui;

import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.*;
import java.util.regex.*;

public class text3{
    public static void main(String args[]){
        EditWindow win=new EditWindow();
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
class EditWindow extends JFrame implements ActionListener{
    JFileChooser filechooser = new JFileChooser();      //文件选择器
    JMenuBar menubar;
    JPopupMenu mouseMenu;
    JMenu menu1,menu2,menu3,menu4;
    JMenuItem itemNew,itemNewWindow,itemSave,itemSaveAs,itemPrinting,
            itemPageSetup,itemCut,itemCopy,itemPaste,itemFind,itemReplace,itemOpen,
            itemFontFormat,itemAbout,mouseCut,mouseCopy,mousePaste,mouseDelet,mouseAll;
    JTextArea text1;
    EditWindow(){
        setTitle("简单文本编译器");
        setSize(500,570);
        setLocation(120,120);
        setVisible(true);
        /*
         * 菜单栏设置：
         * 1.文件
         *   ①新建
         *   ②新窗口
         *   ③打开
         *   ④保存
         *   ⑤另存为
         *   ⑥打印
         * 2.编辑
         *   ①剪切
         *   ②复制
         *   ③粘贴
         *   ④查找
         *   ⑤替换
         * 3.格式
         *   ①字体格式
         *
         * 4.帮助
         * ①关于
         */
        //文件菜单设置
        menubar=new JMenuBar();
        menu1=new JMenu("文件（F）");menu1.setMnemonic('F');
        menu2=new JMenu("编辑（E）");menu2.setMnemonic('E');
        menu3=new JMenu("格式（O）");menu3.setMnemonic('O');
        menu4=new JMenu("帮助（H）");menu4.setMnemonic('H');
        //文件
        itemNew=new JMenuItem("新建（N）              Ctrl+N");itemNewWindow=new JMenuItem("新窗口（W）         Ctrl+W");
        itemOpen=new JMenuItem("打开（O）              Ctrl+O");itemSave=new JMenuItem("保存（S）               Ctrl+S");
        itemSaveAs=new JMenuItem("另存为（E）           Ctrl+E");itemPrinting=new JMenuItem("打印（P）               Ctrl+P");
        itemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
        itemNewWindow.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_MASK));
        itemOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        itemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        itemSaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
        itemPrinting.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
        menu1.add(itemNew);menu1.add(itemNewWindow);menu1.add(itemOpen);menu1.add(itemSave);
        menu1.add(itemSaveAs);menu1.add(itemPrinting);

        //编辑
        itemCut=new JMenuItem("剪切（T）         Ctrl+X");itemCopy=new JMenuItem("复制（C）         Ctrl+C");
        itemPaste=new JMenuItem("粘贴（V）         Ctrl+V");itemFind=new JMenuItem("查找（F）         Ctrl+F");
        itemReplace=new JMenuItem("替换（R）         Ctrl+R");
        itemCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
        itemCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
        itemPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
        itemFind.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
        itemReplace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
        menu2.add(itemCut);menu2.add(itemCopy);menu2.add(itemPaste);
        menu2.add(itemFind);menu2.add(itemReplace);
        //格式
        itemFontFormat=new JMenuItem("字体格式（F）");
        menu3.add(itemFontFormat);
        //帮助
        itemAbout=new JMenuItem("关于（H）");
        menu4.add(itemAbout);
        menubar.add(menu1);menubar.add(menu2);
        menubar.add(menu3);menubar.add(menu4);
        setJMenuBar(menubar);
        validate();
        //设置监听器
        itemNew.addActionListener(this);itemNewWindow.addActionListener(this);itemSave.addActionListener(this);
        itemSaveAs.addActionListener(this);itemPrinting.addActionListener(this);itemOpen.addActionListener(this);
        itemCut.addActionListener(this);itemCopy.addActionListener(this);itemPaste.addActionListener(this);
        itemFind.addActionListener(this);itemReplace.addActionListener(this);
        itemFontFormat.addActionListener(this);itemAbout.addActionListener(this);
        //鼠标右击菜设置
        mouseMenu=new JPopupMenu();
        mouseCut=new JMenuItem("剪切");mouseCopy=new JMenuItem("复制");mousePaste=new JMenuItem("粘贴");
        mouseDelet=new JMenuItem("删除");mouseAll=new JMenuItem("全选");
        mouseMenu.add(mouseCut);mouseMenu.add(mouseCopy);mouseMenu.add(mousePaste);
        mouseMenu.add(mouseDelet);mouseMenu.add(mouseAll);
        //添加文本域
        text1=new JTextArea();
        //设置鼠标监听器
        text1.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e) {
                if(e.getModifiers()==InputEvent.BUTTON3_MASK)
                    mouseMenu.show(text1,e.getX(),e.getY());
            }
        });
        mouseCut.addActionListener(this);mouseCopy.addActionListener(this);mousePaste.addActionListener(this);
        mouseDelet.addActionListener(this);mouseAll.addActionListener(this);
        //添加滚动条
        JScrollPane scrollpane = new JScrollPane(text1);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollpane, BorderLayout.CENTER);
        //自动换行
        text1.setLineWrap(true);
        validate();
    }

    public void actionPerformed(ActionEvent e){
        //
        if(e.getSource()==itemNew) {                                          //新建
            text1.replaceRange("", 0, text1.getText().length());
        }else if(e.getSource()==itemNewWindow) {                               //新窗口

            EditWindow won=new EditWindow();

        }else if(e.getSource()==itemOpen) {                                   //打开
            FileDialog openFile = new FileDialog(this, "打开文件", FileDialog.LOAD);  //文件对话框
            openFile.setVisible(true);
            String filePath = openFile.getDirectory() + openFile.getFile();
            try{
                FileInputStream fis = new FileInputStream(filePath);
                byte[] content = new byte[fis.available()];
                fis.read(content);
                text1.setText(new String(content));
                text1.setCaretPosition(0);
                if(openFile.getFile() != null){
                    this.setTitle(openFile.getFile());
                }
                fis.close();
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }else if(e.getSource() ==  itemSave) {                                //保存
            int i = filechooser.showSaveDialog(EditWindow.this);
            if (i == JFileChooser.APPROVE_OPTION) {
                File f = filechooser.getSelectedFile();
                try {
                    FileOutputStream out = new FileOutputStream(f);
                    out.write(text1.getText().getBytes());
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }else if(e.getSource() ==itemSaveAs) {                                //另存为
            int i = filechooser.showSaveDialog(EditWindow.this);
            if (i == JFileChooser.APPROVE_OPTION) {
                File f = filechooser.getSelectedFile();
                try {
                    FileOutputStream out = new FileOutputStream(f);
                    out.write(text1.getText().getBytes());
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }else if(e.getSource()==itemPrinting) {                               //打印
            new win4();
        }else if(e.getSource()==itemCopy || e.getSource()==mouseCopy) {       //复制
            text1.copy();
        }else if(e.getSource()==itemCut || e.getSource()==mouseCut) {		  //剪切
            text1.cut();
        }else if(e.getSource()==itemPaste || e.getSource()==mousePaste) {     //粘贴
            text1.paste();
        }else if(e.getSource()==mouseDelet) {                                 //删除
            text1.cut();
        }else if(e.getSource()==mouseAll) {                                   //全选
            text1.selectAll();
        }else if(e.getSource()==itemFind) {                                   //查找
            new win1();
        }else if(e.getSource()==itemReplace) {                                //替换
            new win2();
        }else if(e.getSource()==itemFontFormat) {                             //字体格式
            new win3();
        }else if(e.getSource()==itemAbout) {                                  //关于
            JOptionPane.showMessageDialog(EditWindow.this, "Java学习组制作");
        }
    }
    class win1 extends JFrame{
        JButton button1;
        JTextField textfile;
        JLabel titlelName1;
        win1(){
            //setLayout(new FlowLayout());
            setLayout(null);
            setTitle("查找");
            setBounds(100,100,300,200);
            setVisible(true);
            setResizable(false);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            textfile=new JTextField(20);
            button1=new JButton("查找");
            titlelName1=new JLabel("查找内容：");
            textfile.setBounds(100,30,120, 25);
            titlelName1.setBounds(15,30,70, 30);
            button1.setBounds(120, 100, 60, 25);
            add(textfile);
            add(button1);
            add(titlelName1);
            setVisible(true);
            button1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    Pattern p;
                    Matcher m;
                    String ch1,ch2;
                    ch1=textfile.getText();
                    ch2=text1.getText();
                    p=Pattern.compile(ch1);
                    m=p.matcher(ch2);

                    while(m.find()) {
                        text1.select(m.start(), m.end());
                    }
                }
            });
            validate();
        }
    }
    class win2 extends JFrame{
        JButton button1;
        JTextField textfile1,textfile2;
        JLabel titlelName1,titlelName2;
        win2(){
            setLayout(null);
            setTitle("替换");
            setBounds(100,100,300,200);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            titlelName1=new JLabel("查找内容：");
            titlelName2=new JLabel("替换为：");
            textfile1=new JTextField(20);
            textfile2=new JTextField(20);
            button1=new JButton("替换");
            textfile1.setBounds(100,30,120,25);
            textfile2.setBounds(100,60,120,25);
            titlelName1.setBounds(15,30,70, 30);
            titlelName2.setBounds(15,60,70, 30);
            button1.setBounds(120, 100, 60, 25);
            add(titlelName1);
            add(titlelName2);
            add(textfile1);
            add(textfile2);
            add(button1);
            setVisible(true);
            button1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    Pattern p;
                    Matcher m;
                    String ch1,ch2,ch3;
                    ch1=textfile1.getText();
                    ch2=textfile2.getText();
                    ch3=text1.getText();
                    if(ch1==null) {
                        JOptionPane.showMessageDialog(EditWindow.this, "请输入查找内容！");
                    }else {
                        p=Pattern.compile(ch1);
                        m=p.matcher(ch3);
                        while(m.find()) {
                            text1.replaceRange(ch2, m.start(), m.end());;
                        }
                    }
                }
            });
            validate();
        }
    }
    class win3 extends JFrame implements ItemListener{
        JComboBox listFont;
        win3(){
            GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
            String fontName[]=ge.getAvailableFontFamilyNames();
            listFont=new JComboBox(fontName);
            JPanel pNorth=new JPanel();            //创建面板
            pNorth.add(listFont);                  //添加列表
            add(pNorth,BorderLayout.NORTH);        //添加面板
            listFont.addItemListener(this);		  //添加列表监视器
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);
            setBounds(100,120,280,100);
        }
        public void itemStateChanged(ItemEvent e){
            String name=(String)listFont.getSelectedItem();
            Font f=new Font(name,Font.BOLD,32);
            text1.setFont(f);
        }
    }
    class win4 extends JFrame{
        JButton button1,button2;
        win4(){
            setLayout(new FlowLayout());
            setTitle("打印");
            setBounds(100,100,300,100);
            setVisible(true);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            button1=new JButton("打印");
            button2=new JButton("打印预览");
            add(button1);
            add(button2);
            button1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    try {
                        PrinterJob job = PrinterJob.getPrinterJob();     //创建打印对象
                        if (!job.printDialog()) {                        //取消打印
                            return;
                        }
                        //设置打印页面
                        job.setPrintable(new Printable() {
                            @Override
                            public int print(Graphics graphics, PageFormat pageFormat,int pageIndex) throws PrinterException {
                                // TODO Auto-generated method stub
                                if(pageIndex > 0) {                       //判断当前打印页的索引（判断打印的是否正确）
                                    return Printable.NO_SUCH_PAGE;        //超出打印页码
                                }
                                return Printable.PAGE_EXISTS;            //页面可以打印
                            }
                        });
                        job.print();                                     //实现打印
                    } catch (PrinterException e1) {
                        e1.printStackTrace();
                    }
                }
            });
            button2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(EditWindow.this, "该功能尚未开发！");
                }
            });
        }
    }
}
