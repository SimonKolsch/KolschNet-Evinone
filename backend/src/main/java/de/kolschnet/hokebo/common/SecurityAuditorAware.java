package de.kolschnet.hokebo.common;

import java.util.Optional;
import org.springframework.data.domain.AuditorAware;

class SecurityAuditorAware implements AuditorAware<Long> {

  @Override
  public Optional<Long> getCurrentAuditor() {

//    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//    if (authentication == null || !authentication.isAuthenticated()) {
//      return null;
//    }
//
//    return ((MyUserDetails) authentication.getPrincipal()).getUser();

    return Optional.of(10L);
  }
}
