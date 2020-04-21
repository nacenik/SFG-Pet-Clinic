package net.oleksin.sfgpetclinic.model.repositories;

import net.oleksin.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
