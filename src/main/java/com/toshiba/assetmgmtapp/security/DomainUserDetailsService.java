package com.toshiba.assetmgmtapp.security;

import com.toshiba.assetmgmtapp.model.DomainUserDetails;
import com.toshiba.assetmgmtapp.model.User;
import com.toshiba.assetmgmtapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DomainUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User is not present"));
        DomainUserDetails userDetails = new DomainUserDetails(user);
        return userDetails;
    }
}