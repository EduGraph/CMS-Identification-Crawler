package crosscutting.ValueObjects;

public enum CMS {
	Cabacos, 
	Contano, 
	Drupal, 
	Egotec, 
	ExpressionEngine, 
	Fiona, 
	FirstSpirit, 
	Framula, 
	GoettingerCMS, 
	Icoya, 
	Imperia, 
	Ionas3, 
	Joomla, 
	Kryn, 
	Larissa, 
	MaGIC, 
	OpenCMS, 
	Plone, 
	ProcessWire, 
	PyroCMS, 
	UnbekanntesCMS, 
	SharePoint, 
	Typo3, 
	WebBox, 
	Weblication,
	WebVanilla, 
	WordPress, 
	XIMS, 
	ZMS; 

	public boolean isUnbekannt() {
		return this == CMS.UnbekanntesCMS;
	}

	@Override
	public String toString() {
		switch (this) {
		case Cabacos:
			return "Cabacos";
		case Contano:
			return "Contano";
		case Drupal:
			return "Drupal";
		case Egotec:
			return "Egotec";
		case ExpressionEngine:
			return "ExpressionEngine";
		case Fiona:
			return "Fiona";
		case FirstSpirit:
			return "FirstSpirit";
		case Framula:
			return "Framula";
		case GoettingerCMS:
			return "GoettingerCMS";
		case Icoya:
			return "Icoya";
		case Imperia:
			return "Imperia";
		case Ionas3:
			return "Ionas3";
		case Joomla:
			return "Joomla";
		case Kryn:
			return "Kryn";
		case Larissa:
			return "Larissa";
		case MaGIC:
			return "MaGIC";
		case OpenCMS:
			return "OpenCMS";
		case Plone:
			return "Plone";
		case ProcessWire:
			return "ProcessWire";
		case PyroCMS:
			return "PyroCMS";
		case SharePoint:
			return "SharePoint";
		case Typo3:
			return "Typo3";
		case UnbekanntesCMS:
			return "UnbekanntesCMS";
		case WebBox:
			return "WebBox";
		case Weblication:
			return "Weblication";
		case WebVanilla:
			return "webVanilla";
		case XIMS:
			return "XIMS";
		case ZMS:
			return "ZMS";
		default:
			return "UnbekanntesCMS";
		}
	}
}
