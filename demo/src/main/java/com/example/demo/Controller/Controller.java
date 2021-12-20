package com.example.demo.Controller;

import com.example.demo.Exception.UserException;
import com.example.demo.Model.entity.UserDetail;
import com.example.demo.Model.sharedobject.User;
import com.example.demo.Repostiory.UserRepository;
import com.example.demo.Service.UserService;
import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    private UserService  userService;


    @GetMapping(value="")
    public String index() {
        return "Greetings from Spring Boot!";
    }


    @PostMapping(path = "users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> create(@RequestBody User newUser) throws Exception {
       User user = userService.saveMethod(newUser);
       if (user == null) {
           throw new UserException("user are null");
        } else {
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }

    }

    @PutMapping("/update_users/{id}")
   public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id) throws Exception {

        user = userService.updateMethod(user,id);
        if (user == null) {
            throw new UserException("user are null");
        } else {
            return new ResponseEntity<>(user, HttpStatus.UPGRADE_REQUIRED);
        }
    }

    @PutMapping("inactivate_user/{id}")
    public void inactiveUser(@PathVariable Long id) throws Exception {

         userService.inactivateUserMethod(id);

    }

    @DeleteMapping("delete_user/{id}")
    public void deleteUser(@PathVariable Long id) throws Exception {

        userService.deleteUserMethod(id);

    }
    @GetMapping("get/users")
    public ResponseEntity<List<UserDetail>> searchForUser(@SearchSpec Specification<UserDetail> specs) {
        return userService.searchForUser(specs);
    }

    @GetMapping("get/users/dob")
    public ResponseEntity<List<UserDetail>> sortForUserDob() {
        return new ResponseEntity<>(userService.sortUserByDob(), HttpStatus.OK);
    }

    @GetMapping("get/users/dob")
    public ResponseEntity<List<UserDetail>> sortForUserDoj() {
        return new ResponseEntity<>(userService.sortUserByDoj(), HttpStatus.OK);
    }




}
