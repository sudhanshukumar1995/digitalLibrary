package com.project.digitalLibrary.dddd_services;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.digitalLibrary.aaaabbbbb_model.UserModel;
import com.project.digitalLibrary.cccc_repository.UserRepository;
import com.project.digitalLibrary.zzzz_utils.ResourceNotFoundException;
import com.project.digitalLibrary.zzzz_utils.UserPrincipal;


@Service
public class UserService implements UserDetailsService  {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passEncode = new BCryptPasswordEncoder(12);

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    public UserModel addUser(UserModel userModel) {
//        return userRepository.addUser(userModel);
//    }
    
    public UserModel addUser(UserModel userModel) {
    	userModel.setPassword(passEncode.encode(userModel.getPassword()));
        return userRepository.addUser(userModel);
    }

    public UserModel getUserByEmail(String email) {
        return this.userRepository.getUserByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            UserModel userModel = this.getUserByEmail(username);
            return new UserPrincipal(userModel);
        } catch (ResourceNotFoundException e) {
            throw new UsernameNotFoundException(e.getMessage());
        }
    }
}
