/** Et rederi, der kan købes af en spiller */
public class Rederi extends Felt
{
  Spiller ejer;
  double pris;
  double grundleje;

  public Rederi(String navn, double pris, double leje)
  {
    this.navn = navn;
    this.pris = pris;
    this.grundleje = leje;
  }

  public void landet(Spiller sp)
  {
    sp.besked("Du er landet på "+navn);
    if (sp==ejer)
    {                                       // spiller ejer selv grunden
      sp.besked("Det er din egen grund");
    }
    else if (ejer==null)
    {                                       // ingen ejer grunden, så køb den
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
    {                                       // feltet ejes af anden spiller
      sp.besked("Leje: "+grundleje);
      sp.betal(ejer, grundleje);            // spiller betaler til ejeren
    }
  }
}
