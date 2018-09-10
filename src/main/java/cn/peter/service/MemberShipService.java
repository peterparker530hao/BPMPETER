package cn.peter.service;

import java.util.Map;

import cn.peter.model.MemberShip;

public interface MemberShipService {
    /**
     * �û�����ķ���
     *
     * @return
     */
    public MemberShip userLogin(Map<String, Object> map);

    public int deleteAllGroupsByUserId(String userId);

    public int addMemberShip(MemberShip memberShip);
}
