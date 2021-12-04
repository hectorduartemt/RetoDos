package RetoDos;

import RetoDos.CrudRepositories.HairProductCrudRepository;
import RetoDos.CrudRepositories.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RetoDosApplication implements CommandLineRunner {

    @Autowired
    private HairProductCrudRepository productRepository;

    @Autowired
    private UserCrudRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(RetoDosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.deleteAll();
        userRepository.deleteAll();
    }

}
