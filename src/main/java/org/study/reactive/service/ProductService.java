package org.study.reactive.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import org.study.reactive.dto.ProductDto;
import org.study.reactive.repository.ProductRepository;
import org.study.reactive.utils.AppUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@AllArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;


    public Flux<ProductDto> getProducts(){
        System.out.println("fetching data........");
        return productRepository.findAll().map(AppUtils::entityToDto);
    }

    public Mono<ProductDto> getProduct(String productId){
        return productRepository.findById(productId).map(AppUtils::entityToDto);
    }


    public Flux<ProductDto> getProductPriceRangeBtn(double min, double max){
        return productRepository.findByPriceBetween(Range.closed(min,max));
    }

    public Mono<ProductDto> saveProduct(Mono<ProductDto> productDto){
        return  productDto.map(AppUtils::dtoToEntity)
                .flatMap(productRepository::insert)
                .map(AppUtils::entityToDto);



    }

    public Mono<ProductDto> updateProduct(Mono<ProductDto> productDto,String productId){
        return productRepository.findById(productId)
                .flatMap(p->productDto.map(AppUtils::dtoToEntity)
                        .doOnNext(e->e.setProductId(productId)))
                .flatMap(productRepository::save)
                .map(AppUtils::entityToDto);

    }

    public Mono<Void> deleteProduct(String productId){
        return productRepository.deleteById(productId);
    }
}
