package com.asusoftware.userapi.services;

import com.asusoftware.userapi.exceptions.UserNotFoundException;
import com.asusoftware.userapi.mappers.UserDtoEntity;
import com.asusoftware.userapi.model.CreateUserDto;
import com.asusoftware.userapi.model.User;
import com.asusoftware.userapi.model.UserDto;
import com.asusoftware.userapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserDtoEntity userDtoEntity;

    public void create(CreateUserDto createUserDto) {
        User user = userDtoEntity.userToEntity(createUserDto);
        userRepository.save(user);
    }

    public void edit(UserDto userDto) {
        User user = userDtoEntity.userToEntity(userDto);
        User userFromDb = userRepository.findById(userDto.getId()).orElseThrow(UserNotFoundException::new);
        userFromDb.setFirstName(user.getFirstName());
        userFromDb.setLastName(user.getLastName());
        userFromDb.setBirthday(user.getBirthday());
        userFromDb.setEmail(user.getEmail());
        userFromDb.setPhoneNumber(user.getPhoneNumber());
        userFromDb.setProfileImage(user.getProfileImage());
        userFromDb.setPassword(user.getPassword());
        userRepository.save(userFromDb);
    }

    public void saveImage(MultipartFile imageFile) throws IOException {
        String folder = "/photos/";
        byte[] bytes = imageFile.getBytes();
        // The path where we can store the file
        Path path = Paths.get(folder + imageFile.getOriginalFilename());
        Files.write(path, bytes);
    }

    public UserDto findById(UUID id) {
        return userDtoEntity.userToDto(userRepository.findById(id).orElseThrow(UserNotFoundException::new));
    }

    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(userDtoEntity::userToDto).collect(Collectors.toList());
    }

    public void delete(UUID id) {
        userRepository.deleteById(id);
    }
}
