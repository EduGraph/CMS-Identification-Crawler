package read.frontend.Data;

import read.frontend.presentation.Models.AnzahlDerVerwendetenCMS;
import read.frontend.presentation.Models.CMSDerHochschulen;
import read.frontend.presentation.Models.VeraenderungAktuelleWoche;

public interface IReadDomainDataAccessor {
	AnzahlDerVerwendetenCMS GetAnzahlDerVerwendetenCMS();
	CMSDerHochschulen GetCMSDerHochschulen();
	VeraenderungAktuelleWoche GetVeraenderungAktulleWoche();
}
