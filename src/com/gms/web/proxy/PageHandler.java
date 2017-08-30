package com.gms.web.proxy;

import com.gms.web.command.Command;

public class PageHandler{

   public static Command attr(PageProxy pxy){
	   Command cmd=new Command();
      int startRow = 0, endRow =0;
      if(pxy.getPageNumber()<=pxy.getTheNumberOfRows() / pxy.getPageSize() +1){
         if (pxy.getPageNumber() == 1){
         startRow =1;
         endRow = pxy.getPageSize(); 
         cmd.setStartRow("1");
         cmd.setEndRow(String.valueOf(pxy.getPageSize()));
      }else{
         startRow =(pxy.getPageNumber() -1) * pxy.getPageSize() +1;
          endRow = pxy.getPageNumber() * pxy.getPageSize();
          cmd.setStartRow(String.valueOf((pxy.getPageNumber() -1) * pxy.getPageSize() +1));
          cmd.setEndRow(String.valueOf(pxy.getPageNumber() * pxy.getPageSize()));
      }
   }
      //System.out.println(pxy.getPageNumber()+":"+pxy.getTheNumberOfRows()+":"+pxy.getPageSize()+":"+startRow+":"+endRow);
   return cmd;
   }
}