package co.leantechniques.pet.service;

import co.leantechniques.pet.domain.Pet;
import org.springframework.stereotype.Component;

@Component
public class BasePetService implements PetService {

    @Override
    public Pet createPet() {
        Pet pet = new Pet();
        pet.setId(1L);
        pet.setName("Garfield");
        return pet;
    }

}
