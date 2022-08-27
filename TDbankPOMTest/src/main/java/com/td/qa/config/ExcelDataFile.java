package com.td.qa.config;

import com.td.qa.utillities.Xls_Reader;

public class ExcelDataFile {

		
		Xls_Reader d = new Xls_Reader("C:\\Selenium_WorkSpace\\TDbankPOMTest\\POMdatafile.xlsx");
		
		public String wrongEmail = d.getCellData("Data1", "UserName", 6);
		public String wrongPassword = d.getCellData("Data1", "Password", 2);
		public String globalerror = d.getCellData("Data1", "Global Error", 5);
		public String mptEmailerror = d.getCellData("Data1", "Email Error", 7);
		public String mptPassworderror = d.getCellData("Data1", "Password Error", 5);
		public String searchkeywords =  d.getCellData("Data1", "Name", 8);

	
}
