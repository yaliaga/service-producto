package pe.com.service.product.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import pe.com.service.product.model.Product;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

}
