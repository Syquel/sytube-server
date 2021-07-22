package de.syquel.sytube.server.config;

import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.interceptor.Interceptor;

import de.syquel.sytube.server.video.data.Video;
import de.syquel.sytube.server.video.data.VideoTrack;
import de.syquel.sytube.server.video.repository.VideoRepository;
import de.syquel.sytube.server.video.repository.VideoTrackRepository;
import io.quarkus.hibernate.orm.runtime.boot.scan.QuarkusScanner;
import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.runtime.Startup;

@ApplicationScoped
@Startup(Interceptor.Priority.APPLICATION)
public class DataPopulator {

	private final VideoRepository videoRepository;
	private final VideoTrackRepository videoTrackRepository;

	@Inject
	public DataPopulator(final VideoRepository videoRepository, final VideoTrackRepository videoTrackRepository) {
		this.videoRepository = videoRepository;
		this.videoTrackRepository = videoTrackRepository;
	}

	@PostConstruct
	public void populateData() {
		Panache.withTransaction(() ->{
			final Video video = new Video();
			video.setTitle("Blubb Video");
			video.setDescription("Blubb Video Description");

			return videoRepository
				.persist(video)
				.chain(persistedVideo -> {
					final VideoTrack videoTrack = new VideoTrack();
					videoTrack.setBlobName("Test1234");
					videoTrack.setCodec("h265");
					videoTrack.setQuality(VideoTrack.Quality.FHD);
					videoTrack.setBitrate(8000);
					videoTrack.setFrameRate("120/10");
					videoTrack.setVideo(persistedVideo);

					try {
						videoTrack.setMediaType(new MimeType("video/mp4"));
					} catch (final MimeTypeParseException e) {
						throw new IllegalArgumentException("Illegal mime-type format", e);
					}

					return videoTrackRepository.persist(videoTrack);
				});
		}).await().indefinitely();
	}

}
