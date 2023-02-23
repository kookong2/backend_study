package controllers.admin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.board.BoardConfigSaveService;
import models.board.BoardServiceManager;
import static commons.MessageLibrary.*;

import java.io.IOException;
/**
 * /admin/board/config -> 설정 등록 
 * /admin/board/config/게시판 아이디  -> 설정 수정 
 *
 */
@WebServlet("/admin/board/config/*")
public class BoardConfigController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("menuCode", "boardRegister");
		
		RequestDispatcher rd = req.getRequestDispatcher("/admin/board/config.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			BoardServiceManager manager = BoardServiceManager.getInstance();
			BoardConfigSaveService service = manager.getBoardConfigSaveService();
			service.save(req);
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			alertError(resp, e);
		}
	}
}
