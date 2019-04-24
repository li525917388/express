package com.ldh.express.web.activity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Li Dehuan
 * @date 2019年4月23日
 *
 */
@RestController  
@RequestMapping("/act")
public class ActivityController {
	
	@Autowired  
    private RuntimeService runtimeService;
	
	@Autowired  
    private TaskService taskService;  
    
    @Autowired
    private RepositoryService repositoryService;
	
    /**
     * 
     * @param flowid
     * @return
     */
	@RequestMapping(value="/start",method=RequestMethod.GET) 
	public String test(String flowid){
		System.out.println("开始流程：" + flowid);
		
		if(flowid == null){
			return "flowid为空";
		}
		
		System.out.println( "调用流程存储服务，查询部署数量：" + repositoryService.createDeploymentQuery().count());
		
		//
		ProcessInstance pi = runtimeService.startProcessInstanceByKey(flowid);  
		
		System.out.println("id" + pi.getId());
		System.out.println("ActivityId" + pi.getActivityId());
		System.out.println("ProcessInstanceId" + pi.getProcessInstanceId());
		
		return pi.getProcessInstanceId();
	}
	
	
	/**
	 * 
	 * @param piid
	 * @param status
	 * @return
	 */
	@RequestMapping(value="/doTask1",method=RequestMethod.GET) 
	public String doTask(String taskId,int status,int day,String uid){
		
		System.out.println("处理任务：" + taskId);
		
		if(taskId == null){
			return "taskId为空";
		}
		
		taskService.claim(taskId, uid);		//	认领
		//taskService.setVariableLocal(taskId, "status", status);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", status);
		
		taskService.complete(taskId, params );
		
		System.out.println("完成任务");
		
		return taskId;
	}
	
	
	/**
	 * 
	 * @param uid
	 * @return
	 */
	@RequestMapping(value="/queryTask",method=RequestMethod.GET) 
	public List<Task> queryTask(String uid){
		
		System.out.println("用户：" + uid);
		
		if(uid == null){
			return null;
		}
		
		List<Task> list = taskService.createTaskQuery().taskAssignee(uid).list();
		
		if(list.isEmpty()){
			list = taskService.createTaskQuery().taskCandidateUser(uid).list();
		}
		
		System.out.println("任务数：" + list.size());
		
		for(Task task : list){  
			taskService.claim(task.getId(), uid);		//	认领
            System.out.println("任务ID:"+task.getId());  
            System.out.println("任务的办理人:"+task.getAssignee());  
            System.out.println("任务名称:"+task.getName());  
            System.out.println("任务的创建时间:"+task.getCreateTime());  
            System.out.println("ProcessInstanceId:"+task.getProcessInstanceId());  
            System.out.println("ProcessDefinitionId:"+task.getProcessDefinitionId());  

            System.out.println("流程实例ID:"+task.getProcessInstanceId());
            System.out.println("#####################################");  
        }
		
		return list;
		
	}
}
