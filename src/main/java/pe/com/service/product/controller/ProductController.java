package pe.com.service.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pe.com.service.product.model.Product;
import pe.com.service.product.service.Impl.ProductServiceImpl;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
	//@Autowired
		private final ProductServiceImpl productServiceImpl;
		
		@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public void createProduct(@RequestBody Product product) {
			productServiceImpl.createProduct(product);
		}

		@GetMapping(value = "/all", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
		@ResponseBody
		public Flux<Product> findAll() {
			return productServiceImpl.findAllProduct();
		}

		@GetMapping("/{id}")
		public ResponseEntity<Mono<Product>> findProductById(@PathVariable("id") String id) {
			Mono<Product> product = productServiceImpl.findByProductId(id);
			return new ResponseEntity<Mono<Product>>(product, product != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		}
		@PutMapping
		@ResponseStatus(HttpStatus.OK)
		public Mono<Product> update(@RequestBody Product product) {
			return productServiceImpl.updateProduct(product);
		}

		@DeleteMapping("/{id}")
		@ResponseStatus(HttpStatus.OK)
		public void delete(@PathVariable("id") String id) {
			productServiceImpl.deleteProduct(id).subscribe();
		}
	
		@GetMapping("/client/{idCliente}")
		public ResponseEntity<Flux<Product>> findClientById(@PathVariable("idCliente") String idCliente) {
			Flux<Product> product = productServiceImpl.findByClientId(idCliente);
			return new ResponseEntity<Flux<Product>>(product, product != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		}
	

}
