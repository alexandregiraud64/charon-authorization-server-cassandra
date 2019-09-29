package com.agiraud.charon.authorization.cassandra.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.provider.approval.ApprovalStoreUserApprovalHandler;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;

import com.agiraud.charon.authorization.config.AuthorizationServer;
import com.agiraud.charon.core.cassandra.config.CustomApprovalStoreUserApprovalHandler;
import com.agiraud.charon.core.dao.ScopeService;

@Configuration
@EnableAuthorizationServer
public class CassandraAuthorizationServer extends AuthorizationServer {
	/* ************************************************************************* */
	// ATTRIBUTES
	/* ************************************************************************* */
	@Autowired
	private ScopeService scopeService;
	
	/* ************************************************************************* */
	// CONSTRUCTOR
	/* ************************************************************************* */
	@PostConstruct
	public void init() {
		super.setApprovalStoreUserApprovalHandler(approvalStoreUserApprovalHandler());
	}
	
	/* ************************************************************************* */
	// BEANS
	/* ************************************************************************* */
	public ApprovalStoreUserApprovalHandler approvalStoreUserApprovalHandler() {
		ApprovalStoreUserApprovalHandler approvalStoreUserApprovalHandler = new CustomApprovalStoreUserApprovalHandler(scopeService);
		approvalStoreUserApprovalHandler.setApprovalStore(getApprovalStore());
		approvalStoreUserApprovalHandler.setRequestFactory(new DefaultOAuth2RequestFactory(getClientDetailsService()));
		approvalStoreUserApprovalHandler.setClientDetailsService(getClientDetailsService());
		return approvalStoreUserApprovalHandler;
	}
	
}
