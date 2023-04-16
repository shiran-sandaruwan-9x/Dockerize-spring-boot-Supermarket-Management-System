package lk.ijse.spring.controller;

import lk.ijse.spring.dto.ItemsDTO;
import lk.ijse.spring.exception.ValidateException;
import lk.ijse.spring.service.ItemService;
import lk.ijse.spring.utils.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity saveItems(@RequestBody ItemsDTO dto){
        if (dto.getItemId().trim().length()<=0 && dto.getItemName().trim().length()<=0){
            throw new ValidateException("item id or item name not be empty");
        }
        itemService.saveItems(dto);
        return new ResponseEntity(new StandardResponse("201","success",dto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateItems(@RequestBody ItemsDTO dto){
        if (dto.getItemId().trim().length()<=0 && dto.getItemName().trim().length()<=0){
            throw new ValidateException("item id or item name not be empty");
        }
        itemService.updateItems(dto);
        return new ResponseEntity(new StandardResponse("200","success",dto), HttpStatus.OK);
    }

    @DeleteMapping(params = {"itemId"})
    public ResponseEntity deleteItems(@RequestParam String itemId){
        if(itemId.trim().length()<=0){
            throw new ValidateException("item id not be empty");
        }
        itemService.deleteItems(itemId);
        return new ResponseEntity(new StandardResponse("200","success",true),HttpStatus.OK);
    }

    @GetMapping(params = {"itemId","itemName"})
    public ResponseEntity searchItems(@RequestParam String itemId,@RequestParam String itemName){
        ItemsDTO itemsDTOList = itemService.searchItems(itemId, itemName);
        return new ResponseEntity(new StandardResponse("200","success",itemsDTOList),HttpStatus.OK);
    }

    @GetMapping("/getAllItems")
    public ResponseEntity getAllItems(){
        List<ItemsDTO> allItems = itemService.getAllItems();
        return new ResponseEntity(new StandardResponse("200","success",allItems),HttpStatus.OK);
    }

}
