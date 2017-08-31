package com.zhiyou100.zy.web.utils;

public class VideoLength {

	public static String main(Integer length) {
		// TODO Auto-generated method stub

	
		String hour=null;
		String minute=null;
		String seconds=null;
		String abc=null;
		int d=length/3600;
		if(d<10){
			if(d>=1){
				hour="0"+d;
			int e=length-(length/3600)*3600;
			int a=(e/60);
			   if(a>10){
				minute=""+a;
				int b=length-(length/60)*60;
				seconds=b>10?""+b:"0"+b;
			}
			else{
				minute="0"+a;
				int b=length-(length/60)*60;
				seconds=b>10?""+b:"0"+b;
				
			}
		    abc=hour+":"+minute+":"+seconds;			
			}else{
				hour="00";
				int a=(length/60);
				if(a>10){
					minute=""+a;
					int b=length-(length/60)*60;
					seconds=b>10?""+b:"0"+b;
				}
				else{
					minute="0"+a;
					int b=length-(length/60)*60;
					seconds=b>10?""+b:"0"+b;							
				}
			 abc=hour+":"+minute+":"+seconds;
			}					 
		}
		else{
			int g=length/3600;
			  hour=""+g;
			  int f=length-g*3600;
			  int a=(f/60);
				if(a>10){
					minute=""+a;
					int b=length-(length/60)*60;
					seconds=b>10?""+b:"0"+b;
				}
				else{
					minute="0"+a;
					int b=length-(length/60)*60;
					seconds=b>10?""+b:"0"+b;	
				}
			    abc=hour+":"+minute+":"+seconds;	
		}
		return abc;
		
}
	
	
	
}
