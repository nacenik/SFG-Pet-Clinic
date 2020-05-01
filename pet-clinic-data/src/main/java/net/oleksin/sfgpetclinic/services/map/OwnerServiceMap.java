package net.oleksin.sfgpetclinic.services.map;

import net.oleksin.sfgpetclinic.model.Owner;
import net.oleksin.sfgpetclinic.model.Pet;
import net.oleksin.sfgpetclinic.services.OwnerService;
import net.oleksin.sfgpetclinic.services.PetService;
import net.oleksin.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private  final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        Owner saveOwner = null;
        if(object != null){
            if (object.getPets() != null){
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null){
                        if (pet.getPetType().getId() == null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }
                    else {
                        throw new RuntimeException("Pet Type is Required");
                    }

                    if (pet.getId() == null){
                        Pet sevedPet = petService.save(pet);
                        pet.setId(sevedPet.getId());
                    }
                });
            }
            return super.save(object);
        }
        return null;
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll()
                .stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }
}
