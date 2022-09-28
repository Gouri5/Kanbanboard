package com.KANBANBOARD1.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KANBANBOARD1.entity.Task;
import com.KANBANBOARD1.exception.ResourceNotFoundException;
import com.KANBANBOARD1.repo.TaskRepo;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepo taskRepository;
	
	public Task addTask(Task t) 
	{
		taskRepository.save(t);
		return t;
	}
	
	public List<Task> getTask()
	{
		List<Task> lt=taskRepository.findAll();
		return lt;
	}
	public List<Task> addTasks(List<Task> t)
	{
		taskRepository.saveAll(t);
		return t;
	}
	public String delete(long id) 
	{
		taskRepository.deleteById(id);
		return "Deleted Sucessfully";
	}
	public Task updateTask(Task t) throws Throwable
	{
		Long id=t.getId();
		
		@SuppressWarnings("rawtypes")
		Supplier s1= ()->new ResourceNotFoundException("Task Does not exist in the database");
		@SuppressWarnings("unchecked")
		Task t1=taskRepository.findById(id).orElseThrow(s1);
		
		t1.setTitle(t.getTitle());
			t1.setDescription(t.getDescription());
			taskRepository.save(t1);
			return t1;	
		
	}
}
