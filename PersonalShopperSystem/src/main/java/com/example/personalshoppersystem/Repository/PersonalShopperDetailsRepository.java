package com.example.personalshoppersystem.Repository;


import com.example.personalshoppersystem.Model.PersonalShopperDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalShopperDetailsRepository extends JpaRepository<PersonalShopperDetails,Integer> {

    PersonalShopperDetails findPersonalShopperDetailsModelById(Integer id);
}
