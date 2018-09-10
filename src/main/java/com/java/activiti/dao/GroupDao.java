package com.java.activiti.dao;

import java.util.List;
import java.util.Map;

import com.java.activiti.model.Group;

public interface GroupDao {

    /**
     * ��ѯ���н�ɫ���������
     *
     * @return
     */
    public List<Group> findGroup();

    /**
     * ��ҳ��ѯ
     *
     * @param map
     * @return
     */
    public List<Group> groupPage(Map<String, Object> map);

    /**
     * ͳ������
     *
     * @param map
     * @return
     */
    public int groupCount(Map<String, Object> map);

    /**
     * �����h��
     *
     * @param list
     * @return
     */
    public int deleteGroup(List<String> list);

    /**
     * �޸�
     *
     * @param group
     * @return
     */
    public int updateGroup(Group group);

    /**
     * ����
     *
     * @param group
     * @return
     */
    public int addGroup(Group group);

    public List<Group> findByUserId(String id);
}
