package com.siva.jobms.job.controller;

import com.siva.jobms.job.model.Job;
import com.siva.jobms.job.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class JobController {

    JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll(){
        return new ResponseEntity<>(jobService.findAll(),HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Optional<Job>> add(@PathVariable Long id){
        Optional<Job> job = jobService.getJobById(id);
        if (job !=null){
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        boolean deleted = jobService.deleteById(id);
        if(deleted == true){
            return new ResponseEntity<>(deleted, HttpStatus.OK);
        }

        return new ResponseEntity<>(deleted, HttpStatus.NOT_FOUND);

    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<Optional<Job>> updateById(@RequestBody Job job, @PathVariable Long id){
        Optional<Job> update = jobService.updateById(job,id);
        if(update != null){
            return new ResponseEntity<>(update, HttpStatus.OK);
        }

        return new ResponseEntity<>(update, HttpStatus.NOT_FOUND);

    }

}
