package proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class client {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-beans4.xml");
        IUserManger iUserManger =(IUserManger) context.getBean("userMangerImpl");
        iUserManger.addUserInfo("ahui","123123");
        iUserManger.delUserInfo(1);

        iUserManger.queryUser(1);
        iUserManger.modifyUserInfo("ahui",12);
    }
}
