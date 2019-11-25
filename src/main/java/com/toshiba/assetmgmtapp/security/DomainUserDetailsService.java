package com.toshiba.assetmgmtapp.security;

import com.toshiba.assetmgmtapp.model.User;
import com.toshiba.assetmgmtapp.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DomainUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public DomainUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User domainUser = this.userRepository.findByUsername(username)
               .orElseThrow(()-> new UsernameNotFoundException("User is not present"));

        return new DomainUserDetails(domainUser);
    }
}