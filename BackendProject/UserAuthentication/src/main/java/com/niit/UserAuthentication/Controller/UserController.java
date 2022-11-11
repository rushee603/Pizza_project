package com.niit.UserAuthentication.Controller;

import com.niit.UserAuthentication.domain.User;
import com.niit.UserAuthentication.exception.UserNotFoundException;
import com.niit.UserAuthentication.service.SecurityTokenGenerator;
import com.niit.UserAuthentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("customer/")
public class UserController {

        private ResponseEntity responseEntity;
        private UserService userService;
        private SecurityTokenGenerator securityTokenGenerator;

        @Autowired
        public UserController(UserService userService, SecurityTokenGenerator securityTokenGenerator ) {
            this.userService = userService;
            this.securityTokenGenerator = securityTokenGenerator;
        }


        @PostMapping("register")
            public ResponseEntity saveUser(@RequestBody User user) {
            User createdUser = userService.saveUser(user);
            return responseEntity = new ResponseEntity("--->> User Created <<---", HttpStatus.CREATED);}

        @PostMapping("login")
        public ResponseEntity loginUser(@RequestBody User user) throws UserNotFoundException {

            Map<String, String> map = null;
            try {User userObj = userService.findByUserIdAndPassword(user.getUserId(), user.getPassword());
                if (userObj.getUserId().equals(user.getUserId())) {
                   map = securityTokenGenerator.generateToken(user);}
                   responseEntity = new ResponseEntity<>(map, HttpStatus.OK);}
            catch (UserNotFoundException e) {throw new UserNotFoundException();}
            catch (Exception e) {responseEntity = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);}
                return responseEntity;
        }

        @GetMapping("/users")
        public ResponseEntity getAllUsers(HttpServletRequest request) {
            List<User> list = userService.getAllUsers();
            responseEntity = new ResponseEntity(list, HttpStatus.OK);
            return responseEntity;
        }

    }


