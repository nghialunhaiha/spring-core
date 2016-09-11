package org.led.simba.user.controller;

import org.core.controller.BaseController;
import org.led.simba.user.User;
import org.led.simba.user.UserFilterResponse;
import org.led.simba.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mgmt/")
public class UserController extends BaseController {

    @Autowired
    UserService userService; // Service which will do all data retrieval/manipulation work

    // -------------------Retrieve All Users--------------------------------------------------------

    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userService.findAllUsers();
        if (users.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);// You many decide to return
            // HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    // -------------------Retrieve Single User--------------------------------------------------------

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
        User user = userService.findById(id);
        if (user == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    // -------------------Create a User--------------------------------------------------------

    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + user.getUsername());

        if (userService.isUserExist(user)) {
            System.out.println("A User with name " + user.getUsername() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        userService.saveUser(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    // ------------------- Update a User --------------------------------------------------------

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
        System.out.println("Updating User " + id);

        User currentUser = userService.findById(id);

        if (currentUser == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        currentUser.setUsername(user.getUsername());
        currentUser.setAddress(user.getAddress());
        currentUser.setEmail(user.getEmail());

        userService.updateUser(currentUser);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }

    // ------------------- Delete a User --------------------------------------------------------

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting User with id " + id);

        User user = userService.findById(id);
        if (user == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        userService.deleteUserById(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

    // ------------------- Delete All Users --------------------------------------------------------

    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteAllUsers() {
        System.out.println("Deleting All Users");

        userService.deleteAllUsers();
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/search/{searchText}", method = RequestMethod.GET)
    public ResponseEntity<List<User>> searhUsers(@PathVariable("searchText") String searchText) {
        System.out.println("\n\n Searching with key:" + searchText);
        List<User> users = userService.findByName(searchText);

        return response(users);
    }

    @RequestMapping(value = "/user/", params = {"name", "addr"}, method = RequestMethod.GET)
    @ResponseBody
    public List<User> getByNameAndAddr(@RequestParam("name") String userName, @RequestParam("addr") String address) {

        List<User> users = userService.findByNameAndAddr(userName, address);
        return users;
    }

    @RequestMapping(value = {"/user/names", "/user/names/"}, method = RequestMethod.GET)
    @ResponseBody
    public List<UserFilterResponse> getNames() {
        List<UserFilterResponse> values = new ArrayList<>();
        values.add(new UserFilterResponse(1, "nghia", "HaiHa"));
        values.add(new UserFilterResponse(2, "nghia2", "HaiHa"));
        values.add(new UserFilterResponse(3, "nghia3", "HaiHa"));
        values.add(new UserFilterResponse(4, "nghia4", "HaiHa"));
        values.add(new UserFilterResponse(5, "nghia5", "HaiHa"));

        return values;
    }
}