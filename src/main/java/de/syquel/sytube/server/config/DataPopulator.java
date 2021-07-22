package de.syquel.sytube.server.config;

import de.syquel.sytube.server.video.data.Video;
import de.syquel.sytube.server.video.data.VideoTrack;
import de.syquel.sytube.server.video.repository.VideoRepository;
import io.quarkus.runtime.Startup;

import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.interceptor.Interceptor;
import java.util.List;

@ApplicationScoped
@Startup(Interceptor.Priority.APPLICATION)
public class DataPopulator {

	private final VideoRepository videoRepository;

	@Inject
	public DataPopulator(final VideoRepository videoRepository) {
		this.videoRepository = videoRepository;
	}

	@PostConstruct
	public void populateData() {
		final Video video = new Video();
		video.setTitle("Blubb Video");
		video.setDescription("Blubb Video Description");

		final VideoTrack videoTrack = new VideoTrack();
		videoTrack.setBlobName("Test1234");
		videoTrack.setCodec("h265");
		videoTrack.setQuality(VideoTrack.Quality.FHD);
		videoTrack.setBitrate(8000);
		videoTrack.setFrameRate("120/10");

		try {
			videoTrack.setMediaType(new MimeType("video/mp4"));
		} catch (final MimeTypeParseException e) {
			throw new IllegalArgumentException("Illegal mime-type format", e);
		}

		video.setVideoTracks(List.of(videoTrack));

		videoRepository.persist(video);
	}

}
