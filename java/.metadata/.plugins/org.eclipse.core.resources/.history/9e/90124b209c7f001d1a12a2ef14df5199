package day28.sub1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class Ex03 {
	public static void main(String[] args) throws Exception{
		
		URL url = new URL("https://www.naver.com");
		
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.connect();
		
		InputStream in = conn.getInputStream();
		// InputStreamReader
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);
		
		StringBuffer html = new StringBuffer(2000);
		String line = null;
		while((line = br.readLine()) != null) {
			html.append(line);
		}
		
		System.out.println(html.toString());
		
		br.close();
		
		conn.disconnect();
		
		
	}
}
