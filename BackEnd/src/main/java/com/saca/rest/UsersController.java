package com.saca.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;

import com.saca.backEnd.isClient;
import com.saca.dtos.CompraDTO;
import com.saca.dtos.UserDTO;
import com.saca.dtos.detalleDTO;
import com.saca.entities.Compra;
import com.saca.entities.User;
import com.saca.entities.compraDetalle;
import com.saca.services.IUserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@RequestMapping("users")
public class UsersController {

    @Autowired
    private IUserService repoUser;
    @Autowired
    private BCryptPasswordEncoder encoder;

    @isClient
    @GetMapping("byid/{id}")
    public UserDTO getById(@PathVariable("id") Long id){
        return convertUDTO(repoUser.getUserById(id));
    }
    @RolesAllowed({"ROLE_ADMIN","ROLE_CLIENT"})
    @GetMapping("byusername/{username}")
    public UserDTO getByUsername(@PathVariable("username") String username){
        return convertUDTO(repoUser.getUserByUsername(username));
    }
    @PostMapping("crear")
    public boolean crearUser(@RequestBody UserDTO nuevo){
        if(repoUser.userExiste(nuevo.getUsername())){
            return false;
        }
        repoUser.crearUser(convertUDTO(nuevo));
        return true;
    }
    @isClient
    @GetMapping("byuserandpass/{username}/{password}")
    public UserDTO getByUserAndPassword(@PathVariable("username") String username, @PathVariable("password") String password){
        return convertUDTO(repoUser.getByUserAndPassword(username, password));
    }
    
    /*User a UserDTO*/
    public UserDTO convertUDTO(User user){

        UserDTO result = new UserDTO();
        result.setId(user.getId());
        result.setUsername(user.getUsername());
        result.setEmail(user.getEmail());
        result.setCelular(user.getCelular());
        result.setPassword(user.getPassword());
        result.setRol(user.getRol());
        result.setCompras(convertCDTOs(user.getCompras()));

        return result;
    }
    /*UserDTO a User*/
    public User convertUDTO(UserDTO user){

        User result = new User();
        result.setId(user.getId());
        result.setUsername(user.getUsername());
        result.setEmail(user.getEmail());
        result.setCelular(user.getCelular());
        result.setPassword(encoder.encode(user.getPassword()));
        result.setRol(user.getRol());

        return result;
    }

    public List<CompraDTO> convertCDTOs(List<Compra> compras) {
        List<CompraDTO> result = new ArrayList<>();
        
        for (Compra compra : compras) {
            CompraDTO aux = new CompraDTO();
            aux.setId(compra.getId());
            aux.setTotal(compra.getTotal());
            aux.setComprador(compra.getComprador().getUsername());
            aux.setProductos(convertDDTOs(compra.getProductos()));
            result.add(aux);
        }

        return result;
    }

    public List<detalleDTO> convertDDTOs(List<compraDetalle> detalles){
        List<detalleDTO> result = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();

        for (compraDetalle detalle : detalles) {
            result.add(mapper.map(detalle, detalleDTO.class));
        }

        return result;
    }
    
}
