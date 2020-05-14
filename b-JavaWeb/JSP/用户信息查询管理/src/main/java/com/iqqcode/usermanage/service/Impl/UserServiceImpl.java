package com.iqqcode.usermanage.service.impl;

import com.iqqcode.usermanage.dao.UserDao;
import com.iqqcode.usermanage.dao.impl.UserDaoImpl;
import com.iqqcode.usermanage.domain.PageBean;
import com.iqqcode.usermanage.domain.User;
import com.iqqcode.usermanage.service.UserService;

import java.util.List;
import java.util.Map;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-22 12:05
 * @Description:业务逻辑层，调用数据访问层
 */
public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    /**
     * 调用dao完成查询
     * @return
     */
    @Override
    public List<User> findAll() {
        //调用dao完成查询
        return dao.findAll();
    }

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void deleteUser(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.update(user);
    }

    @Override
    public void delSelectedUser(String[] ids) {
        if(ids != null && ids.length > 0) {
            //1.遍历数组
            for (String id : ids) {
                //2.调用dao删除
                dao.delete(Integer.parseInt(id));
            }
        }
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        int totalPage;//总页码

        if (currentPage <= 0) {
            currentPage = 1;
        }
        //1.创建PageBane对象
        PageBean<User> pageBean = new PageBean<User> ();

        //2.设置参数
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);

        //3.调用dao查询总记录数
        int totalCount = dao.findTotalCount(condition);
        pageBean.setTotalCount(totalCount);

        //4.调用dao查询List集合
        //计算开始的记录索引
        int start = (currentPage - 1) * rows;
        List<User> list = dao.findByPage(start,rows, condition);
        pageBean.setList(list);

        //5.计算总页码
        totalPage = (totalCount % rows)  == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pageBean.setTotalPage(totalPage);

        if (currentPage >= totalPage) {
            currentPage = totalPage;
        }

        return pageBean;
    }
}
