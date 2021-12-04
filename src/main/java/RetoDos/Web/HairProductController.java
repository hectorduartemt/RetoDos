/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RetoDos.Web;

import RetoDos.Model.HairProduct;
import RetoDos.Services.HairProductServices;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hldua
 */
@RestController
@RequestMapping("/api/hairproducts")
@CrossOrigin(origins = "*")
public class HairProductController {
    
    @Autowired
    private HairProductServices service;
    
    @GetMapping("/all")/*Mostramos todos los usuarios registrados en la tabla user*/
    public List<HairProduct> getAll(){
        return service.getAll();
    }
    
    @GetMapping("/{reference}")/*Mostramos todos los usuarios registrados en la tabla user*/
    public Optional<HairProduct> getByReference(@PathVariable("reference")String reference){
        return service.getByReference(reference);
    }
    
     @PostMapping("/new")/*Agregamos nuevos usuarios en la tabla user*/
    @ResponseStatus(HttpStatus.CREATED)
    public HairProduct save(@RequestBody HairProduct product){
        return service.save(product);
    }
    
    @PutMapping("/update")/*Agregamos nuevos usuarios en la tabla user*/
    @ResponseStatus(HttpStatus.CREATED)
    public HairProduct update(@RequestBody HairProduct product){
        return service.update(product);
    }
    
    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference){
        return service.delete(reference);
    }
    
}
