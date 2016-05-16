package org.mel.tutorial.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Before;
import org.junit.Test;

public class ShiroSimpleTest {

	@Before
	public void setUp() throws Exception {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-simple.ini");
		SecurityUtils.setSecurityManager(factory.getInstance());
	}

	@Test
	public void test() {
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.login(new UsernamePasswordToken("privatemiao", "P@ssw0rd"));
		System.out.println(currentUser.isPermitted("system:100:role:create"));
		currentUser.logout();
	}

}
