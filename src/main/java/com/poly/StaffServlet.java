package com.poly;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import com.poly.dto.Staff;

/**
 * Servlet implementation class StaffServlet
 */
@MultipartConfig
@WebServlet("/staff")
public class StaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/staff/form.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			File dir = new File(req.getServletContext().getRealPath("/files"));
			Part photo = req.getPart("photo");
			File photoFile = new File(dir, photo.getSubmittedFileName());
			photo.write(photoFile.getAbsolutePath());

			// Định dạng thời gian nhập vào
			DateTimeConverter dtc = new DateConverter(new Date());
			dtc.setPattern("MM/dd/yyyy");
			ConvertUtils.register(dtc, Date.class);
			Staff staff = new Staff();
			staff.setPhoto(photoFile.getName());
			// Đọc tham số vào các thuộc tính của bean staff
			BeanUtils.populate(staff, req.getParameterMap());
			
			// Chia sẻ với result.jsp
			req.setAttribute("bean", staff);
		} catch (Exception e) {
			e.printStackTrace();
		}

		req.getRequestDispatcher("/views/staff/result.jsp").forward(req, resp);
	}

}
