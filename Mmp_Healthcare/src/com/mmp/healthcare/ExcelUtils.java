package com.mmp.healthcare;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelUtils {
	
		public static String[][] readData(String fileName) throws BiffException, IOException
		{
			
			File f = new File(fileName);
			Workbook w = Workbook.getWorkbook(f);		
			Sheet sheet = w.getSheet(0);
			//int rows = sheet.getRows();
			//int cols = sheet.getColumns();
			int rows=1;
			int cols=6;
			String inputData[][] = new String[rows][cols];
			for(int i=0;i<rows;i++)
			{
				for(int j=0;j<cols;j++)
				{
					Cell cell =sheet.getCell(j,i);
					String str = cell.getContents();
					inputData[i][j]=str;
				}
			}
			return inputData;
}
}
