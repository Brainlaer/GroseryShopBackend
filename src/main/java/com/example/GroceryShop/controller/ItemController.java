package com.example.GroceryShop.controller;

import com.example.GroceryShop.model.GroceryItem;
import com.example.GroceryShop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/getAll")
    public String getAll(){
        return itemService.getAll();
    }

    @PostMapping("/insert")
    public String insert(@RequestBody GroceryItem groceryItem){
        return itemService.insert(groceryItem);
    }

    @PutMapping("/update")
    public String update(@RequestBody GroceryItem groceryItem){
        return itemService.update(groceryItem);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteItem(@PathVariable("id") String id) {
        return itemService.delete(id);
    }

    @PatchMapping("/updateData/{id}")
    public String updateData(@PathVariable String id, @RequestBody GroceryItem groceryItem){
        return itemService.updateData(id, groceryItem);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.HEAD)
    public ResponseEntity<?> handleHeadRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.OPTIONS)
    public String optionsUpdate() {
        return itemService.optionsUpdate();
    }

}
