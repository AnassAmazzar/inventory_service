package ma.emsi.inventory_service.metier;

import ma.emsi.inventory_service.dao.entities.Creator;

import java.util.List;

public interface CreatorManager {
    Creator addCreator(Creator creator);
    void updateCreator(Creator creator);
    boolean deleteCreatorById(Integer id);
    boolean deleteCreator(Creator creator);
    Creator getCreator(Integer id);
    List<Creator> getAllCreator();
}
