/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RetoDos.CrudRepositories;

import RetoDos.Model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author hldua
 */
public interface UserCrudRepository extends MongoRepository<User, Integer> {
    
    public Optional<User> findByName(String name);
    public List<User> findByNameOrEmail(String name, String email);
    public Optional<User> findByEmail(String email);
    public Optional<User> findByEmailAndPassword(String email, String password);    
    public List<User> findByIdOrEmailOrName(Integer id, String Email, String Name);
}
