package cn.peter.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.peter.model.Group;
import cn.peter.model.MemberShip;
import cn.peter.model.User;
import cn.peter.service.MemberShipService;
import cn.peter.util.ResponseUtil;
import cn.peter.util.StringUtil;

@Controller
@RequestMapping("/memberShip")
public class MenberShipController {
    @Resource
    private MemberShipService memberShipService;

    @RequestMapping("/updateMemberShip")
    public String updateMemberShip(HttpServletResponse response, String userId, String groupsIds) throws Exception {
        //刪除全部角色
        memberShipService.deleteAllGroupsByUserId(userId);

        if (StringUtil.isNotEmpty(groupsIds)) {
            //分割字符串，以，分割
            String idsArr[] = groupsIds.split(",");
            for (String groupId : idsArr) {
                User user = new User();
                user.setId(userId);
                Group group = new Group();
                group.setId(groupId);
                MemberShip memberShip = new MemberShip();
                memberShip.setUser(user);
                memberShip.setGroup(group);
                memberShipService.addMemberShip(memberShip);
            }
        }
        JSONObject result = new JSONObject();
        result.put("success", true);
        ResponseUtil.write(response, result);
        return null;
    }
}
