package com.tapia.app.usersGradle.DAO;


import com.tapia.app.usersGradle.models.Direcciones;
import com.tapia.app.usersGradle.models.Users;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface IUsersDao extends CrudRepository<Users, Long> {


}

