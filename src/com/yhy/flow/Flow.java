package com.yhy.flow;

public interface Flow {
	public void gameInit();
	public void turnBegin();
	public void roundBegin();
	public void combat();
	public void roundEnd();
	public void turnEnd();
}
