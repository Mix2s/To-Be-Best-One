package cn.bite.travel.service.impl;

import cn.bite.travel.dao.UserDao;
import cn.bite.travel.dao.impl.UserDaoImpl;
import cn.bite.travel.domain.User;
import cn.bite.travel.service.UserService;
import cn.bite.travel.util.MailUtils;
import cn.bite.travel.util.UuidUtil;

/**
 *用户相关业务实现层
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    /**
     * 用户注册功能
     * @param user
     * @return
     */
    @Override
    public boolean regist(User user) {
        User u = userDao.finByUsername(user.getUsername());
        //调用dao使用用户名查询用户
        if(u!=null){
            return false;
        }
        //判断用户是否为空  为空直接返回true
        //保存用户
        //给用户设置激活码 随机 唯一
        user.setCode(UuidUtil.getUuid());
        //设置当前用户默认的激活状态
        user.setStatus("N");

        userDao.saveUser(user);
        //2.注册成功 激活邮件
        //发送邮件
        //收件人（收件人邮箱） 邮件标题
        String content = "当前邮箱处于未激活状态，请点击<a href='http://localhost/travel/user/active?code="+user.getCode()+"'>激活</a>";

        MailUtils.sendMail(user.getEmail(),content,"激活邮件");
        return true;
    }


    /**
     * 激活邮件实现
     * @param code
     * @return
     */
    @Override
    public boolean active(String code) {
        //调用userDao通过激活码查询用户
        User user = userDao.findByCode(code);
        //判断用户是否存在
        if(user!=null){
            //更新用户状态
            userDao.updateStatus(user);
            return true;
        }else{
            return false;
        }
    }

    /**
     * 根据前台返回的用户名密码查询
     * @param user
     * @return
     */
    @Override
    public User findByUsernameAndPassword(User user) {
        return userDao.finByUsernameAndPassword(user.getUsername(),user.getPassword());
    }


}
