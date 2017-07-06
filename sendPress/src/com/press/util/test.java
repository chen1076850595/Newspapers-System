package com.press.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class test {
	public static void list(){
		List list = new ArrayList<Integer>();
		for(int i=0;i<5;i++){
			list.add(i);
		}
		Collections.reverse(list);
		for(int j=0;j<5;j++){
			System.out.println(list.get(j));
		}
	}
	public static void blo(){
	}
	
	//public static void main(String[] args) {
	//	list();
	//}
}
