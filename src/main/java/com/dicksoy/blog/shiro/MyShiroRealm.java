package com.dicksoy.blog.shiro;

import java.util.List;

import javax.annotation.Resource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dicksoy.blog.dto.ResourcesDto;
import com.dicksoy.blog.po.User;
import com.dicksoy.blog.service.ResourcesService;
import com.dicksoy.blog.service.UserService;
import com.dicksoy.blog.vo.ResourcesVo;

public class MyShiroRealm extends AuthorizingRealm {

	@Resource
	private UserService userService;

	@Resource
	private ResourcesService resourcesService;

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection collection) {
		// User{id=1, username='admin', password='3ef7164d1f6167cb9f2658c07d3c2f0a', enable=1}
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		ResourcesDto resources = new ResourcesDto(user.getId());
		List<ResourcesVo> resourcesList = resourcesService.loadUserResource(resources);
		// 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		for (ResourcesVo resourcesVo : resourcesList) {
			info.addStringPermission(resourcesVo.getResourcesUrl());
		}
		return info;
	}

	/**
	 * 认证
	 * @param token
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String username = token.getUsername();
		User user = userService.selectOne(new EntityWrapper<User>().eq("user_name", username));
		if (null == user) throw new UnknownAccountException();	//未知账号
//		if (user.getState().equals(1)) throw new LockedAccountException();	//账号锁定
		SimpleAuthenticationInfo authorizationInfo = new SimpleAuthenticationInfo(username, user.getPassword(), getName());
		// 当验证都通过后，把用户信息放在session里
		Session session = SecurityUtils.getSubject().getSession();
		session.setAttribute("userSession", user);
		session.setAttribute("userSessionId", user.getId());
		return authorizationInfo;

	}

	/**
	 * 指定principalCollection 清除
	 */
	public void clearCachedAuthorizationInfo(PrincipalCollection principalCollection) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(
				principalCollection, getName());
		super.clearCachedAuthorizationInfo(principals);
	}
}

/**
<!-- 身份认证异常 -->  
<!-- 身份令牌异常，不支持的身份令牌 -->  
org.apache.shiro.authc.pam.UnsupportedTokenException  
  
<!-- 未知账户/没找到帐号,登录失败 -->  
org.apache.shiro.authc.UnknownAccountException  
<!-- 帐号锁定 -->  
org.apache.shiro.authc.LockedAccountException  
<!-- 用户禁用 -->  
org.apache.shiro.authc.DisabledAccountException  
<!-- 登录重试次数，超限。只允许在一段时间内允许有一定数量的认证尝试 -->  
org.apache.shiro.authc.ExcessiveAttemptsException  
<!-- 一个用户多次登录异常：不允许多次登录，只能登录一次 。即不允许多处登录-->  
org.apache.shiro.authc.ConcurrentAccessException  
<!-- 账户异常 -->  
org.apache.shiro.authc.AccountException  
<!-- 过期的凭据异常 -->  
org.apache.shiro.authc.ExpiredCredentialsException  
<!-- 错误的凭据异常 -->  
org.apache.shiro.authc.IncorrectCredentialsException  
<!-- 凭据异常 -->  
org.apache.shiro.authc.CredentialsException  
org.apache.shiro.authc.AuthenticationException  
<!-- 权限异常 -->  
<!-- 没有访问权限，访问异常 -->  
org.apache.shiro.authz.HostUnauthorizedException  
org.apache.shiro.authz.UnauthorizedException  
<!-- 授权异常 -->  
org.apache.shiro.authz.UnauthenticatedException  
org.apache.shiro.authz.AuthorizationException  
<!-- shiro全局异常 -->  
org.apache.shiro.ShiroException 
 */
