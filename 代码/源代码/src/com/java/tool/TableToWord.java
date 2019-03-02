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
		       
		   //���ú�ͬͷ    
		       
		   Paragraph ph = new Paragraph();    
		   Font f  = new Font();    
		       
		   Paragraph p = new Paragraph(title,   
		 new Font(Font.NORMAL, 20+size, Font.BOLD, new Color(0, 0, 0)) );    
		    p.setAlignment(1);    
		    document.add(p);    
		    ph.setFont(f);    
		    
		    // ������������    
		    // BaseFont bfFont =    
		    // BaseFont.createFont("STSongStd-Light",  
		 //"UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);    
		    // Font chinaFont = new Font();    
		    /*   
		     * ���������еı��   
		     */   
		    Table table = new Table(colNumber);     
	        table.setWidths(width);  
	        table.setWidth(90);//ռҳ���ȱ���  
	        table.setAlignment(Element.ALIGN_CENTER);//����  
	       // table.setAlignment(Element.ALIGN_MIDDLE);//��ֱ����  
	        table.setAutoFillEmptyCells(true);//�Զ�����   
		    table.setBorderWidth(1);    
		    table.setBorderColor(Color.BLACK);    
		    table.setPadding(0);    
		    table.setSpacing(0);    
		        
		    /*   
		     * ��ӱ�ͷ��Ԫ��   
		     */   
		    Cell cell = new Cell("��ͷ");//��Ԫ��    
		    for(int i=0;i<head.length;i++){
		    	 f = new Font(Font.NORMAL, 11+size, Font.NORMAL, new Color(0, 0, 0));
		    	 cell = new Cell(new Phrase(head[i],f));
		    	 cell.setHeader(true);
		    	 cell.setVerticalAlignment(Element.ALIGN_CENTER); 
		    	 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		    	 table.addCell(cell);
		    }
		    table.endHeaders();
		    // ��������    
		   /* cell = new Cell("Example cell 2");    
		    cell.setRowspan(2);//��ǰ��Ԫ��ռ����,������    
		    table.addCell(cell);    
		    table.addCell("1,1");    
		    table.addCell("1,2");    
		    table.addCell("1,3");    
		    table.addCell("1,4");    
		    table.addCell("1,5");    
		    table.addCell(new Paragraph("��java���ɵı��1"));    
		    table.addCell(new Paragraph("��java���ɵı��2"));    
		    table.addCell(new Paragraph("��java���ɵı��3"));    
		    table.addCell(new Paragraph("��java���ɵı��4"));    
		    document.add(new Paragraph("��java����word�ļ�"));    */
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
