package com.example.aops.service;

import com.example.aops.model.User;
import com.example.aops.model.UserPrincipal;
import com.example.aops.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user=userRepo.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("user not found");
        }
        return new UserPrincipal(user);


    }
}
