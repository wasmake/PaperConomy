package com.akardoo.paperconomy.objects;

public class Currency {
	private String name, symbol;
	private double limit, limitp;
	
	public Currency(String name, String symbol, double limit, double limitp){
		this.name = name;
		this.symbol = symbol;
		this.limit = limit;
		this.limitp = limitp;
	}
	
	public void setName(String n){
		this.name = n;
	}
	
	public void setSymbol(String s){
		this.symbol = s;
	}
	
	public void setLimit(double l){
		this.limit = l;
	}
	
	public void setLimitp(double l){
		this.limitp = l;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getSymbol(){
		return this.symbol;
	}
	
	public double getLimit(){
		return this.limit;
	}
	
	public double getLimitp(){
		return this.limitp;
	}
	
}
