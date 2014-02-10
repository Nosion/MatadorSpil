/** En gade, der kan købes af en spiller og bebygges */
public class Gade extends Felt
{
  Spiller ejer;
  double pris;
  double grundleje;
  int antalHuse = 0;
  double huspris;

  public Gade(String navn, double pris, double leje, double huspris)
  {
    this.navn = navn;
    this.pris = pris;
    this.grundleje = leje;
    this.huspris = huspris;
  }

  public void landet(Spiller sp)
  {
    sp.besked("Du er landet på "+navn);

    if (sp==ejer)
    { // eget felt
      sp.besked("Det er din egen grund");
      if (antalHuse<5 && sp.konto>huspris && // bemærk: kun hvis betingelserne
        sp.spørgsmål("købe hus for "+huspris))// er opfyldt stilles spørgsmålet
      { // byg et hus
        ejer.transaktion( -huspris );
        antalHuse = antalHuse + 1;
      }
    }
    else if (ejer==null)
    { // ingen ejer grunden, køb den?
      if (sp.konto > pris)
      {
        if (sp.spørgsmål("købe "+navn+" for "+pris))
        {
          sp.transaktion( -pris );
          ejer=sp;
        }
      }
      else sp.besked("Du har ikke penge nok til at købe "+navn);
    }
    else
    { // felt ejes af anden spiller
      double leje = grundleje + antalHuse * huspris;
      sp.besked("Leje: "+leje);
      sp.betal(ejer, leje); // spiller betaler til ejeren
    }
  }
}