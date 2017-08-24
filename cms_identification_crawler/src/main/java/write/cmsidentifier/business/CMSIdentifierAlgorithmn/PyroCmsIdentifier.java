package write.cmsidentifier.business.CMSIdentifierAlgorithmn;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import crosscutting.ValueObjects.CMS;
import write.cmsidentifier.business.models.Site;

public class PyroCmsIdentifier implements ICMSIdentifier {
	private Site site;
	
	public PyroCmsIdentifier(Site site) {
		this.site = site;
	}

	@Override
	public CMS identify() {
		if (this.CSSClassPyroImageFound()) {
			return CMS.PyroCMS;
		}
		
		return CMS.UnbekanntesCMS;
	}

	private boolean CSSClassPyroImageFound() {
		Document doc = Jsoup.parse(this.site.getHtml());
		Elements pyroImage = doc.getElementsByClass("pyro-image");
		return isPyroImageClassFound(pyroImage);
	}

	private boolean isPyroImageClassFound(Elements pyroImage) {
		return pyroImage != null && pyroImage.size() > 0;
	}
}
