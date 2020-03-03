package spotify.users.service;

import spotify.users.models.UserModel;

public interface UserService {

  void createUser(UserModel model);

  void deleteUser(int id);

  UserModel getUser(int id);

  void updateUser(UserModel model);

}
