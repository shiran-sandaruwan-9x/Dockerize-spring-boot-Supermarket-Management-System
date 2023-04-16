package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.ItemsDTO;
import lk.ijse.spring.entity.Items;
import lk.ijse.spring.exception.NotFoundException;
import lk.ijse.spring.exception.NullPointException;
import lk.ijse.spring.exception.ValidateException;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepo itemRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public boolean saveItems(ItemsDTO dto) {
        if (dto!=null){
            if (itemRepo.existsById(dto.getItemId())){
                throw new ValidateException("item not exist");
            }
            itemRepo.save(mapper.map(dto, Items.class));
            return true;
        }
        throw new NullPointException("add items details");
    }

    @Override
    public boolean updateItems(ItemsDTO dto) {
        if (dto!=null){
            if (itemRepo.existsById(dto.getItemId())){
                itemRepo.save(mapper.map(dto, Items.class));
                return true;
            }
            throw new NotFoundException("this item not found to update");
        }
        throw new NullPointException("add items details");
    }

    @Override
    public ItemsDTO searchItems(String itemId, String itemName) {
        if (itemId!="" || itemName!=""){
           return mapper.map(itemRepo.findByItemIdOrItemName(itemId,itemName),ItemsDTO.class);
        }
        throw new NotFoundException("this item not found");
    }

    @Override
    public List<ItemsDTO> getAllItems() {
        List<Items> all = itemRepo.findAll();
        if (all!=null && !all.isEmpty()){
            return mapper.map(all,new TypeToken<ArrayList<ItemsDTO>>(){}.getType());
        }
        throw new NullPointException("items don't have");
    }

    @Override
    public boolean deleteItems(String itemId) {
        if (itemRepo.existsById(itemId)){
            itemRepo.deleteById(itemId);
            return true;
        }
        throw new NotFoundException("this item not found to delete");
    }
}
