/** Startfeltet - når en spiller passerer dette felt, får han 5000 kr */
public class Start extends Felt
{
  double gevinst;

  public Start(double gevinst)
  {
    navn = "Start";
    this.gevinst = gevinst;
  }

  public void passeret(Spiller sp)                 // tilsidesæt metode i Felt
  {
    sp.besked("Du passerer start og modtager "+gevinst);
    sp.transaktion(gevinst);                      // kredit/debit af konto
  }

  public void landet(Spiller sp)                   // tilsidesæt metode i Felt
  {
    sp.besked("Du lander på start og modtager "+gevinst);
    sp.transaktion(gevinst);
  }
}
