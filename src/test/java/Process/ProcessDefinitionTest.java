package Process;

import org.activiti.engine.*;

import org.activiti.engine.repository.Deployment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.InputStream;
import java.util.zip.ZipInputStream;
//更新测试3
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-mvc.xml",
        "classpath*:mybatis-config.xml","classpath*:applicationContext.xml","classpath*:activiti-context.xml"})
public class ProcessDefinitionTest {

    @Autowired
  ProcessEngine ProcessEngines;

    /**自動建表*/
    @Test
    public void createTable(){
        // 创建一个流程引擎配置对象
        ProcessEngineConfiguration conf = ProcessEngineConfiguration
                .createStandaloneProcessEngineConfiguration();
        // 设置数据源信息
        conf.setJdbcDriver("com.mysql.jdbc.Driver");
        conf.setJdbcUrl("jdbc:mysql://localhost:3306/activiti");
        conf.setJdbcUsername("root");
        conf.setJdbcPassword("root");
        // 设置自动建表
        conf.setDatabaseSchemaUpdate("true");
        // 创建一个流程引擎对象，在创建流程引擎对象过程中会自动建表
        conf.buildProcessEngine();


    }



    /**部署流程定义*/
    @Test
    public void deploymentProcessDefinition(){
        Deployment deployment = ProcessEngines.getRepositoryService()//与流程定义和部署对象相关的Service
                .createDeployment()//创建一个部署对象
                .name("請假流程")//添加部署的名称
                .addClasspathResource("activiti/activitiEmployeeProcess.bpmn")//从classpath的资源中加载，一次只能加载一个文件
                .addClasspathResource("activiti/activitiEmployeeProcess.png")//从classpath的资源中加载，一次只能加载一个文件
                .deploy();//完成部署
        System.out.println("部署ID："+deployment.getId());//1
        System.out.println("部署名称："+deployment.getName());//helloworld入门程序
    }

    /*
     *部署流程定义 （从zip）
     */
    @Test
    public void deploymentProcessDefinition_zip(){
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("diagrams/HelloWorld.zip");
        ZipInputStream zipInputStream = new ZipInputStream(in);
        Deployment deployment = ProcessEngines.getRepositoryService()//与流程定义和部署对象相关的Service
                .createDeployment()//创建一个部署对象
                .name("流程定义")//添加部署名称
                .addZipInputStream(zipInputStream)//完成zip文件的部署
                .deploy();//完成部署
        System.out.println("部署ID："+deployment.getId());
        System.out.println("部署名称:"+deployment.getName());

    }



}
