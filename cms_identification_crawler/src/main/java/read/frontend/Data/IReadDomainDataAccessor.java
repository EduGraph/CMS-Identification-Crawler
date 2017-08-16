package read.frontend.Data;

import read.frontend.presentation.Models.AnzahlDerVerwendetenCMS;
import read.frontend.presentation.Models.CMSDerHochschulen;

public interface IReadDomainDataAccessor {
	AnzahlDerVerwendetenCMS GetAnzahlDerVerwendetenCMS();
	CMSDerHochschulen GetCMSDerHochschulen();
}
