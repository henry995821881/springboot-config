package org.henry.wx_account.bean;

import java.io.Serializable;
import java.util.Date;

public class QueryAccount implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	
	  private String type;

	  
	   
	    private String userId;

	 
	   /**
	    * 2017-08-08 22:23:01 时间格式
	    */
	    private String start_date;
	    
	    private String end_date;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getStart_date() {
			return start_date;
		}

		public void setStart_date(String start_date) {
			this.start_date = start_date;
		}

		public String getEnd_date() {
			return end_date;
		}

		public void setEnd_date(String end_date) {
			this.end_date = end_date;
		}

	
	
	    
	    
	    
	
}
