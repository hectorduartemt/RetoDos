/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RetoDos.Web;

import RetoDos.Model.User;
import RetoDos.Services.UserServices;
import java.util.List;
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
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {
    
    @Autowired /*Autowired busca un objeto manejado, de esta manera no es necesario crear una instancianueva del objetocada vez que se necesite*/
    private UserServices service;
    
    @GetMapping("/all")/*Mostramos todos los usuarios registrados en la tabla user*/
    public List<User> getUsers(){
        return service.getAll();
    }
    
    @PostMapping("/new")/*Agregamos nuevos usuarios en la tabla user*/
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user){
        return service.save(user);
    }
    
    @PutMapping("/update")/*Agregamos nuevos usuarios en la tabla user*/
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user){
        return service.update(user);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id){
        return service.delete(id);
    }
    
    @GetMapping("/emailexist/{email}")/*Realizamos la busqueda por medio del correo electronico registrado*/
    public boolean existEmail(@PathVariable("email")String email){
        return service.getUserByEmail(email);
    }
    
    @GetMapping("/{email}/{password}")/*Realizamos la busqueda por medio del correo electronico y la contraseña registrada*/
    public User authUser(@PathVariable("email")String email,@PathVariable("password")String password){
        return service.getUserByEmailAndPassword(email,password);
    }
    
}
