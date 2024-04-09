package ma.emsi.inventory_service.dao.repository;

import jakarta.transaction.Transactional;
import ma.emsi.inventory_service.dao.entities.Creator;
import ma.emsi.inventory_service.dao.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;

@Transactional
public interface VideoRepo extends JpaRepository<Video, Integer> {
    @Modifying
    @Query("update Video v set v.name = :name, v.url= :url, v.description= :description, v.datePublication = :datePublication," +
            " v.creator = :creator where v.id = :id")
    int updateById(@Param(value = "id") long id, @Param(value = "name") String name, @Param(value = "url") String url,
                    @Param(value="description") String description, @Param(value="datePublication") LocalDate datePublication,
                    @Param(value = "creator") Creator creator);
}
