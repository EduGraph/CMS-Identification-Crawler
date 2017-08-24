package CmsIdentifierTests;

import org.junit.Assert;
import org.junit.Test;

import crosscutting.ValueObjects.CMS;
import write.cmsidentifier.business.CMSIdentifierAlgorithmn.EgotecIdentifier;
import write.cmsidentifier.business.CMSIdentifierAlgorithmn.ICMSIdentifier;
import write.cmsidentifier.business.models.Site;

public class EgotecIdentifierTest {
	@Test
	public void ShouldReturnUnbekanntesCMSWhenThereIsNoHintForErgotec(){
		// Arrange
		String html = "<html><head></head><body></body></html>";
		ICMSIdentifier ergotec = new EgotecIdentifier(new Site(html, null));
		
		// Act
		CMS result = ergotec.identify();
		
		// Assert
		Assert.assertEquals(CMS.UnbekanntesCMS, result);
	}
	
	@Test
	public void ShouldReturnErgotecWhenMetaTagIsFound(){
		// Arrange
		String html = "<meta name=\"generator\" content=\"EGOTEC 16.6.5 85699/www.EGOTEC.com\" />";
		ICMSIdentifier ergotec = new EgotecIdentifier(new Site(html, null));
		
		// Act
		CMS result = ergotec.identify();
		
		// Assert
		Assert.assertEquals(CMS.Egotec, result);
	}
}
