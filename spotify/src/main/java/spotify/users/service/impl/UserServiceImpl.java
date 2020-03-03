package spotify.users.service.impl;

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
  public void createUser(final UserModel model) {
    final User user = userConverter.convertToEntity(model);

    userRepository.create(user);
  }

  @Override
  public void deleteUser(final int id) {
    userRepository.delete(id);
  }

  @Override
  public UserModel getUser(final int id) {
    final User user = userRepository.get(id);

    if (user == null) {
      return null;
    }

    return userConverter.convertToModel(user);
  }

  @Override
  public void updateUser(final UserModel model) {
    final User user = userConverter.convertToEntity(model);

    userRepository.update(user);
  }

}
