package com.example.demo.config;

import com.example.demo.entity.AuthorityEntity;
import com.example.demo.entity.CustomerEntity;
import com.example.demo.model.SecurityCustomer;
import com.example.demo.repository.ICustomerRepository;
import com.example.demo.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import sun.security.util.Password;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class UserNameAndPassWordAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        Optional<CustomerEntity> customer = customerRepository.findByEmail(username);
        if (customer.isPresent()) {
            if (passwordEncoder.matches(pwd, customer.get().getPwd())) {
                List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
                authorities = getGrantedAuthorities(customer.get().getRole());
                return new UsernamePasswordAuthenticationToken(username, pwd, authorities);
            } else {
                throw new BadCredentialsException("Invaild password!");
            }
        } else {
            throw new BadCredentialsException("No user register with in details!");
        }
    }

    private List<SimpleGrantedAuthority> getGrantedAuthorities(Set<AuthorityEntity> authorityEntitySet) {
        List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
        for (AuthorityEntity authorityEntity : authorityEntitySet) {
            list.add(new SimpleGrantedAuthority(authorityEntity.getName()));
        }
        return list;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
