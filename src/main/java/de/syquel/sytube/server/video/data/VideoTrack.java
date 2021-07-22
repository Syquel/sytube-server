package de.syquel.sytube.server.video.data;

import de.syquel.sytube.server.common.data.AbstractStorageEntity;
import io.quarkus.mongodb.panache.MongoEntity;

import javax.activation.MimeType;

public class VideoTrack extends AbstractStorageEntity {

	private MimeType mediaType;

	private Quality quality;

	private String frameRate;

	private int bitrate;

	private String codec;

	public MimeType getMediaType() {
		return mediaType;
	}

	public void setMediaType(final MimeType mediaType) {
		this.mediaType = mediaType;
	}

	public Quality getQuality() {
		return quality;
	}

	public void setQuality(final Quality quality) {
		this.quality = quality;
	}

	public String getFrameRate() {
		return frameRate;
	}

	public void setFrameRate(final String frameRate) {
		this.frameRate = frameRate;
	}

	public int getBitrate() {
		return bitrate;
	}

	public void setBitrate(final int bandwidth) {
		this.bitrate = bandwidth;
	}

	public String getCodec() {
		return codec;
	}

	public void setCodec(final String codec) {
		this.codec = codec;
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
