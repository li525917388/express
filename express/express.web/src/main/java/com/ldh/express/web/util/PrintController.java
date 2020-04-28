package com.ldh.express.web.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 打印控制类
 * 
 * @author Li Dehuan
 * @date 2019年8月7日
 *
 */
@Controller
@RequestMapping("print")
public class PrintController {
	
	@Resource
    private DataSource dataSource;
	
	@RequestMapping("pdf")
	public String pdf(String reportName,HttpServletRequest req) throws JRException {

		String reportSource = req.getServletContext().getRealPath(
				"/jasper/" + reportName + ".jrxml");

		File parent = new File(reportSource).getParentFile();

		// 将.jrxml模板文件编译成为.jasper文件,当然,其文件名可以指定,如果没指定,则与.jrxml文件名一样.只是后缀不同而已
		File complieFile = new File(parent, "" + reportName + ".jasper");
		if (!complieFile.exists()) {
			JasperCompileManager.compileReportToFile(reportSource,
					complieFile.getAbsolutePath());
		}

		req.setAttribute("test", 1);

		return "redirect:jasper/" + reportName + ".jasper";
	}

	@GetMapping("/{reportName}")
	public void pdfByName(@PathVariable("reportName") final String reportName,
			@RequestParam(required = false) Map<String, Object> parameters,
			HttpServletResponse response) throws IOException, JRException, SQLException {

		parameters = parameters == null ? new HashMap<>() : parameters;
		// 获取文件流
		ClassPathResource resource = new ClassPathResource("jaspers"
				+ File.separator + reportName + ".jasper");
		InputStream jasperStream = resource.getInputStream();

		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters, dataSource.getConnection());
		// JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
		// null, new JREmptyDataSource());
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "inline;");
		final OutputStream outputStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

	}

}
