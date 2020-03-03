package spotify.users.service.impl;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import spotify.users.entities.User;
import spotify.users.entities.UserRepository;
import spotify.users.models.UserModel;
import spotify.users.service.UserService;
import spotify.users.service.converters.UserConverter;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final UserConverter userConverter;

  public UserServiceImpl(final UserRepository userRepository,
      final UserConverter userConverter) {
    this.userRepository = userRepository;
    this.userConverter = userConverter;
  }

  @Override
  public UserModel createUser(final UserModel model) {
    final User user = userConverter.convertToEntity(model);

    final User created = userRepository.save(user);

    return userConverter.convertToModel(created);
  }

  @Override
  public void deleteUser(final String id) {
    final Optional<User> userOpt = userRepository.findById(id);
    if (!userOpt.isPresent()) {
      return;
    }
    userRepository.delete(userOpt.get());
  }

  @Override
  public UserModel getUser(final String id) {
    final Optional<User> userOpt = userRepository.findById(id);

    return userOpt.map(userConverter::convertToModel).orElse(null);
  }

  @Override
  public UserModel updateUser(final UserModel model) {
    final User user = userConverter.convertToEntity(model);

    final User updated = userRepository.save(user);

    return userConverter.convertToModel(updated);
  }

}
