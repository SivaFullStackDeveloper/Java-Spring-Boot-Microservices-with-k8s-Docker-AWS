package com.siva.jobms.job.impl;


import com.siva.jobms.job.model.Job;
import com.siva.jobms.job.repo.JobRepo;
import com.siva.jobms.job.service.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobImpl implements JobService {
    JobRepo jobRepo;

    public JobImpl(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }

    @Override
    public List<Job> findAll() {
        return jobRepo.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepo.save(job);
    }

    @Override
    public Optional<Job> getJobById(Long id) {
        Optional<Job> job = jobRepo.findById(id);

        return job;
    }

    @Override
    public boolean deleteById(Long id) {
        jobRepo.deleteById(id);

        return true;
    }

    @Override
    public Optional<Job> updateById(Job job, Long id) {
        Optional<Job> job1 = jobRepo.findById(id);

        if (job1.get().getId() == id) {
            job1.get().setLocation(job.getLocation());
            job1.get().setDescription(job.getDescription());
            job1.get().setTitle(job.getTitle());
            job1.get().setMaxSalary(job.getMaxSalary());
            job1.get().setMinSalary(job.getMinSalary());
            jobRepo.save(job1.get());
        }

        return job1;
    }
}
