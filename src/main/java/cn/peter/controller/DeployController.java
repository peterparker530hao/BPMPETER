package cn.peter.controller;

import java.util.List;
import java.util.zip.ZipInputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import cn.peter.model.PageInfo;
import cn.peter.util.DateJsonValueProcessor;
import cn.peter.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * ���̲������
 *
 * @author Administrator
 */
@Controller
@RequestMapping("/deploy")
public class DeployController {

    //ע��activitiService����
    @Resource
    private RepositoryService repositoryService;

    /**
     * ��ҳ��ѯ����
     *
     * @param rows
     * @param page
     * @param s_name
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/deployPage")
    public String deployPage(String rows, String page, String s_name, HttpServletResponse response) throws Exception {
        if (s_name == null) {
            s_name = "";
        }
        PageInfo pageInfo = new PageInfo();
        //���ÿҳ��ʾ����
        Integer sizePage = Integer.parseInt(rows);
        pageInfo.setPageSize(sizePage);
        // �ڼ�ҳ
        String pageIndex = page;
        if (pageIndex == null || pageIndex == "") {
            pageIndex = "1";
        }
        pageInfo.setPageIndex((Integer.parseInt(pageIndex) - 1)
                * sizePage);
        //ȡ��������
        long deployCount = repositoryService.createDeploymentQuery().deploymentNameLike("%" + s_name + "%")
                .count();

        List<Deployment> deployList = repositoryService.createDeploymentQuery()//�������̲�ѯʵ��
                .orderByDeploymenTime().desc()  //����
                .deploymentNameLike("%" + s_name + "%")   //����Nameģ����ѯ
                .listPage(pageInfo.getPageIndex(), pageInfo.getPageSize());

        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new String[]{"resources"});
        jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(deployList, jsonConfig);
        result.put("rows", jsonArray);
        result.put("total", deployCount);
        ResponseUtil.write(response, result);
        return null;
    }

    /**
     * ���ϴ����̲���ZIP�ļ�
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/addDeploy")
    public String addDeploy(HttpServletResponse response, MultipartFile deployFile) throws Exception {
        repositoryService.createDeployment() //��������
                .name(deployFile.getOriginalFilename())    //��Ҫ������������
                .addZipInputStream(new ZipInputStream(deployFile.getInputStream()))//���ZIP������
                .deploy();//��ʼ����
        JSONObject result = new JSONObject();
        result.put("success", true);
        ResponseUtil.write(response, result);
        return null;
    }

    /**
     * ����ɾ������
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/delDeploy")
    public String delDeploy(HttpServletResponse response, String ids) throws Exception {
        //����ַ���
        String[] idsStr = ids.split(",");
        for (String str : idsStr) {
            repositoryService.deleteDeployment(str, true);
        }
        JSONObject result = new JSONObject();
        result.put("success", true);
        ResponseUtil.write(response, result);
        return null;
    }
}
