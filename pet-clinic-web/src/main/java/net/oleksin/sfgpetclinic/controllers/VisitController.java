package net.oleksin.sfgpetclinic.controllers;

import net.oleksin.sfgpetclinic.model.Pet;
import net.oleksin.sfgpetclinic.model.Visit;
import net.oleksin.sfgpetclinic.services.PetService;
import net.oleksin.sfgpetclinic.services.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class VisitController {

    private final String VIEW_VISIT_CREATE_OR_UPDATE_FORM = "pets/createOrUpdateVisitForm";

    private final PetService petService;
    private final VisitService visitService;

    public VisitController(PetService petService, VisitService visitService) {
        this.petService = petService;
        this.visitService = visitService;
    }

    @InitBinder
    public void loadVisit(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

    @ModelAttribute("visit")
    public Visit loadPetVisit(@PathVariable("petId") Long petId, Model model){
        Pet pet = petService.findById(petId);
        model.addAttribute("pet", pet);
        Visit visit = new Visit();
        pet.getVisits().add(visit);
        visit.setPet(pet);

        return visit;
    }

    @GetMapping("/owners/*/pets/{petId}/visits/new")
    public String initVisitForm(@PathVariable("petId") Long petId, Model model){
        return VIEW_VISIT_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/owners/{ownerId}/pets/{petId}/visits/new")
    public String processVisitForm(@Valid Visit visit, BindingResult result){
        if (result.hasErrors()){
            return VIEW_VISIT_CREATE_OR_UPDATE_FORM;
        }else {
            visitService.save(visit);
            return "redirect:/owners/{ownerId}";
        }
    }
}
