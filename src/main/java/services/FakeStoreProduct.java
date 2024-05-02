package services;

import Dtos.FakeStoreProductDto;
import models.Category;
import models.Product;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProduct implements ProductService {

    @Override
    public Product getSingleProduct(Long id) {
        RestTemplate restTemplate = new RestTemplate();

        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);

        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImageUrl(fakeStoreProductDto.getImageUrl());

        Category category = new Category();
        category.setTitle("Vishnu");
        product.setCategory(category);
        return product;
    }
}
