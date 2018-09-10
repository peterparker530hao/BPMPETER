package cn.peter.dao;

import java.util.Map;

import cn.peter.model.MemberShip;

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
