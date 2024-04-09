package ma.emsi.inventory_service.metier;

import ma.emsi.inventory_service.dao.entities.Video;

import java.util.List;
import java.util.Optional;

public interface VideoManager {
    Video addVideo(Video video);
    int updateVideo(Video video);
    boolean deleteVideoById(Integer id);
    boolean deleteVideo(Video video);
    Video getVideoById(Integer id);
    List<Video> getAllVideo();
}
