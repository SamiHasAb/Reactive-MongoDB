package org.study.reactive.repository;

import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import org.study.reactive.dto.ProductDto;
import org.study.reactive.model.Product;
import reactor.core.publisher.Flux;

import java.util.UUID;
@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, UUID> {

    Flux<ProductDto> findByPriceBetween(Range<Double> priceRange);

}
