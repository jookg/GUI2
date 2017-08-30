package com.gms.web.command;

import com.gms.web.constant.Extension;
import com.gms.web.constant.Path;

import lombok.Getter;
import lombok.Setter;

public class Command implements Commandable {
	@Getter
	protected String action,pageNumber,veiw,search,column;
	@Getter @Setter
	protected String startRow,endRow,page,dir;
	
	public void setPageNumber(String pageNumber){
		this.pageNumber=(pageNumber==null)? "1":pageNumber;
	}
	public void setAction(String action) {
		this.action=(action.equals(""))? "move":action;

	}
	public void setSearch(String search){
		this.search=(search==null)? "":search;
	}
	public void setColumn(String column){
		this.column=(column==null)? "none":column;
	}
	@Override
	public void process() {
		this.veiw=(dir.equals("home"))? "/WEB-INF/view/common/home.jsp":Path.VIEW_PATH+dir+Path.SEPARATOR+page+Extension.JSP;
	}
	public String toString(){
		return "Command[DEST="+dir+"/"+page+".jsp"+",ACTION="+action+"]";
	}


}
