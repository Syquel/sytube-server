package de.syquel.sytube.server.video.data;

import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import de.syquel.sytube.server.common.data.AbstractEntity;

@Entity
public class Video extends AbstractEntity<UUID> {

	@Basic
	@NotBlank
	private String title;

	@Basic
	@NotBlank
	private String description;

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

}
