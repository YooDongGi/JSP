package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.user.model.UserVo;

public class SessionCheckFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		// 요청 URI가 S_USER 속성이 세션에 있어야 하는 주소인지 체크
		String uri = req.getRequestURI();	// 요청 URI
		
		// 세션 체크가 필요 없는 주소 : login.jsp, loginController
		// endsWith ==> 종료 문자열이 " "로 끝나는지 확인
		// contains ==> 문자열이 포함되는지 확인
		if(uri.endsWith("login.jsp") || 
				uri.endsWith("loginController") ||
				uri.contains("/css/") ||
				uri.contains("/js/") ||
				uri.contains("/image/") ) {
			chain.doFilter(request, response);
		}
		// 세션 체크가 필요 있는 주소 ( S_USER속성 확인 )
		else {
			UserVo user = (UserVo)req.getSession().getAttribute("S_USER");
			
			// user 정보가 NULL ==> 로그인 X		-> 로그인 화면으로 이동
			if(user == null) {
				((HttpServletResponse)response).sendRedirect(req.getContextPath() + "/login.jsp");
			}
			// user 정보가 !NULL ==> 로그인 O		-> 요청처리
			else {
				chain.doFilter(request, response);
			}
		}
	}

	@Override
	public void destroy() {
	}

}
