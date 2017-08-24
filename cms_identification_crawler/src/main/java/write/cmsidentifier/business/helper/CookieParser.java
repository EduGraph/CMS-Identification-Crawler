package write.cmsidentifier.business.helper;

import write.cmsidentifier.business.models.Cookie;

public class CookieParser {
	private String cookieString;

	public CookieParser(String cookieString) {
		this.cookieString = cookieString;
	}
	
	public Cookie parse(){
		String[] rawCookie = this.cookieString.split(";");
		String[] rawCookieNameAndValue = rawCookie[0].split("=");
		
		String name = rawCookieNameAndValue[0].trim();
		String value = rawCookieNameAndValue[1].trim();
		
		return new Cookie(name, value);
	}
}
