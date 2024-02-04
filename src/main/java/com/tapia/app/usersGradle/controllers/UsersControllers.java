package com.tapia.app.usersGradle.controllers;

import com.tapia.app.usersGradle.Service.IUser;
import com.tapia.app.usersGradle.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("WSCentralesMock/api/v1/")
public class UsersControllers {

    @Autowired
    private IUser userService;

    @PostMapping("usuarios")
    public Map<String, String> guardar(@RequestBody Users c) {
        userService.guardar(c);
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("msg", "Usuario guardado correctamente");
        return respuesta;
    }

    @GetMapping("usuarios")
    public List<Users> listar(){
        List<Users> users = userService.listar();
        return users;
    }

    @GetMapping("/usuarios/{id}")
    public Users obtenerPorId(@PathVariable(name = "id")Long id) {
        Optional<Users> users = userService.getById(id);
        if (users.isPresent()) {
            return users.get();
        }else {
            return null;
        }
    }

   @PutMapping("/usuarios/{id}")
    public Map<String, String> actualizar(@RequestBody Users c, @PathVariable(name = "id") Long id) {
        Optional<Users> users = userService.getById(id);
        if (users.isPresent()) {
            c.setId(id);
            userService.guardar(c);
        }else {
            throw new RuntimeException("El usuario no existe");
        }
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("msg", "Usuario actualizado correctamente");
        return respuesta;
    }

    @DeleteMapping("/usuarios/{id}")
    public Map<String, String> eliminar(@PathVariable(name = "id")Long id){
        userService.eliminar(id);
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("msg","Uusario eliminado correctamente");
        return respuesta;
    }

}
