package kr.co.mySpring.WebCorolling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class urlTest2 {
	public static void main(String[] args) {
		try {
			
			URL url = new URL("https://www.naver.com/");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String tmp;
			String total = "";
			
			while ((tmp = br.readLine()) != null) {
				if(tmp.contains("class=\"nav_item\"")) {
						if(tmp.contains("<a")) {
						System.out.println(tmp.split("</a>")[0].split(">")[2]);
						total += tmp.split("</a>")[0].split(">")[2] + "\n";
						
						File file = new File("/home/dev06/네이버가로메뉴.txt");
						BufferedWriter writer = new BufferedWriter(new FileWriter(file)) ;
						writer.write(total);
						writer.close();
						}
				}
			}
			con.disconnect();
			br.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
/*
	public static void main(String[] args) {
		try {
			
			URL url = new URL("https://www.naver.com/");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String tmp;
			
			
			while ((tmp = br.readLine()) != null) {
				if(tmp.contains("class=\"title elss\"")) {
					//System.out.println("tmp===>" + tmp);
					System.out.println(tmp.split(">")[1].split("<")[0]);
					//System.out.println(tmp.split(">")[1].split("<")[0]);
					System.out.println();
				}
			}
			con.disconnect();
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

*/