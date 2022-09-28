package com.KANBANBOARD1.controller;


	import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
	import com.KANBANBOARD1.entity.Task;
	import com.KANBANBOARD1.service.TaskService;


	@CrossOrigin
	@RestController
	@RequestMapping("/KanbanApi")
	public class TaskController {
		
		@Autowired
		private TaskService taskService;
		

		
		@PostMapping("/addTask")
		public ResponseEntity<Task> addTask(@Valid @RequestBody Task t)
		{
			Task ts =taskService.addTask(t);
			ResponseEntity<Task> re=new ResponseEntity<Task>(ts,HttpStatus.OK);
			return re;
			
		}

		@GetMapping("/getTask")
		public ResponseEntity<List<Task>> getTask()
		{
			//this.restTemplate.getForObject( null,List.class);//place the url in place of null 
			List<Task> lt = taskService.getTask();
			ResponseEntity<List<Task>> re=new ResponseEntity<List<Task>>(lt,HttpStatus.OK);
			return re;
			
		}
		
		@PutMapping("/updateTasks")
		public ResponseEntity<Task> updateTask(@RequestBody Task t) throws Throwable
		{
			Task t1=taskService.updateTask(t);
			ResponseEntity<Task> re =new ResponseEntity<Task>(t1,HttpStatus.OK);
			return re;
		}
		
		@DeleteMapping(path="/deleteTask/{id}")
		public ResponseEntity<String> deleteTask(@PathVariable long id)
		{
			taskService.delete(id);
			
			ResponseEntity<String> re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
			return re;
		}
	}


