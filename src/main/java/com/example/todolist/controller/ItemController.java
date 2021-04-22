package com.example.todolist.controller;

import com.example.todolist.model.Item;
import com.example.todolist.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemService.getItems();
        return ResponseEntity.status(HttpStatus.OK).body(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable Long id) {
        Item item = itemService.getItemById(id);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }

    @PostMapping
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        itemService.save(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item item) {
        itemService.updateById(id, item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteItem(@PathVariable Long id) {
        itemService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(id);
    }
}
