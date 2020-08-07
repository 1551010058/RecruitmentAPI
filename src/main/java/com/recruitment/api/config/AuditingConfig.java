package com.recruitment.api.config;
///*
// * Copyright (C) OU 2019 
// * @date Oct 3, 2019
// * @version 1.0
// */
//
//package com.vieclam.config;
//
//import java.util.Optional;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.domain.AuditorAware;
//import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//import org.springframework.security.authentication.AnonymousAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//
//import com.ou.vn.security.UserPrincipal;
//
//@Configuration
//@EnableJpaAuditing
//public class AuditingConfig {
//
//	@Bean
//	public AuditorAware<Long> auditorProvider() {
//		return new SpringSecurityAuditAwareImpl();
//	}
//}
//
//class SpringSecurityAuditAwareImpl implements AuditorAware<Long> {
//
//	@Override
//	public Optional<Long> getCurrentAuditor() {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//		if (authentication == null || !authentication.isAuthenticated()
//				|| authentication instanceof AnonymousAuthenticationToken) {
//			return Optional.empty();
//		}
//
//		UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
//
//		return Optional.ofNullable(userPrincipal.getId());
//	}
//}
