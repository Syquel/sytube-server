package de.syquel.sytube.server.video.repository;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;

import de.syquel.sytube.server.video.data.Video;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;

@ApplicationScoped
public class VideoRepository implements PanacheRepositoryBase<Video, UUID> {

}
