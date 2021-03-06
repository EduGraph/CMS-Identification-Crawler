package write.cmsidentifier.business.CMSIdentifierAlgorithmn;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import crosscutting.ValueObjects.CMS;
import write.cmsidentifier.business.helper.IdentifierHelper;
import write.cmsidentifier.business.models.Site;

public class ImperiaIdentifier implements ICMSIdentifier {
	private Site site;
	public ImperiaIdentifier(Site site) {
		this.site = site;
	}

	@Override
	public CMS identify() {
		if (this.isImperiaInSrc()) {
			return CMS.Imperia;
		}
		
		if (this.isImperiaCommentFound()) {
			return CMS.Imperia;
		}
		return CMS.UnbekanntesCMS;
	}

	private boolean isImperiaCommentFound() {
		return this.site.getHtml().contains("<!-- IMPERIA");
	}

	private boolean isImperiaInSrc() {
		Document doc = Jsoup.parse(this.site.getHtml());
		Elements elements = doc.getAllElements();
		
		for (Element element : elements) {
			if (element.attr("src").contains("imperia")) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean isMetaGeneratorTagFound() {
		String metaContent = IdentifierHelper.GetMetaGeneratorContent(this.site);
		return metaContent != null && metaContent.contains("IMPERIA");
	}
}
