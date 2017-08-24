package write.cmsidentifier.business.helper;

import java.util.function.Predicate;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import write.cmsidentifier.business.models.Site;

public class IdentifierHelper {
	public static String GetMetaGeneratorContent(Site site){
		return IdentifierHelper.GetMetaTag(site, "generator", "content");
	}
	
	public static String GetMetaSystemContent(Site site){
		return IdentifierHelper.GetMetaTag(site, "system", "content");
	}

	public static Boolean FindSomethingInInlineJavaScript(Site site, String something){
		Predicate<Element> JavaScriptInline = element -> element.attr("type").contains("text/javascript") && element.data().contains(something);
		return IdentifierHelper.FindSomeThing(site, JavaScriptInline);
	}
	
	public static Boolean FindSometingInHref(Site site, String something){
		Predicate<Element> href = element -> element.attr("href").contains(something);
		return IdentifierHelper.FindSomeThing(site, href);
	}
	
	public static boolean FindSomethingInJavaScriptSrc(Site site, String something) {
		Predicate<Element> JavaScriptSrc = element -> element.attr("type").contains("text/javascript") && element.attr("src").contains(something);
		return IdentifierHelper.FindSomeThing(site, JavaScriptSrc);
	}
	
	public static boolean FindSometingInClass(Site site, String something) {
		Predicate<Element> condition = IdentifierHelper.AttrContainsPredicate("class", something);
		return IdentifierHelper.FindSomeThing(site, condition);
	}
	
	private static Predicate<Element> AttrContainsPredicate(String attr, String contains){
		return  element -> element.attr(attr).contains(contains);
	}
	
	private static String GetMetaTag(Site site, String key, String value) {
		Document doc = Jsoup.parse(site.getHtml());
		return doc.select("meta[name="+ key +"]").attr(value).toUpperCase();
	}
	
	private static boolean FindSomeThing(Site site, Predicate<Element> condition){
		Document doc = Jsoup.parse(site.getHtml());
		Elements elements = doc.getAllElements();
		for (Element element : elements) {
			if (condition.test(element)){
				return true;
			}
		}
		
		return false;
	}	
}
