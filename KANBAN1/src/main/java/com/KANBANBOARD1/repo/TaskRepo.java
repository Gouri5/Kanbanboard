package com.KANBANBOARD1.repo;



	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

	import com.KANBANBOARD1.entity.Task;


	@Repository
	public interface TaskRepo  extends JpaRepository<Task,Long>{
		

	}

