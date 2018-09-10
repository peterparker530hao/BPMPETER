package cn.peter.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import cn.peter.dao.MemberShipDao;
import cn.peter.model.MemberShip;
import cn.peter.service.MemberShipService;
import org.springframework.stereotype.Service;

@Service("memberShipService")
public class MemberShipServiceImpl implements MemberShipService {

    @Resource
    private MemberShipDao menberShipDao;

    /**
     * �û�����ķ���
     *
     * @return
     */
    public MemberShip userLogin(Map<String, Object> map) {
        return menberShipDao.userLogin(map);
    }

    public int deleteAllGroupsByUserId(String userId) {
        return menberShipDao.deleteAllGroupsByUserId(userId);
    }

    public int addMemberShip(MemberShip memberShip) {
        return menberShipDao.addMemberShip(memberShip);
    }
}
