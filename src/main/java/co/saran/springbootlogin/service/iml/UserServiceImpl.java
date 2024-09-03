package co.saran.springbootlogin.service.iml;

import co.saran.springbootlogin.dto.UserRequestDto;
import co.saran.springbootlogin.entity.User;
import co.saran.springbootlogin.repository.UserRepository;
import co.saran.springbootlogin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createNewUser(UserRequestDto userRequestDto) {
        User user = new User();
        user.setUsername(userRequestDto.username());
        user.setPassword(userRequestDto.password());
        user.setEmail(userRequestDto.email());
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User updateUser(Long id, UserRequestDto userRequestDto) {
        User newUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        newUser.setUsername(userRequestDto.username());
        newUser.setPassword(userRequestDto.password());
        newUser.setEmail(userRequestDto.email());
        return userRepository.save(newUser);
    }

    @Override
    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "User deleted successfully";
    }
}
