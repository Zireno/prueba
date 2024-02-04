package com.tapia.app.usersGradle.Service;

import com.tapia.app.usersGradle.DAO.IUsersDao;
import com.tapia.app.usersGradle.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IUser implements  IService<Users>{

    @Autowired
    private IUsersDao userDao;

    @Override
    public List<Users> listar() {
        List<Users> users = new ArrayList();
        users = (List<Users>) userDao.findAll();
        return users;
    }

    @Override
    public Optional<Users> getById(Long id) {
            Optional<Users> users = userDao.findById(id);
            return users;
    }

    @Override
    public void guardar(Users t) {
        this.userDao.save(t);
    }

    @Override
    public void eliminar(Long id) {
        this.userDao.deleteById(id);
    }
}
