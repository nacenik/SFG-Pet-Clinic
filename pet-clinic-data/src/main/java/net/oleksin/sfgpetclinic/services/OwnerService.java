package net.oleksin.sfgpetclinic.services;

import net.oleksin.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);
}
