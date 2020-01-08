/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineplay.watcher.service;

import com.onlineplay.watcher.entity.Users;
import com.onlineplay.watcher.repository.UsersRepository;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Anđelka
 */
@Service
public class UsersService implements CommandLineRunner {

    private UsersRepository usersRepository;
    private PasswordEncoder passwordEncoder;

    public UsersService(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        // Delete all
        this.usersRepository.deleteAll();

        // Crete users
        Users dan = new Users("dan", passwordEncoder.encode("dan123"), "USER", "");
        Users admin = new Users("admin", passwordEncoder.encode("admin123"), "ADMIN", "ACCESS_TEST1,ACCESS_TEST2");
        Users manager = new Users("manager", passwordEncoder.encode("manager123"), "MANAGER", "ACCESS_TEST1");

        List<Users> users = Arrays.asList(dan, admin, manager);

        // Save to db
        this.usersRepository.saveAll(users);
    }

    public List<Users> listAll() {
        return usersRepository.findAll();
    }

    public void save(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usersRepository.save(user);
    }

    public Users get(long id_user) {
        return usersRepository.findById(id_user).get();
    }

    public void delete(long id_user) {
        usersRepository.deleteById(id_user);
    }

    public Users findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }

}
