package de.syquel.sytube.server.video.data;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import de.syquel.sytube.server.common.data.AbstractStorageEntity;

@Entity
public class VideoTrack extends AbstractStorageEntity {

	@Basic
	@NotBlank
	private String mediaType;

	@Basic
	@Enumerated(EnumType.STRING)
	private Quality quality;

	@Basic
	@NotBlank
	private String frameRate;

	@Basic
	@Positive
	private int bandwidth;

	@Basic
	@NotBlank
	private String codec;

	@ManyToOne
	@NotNull
	private Video video;

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(final String mediaType) {
		this.mediaType = mediaType;
	}

	public Quality getQuality() {
		return quality;
	}

	public void setQuality(final Quality quality) {
		this.quality = quality;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(final Video video) {
		this.video = video;
	}

	public enum Quality {
		UHD(3840, 2160), FHD(1920, 1080), HD(1280, 720);

		private final int width;
		private final int height;

		Quality(final int width, final int height) {
			this.width = width;
			this.height = height;
		}

		public static Quality of(final int width, final int height) {
			if (UHD.width == width && UHD.height == height) {
				return UHD;
			} else if (FHD.width == width && FHD.height == height) {
				return FHD;
			} else if (HD.width == width && HD.height == height) {
				return HD;
			} else {
				throw new IllegalArgumentException("Invalid width " + width + " and height " + height);
			}
		}

	}

}
