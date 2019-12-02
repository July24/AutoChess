package com.yhy;

import java.util.Scanner;

import com.yhy.flow.FlowConst;
import com.yhy.flow.SingleFlowControl;

public class Entrance {
	
	public static void main(String[] args) throws Exception {
		System.out.println(FlowConst.LINE);
		System.out.println("*****Java Auto Chess*******");
		System.out.println("**************************");
		System.out.println("********1.对战电脑***********");
		System.out.println(FlowConst.LINE);
		Scanner scan = new Scanner(System.in);
		int i = scan.nextInt();
		if(i == 1) {
			try {
				SingleFlowControl single = new SingleFlowControl();
				single.gameInit();
				single.game();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
