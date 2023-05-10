package aiss.gitminer.controllers;

import aiss.gitminer.repositories.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

        private UserRepository repository;

        public UserController(UserRepository repository) {
            this.repository = repository;
        }

}
