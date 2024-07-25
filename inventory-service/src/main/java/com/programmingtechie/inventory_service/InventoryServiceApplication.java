package com.programmingtechie.inventory_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.programmingtechie.inventory_service.entity.Inventory;
import com.programmingtechie.inventory_service.repository.InventoryRepository;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args -> {
			Inventory inv = new Inventory();
			inv.setSkuCode("iphone_13");
			inv.setQuantity(100);

			Inventory inv_1 = new Inventory();
			inv_1.setSkuCode("iphone_13_red");
			inv_1.setQuantity(100);

			inventoryRepository.save(inv);
			inventoryRepository.save(inv_1);
		};
	}
}
