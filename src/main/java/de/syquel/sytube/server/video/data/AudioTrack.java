package de.syquel.sytube.server.video.data;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import de.syquel.sytube.server.common.data.AbstractStorageEntity;

@Entity
public class AudioTrack extends AbstractStorageEntity {

	@Basic
	@NotBlank
	private String mediaType;

	@ManyToOne
	private Video video;

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(final String mediaType) {
		this.mediaType = mediaType;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(final Video video) {
		this.video = video;
	}

}
