package net.oleksin.sfgpetclinic.bootstrap;

import net.oleksin.sfgpetclinic.model.Owner;
import net.oleksin.sfgpetclinic.model.Vet;
import net.oleksin.sfgpetclinic.services.OwnerService;
import net.oleksin.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("EvGeiny");
        owner1.setLastName("Martynuk");

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Nikita");
        owner2.setLastName("Oleksin");

        System.out.println("Loaded Owners.....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("John");
        vet1.setLastName("Smith");

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Lussy");
        vet2.setLastName("Leks");

        System.out.println("Loaded Vets......");

    }
}
