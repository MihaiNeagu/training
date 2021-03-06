package ro.victor.training.jpa2.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Subject {
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@ManyToOne
	private Teacher holderTeacher;
	
	@OneToMany(mappedBy="subject")
	private List<TeachingActivity> activities = new ArrayList<>();

	public Subject() {
	}
	
	public Subject(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teacher getHolderTeacher() {
		return holderTeacher;
	}

	public void setHolderTeacher(Teacher holder) {
		this.holderTeacher = holder;
	}

	public List<TeachingActivity> getActivities() {
		return activities;
	}

	public void setActivities(List<TeachingActivity> activities) {
		this.activities = activities;
	}
	
	
	
	
}
