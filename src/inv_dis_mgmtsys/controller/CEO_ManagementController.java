package inv_dis_mgmtsys.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import inv_dis_mgmtsys.dao.FinanaceManagement_IDAOImpl;
import inv_dis_mgmtsys.services.FinanaceManagement_IServicesImpl;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

@Controller
@Transactional
public class CEO_ManagementController {

	@Autowired
	private FinanaceManagement_IServicesImpl finanaceManagement_IServicesImpl;

	@RequestMapping("/CEO")
	public ModelAndView dashboardView() {

		System.out.println("Inside CEO dashbaord");
		return new ModelAndView("/Dashboards/CEO");
	}

	@RequestMapping(value = "supplierfinancereport", method = RequestMethod.GET)
	@ResponseBody
	public void getSupplierFinanceReport(HttpSession session) throws JRException, IOException {

		List<Map<String,Object>> dataSource = finanaceManagement_IServicesImpl.getSupplierFinanceViewDetails();
		JRDataSource jrDataSource = new JRBeanCollectionDataSource(dataSource);
		String path = session.getServletContext().getRealPath("/Report/");
		JasperDesign jasperDesign = JRXmlLoader.load(path + "/CEO_Supplier_Finance_Report.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null , jrDataSource);
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		HttpServletResponse response = servletRequestAttributes.getResponse();
		response.setContentType("application/x-pdf");
		response.setHeader("Content-disposition", "inline; filename=supplierfinanceReport.pdf");

		final OutputStream outStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	}
	
	@RequestMapping(value = "retailerfinancereport", method = RequestMethod.GET)
	@ResponseBody
	public void getRetailerFinanceReport(HttpSession session) throws JRException, IOException {

		//This line needs to be changed
		List<Map<String,Object>> dataSource = finanaceManagement_IServicesImpl.getRetailerFinanceViewDetails();
		JRDataSource jrDataSource = new JRBeanCollectionDataSource(dataSource);
		String path = session.getServletContext().getRealPath("/Report/");
		//This line needs to be changed
		JasperDesign jasperDesign = JRXmlLoader.load(path + "/CEO_Retailer_Finance_Report.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null , jrDataSource);
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		HttpServletResponse response = servletRequestAttributes.getResponse();
		response.setContentType("application/x-pdf");
		//This line needs to be changed
		response.setHeader("Content-disposition", "inline; filename=retailerfinanceReport.pdf");

		final OutputStream outStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	}
	
	@RequestMapping(value = "incomereport", method = RequestMethod.GET)
	@ResponseBody
	public void getIncomeReport(HttpSession session) throws JRException, IOException {

		//This line needs to be changed
		List<Map<String,Object>> dataSource = finanaceManagement_IServicesImpl.getIncomeFinanceViewDetails();
		JRDataSource jrDataSource = new JRBeanCollectionDataSource(dataSource);
		String path = session.getServletContext().getRealPath("/Report/");
		//This line needs to be changed
		JasperDesign jasperDesign = JRXmlLoader.load(path + "/CEO_Income_Report.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null , jrDataSource);
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		HttpServletResponse response = servletRequestAttributes.getResponse();
		response.setContentType("application/x-pdf");
		//This line needs to be changed
		response.setHeader("Content-disposition", "inline; filename=incomeReport.pdf");

		final OutputStream outStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	}
	
	@RequestMapping(value = "expensereport", method = RequestMethod.GET)
	@ResponseBody
	public void getExpenseReport(HttpSession session) throws JRException, IOException {

		//This line needs to be changed
		List<Map<String,Object>> dataSource = finanaceManagement_IServicesImpl.getExpenseFinanceViewDetails();
		JRDataSource jrDataSource = new JRBeanCollectionDataSource(dataSource);
		String path = session.getServletContext().getRealPath("/Report/");
		//This line needs to be changed
		JasperDesign jasperDesign = JRXmlLoader.load(path + "/CEO_Expense_Report.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null , jrDataSource);
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		HttpServletResponse response = servletRequestAttributes.getResponse();
		response.setContentType("application/x-pdf");
		//This line needs to be changed
		response.setHeader("Content-disposition", "inline; filename=incomeReport.pdf");

		final OutputStream outStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	}

}
