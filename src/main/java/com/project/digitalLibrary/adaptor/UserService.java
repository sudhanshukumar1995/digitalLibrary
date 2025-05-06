package com.project.digitalLibrary.adaptor;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.digitalLibrary.model.UserModel;
import com.project.digitalLibrary.repository.UserRepository;
import com.project.digitalLibrary.utils.ResourceNotFoundException;
import com.project.digitalLibrary.utils.UserPrincipal;


@Service
public class UserService implements UserDetailsService  {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel addUser(UserModel userModel) {
        return this.userRepository.addUser(userModel);
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
