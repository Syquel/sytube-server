package de.syquel.sytube.server.video.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import de.syquel.sytube.server.video.data.Video;

@Path("videos")
public class VideoController {

	@GET
	public Video read() {
		return null;
	}

}
