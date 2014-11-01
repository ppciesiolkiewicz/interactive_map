package pl.edu.wroc.pwr.service.model;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by krzaczek on 29.10.14.
 */
public abstract class Model implements Serializable {

	@Id
	private String id;
	private String name;
	private String description;
	private Long ownerId;
	private Set<String> tags;

	protected Model(String name, String description, Long ownerId, Set<String> tags) {
		this.name = name;
		this.description = description;
		this.ownerId = ownerId;
		this.tags = tags;
	}

	protected Model() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}
}
