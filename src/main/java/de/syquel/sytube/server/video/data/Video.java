package de.syquel.sytube.server.video.data;

import de.syquel.sytube.server.common.data.AbstractEntity;
import io.quarkus.mongodb.panache.MongoEntity;

import java.util.List;

@MongoEntity
public class Video extends AbstractEntity {

	private String title;

	private String description;

	private DashManifest dashManifest;

	private List<VideoTrack> videoTracks;

	private List<AudioTrack> audioTracks;

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

	public DashManifest getDashManifest() {
		return dashManifest;
	}

	public void setDashManifest(final DashManifest dashManifest) {
		this.dashManifest = dashManifest;
	}

	public List<VideoTrack> getVideoTracks() {
		return videoTracks;
	}

	public void setVideoTracks(final List<VideoTrack> videoTracks) {
		this.videoTracks = videoTracks;
	}

	public List<AudioTrack> getAudioTracks() {
		return audioTracks;
	}

	public void setAudioTracks(final List<AudioTrack> audioTracks) {
		this.audioTracks = audioTracks;
	}
}
