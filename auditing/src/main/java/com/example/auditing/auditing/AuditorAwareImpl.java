package com.example.auditing.auditing;

import java.util.Optional;

public class AuditorAwareImpl implements org.springframework.data.domain.AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Quang");
    }

}

// ------------------ Use below code for spring security --------------------------

    /* public class SpringSecurityAuditorAware implements AuditorAware<User> {

     public User getCurrentAuditor() {

      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

      if (authentication == null || !authentication.isAuthenticated()) {
       return null;
      }

      return ((MyUserDetails) authentication.getPrincipal()).getUser();
     }
    }
    */
