package net.oleksin.sfgpetclinic.model.repositories;

import net.oleksin.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
