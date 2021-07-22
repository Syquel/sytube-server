package de.syquel.sytube.server.video.data;

import javax.activation.MimeType;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import de.syquel.sytube.server.common.data.AbstractStorageEntity;

@Entity
public class AudioTrack extends AbstractStorageEntity {

	@Basic
	@NotBlank
	private MimeType mediaType;

	@ManyToOne
	private Video video;

	public MimeType getMediaType() {
		return mediaType;
	}

	public void setMediaType(final MimeType mediaType) {
		this.mediaType = mediaType;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(final Video video) {
		this.video = video;
	}

}
