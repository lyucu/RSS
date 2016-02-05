package tt;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RssReader {
	public static void main(String args[]) throws Exception {
		RssReader r = new RssReader();
		r.run();
	}
	
	public static Map<String, String> map = new LinkedHashMap<String, String>();
	public Map<String, String> run() throws Exception {
		URL url = new URL("http://www.gamersky.com/ ");
		URLConnection connection = url.openConnection();

		InputStream is = new BufferedInputStream(connection.getInputStream());
//		System.out.println(connection.getContentType());
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
		
		Pattern pattern1 = Pattern.compile("/(\\d+)\\.shtml");
		Pattern pattern2 = Pattern.compile(">(.+)</a>");
		String s;
		boolean flag = false;
		int count = 0;
		while ((s = br.readLine()) != null) {
			System.out.println(s);
			String temp1 = "";
			String temp2 = "'";
			if (s.contains("<ul class=\"Ptxt block\">")) {
				flag = true;
				count ++;
				if (count == 2) flag = false;
			}
			if (s.contains("<div class=\"Home-Page\">"))
				flag = false;
			if (flag) {
				if (s.contains(" <a href=")) {
					Matcher m = pattern1.matcher(s);
					while (m.find()){
//						System.out.println(m.group(1));
						temp1 = m.group(1);
					}
					m = pattern2.matcher(s);
					while (m.find()){
//						System.out.println(m.group(1));
						temp2 = m.group(1);
					}
					map.put(temp1, temp2);
//					System.out.println(s);
				}
			}
		}
		return map;
	}
}
