package net.oleksin.sfgpetclinic.repositories;

import net.oleksin.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
