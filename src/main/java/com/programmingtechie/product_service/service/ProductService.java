package com.programmingtechie.product_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.programmingtechie.product_service.dto.ProductRequest;
import com.programmingtechie.product_service.dto.ProductResponse;
import com.programmingtechie.product_service.entity.Product;
import com.programmingtechie.product_service.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

	private final ProductRepository repository;

	public void createProduct(ProductRequest productRequest) {
		Product product = Product.builder().name(productRequest.getName()).description(productRequest.getDescription())
				.price(productRequest.getPrice()).build();

		repository.save(product);
		log.info("Product {} is saved", product.getId());
	}

	public List<ProductResponse> getAllProduct() {
		List<Product> products = repository.findAll();

		// khi sử dụng 1 phương thức trong lớp có thể sử dụng tham chiếu phương thức
		// theo dạng 'this::mapToProductResponse'
		return products.stream().map(this::mapToProductResponse).toList();
	}

	private ProductResponse mapToProductResponse(Product product) {
		return ProductResponse.builder().id(product.getId()).name(product.getName())
				.description(product.getDescription()).price(product.getPrice()).build();
	}
}
