package com.example.personalshoppersystem.Controller;

import com.example.personalshoppersystem.API.ApiResponse;
import com.example.personalshoppersystem.Model.PersonalShopper;
import com.example.personalshoppersystem.Service.PersonalShopperService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/personalShopper")
@RequiredArgsConstructor
public class PersonalShopperController {

    private final PersonalShopperService personalShopperService;
    @GetMapping("/get")
    public ResponseEntity getPersonalShoppers(){
        return ResponseEntity.status(200).body(personalShopperService.getPersonalShoppers());
    }
    @PostMapping("/add")
    public ResponseEntity addPersonalShopper(@RequestBody @Valid PersonalShopper personalShopper){
        personalShopperService.addPersonalShoppers(personalShopper);
        return ResponseEntity.status(200).body(new ApiResponse("Shopper added"));
    }


}
