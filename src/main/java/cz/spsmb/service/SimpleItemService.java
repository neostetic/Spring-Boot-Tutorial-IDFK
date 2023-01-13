package cz.spsmb.service;

import cz.spsmb.entity.Item;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class SimpleItemService implements ItemService {

    private List<Item> items = new LinkedList<>();

    @Override
    public List<Item> getAll() {
        return items;
    }

    @Override
    public void save(Item item) {
        this.items.add(item);
    }
}
