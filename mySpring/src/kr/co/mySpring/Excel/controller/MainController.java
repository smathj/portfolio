package kr.co.mySpring.Excel.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@Autowired
	SqlSessionTemplate SqlSessionTemplate;	
	
	
		@GetMapping("/excel/download.do")
		public void excelDownLoad(HttpServletResponse response, Model model) throws IOException {
			
			Workbook wb = new XSSFWorkbook();			
			Sheet sheet = wb.createSheet("첫번째 시트");	
			
			Row row = null;
			Cell cell = null;
			
			int rowNum = 0;
			
			// Header
			row = sheet.createRow(rowNum++);
			cell = row.createCell(0);
			cell.setCellValue("번호");
			
			
			cell = row.createCell(1);
			cell.setCellValue("이름");
			
			
			cell = row.createCell(2);
			cell.setCellValue("제목");
			
			// Body																	
			for(int i = 0 ; i<3; i++) {							
				row = sheet.createRow(rowNum++);
				cell = row.createCell(0);
				cell.setCellValue(i+"번");
				
				cell = row.createCell(1);
				cell.setCellValue(i+"_name");
				
				cell = row.createCell(2);
				cell.setCellValue(i+"_title");
				
			}
			
			// 
			response.setContentType("ms-vnd/excel");
			//response.setHeader("Content-Disposition", "attachment;filename=example.xls");
			response.setHeader("Content-Disposition", "attachment;filename=example.xlsx");
			
			
			// Excel File Output
			wb.write(response.getOutputStream());		
			wb.close();									

	}

}
