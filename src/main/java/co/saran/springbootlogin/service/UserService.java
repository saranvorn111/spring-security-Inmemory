package co.saran.springbootlogin.service;

import co.saran.springbootlogin.dto.UserRequestDto;
import co.saran.springbootlogin.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    User createNewUser(UserRequestDto userRequestDto);

    Optional<User> getUserById(Long id);

    User updateUser(Long id, UserRequestDto userRequestDto);
    String deleteUser(Long id);
}
