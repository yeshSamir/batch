package com.springBatch.batch.controller;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/load")
public class LoadController {

    @Autowired
    JobLauncher jobLauncher;
    @Autowired
    Job job;
    @GetMapping
    public BatchStatus load() throws  JobExecutionException {
        JobParameters parameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();
       JobExecution jobExecution = jobLauncher.run(job, parameters);

       while(jobExecution.isRunning()){
           System.out.println("Batch is running");
       }
       return jobExecution.getStatus();

    }
}
