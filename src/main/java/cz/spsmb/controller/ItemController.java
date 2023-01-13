package cz.spsmb.controller;

import cz.spsmb.entity.Item;
import cz.spsmb.service.ItemService;
import cz.spsmb.service.SimpleItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(path = "/items", method = RequestMethod.GET)
    public List<Item> getAllItems() {
       return itemService.getAll();
    }

    @RequestMapping(path = "/item", method = RequestMethod.POST)
    public void saveItem(@RequestBody Item item) {
        itemService.save(item);
    }
}
