package net.oleksin.sfgpetclinic.services.map;

import net.oleksin.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    final Long id = 1L;
    final String lastName = "Blanc";

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());

        ownerServiceMap.save(Owner.builder().id(1L).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();

        assertEquals(1, owners.size());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(id);

        assertEquals(id, owner.getId());
    }

    @Test
    void saveExistingId() {
        Long newId = 2L;
        Owner owner = Owner.builder().id(newId).build();

        Owner savedOwner = ownerServiceMap.save(owner);

        assertEquals(newId, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner savedOwner = ownerServiceMap.save(Owner.builder().build());

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(id));

        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(id);

        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner blanc = ownerServiceMap.findByLastName(lastName);

        assertEquals(lastName, blanc.getLastName());
    }

    @Test
    void findByLastNameNotFound() {
        Owner owner = ownerServiceMap.findByLastName("lol");

        assertNull(owner);
    }
}