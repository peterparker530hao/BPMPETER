package cn.peter.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.peter.dao.LeaveDao;
import cn.peter.model.Leave;
import cn.peter.service.LeaveService;
@Service("leaveService")
public class LeaveServiceImpl implements LeaveService {
    @Resource
    private LeaveDao leaveDao;

    public List<Leave> leavePage(Map<String, Object> map) {
        return leaveDao.leavePage(map);
    }

    public int leaveCount(Map<String, Object> map) {
        return leaveDao.leaveCount(map);
    }

    public int addLeave(Leave leave) {
        return leaveDao.addLeave(leave);
    }

    public Leave findById(String id) {
        return leaveDao.findById(id);
    }

    public int updateLeave(Leave leave) {
        return leaveDao.updateLeave(leave);
    }

    public Leave getLeaveByTaskId(String processInstanceId) {
        return leaveDao.getLeaveByTaskId(processInstanceId);
    }
}
