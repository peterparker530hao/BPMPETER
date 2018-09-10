package com.java.activiti.dao;

import java.util.Map;

import com.java.activiti.model.MemberShip;

public interface MemberShipDao {
    /**
     * �û�����ķ���
     *
     * @return
     */
    public MemberShip userLogin(Map<String, Object> map);

    public int deleteAllGroupsByUserId(String userId);

    public int addMemberShip(MemberShip memberShip);
}
