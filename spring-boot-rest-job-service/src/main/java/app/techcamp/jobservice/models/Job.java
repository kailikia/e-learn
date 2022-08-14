package app.techcamp.jobservice.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "jobs")
public class Job extends AuditModel {

	@Id
    @GeneratedValue(generator = "job_generator")
    @SequenceGenerator(
            name = "job_generator",
            sequenceName = "job_sequence",
            initialValue = 1000
    )
	private Long id;
	
	@NotBlank
    @Size(min = 3, max = 100)
    private String title;
	
	@Min(1)
    private int description;
	
	@Min(1)
    private float approximateSalary;
	
	@Min(1)
    private Date dueDate;
	
	@Min(1)
    private int status;

	public Job() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDescription() {
		return description;
	}

	public void setDescription(int description) {
		this.description = description;
	}

	public float getApproximateSalary() {
		return approximateSalary;
	}

	public void setApproximateSalary(float approximateSalary) {
		this.approximateSalary = approximateSalary;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	    
}
