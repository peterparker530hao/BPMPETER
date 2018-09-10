package cn.peter.service;

import java.util.List;
import java.util.Map;

import cn.peter.model.Leave;

public interface LeaveService {
    public List<Leave> leavePage(Map<String, Object> map);

    public int leaveCount(Map<String, Object> map);

    public int addLeave(Leave leave);
    public Leave findById(String id);

    public int updateLeave(Leave leave);

    public Leave getLeaveByTaskId(String processInstanceId);
}
