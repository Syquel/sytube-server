package de.syquel.sytube.server.video.data;

import javax.persistence.Basic;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.ws.rs.core.MediaType;

import de.syquel.sytube.server.common.data.AbstractStorageEntity;
import de.syquel.sytube.server.common.data.MediaTypeAttributeConverter;

@Entity
public class AudioTrack extends AbstractStorageEntity {

	@Basic
	@Convert(converter = MediaTypeAttributeConverter.class)
	@NotBlank
	private MediaType mediaType;

	@Basic
	@Positive
	private int bitRate;

	@Basic
	@Convert(converter = MediaTypeAttributeConverter.class)
	@NotBlank
	private Codec codec;

	@ManyToOne
	private Video video;

	public MediaType getMediaType() {
		return mediaType;
	}

	public void setMediaType(final MediaType mediaType) {
		this.mediaType = mediaType;
	}

	public int getBitRate() {
		return bitRate;
	}

	public void setBitRate(int bitRate) {
		this.bitRate = bitRate;
	}

	public Codec getCodec() {
		return codec;
	}

	public void setCodec(final Codec codec) {
		this.codec = codec;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(final Video video) {
		this.video = video;
	}

}
