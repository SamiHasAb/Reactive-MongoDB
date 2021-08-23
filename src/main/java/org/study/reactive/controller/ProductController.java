package org.study.reactive.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.study.reactive.dto.ProductDto;
import org.study.reactive.model.Product;
import org.study.reactive.service.ProductService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public Flux<ProductDto> getProducts(){

        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Mono<ProductDto> getProduct(@PathVariable("id") String productId) {
        return productService.getProduct(productId);
    }

    @GetMapping("/product-range")
    public Flux<ProductDto> getProductPriceRangeBetween(@RequestParam("min") double min, @RequestParam("max")double max){
        return productService.getProductPriceRangeBtn(min,max);
    }

    @PostMapping
    public Mono<ProductDto> saveProduct(@RequestBody Mono<ProductDto> productDto){
        return productService.saveProduct(productDto);
    }

    @PutMapping("/update/{id}")
    public Mono<ProductDto> updateProduct(@RequestBody Mono<ProductDto> productDto,@PathVariable("id") String productId){
        return productService.updateProduct(productDto, productId);
    }


    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteProduct(@PathVariable("id") String productId){
        return productService.deleteProduct(productId);
    }
}
