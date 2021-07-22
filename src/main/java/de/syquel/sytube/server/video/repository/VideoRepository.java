package de.syquel.sytube.server.video.repository;

import de.syquel.sytube.server.video.data.Video;
import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepositoryBase;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class VideoRepository implements ReactivePanacheMongoRepositoryBase<Video, ObjectId> {

}
