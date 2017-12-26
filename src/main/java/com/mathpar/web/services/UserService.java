package com.mathpar.web.services;

import com.mathpar.web.db.dao.DbUser;
import com.mathpar.web.db.entity.User;
import com.mathpar.web.exceptions.AuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@Service
public class UserService {

    @Autowired
    public DbUser dbUser;

    public User getUser(String email, String password)
            throws IOException, NoSuchAlgorithmException, AuthException {
        return dbUser.getUser(email, password);
    }

}