package com.example.personalshoppersystem.Service;



import com.example.personalshoppersystem.Model.PersonalShopper;
import com.example.personalshoppersystem.Repository.PersonalShopperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonalShopperService {

    private final PersonalShopperRepository personalShopperRepository;

    public List<PersonalShopper> getPersonalShoppers(){

        return personalShopperRepository.findAll();
    }
    public void addPersonalShoppers(PersonalShopper personalShopper){

        personalShopperRepository.save(personalShopper);
    }

    /*public void updatePersonalShoppers(PersonalShopperModel personalShopper, Integer id){
        PersonalShopperModel oldPersonalShopper = personalShopperRepository.findPersonalShopperModelById(id);
        if(oldPersonalShopper ==null)
            throw new ApiException("Id not found");

        oldPersonalShopper
    }*/

    public List<PersonalShopper> getPersonalShopperByCity(String city){

        List<PersonalShopper> personalShoppers=personalShopperRepository.findPersonalShopperModelByCity(city);
        return personalShoppers;
    }
    public PersonalShopper getPersonalShopperByUsername(String username){

        PersonalShopper personalShopper=personalShopperRepository.findPersonalShopperModelByUsername(username);
        return personalShopper;
    }
}
