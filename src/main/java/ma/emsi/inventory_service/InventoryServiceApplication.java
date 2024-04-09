package ma.emsi.inventory_service;

import ma.emsi.inventory_service.dao.entities.Creator;
import ma.emsi.inventory_service.dao.entities.Video;
import ma.emsi.inventory_service.dao.repository.CreatorRepo;
import ma.emsi.inventory_service.dao.repository.VideoRepo;
import ma.emsi.inventory_service.metier.CreatorManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@SpringBootApplication
public class InventoryServiceApplication {
    @Autowired
    CreatorRepo creatorRepo;
    @Autowired
    VideoRepo videoRepo;

    @Autowired
    CreatorManager creatorManager;
    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner startup() {
        return args -> {
            //null, "Ahmed", "Ahmed@gmail.com", null
            /*
            Creator cr1 = new Creator();
            cr1.setName("AstronoTech Productions");
            cr1.setEmail("contact@astronotech.com");

            Creator cr2 = new Creator();
            cr2.setName("ChefCuisine Channel");
            cr2.setEmail("info@chefcuisinechannel.com");

            Creator cr3 = new Creator();
            cr3.setName("CodeMasters Academy");
            cr3.setEmail("support@codemastersacademy.org");

            Creator cr4 = new Creator();
            cr4.setName("Wanderlust Adventures");
            cr4.setEmail("contact@wanderlustadventures.com");

            Creator cr5 = new Creator();
            cr5.setName("FitLife Studio");
            cr5.setEmail("support@fitlifestudio.com");

            List<Creator> creators = new ArrayList<>(Arrays.asList(cr1, cr2, cr3, cr4, cr5));
            creatorRepo.saveAll(creators);
             */

            /*
            Video vd1 = new Video();
            vd1.setName("Le mystère des trous noirs (Documentaire)");
            vd1.setUrl("https://youtu.be/_AR-yX_GIuc?si=RYCPvL95PoAC3d8r");
            vd1.setDescription("Les trous noirs, les entités ou les régions les plus fascinantes de l'univers");
            vd1.setDatePublication(LocalDate.now());
            vd1.setCreator(cr1);
            videoRepo.save(vd1);

            Video vd2 = new Video();
            vd2.setName("A la recherche de la Théorie du Tout (Documentaire)");
            vd2.setUrl("https://www.youtube.com/watch?v=CORpXO4qPjE");
            vd2.setDescription("La théorie du tout est une théorie qui viserait à unifier les 2 principales théories de notre univers");
            vd2.setDatePublication(LocalDate.parse("2024-01-07"));
            //vd2.setDatePublication(new Date(2024, Calendar.MARCH, 16));
            vd2.setCreator(cr2);
            videoRepo.save(vd2);

            System.out.println(creatorRepo.findById(cr1.getId()));
            cr1.setName("Toto");
            cr1.setEmail("toto@exemple.com");
            creatorManager.updateCreator(cr1);
            System.out.println(creatorManager.getCreator(cr1.getId()));
            videoRepo.delete(vd1);
            */
        };
    }

}
