package com.github.kubikrubikvkube.amioTaskManagement.repository;

import com.github.kubikrubikvkube.amioTaskManagement.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {


}
