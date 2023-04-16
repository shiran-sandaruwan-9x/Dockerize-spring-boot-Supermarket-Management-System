package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepo extends JpaRepository<Items,String> {

    Items findByItemIdOrItemName(String itemId, String itemName);
    List<Items> findAllByItemId(String itemId);

}
