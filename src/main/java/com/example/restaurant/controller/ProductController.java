package com.example.restaurant.controller;

import com.example.restaurant.domain.product.Product;
import com.example.restaurant.domain.product.ProductRepository;
import com.example.restaurant.domain.product.RequestProduct;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepository repository;

    @GetMapping
    public ResponseEntity getAllProducts(){
        try {
            var allProducts = repository.findAll();
            return ResponseEntity.ok(allProducts);
        }catch (Exception e){
            throw new EntityNotFoundException("Os dados não foram encontrados");
        }
    }

    @PostMapping
    public ResponseEntity registerProduct(@Valid @RequestBody RequestProduct data){
        try {
            Product newProduct = new Product(data);
            repository.save(newProduct);
            return ResponseEntity.ok().body("Novo produto cadastrado");
        }catch (Exception e){
            throw new EntityNotFoundException("Usuário não foi cadastrado");
        }
    }

    @PutMapping
    public ResponseEntity updateProduct(@Valid @RequestBody RequestProduct data){
        Optional<Product> optionalProduct = repository.findById(data.id());
        if (optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            product.setName(data.name());
            product.setPrice(data.price());
            product.setDescription(data.description());
            product.setImage(data.image());
            repository.save(product);
            return ResponseEntity.ok().body("Produto atualizado com sucesso");
        } else {
            throw new EntityNotFoundException("Funcionário com esse id, não foi encontrado");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable String id){
        Optional<Product> optionalProduct = repository.findById(id);
        if (optionalProduct.isPresent()){
            repository.deleteById(id);
            return ResponseEntity.ok().body("O id" + id + "foi deletado");
        } else {
            throw new EntityNotFoundException();
        }
    }
}
