package com.iqqcode.travelocity.service.impl;


import com.iqqcode.travelocity.dao.UserDao;
import com.iqqcode.travelocity.dao.impl.UserDaoImpl;
import com.iqqcode.travelocity.domain.User;
import com.iqqcode.travelocity.service.UserService;
import com.iqqcode.travelocity.util.MailUtils;
import com.iqqcode.travelocity.util.UuidUtil;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-24 11:36
 * @Description:
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    /**
     * 注册用户
     * @param user
     * @return
     */
    @Override
    public boolean regist(User user) {
        //1.根据用户名查询用户对象
        User u = userDao.findByUsername(user.getUsername());
        //判断u是否为null
        if(u != null){
            //用户名存在，注册失败
            return false;
        }
        //2.保存用户信息
        //设置激活码(唯一)
        user.setCode(UuidUtil.getUuid());
        //设置激活状态
        user.setStatus("N");
        userDao.save(user);

        //3.激活邮件发送6
        String content = "<a href='http://localhost:8080/travelocity/activeUserServlet?code="+user.getCode()+"'>点击激活【黑马旅游网】</a>";

        MailUtils.sendMail(user.getEmail(),content,"激活邮件");

        return true;
    }

    @Override
    public boolean active(String code) {
        //1.根据激活码查询用户对象
        User user = userDao.findByCode(code);
        if (user != null) {
            //2.调用dao的修改激活状态的方法
            userDao.updateStatus(user);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public User login(User user) {
        return userDao.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }
}
