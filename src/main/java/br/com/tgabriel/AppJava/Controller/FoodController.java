package br.com.tgabriel.AppJava.Controller;

import br.com.tgabriel.AppJava.Food.Food;
import br.com.tgabriel.AppJava.Food.FoodRepository;
import br.com.tgabriel.AppJava.Food.FoodRequestDTO;
import br.com.tgabriel.AppJava.Food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("FOOD")

public class FoodController {

    @Autowired
    private FoodRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data ){
       Food food = new Food(data);
        repository.save(food);

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDTO> getAll(){

        List<FoodResponseDTO> foods = repository.findAll().stream().map(FoodResponseDTO::new).toList();

        return foods;
    }
}
