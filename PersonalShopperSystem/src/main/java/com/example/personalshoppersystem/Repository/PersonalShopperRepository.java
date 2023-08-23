package com.example.personalshoppersystem.Repository;


import com.example.personalshoppersystem.Model.PersonalShopper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalShopperRepository extends JpaRepository<PersonalShopper,Integer> {

    PersonalShopper findPersonalShopperModelById(Integer id);
    PersonalShopper findPersonalShopperModelByUsername(String username);
    List<PersonalShopper> findPersonalShopperModelByCity(String city);
}
