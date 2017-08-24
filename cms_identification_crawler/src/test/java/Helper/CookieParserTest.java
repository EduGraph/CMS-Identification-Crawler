package Helper;

import org.junit.Assert;
import org.junit.Test;

import write.cmsidentifier.business.helper.CookieParser;
import write.cmsidentifier.business.models.Cookie;

public class CookieParserTest {
	@Test
	public void shouldProduceCookieWithName(){
		// Arrange
		String cookieString = "testcookie=testvalue; expires=Mon, 03-Jul-2017 20:37:38 GMT; path=/; httponly";

		// Act
		Cookie result = new CookieParser(cookieString).parse();
		
		// Assert
		Assert.assertEquals("testcookie", result.getName());
	}
	
	@Test
	public void shouldProduceCookieWithValue(){
		// Arrange
		String cookieString = "testcookie=testvalue; expires=Mon, 03-Jul-2017 20:37:38 GMT; path=/; httponly";

		// Act
		Cookie result = new CookieParser(cookieString).parse();
		
		// Assert
		Assert.assertEquals("testvalue", result.getValue());
	}
}
