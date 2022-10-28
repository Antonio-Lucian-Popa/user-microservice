package com.asusoftware.userapi.controller;

import com.asusoftware.userapi.model.CreateUserDto;
import com.asusoftware.userapi.model.UserDto;
import com.asusoftware.userapi.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1/users")
public class UserController {

    private final UserService userService;

    /**
     * Create user
     * @param createUserDto
     */
    @PostMapping(path = "/create")
    public void create(@RequestBody CreateUserDto createUserDto) {
        userService.create(createUserDto);
    }

    /**
     * Find all users in the app
     * @return
     */
    @GetMapping(path = "/findAll")
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    /**
     * Find a particular user using his id
     * @param id
     * @return
     */
    @GetMapping(path = "/findById/{id}")
    public UserDto findById(@PathVariable(name = "id") UUID id) {
        return userService.findById(id);
    }

    /**
     * Update user
     * @param id
     * @param userDto
     */
    @PutMapping(path = "/update/{id}")
    private void edit(@PathVariable(name = "id") UUID id, @RequestBody UserDto userDto) {
        userService.edit(userDto);
    }

    /**
     * Delete user by id
     * @param id
     */
    @DeleteMapping(path = "/delete/{id}")
    public void deleteById(@PathVariable(name = "id") UUID id) {
        userService.delete(id);
    }

    @PostMapping(path = "/uploadImage")
    public String uploadImage(@RequestParam("imageFile") MultipartFile multipartFile) {
        String returnValue = "";
        return null;
    }
}
