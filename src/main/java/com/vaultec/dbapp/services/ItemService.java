package com.vaultec.dbapp.services;

import com.vaultec.dbapp.gui.cards.DefaultCard;
import com.vaultec.dbapp.model.entity.Item;
import com.vaultec.dbapp.repository.DwellerRepository;
import com.vaultec.dbapp.repository.ItemsRepository;
import com.vaultec.dbapp.validation.UsableBy;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Getter
@Setter(onMethod = @__(@Autowired))
public class ItemService {

    private ItemsRepository itemsRepository;
    private DwellerRepository dwellerRepository;

    List<Item> findItemsByDwellerId(Long id) {
        return this.itemsRepository.findAllByDwellerId(id);
    }

    public List<Item> findAll() {
        return this.itemsRepository.findAll();
    }

    boolean toggleReservation(Long itemId) {
        Optional<Item> existing = itemsRepository.findById(itemId);

        if(existing.isEmpty()) {
            System.out.println("SELECTED ITEM DOESN'T EXIST (ID MISMATCH).");
            return false;
        }

        Item item = existing.get();

        if(
                !item.getDweller().getDweller_id().equals(-1L)
                && !item.getDweller().getDweller_id().equals(DefaultCard.getCurrentDweller().getDweller_id())
        ) {
            System.out.println("SELECTED ITEM IS ALREADY RESERVED BY SOMEONE ELSE");
            return false;
        }

        item.setDweller(dwellerRepository.findById(DefaultCard.getCurrentDweller().getDweller_id()).get());

        itemsRepository.save(item);

        return true;
    }
}
