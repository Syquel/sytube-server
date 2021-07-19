package de.syquel.sytube.server.video.data;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.ws.rs.core.MediaType;

import de.syquel.sytube.server.common.data.AbstractStorageEntity;

@Entity
public class AudioTrack extends AbstractStorageEntity {

	@Basic
	@NotBlank
	private MediaType mediaType;

	@ManyToOne
	private Video video;

	public MediaType getMediaType() {
		return mediaType;
	}

	public void setMediaType(final MediaType mediaType) {
		this.mediaType = mediaType;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(final Video video) {
		this.video = video;
	}

}
