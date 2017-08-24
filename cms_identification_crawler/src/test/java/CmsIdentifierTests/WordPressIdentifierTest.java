package CmsIdentifierTests;

import org.junit.Assert;
import org.junit.Test;

import crosscutting.ValueObjects.CMS;
import write.cmsidentifier.business.CMSIdentifierAlgorithmn.ICMSIdentifier;
import write.cmsidentifier.business.CMSIdentifierAlgorithmn.WordPressIdentifier;
import write.cmsidentifier.business.models.Site;

public class WordPressIdentifierTest {
	@Test
	public void ShouldReturnUnbekanntesCMSWhenThereIsNoHintForTypo3(){
		// Arrange
		String html = "<html><head></head><body></body></html>";
		ICMSIdentifier wordpress = new WordPressIdentifier(new Site(html, null));
		
		// Act
		CMS result = wordpress.identify();
		
		// Assert
		Assert.assertEquals(CMS.UnbekanntesCMS, result);
	}
	
	@Test
	public void ShouldReturnWordPressWhenWp_contentIsFoundInHref(){
		// Arrange
		String html = "<link href='wp-content' />";
		ICMSIdentifier wordpress = new WordPressIdentifier(new Site(html, null));
		
		// Act
		CMS result = wordpress.identify();
		
		// Assert
		Assert.assertEquals(CMS.WordPress, result);
	}
}
