package com.java.tool;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.rtf.RtfWriter2;

public class TableToWord {

	public static void openWord(String outPath,int[] width,String title,int colNumber,String[] head,Vector<Vector<String>> data,int size,int orien){
		Document document = null;
		if(orien == 0){
		 document = new Document(PageSize.A4);   
		}else if(orien == 1){
		 document = new Document(PageSize.A4.rotate());   
		}
		   try {    
		    RtfWriter2.getInstance(document,  
		 new FileOutputStream(outPath));    
		   
		    document.open();    
		       
		   //设置合同头    
		       
		   Paragraph ph = new Paragraph();    
		   Font f  = new Font();    
		       
		   Paragraph p = new Paragraph(title,   
		 new Font(Font.NORMAL, 20+size, Font.BOLD, new Color(0, 0, 0)) );    
		    p.setAlignment(1);    
		    document.add(p);    
		    ph.setFont(f);    
		    
		    // 设置中文字体    
		    // BaseFont bfFont =    
		    // BaseFont.createFont("STSongStd-Light",  
		 //"UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);    
		    // Font chinaFont = new Font();    
		    /*   
		     * 创建有三列的表格   
		     */   
		    Table table = new Table(colNumber);     
	        table.setWidths(width);  
	        table.setWidth(90);//占页面宽度比例  
	        table.setAlignment(Element.ALIGN_CENTER);//居中  
	       // table.setAlignment(Element.ALIGN_MIDDLE);//垂直居中  
	        table.setAutoFillEmptyCells(true);//自动填满   
		    table.setBorderWidth(1);    
		    table.setBorderColor(Color.BLACK);    
		    table.setPadding(0);    
		    table.setSpacing(0);    
		        
		    /*   
		     * 添加表头的元素   
		     */   
		    Cell cell = new Cell("表头");//单元格    
		    for(int i=0;i<head.length;i++){
		    	 f = new Font(Font.NORMAL, 11+size, Font.NORMAL, new Color(0, 0, 0));
		    	 cell = new Cell(new Phrase(head[i],f));
		    	 cell.setHeader(true);
		    	 cell.setVerticalAlignment(Element.ALIGN_CENTER); 
		    	 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		    	 table.addCell(cell);
		    }
		    table.endHeaders();
		    // 表格的主体    
		   /* cell = new Cell("Example cell 2");    
		    cell.setRowspan(2);//当前单元格占两行,纵向跨度    
		    table.addCell(cell);    
		    table.addCell("1,1");    
		    table.addCell("1,2");    
		    table.addCell("1,3");    
		    table.addCell("1,4");    
		    table.addCell("1,5");    
		    table.addCell(new Paragraph("用java生成的表格1"));    
		    table.addCell(new Paragraph("用java生成的表格2"));    
		    table.addCell(new Paragraph("用java生成的表格3"));    
		    table.addCell(new Paragraph("用java生成的表格4"));    
		    document.add(new Paragraph("用java生成word文件"));    */
		    f = new Font(Font.NORMAL, 10+size, Font.NORMAL, new Color(0, 0, 0));
		    for(int i=0;i<data.size();i++)
		    	for(int j=0;j<data.elementAt(i).size();j++){
		    		//if(j!=0)
		    		cell = new Cell(new Phrase(data.elementAt(i).elementAt(j),f));  
		    	    //cell.setVerticalAlignment(Element.ALIGN_MIDDLE); 
		    	    cell.setVerticalAlignment(Element.ALIGN_CENTER); 
		    	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		    		table.addCell(cell);
		    		//table.set
		    	}
		    document.add(table);    
		    document.close();    
		   } catch (FileNotFoundException e) {    
		    e.printStackTrace();    
		   } catch (DocumentException e) {    
		    e.printStackTrace();    
		   } catch (IOException e) {    
		    e.printStackTrace();    
		   }    
		  }    
}
