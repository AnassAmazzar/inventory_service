package ma.emsi.inventory_service.metier;

import ma.emsi.inventory_service.dao.entities.Video;
import ma.emsi.inventory_service.dao.repository.VideoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VideoManagerService implements VideoManager{
    @Autowired
    VideoRepo videoRepoo;
    @Override
    public Video addVideo(Video video) {
        try{
            return videoRepoo.save(video);
        }catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

    @Override
    public int updateVideo(Video video) {

        return videoRepoo.updateById(video.getId(), video.getName(), video.getUrl(),
                video.getDescription(), video.getDatePublication(), video.getCreator());
    }

    @Override
    public boolean deleteVideoById(Integer id) {
        try{
            videoRepoo.deleteById(id);
            return true;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }
        return false;
    }
    @Override
    public boolean deleteVideo(Video video) {
        try{
            videoRepoo.delete(video);
            return true;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }
        return false;
    }

    @Override
    public Video getVideoById(Integer id) {
        return videoRepoo.findById(id).get();
    }
    @Override
    public List<Video> getAllVideo() {
        return videoRepoo.findAll();
    }
}
