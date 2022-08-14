package app.techcamp.jobservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.techcamp.jobservice.models.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long>
{
	
}
