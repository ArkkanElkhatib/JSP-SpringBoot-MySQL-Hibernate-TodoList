package com.example.todolist.service;

import com.example.todolist.model.Item;
import com.example.todolist.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Transactional
    public void save(Item item) {
        itemRepository.save(item);
    }

    @Transactional(readOnly = true)
    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Item getItemById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new IndexOutOfBoundsException("Item not found"));
    }

    @Transactional
    public void updateById(Long id, Item item) {
        Item prevItem = itemRepository.findById(id)
                    .orElseThrow(() -> new IndexOutOfBoundsException("Item not found"));
        item.setId(prevItem.getId());
        if (item.getTitle().compareTo("") == 0) {
            item.setTitle(prevItem.getTitle());
        }
        if (item.getDescription().compareTo("") == 0) {
            item.setDescription(prevItem.getDescription());
        }
        itemRepository.save(item);
    }

    @Transactional
    public void deleteById(Long id) {
        itemRepository.deleteById(id);
    }
}
