package de.syquel.sytube.server.video.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.syquel.sytube.server.video.data.Video;
import de.syquel.sytube.server.video.repository.VideoRepository;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import org.bson.types.ObjectId;
import org.jboss.resteasy.reactive.RestPath;

import java.util.List;

@Path("videos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VideoController {

	private final VideoRepository videoRepository;

	@Inject
	public VideoController(final VideoRepository videoRepository) {
		this.videoRepository = videoRepository;
	}

	@GET
	@Path("")
	public Uni<List<Video>> list() {
		return videoRepository.listAll();
	}

	@GET
	@Path("{id:[a-fA-F0-9]}")
	public Uni<Video> read(@RestPath final String id) {
		return videoRepository.findById(new ObjectId(id));
	}

}
