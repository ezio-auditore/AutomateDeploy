package com.stark.entities;

public class SearchCriteria {
	
	private String startWith;
	private String endsWith;
	public String getStartWith() {
		return startWith;
	}
	public void setStartWith(String startWith) {
		this.startWith = startWith;
	}
	public String getEndsWith() {
		return endsWith;
	}
	public void setEndsWith(String endsWith) {
		this.endsWith = endsWith;
	}
	public SearchCriteria(String startWith, String endsWith) {
this.startWith=startWith.isEmpty()?"":startWith;
this.endsWith=startWith.isEmpty()?"":endsWith;
	}


	

}
