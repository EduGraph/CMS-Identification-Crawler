package read.frontend.presentation.Models;

import java.util.List;

import crosscutting.query.IResult;

public class CMSDerHochschulen implements IResult {
	private List<HochschuleCMS> cmsDerHochschulen;

	public CMSDerHochschulen(List<HochschuleCMS> cmsDerHochschulen) {
		super();
		this.cmsDerHochschulen = cmsDerHochschulen;
	}

	public List<HochschuleCMS> getCmsDerHochschulen() {
		return cmsDerHochschulen;
	}

	public void setCmsDerHochschulen(List<HochschuleCMS> cmsDerHochschulen) {
		this.cmsDerHochschulen = cmsDerHochschulen;
	}

}
