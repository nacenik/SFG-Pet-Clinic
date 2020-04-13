package net.oleksin.sfgpetclinic.bootstrap;

import net.oleksin.sfgpetclinic.model.Owner;
import net.oleksin.sfgpetclinic.model.PetType;
import net.oleksin.sfgpetclinic.model.Vet;
import net.oleksin.sfgpetclinic.services.OwnerService;
import net.oleksin.sfgpetclinic.services.PetTypeService;
import net.oleksin.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Reks");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Saumon");
        PetType saveCatPetType = petTypeService.save(cat);

        System.out.println("Loaded Pets.......");


        Owner owner1 = new Owner();
        owner1.setFirstName("EvGeiny");
        owner1.setLastName("Martynuk");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Nikita");
        owner2.setLastName("Oleksin");
        ownerService.save(owner2);

        System.out.println("Loaded Owners.....");

        Vet vet1 = new Vet();
        vet1.setFirstName("John");
        vet1.setLastName("Smith");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Lussy");
        vet2.setLastName("Leks");
        vetService.save(vet2);

        System.out.println("Loaded Vets......");

    }
}
