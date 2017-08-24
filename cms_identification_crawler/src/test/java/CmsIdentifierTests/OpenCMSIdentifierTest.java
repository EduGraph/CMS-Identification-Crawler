package CmsIdentifierTests;

import org.junit.Assert;
import org.junit.Test;

import crosscutting.ValueObjects.CMS;
import write.cmsidentifier.business.CMSIdentifierAlgorithmn.ICMSIdentifier;
import write.cmsidentifier.business.CMSIdentifierAlgorithmn.OpenCMSIdentifier;
import write.cmsidentifier.business.models.Site;

public class OpenCMSIdentifierTest {
	@Test
	public void ShouldReturnUnbekanntesCMSWhenThereIsNoHintForErgotec(){
		// Arrange
		String html = "<html><head></head><body></body></html>";
		ICMSIdentifier openCms = new OpenCMSIdentifier(new Site(html, null));
		
		// Act
		CMS result = openCms.identify();
		
		// Assert
		Assert.assertEquals(CMS.UnbekanntesCMS, result);
	}
	
	@Test
	public void ShouldReturnErgotecWhenMetaTagIsFound(){
		// Arrange
		String html = "<meta name=\"system\" content=\"OpenCms 10.5.x-643563\" />";
		ICMSIdentifier openCms = new OpenCMSIdentifier(new Site(html, null));
		
		// Act
		CMS result = openCms.identify();
		
		// Assert
		Assert.assertEquals(CMS.OpenCMS, result);
	}
}
