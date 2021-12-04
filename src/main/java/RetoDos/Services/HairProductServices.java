/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RetoDos.Services;

import RetoDos.Model.HairProduct;
import RetoDos.Repositories.HairProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hldua
 */
@Service
public class HairProductServices {

    @Autowired
    private HairProductRepository repository;

    public List<HairProduct> getAll() {
        return repository.getAll();
    }

    public Optional<HairProduct> getByReference(String reference) {
        return repository.getByReference(reference);
    }

    public HairProduct save(HairProduct product) {
        if (product.getReference() == null) {
            return product;
        } else {
            return repository.save(product);
        }
    }
    
    public HairProduct update(HairProduct product) {
        if (product.getReference() != null) {
            Optional<HairProduct> existsProduct = repository.getByReference(product.getReference());
            
            if (!existsProduct.isEmpty()) {
                
                if (product.getBrand() != null) {
                    existsProduct.get().setBrand(product.getBrand());
                }
                if (product.getCategory() != null) {
                    existsProduct.get().setCategory(product.getCategory());
                }
                if (product.getName() != null) {
                    existsProduct.get().setName(product.getName());
                }
                if (product.getDescription() != null) {
                    existsProduct.get().setDescription(product.getDescription());
                }
                if (product.getPrice() != 0.0) {
                    existsProduct.get().setPrice(product.getPrice());
                }
                if (product.getQuantity() != 0) {
                    existsProduct.get().setQuantity(product.getQuantity());
                }
                if (product.getPhotography() != null) {
                    existsProduct.get().setPhotography(product.getPhotography());
                }
                existsProduct.get().setAvailability(product.isAvailability());
                repository.save(existsProduct.get());
                return existsProduct.get();
            } else {
                
                return product;
            }
        } else {
            return product;
        }
    }
    
    public boolean delete(String reference){
        Boolean aBoolean = getByReference(reference).map(product ->{
           repository.delete(product);
           return true;
        }).orElse(false);
        return aBoolean;
    }
}
