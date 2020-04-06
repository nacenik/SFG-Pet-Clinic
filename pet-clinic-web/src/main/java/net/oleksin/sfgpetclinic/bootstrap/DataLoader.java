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
