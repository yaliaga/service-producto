package pe.com.service.product.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import pe.com.service.product.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
	
	Flux<Product> findByIdClient(String idClient);
	
	Mono<Product> saveProduct(Product product);
}
