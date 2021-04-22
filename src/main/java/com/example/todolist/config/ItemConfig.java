package com.example.todolist.config;

import com.example.todolist.model.Item;
import com.example.todolist.repository.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ItemConfig {

    @Bean
    CommandLineRunner commandLineRunner(ItemRepository itemRepository) {
        return args -> {
            Item item1 = new Item(1L,
                        "Item 1",
                        "Desc 1");

            Item item2 = new Item(2L,
                    "Item 2",
                    "Desc 2");

            Item item3 = new Item(3L,
                    "Item 3",
                    "Desc 3");

            itemRepository.saveAll(List.of(item1, item2, item3));
        };
    }
}
