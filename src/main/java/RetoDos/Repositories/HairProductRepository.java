/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RetoDos.Repositories;

import RetoDos.CrudRepositories.HairProductCrudRepository;
import RetoDos.Model.HairProduct;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hldua
 */
@Repository
public class HairProductRepository {
    
    @Autowired
    private HairProductCrudRepository repository;
    
    public List<HairProduct> getAll(){
        return repository.findAll();
    }
    
    public Optional<HairProduct> getByReference(String reference){
        return repository.findById(reference);
    }
    
    public HairProduct save(HairProduct product){
        return repository.save(product);
    }
    
    public HairProduct update(HairProduct product){
        return repository.save(product);
    }
    
    public void delete(HairProduct product){
        repository.delete(product);
    }
}
