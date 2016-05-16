package org.mel.tutorial.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class CustomRealm extends AuthorizingRealm {

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken t = (UsernamePasswordToken) token;
		System.out.println("Token->" + t);
		System.out.println("getCredentials->" + new String((char[]) t.getCredentials()));
		System.out.println("getHost->" + t.getHost());
		System.out.println("getPassword->" + new String(t.getPassword()));
		System.out.println("getPrincipal->" + t.getPrincipal());
		System.out.println("getUsername->" + t.getUsername());
		System.out.println("Name->" + getName());
		return new SimpleAuthenticationInfo(t.getUsername(), new String(t.getPassword()), getName());
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println(">>>>>>>>>>>>>>>>>>");
		return null;
	}

}
