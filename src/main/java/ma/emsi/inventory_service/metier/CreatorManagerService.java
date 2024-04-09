package ma.emsi.inventory_service.metier;

import ma.emsi.inventory_service.dao.entities.Creator;
import ma.emsi.inventory_service.dao.repository.CreatorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreatorManagerService implements CreatorManager{
    @Autowired
    CreatorRepo creatorRepo;

    @Override
    public Creator addCreator(Creator creator) {
        try{
            return creatorRepo.save(creator);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        return null;
    }

    @Override
    public void updateCreator(Creator creator) {
        try {
            creatorRepo.updateCreatorById(creator.getName(), creator.getEmail(), creator.getId());
            System.out.println("Modifier avec succes");
        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public boolean deleteCreatorById(Integer id) {
        try{
            creatorRepo.deleteById(id);
            return true;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }
        return false;
    }
    @Override
    public boolean deleteCreator(Creator creator) {
        try{
            creatorRepo.delete(creator);
            return true;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }
        return false;
    }

    @Override
    public Creator getCreator(Integer id) {
        return creatorRepo.findById(id).get();
    }

    @Override
    public List<Creator> getAllCreator() {
        return creatorRepo.findAll();
    }
}
