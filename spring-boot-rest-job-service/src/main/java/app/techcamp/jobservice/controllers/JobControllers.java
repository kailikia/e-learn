package app.techcamp.jobservice.controllers;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.techcamp.jobservice.exceptions.ResourceNotFoundException;
import app.techcamp.jobservice.models.Job;
import app.techcamp.jobservice.repositories.JobRepository;


@RestController
public class JobControllers {
		
	    @Autowired
	    private JobRepository jobRepo;
	        
	    @GetMapping("/jobs/{userId}")
	    public List<Job> getUserJobs(@PathVariable String userId)
	    {
	    	
	    	return jobRepo.findAll();
	    }
	    
	    
	    @PostMapping("/jobs")
	    public Job createJob(@Valid @RequestBody Job jobo)
	    {

	    	return jobRepo.save(jobo);
       
	    }	
	    
	    @PutMapping("/jobs/{jid}")
	    public Job updateJob(@PathVariable Long jid,@Valid @RequestBody Job jobo) {
	        return jobRepo.findById(jid)
	                .map(job -> {
	                	job.setStatus(jobo.getStatus());
	                    return jobRepo.save(job);
	                }).orElseThrow(() -> new ResourceNotFoundException("job not found with id " + jid));
	    }	    
}