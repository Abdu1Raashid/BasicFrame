package data;

import utilities.Xls_Reader;

public class DataFile {
	
	Xls_Reader d = new Xls_Reader("/Users/raashidshaikh/Desktop/QA/SeleniumWorkSpace/BasicFrameWork/ValueKeeper.xlsx");
    
	
	public String EmailSpecChar = d.getCellData("Data1","UserName" , 4);
	public String WrongPass = d.getCellData("Data1", "Password", 2);
	public String EmailNoSPecChar = d.getCellData("Data1", "UserName", 3);
	public String SpecCharErr = d.getCellData("Data1", "Email Error", 5);
	public String EmptyEmailErr = d.getCellData("Data1", "Email Error", 4);
	public String EmptyPassErr = d.getCellData("Data1", "Password Error", 3);

}
