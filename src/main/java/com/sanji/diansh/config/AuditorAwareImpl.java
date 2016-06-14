package com.sanji.diansh.config;

import org.apache.shiro.SecurityUtils;
import org.springframework.data.domain.AuditorAware;
public class AuditorAwareImpl implements AuditorAware<Object> {

	public Object getCurrentAuditor() {
		return SecurityUtils.getSubject().getPrincipal();
	}
	
}
