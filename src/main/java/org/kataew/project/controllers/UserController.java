package org.kataew.project.controllers;


import com.sun.istack.Nullable;
import org.kataew.project.entities.UserEntity;
import org.kataew.project.repositories.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin("http://localhost:5173/")
@RestController
public class UserController {
    UserEntityRepository userEntityRepository;

    UserController(@Autowired UserEntityRepository userEntityRepository){
        this.userEntityRepository = userEntityRepository;
    }

    @PostMapping(path="/signIn",consumes = "application/json")
    public ResponseEntity<?> signIn(@RequestBody UserEntity user){

        UserEntity checkedUser = userEntityRepository.findByLogin(user.getLogin());
        if(checkedUser != null){
            if(checkedUser.getPassword().equals(user.getPassword())){
                return new ResponseEntity<>(checkedUser,HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("not correct password",HttpStatus.CONFLICT);
            }

        }
        else{
            return new ResponseEntity<>("user is not found",HttpStatus.NOT_FOUND);
        }


        //TODO: добавить логику отправки токена

    }

    @PostMapping("/signUp")
    public ResponseEntity<String> signUp(@RequestBody UserEntity user){

        UserEntity checkedUser = userEntityRepository.findByLogin(user.getLogin());
        if(checkedUser != null){
            return new ResponseEntity<>("login already exist",HttpStatus.CONFLICT);
        }

        userEntityRepository.save(user);

        return new ResponseEntity<>("user created", HttpStatus.CREATED);
    }


    @DeleteMapping("/deleteUser")
    public ResponseEntity<String> deleteUser(@RequestBody UserEntity user){
        @Nullable
        UserEntity checkUser = userEntityRepository.findByLogin(user.getLogin());
        if(checkUser.getIdUser() != null){
            userEntityRepository.deleteById(checkUser.getIdUser());
            return new ResponseEntity<>("user deleted", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("user not found", HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/updateUser/{login}/{password}")
    public  ResponseEntity<String> updateUser(@PathVariable String login,@PathVariable String password,@RequestBody UserEntity newUser){
        UserEntity usr  = userEntityRepository.findByLogin(login);
        if(usr != null){
            if(usr.getPassword().equals(password)){

                usr.setLogin(newUser.getLogin());
                usr.setPassword(newUser.getPassword());
                usr.setName(newUser.getName());
                usr.setSurname(newUser.getSurname());
                usr.setMidname(newUser.getMidname());
                usr.setPhone(newUser.getPhone());
                usr.setPhoto(newUser.getPhoto());
                userEntityRepository.save(usr);
                return  new ResponseEntity<>("user changed", HttpStatus.OK);

            }
            else{
                return new ResponseEntity<>("bad password", HttpStatus.CONFLICT);
            }
        }
        else{
            return new ResponseEntity<>("user not found", HttpStatus.CONFLICT);
        }
    }
}

