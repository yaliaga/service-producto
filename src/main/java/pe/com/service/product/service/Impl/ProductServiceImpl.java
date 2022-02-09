package pe.com.service.product.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.service.product.model.Product;
import pe.com.service.product.repository.ProductRepository;
import pe.com.service.product.service.ProductService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public void createProduct(Product product) {
		productRepository.save(product).subscribe();

	}

	@Override
	public Mono<Product> findByProductId(String id) {
		return productRepository.findById(id);
	}

	@Override
	public Flux<Product> findAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public Mono<Product> updateProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Mono<Void> deleteProduct(String id) {
		return productRepository.deleteById(id);
	}

}
