package pe.com.service.product.service;

import pe.com.service.product.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
void createProduct(Product product);
    
    Mono<Product> findByProductId(String id);
 
    Flux<Product> findAllProduct();
 
    Mono<Product> updateProduct(Product product);
 
    Mono<Void> deleteProduct(String id);
}
