package com.vaultec.dbapp.services;

import com.vaultec.dbapp.gui.cards.DefaultCard;
import com.vaultec.dbapp.model.entity.Generator;
import com.vaultec.dbapp.model.entity.Item;
import com.vaultec.dbapp.model.enums.UserType;
import com.vaultec.dbapp.repository.DwellerRepository;
import com.vaultec.dbapp.repository.ItemsRepository;
import com.vaultec.dbapp.validation.UsableBy;
import com.vaultec.dbapp.validation.UserValidator;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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

    public boolean addItem(Item item) {
        this.itemsRepository.save(item);
        return true;
    }

    public boolean toggleReservation(Long itemId) {
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

        if(item.getDweller().getDweller_id().equals(DefaultCard.getCurrentDweller().getDweller_id()))
            item.setDweller(dwellerRepository.findById(-1L).get());
        else
            item.setDweller(dwellerRepository.findById(DefaultCard.getCurrentDweller().getDweller_id()).get());

        itemsRepository.save(item);

        return true;
    }

    @UsableBy({UserType.MANAGER, UserType.OVERSEER})
    public boolean setVerStatus(List<Long> itemId, String verStatus) {

        try {
            if (!UserValidator.isAllowed(
                    DefaultCard.getCurrentDweller().getJob().getJob_title().toUpperCase(),
                    this.getClass().getDeclaredMethod("setVerStatus", List.class, String.class)
            )) {
                System.out.println("USER IS UNABLE TO PERFORM VERIFICATION.");
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        List<Item> items =
                itemId.stream()
                        .map( id -> itemsRepository.findById(id).orElse(null))
                        .toList();

        items.forEach( item -> {
            if(item == null) {
                return;
            }
            item.setVerStatus(verStatus);
            itemsRepository.save(item);
        });

        if(items.contains(null)) {
            System.out.println("COMPLETED VERIFICATION PROCESS WITH SOME ERRORS.");
        }

        System.out.println("VERIFIED " + items.stream().filter(Objects::nonNull).count() + " GENERATORS SUCCESSFULLY.");
        return true;
    }
}
