package ma.emsi.inventory_service.dao.repository;

import jakarta.transaction.Transactional;
import ma.emsi.inventory_service.dao.entities.Creator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

@Transactional
public interface CreatorRepo extends JpaRepository<Creator, Integer> {
    @Modifying
    @Query("update Creator c set c.name= :name,c.email= :email where c.id= :id")
    void updateCreatorById(String name, String email, Integer id);
}
