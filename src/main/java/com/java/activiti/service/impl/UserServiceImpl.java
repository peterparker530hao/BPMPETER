package com.java.activiti.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java.activiti.dao.UserDao;
import com.java.activiti.model.User;
import com.java.activiti.service.UserService;

@Service("serService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    public User findById(String userId) {
        return userDao.findById(userId);
    }
//	/**
//	 * ����
//	 * @return
//	 */
//	public User userLogin(User user){
//		return userDao.userLogin(user);
//	}

    /**
     * '
     * ��ҳ��ѯ�û�
     *
     * @param map
     * @return
     */
    public List<User> userPage(Map<String, Object> map) {
        return userDao.userPage(map);
    }

    public int userCount(Map<String, Object> map) {
        return userDao.userCount(map);
    }

    /**
     * ����ɾ���û�
     *
     * @param id
     * @return
     */
    public int deleteUser(List<String> id) {
        return userDao.deleteUser(id);
    }

    /**
     * �޸��û�
     *
     * @param user
     * @return
     */
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    /**
     * �����û�
     *
     * @param user
     * @return
     */
    public int addUser(User user) {
        return userDao.addUser(user);
    }
}
