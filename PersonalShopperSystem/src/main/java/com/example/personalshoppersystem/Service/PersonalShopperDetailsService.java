package com.example.personalshoppersystem.Service;


import com.example.personalshoppersystem.API.ApiException;
import com.example.personalshoppersystem.DTO.PersonalShopperDetailsDTO;
import com.example.personalshoppersystem.Model.PersonalShopperDetails;
import com.example.personalshoppersystem.Model.PersonalShopper;
import com.example.personalshoppersystem.Repository.PersonalShopperDetailsRepository;
import com.example.personalshoppersystem.Repository.PersonalShopperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class PersonalShopperDetailsService {

    private final PersonalShopperDetailsRepository personalShopperDetailsRepository;
    private final PersonalShopperRepository personalShopperRepository;

    public List<PersonalShopperDetails> getPersonalShoppersDetails(){
        return personalShopperDetailsRepository.findAll();
    }
    public void addPersonalShoppersDetails(PersonalShopperDetailsDTO personalShopperDetailsDTO){
        PersonalShopper personalShopper=personalShopperRepository.findPersonalShopperModelById(personalShopperDetailsDTO.getPersonalShopperId());
        if(personalShopper ==null)
            throw new ApiException("Id not found");

        PersonalShopperDetails personalShopperDetails = new PersonalShopperDetails(null,personalShopperDetailsDTO.getPhoneNumber(),personalShopperDetailsDTO.getBriefDescription(),personalShopperDetailsDTO.getSpecialty(),personalShopperDetailsDTO.getGender(),personalShopperDetailsDTO.getRating(),personalShopperDetailsDTO.getBalance(),personalShopper);
        personalShopperDetailsRepository.save(personalShopperDetails);
    }
}
