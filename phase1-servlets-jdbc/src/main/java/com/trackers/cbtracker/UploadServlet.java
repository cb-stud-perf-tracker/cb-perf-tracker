package com.trackers.cbtracker;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentDao studentDao;

    @Override
    public void init() throws ServletException {
        super.init();
        // Since StudentDao is hard-coded, just create an instance
        studentDao = new StudentDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Part filePart = request.getPart("csvFile");
        if (filePart == null) {
            response.getWriter().println("No file uploaded!");
            return;
        }

        // parse CSV lines...
        // pass data to studentDao.saveOrUpdatePerformance(...)
        response.getWriter().println("Upload processed (with hard-coded DB credentials).");
    }
}