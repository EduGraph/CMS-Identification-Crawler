package CmsIdentifierTests;

import org.junit.Assert;
import org.junit.Test;

import crosscutting.ValueObjects.CMS;
import write.cmsidentifier.business.CMSIdentifierAlgorithmn.DrupalIdentifier;
import write.cmsidentifier.business.CMSIdentifierAlgorithmn.ICMSIdentifier;
import write.cmsidentifier.business.models.Site;

public class DrupalIdentifierTest {
	@Test
	public void ShouldReturnUnbekanntesCMSWhenThereIsNoHintForTypo3(){
		// Arrange
		String html = "<html><head></head><body></body></html>";
		ICMSIdentifier drupal = new DrupalIdentifier(new Site(html, null));
		
		// Act
		CMS result = drupal.identify();
		
		// Assert
		Assert.assertEquals(CMS.UnbekanntesCMS, result);
	}
	
	@Test
	public void ShouldReturnDrupalWhenThereIsDrupalWireInJavaScript(){
		// Arrange
		String html = "<script type=\'text/javascript\'>Drupal</script>";
		ICMSIdentifier drupal = new DrupalIdentifier(new Site(html, null));
		
		// Act
		CMS result = drupal.identify();
		
		// Assert
		Assert.assertEquals(CMS.Drupal, result);
	}
	
	@Test
	public void ShouldReturnDrupalWhenThereIsDrupalInJavaScriptSrcPath(){
		// Arrange
		String html = "<script type=\"text/javascript\" src=\"drupal\"></script>";
		ICMSIdentifier drupal = new DrupalIdentifier(new Site(html, null));
		
		// Act
		CMS result = drupal.identify();
		
		// Assert
		Assert.assertEquals(CMS.Drupal, result);
	}
}
