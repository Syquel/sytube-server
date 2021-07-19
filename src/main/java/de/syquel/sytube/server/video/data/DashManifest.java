package de.syquel.sytube.server.video.data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import de.syquel.sytube.server.common.data.AbstractStorageEntity;

@Entity
public class DashManifest extends AbstractStorageEntity {

	@OneToOne
	private Video video;

	public Video getVideo() {
		return video;
	}

	public void setVideo(final Video video) {
		this.video = video;
	}

}
