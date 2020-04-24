package net.oleksin.sfgpetclinic.repositories;

import net.oleksin.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
