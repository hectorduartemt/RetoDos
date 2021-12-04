/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RetoDos.Services;

import RetoDos.Model.User;
import RetoDos.Repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hldua
 */
@Service
public class UserServices {
    
    @Autowired
    private UserRepository repository;
    
    public List<User> getAll(){
        return repository.getAll();
    }
    
    public Optional<User> getUserById(Integer id){
        return repository.getUserById(id);
    }
    
    public User save(User user){
        
        if(user.getId()== null){
            return user;
        }else{
            if(user.getIdentification()== null || user.getEmail() == null || user.getName() == null || user.getPassword() == null || user.getType() == null){
                return user; 
            }else{
                List <User> existUsers = repository.getUserByIdOrEmailOrName(user.getId(), user.getEmail(), user.getName());
                if(existUsers.isEmpty()){
                  return repository.save(user);  
                }else{
                    return user;
                }
            } 
        }
    }

    
    public boolean getUserByEmail(String email){
        return repository.getUserByEmail(email).isPresent();
    }
    
    public User getUserByEmailAndPassword(String email, String password){
        Optional<User> user = repository.getUserByEmailAndPassword(email, password);
        if (user.isPresent()){
            return user.get();
        }else{
            return new User();
        }
    }
    
    public User update(User user){
        Optional<User> existsUser = repository.getUserById(user.getId());
        if(existsUser.isPresent()){
            if(user.getIdentification()!= null){
                existsUser.get().setIdentification(user.getIdentification());
            }
            if(user.getName()!= null){
                existsUser.get().setName(user.getName());
            }
            if(user.getAddress()!= null){
                existsUser.get().setAddress(user.getAddress());
            }
            if(user.getCellPhone()!= null){
                existsUser.get().setCellPhone(user.getCellPhone());
            }
            if(user.getEmail()!= null){
                existsUser.get().setEmail(user.getEmail());
            }
            if(user.getPassword()!= null){
                existsUser.get().setPassword(user.getPassword());
            }
            if(user.getZone()!= null){
                existsUser.get().setZone(user.getZone());
            }
            if(user.getType()!= null){
                existsUser.get().setType(user.getType());
            }
            return repository.save(existsUser.get());
        }else{
            return user;
        }
    }
    
    public boolean delete(Integer id){
        Boolean aBoolean = getUserById(id).map(user ->{
           repository.delete(user.getId());
           return true;
        }).orElse(false);
        return aBoolean;
    }
}
