package com.example.todolist.controller;

import com.example.todolist.model.Item;
import com.example.todolist.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RequestMapping("/items")
@Controller
public class ItemPageController {

    private final ItemService itemService;

    public ItemPageController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public String getAllItems(Model model) {
        List<Item> items = itemService.getItems();
        model.addAttribute("items", items);
        return "view/items";
    }

    @GetMapping("/{id}")
    public String getItem(@PathVariable Long id, Model model) {
        Item item = itemService.getItemById(id);
        model.addAttribute("item", item);
        return "view/item";
    }

    @PostMapping
    public RedirectView addItem(@RequestParam String title, @RequestParam String description, Model model) {
        Item item = new Item(title, description);
        itemService.save(item);
        return new RedirectView("/items");
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
