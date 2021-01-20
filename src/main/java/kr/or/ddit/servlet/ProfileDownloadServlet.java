package kr.or.ddit.servlet;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

@WebServlet("/profileDownload")
public class ProfileDownloadServlet extends HttpServlet {
	private UserServiceI userService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userid = req.getParameter("userid");
		UserVo userVo = userService.selectUser(userid);
		
		String path = "";
		String filename="";
		if(userVo.getRealfilename() == null) {
			path = getServletContext().getRealPath("/image/unknown.png");
			filename = "unknown.png";
		} else {
			path = "d:\\upload\\" + userVo.getRealfilename();
			filename = userVo.getFilename();
		}
		
		resp.setHeader("Content-Disposition", "attachment; filename=" + filename);
		
		FileInputStream fis = new FileInputStream(path);
		ServletOutputStream sos = resp.getOutputStream();
		
		byte[] buff = new byte[512];
		
		while(fis.read(buff) != -1) {
			sos.write(buff);
		}
		
		fis.close();
		sos.close();
	}
}

