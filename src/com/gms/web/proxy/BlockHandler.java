package com.gms.web.proxy;

public class BlockHandler{

   public static int[] attr(PageProxy pxy)  {
      int[]result=new int[6];
      int theNumberOfPages=0, startPage=0, endPage=0;
      theNumberOfPages=(pxy.getTheNumberOfRows() % pxy.getPageSize()) ==0? pxy.getTheNumberOfRows()/pxy.getPageSize():pxy.getTheNumberOfRows()/pxy.getPageSize()+1;
      startPage = pxy.getPageNumber()-((pxy.getPageNumber()-1)%pxy.getBlockSize());
      endPage = (startPage+pxy.getBlockSize()-1 <=theNumberOfPages)? startPage+pxy.getBlockSize()-1:theNumberOfPages;
      result[0]= pxy.getPageNumber();
      result[1]= theNumberOfPages;
      result[2]= startPage;
      result[3]= endPage;
      result[4]= startPage-pxy.getBlockSize();//startPage-(theNumberOfPages/pxy.getBlockSize()); //preblock
      result[5]= startPage+pxy.getBlockSize();//startPage+(theNumberOfPages/pxy.getBlockSize()); //nextblock
      return result;
   }

}