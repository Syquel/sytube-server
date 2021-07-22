package de.syquel.sytube.server.video.data;

import de.syquel.sytube.server.common.data.AbstractStorageEntity;

import javax.activation.MimeType;

public class AudioTrack extends AbstractStorageEntity {

	private MimeType mediaType;

	public MimeType getMediaType() {
		return mediaType;
	}

	public void setMediaType(final MimeType mediaType) {
		this.mediaType = mediaType;
	}

}
