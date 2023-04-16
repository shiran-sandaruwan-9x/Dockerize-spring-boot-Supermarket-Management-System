package lk.ijse.spring.service;

import lk.ijse.spring.dto.ItemsDTO;

import java.util.List;

public interface ItemService {
    boolean saveItems(ItemsDTO dto);
    boolean updateItems(ItemsDTO dto);
    ItemsDTO searchItems(String itemId,String itemName);
    List<ItemsDTO> getAllItems();
    boolean deleteItems(String itemId);
}
