package org.study.reactive.repository;

import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import org.study.reactive.dto.ProductDto;
import org.study.reactive.model.Product;
import reactor.core.publisher.Flux;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

    Flux<ProductDto> findByPriceBetween(Range<Double> priceRange);

}
