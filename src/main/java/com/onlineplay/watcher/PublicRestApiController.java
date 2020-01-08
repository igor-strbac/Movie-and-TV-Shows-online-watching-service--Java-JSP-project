/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineplay.watcher;

import com.onlineplay.watcher.entity.Users;
import com.onlineplay.watcher.repository.UsersRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Anđelka
 */
@RestController
@RequestMapping("api/public")
public class PublicRestApiController {
    private UsersRepository usersRepository;

    public PublicRestApiController(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @GetMapping("test1")
    public String test1(){
        return "API Test 1";
    }

    @GetMapping("test2")
    public String test2(){
        return "API Test 2";
    }

    @GetMapping("users")
    public List<Users> users(){
        return this.usersRepository.findAll();
    } 
}
