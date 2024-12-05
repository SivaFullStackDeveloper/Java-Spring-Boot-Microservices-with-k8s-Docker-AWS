package com.siva.firstjobapp.job.service;

import com.siva.firstjobapp.job.model.Job;

import java.util.List;
import java.util.Optional;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);
    Optional<Job> getJobById(Long id);
    boolean deleteById(Long id);
    Optional<Job> updateById(Job job, Long id);
}
