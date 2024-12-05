package com.siva.firstjobapp.job.repo;

import com.siva.firstjobapp.job.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepo extends JpaRepository<Job,Long> {
}
