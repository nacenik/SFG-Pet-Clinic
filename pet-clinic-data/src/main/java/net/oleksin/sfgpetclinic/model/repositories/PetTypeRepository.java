package net.oleksin.sfgpetclinic.model.repositories;

import net.oleksin.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
