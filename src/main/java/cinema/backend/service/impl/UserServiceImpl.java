

package cinema.backend.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import cinema.backend.entity.User;
import cinema.backend.repo.UserRepo;
import cinema.backend.service.UserService;

import java.util.List;
import java.util.Optional;

/**
 * @author XDSSWAR
 * Created on 06/03/2024
 */
@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepo repo;


    @Override
    public Optional<User> save(User user) {
        return Optional.of(repo.save(user));
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return repo.findByUserName(userName);
    }

    @Override
    public List<User> findAll() {
        return repo.findAll();
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }

    public boolean verifyLogin(String userName, String password) {
        Optional<User> user = repo.findByUserNameAndPasswordHash(userName, password);
        return user.isPresent();
    }
}
