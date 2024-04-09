package ma.emsi.inventory_service.web;

import ma.emsi.inventory_service.dao.entities.Creator;
import ma.emsi.inventory_service.dao.entities.Video;
import ma.emsi.inventory_service.metier.CreatorManager;
import ma.emsi.inventory_service.metier.VideoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class VideoController {
    @Autowired
    VideoManager videoManager;

    @Autowired
    CreatorManager creatorManager;

    @GetMapping("")
    public String index(Model model){
        List<Video> videos = videoManager.getAllVideo();
        model.addAttribute("listVideo", videos);
        return "index";
    }

    @PostMapping("/search")
    public String index(Model model,  Integer search){
        Video video = videoManager.getVideoById(search);
        System.out.println(video);
        model.addAttribute("listVideo", Arrays.asList(video));
        return "index";
    }

    @GetMapping("/addvideo")
    public String ajouterVideo(Model model){
        Video video = new Video();
        model.addAttribute("video", video);
        List<Creator> nameCreators = creatorManager.getAllCreator();
        model.addAttribute("listNameCreator", nameCreators);
        return "ajouterVideo";
    }

    @PostMapping("/addvideo")
    public String ajouterVideo(@ModelAttribute() Video video){
        //System.out.println(video.getDatePublication());
        videoManager.addVideo(video);
        return "redirect:/";
    }

    @GetMapping("/updatevideo/{id}")
    public String modifierVideo(@PathVariable(value = "id") Integer id, Model model){
        Video video = videoManager.getVideoById(id);
        model.addAttribute("video", video);
        List<Creator> nameCreators = creatorManager.getAllCreator();
        model.addAttribute("listNameCreator", nameCreators);
        return "modifierVideo";
    }

    @PostMapping("/updatevideo")
    public String modifierVideo(@ModelAttribute Video video){
        videoManager.updateVideo(video);
        return "redirect:/";
    }
    @GetMapping("/deletevideo/{id}")
    public String supprimerVideo(@PathVariable(value = "id") Integer id, Model model){
        Video video = videoManager.getVideoById(id);
        model.addAttribute("video", video);
        return "supprimerVideo";
    }
    @PostMapping("/deletevideo")
    public String supprimerVideo(@ModelAttribute Video video){
        videoManager.deleteVideo(video);
        return "redirect:/";
    }


}
