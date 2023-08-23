package com.example.personalshoppersystem.Controller;


import com.example.personalshoppersystem.API.ApiResponse;
import com.example.personalshoppersystem.DTO.PersonalShopperDetailsDTO;
import com.example.personalshoppersystem.Service.PersonalShopperDetailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/personalShopperDetails")
@RequiredArgsConstructor
public class PersonalShopperDetailsController {

    private final PersonalShopperDetailsService personalShopperDetailsService;

    @GetMapping("/get")
    public ResponseEntity getPersonalShoppersDetails() {
        return ResponseEntity.status(200).body(personalShopperDetailsService.getPersonalShoppersDetails());

    }

    @PostMapping("/add")
    public ResponseEntity addPersonalShopperDetails(@RequestBody @Valid PersonalShopperDetailsDTO personalShopperDetailsDTO) {
        personalShopperDetailsService.addPersonalShoppersDetails(personalShopperDetailsDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Shopper added"));

    }
}
