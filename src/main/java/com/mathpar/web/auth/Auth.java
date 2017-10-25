//package com.mathpar.web.auth;

import com.mathpar.func.Page;
//import com.mathpar.parallel.webCluster.engine.QueryCreator;
import com.mathpar.web.controller.PageParam;
import com.mathpar.web.db.dao.DbUser;
import com.mathpar.web.db.entity.User;
import com.mathpar.web.db.entity.UserRole;
import com.mathpar.web.entity.ResponseStatus;
import com.mathpar.web.exceptions.AuthException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

@RestController
@RequestMapping(value = "/api/auth", method = RequestMethod.POST)
public class Auth {
    private static final Logger LOG = LoggerFactory.getLogger(Auth.class);

    private DbUser dbUser;

    @Autowired
    public void setDbUser(DbUser dbUser) {
        this.dbUser = dbUser;
    }

 
}
