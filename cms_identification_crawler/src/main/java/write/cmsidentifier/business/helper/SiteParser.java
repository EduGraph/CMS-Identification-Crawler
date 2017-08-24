package write.cmsidentifier.business.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import write.cmsidentifier.business.models.Cookie;
import write.cmsidentifier.business.models.Site;

public class SiteParser implements ISiteParser {
	private String url;

	public SiteParser(String url) {
		this.url = url;
	}
	
	public Site parse(){
		try {
			URLConnection connection = new URL(this.url).openConnection();
			String html = this.getHtml(connection);
			List<Cookie> cookies = this.getCookies(connection);
			return new Site(html, cookies);
		} catch (IOException e) {
			return new Site("", new ArrayList<>());
		}
	}
	
	private List<Cookie> getCookies(URLConnection connection) {
		List<String> rawCookies = connection.getHeaderFields().get("Set-Cookie");
		List<Cookie> cookies = new ArrayList<>();
		
		if (rawCookies == null || rawCookies.size() == 0) {
			return cookies;  
		}
		
		for (String rawCookie : rawCookies) {
			cookies.add(new CookieParser(rawCookie).parse());
		}
		
		return cookies;
	}

	private String getHtml(URLConnection connection) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		StringBuilder builder = new StringBuilder();
		String htmlLine;
		
		while((htmlLine = in.readLine()) != null){
			builder.append(htmlLine);
		}
		in.close();
		
		return builder.toString();
	}
}
