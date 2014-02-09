/** Helle - hvis man lander her f�r man en gevinst */
public class Helle extends Felt
{
  double gevinst;

  public Helle (int gevinst)
  {
    navn = "Helle";                 // navn er arvet fra Felt
    this.gevinst = gevinst;
  }

  public void landet(Spiller sp)    // tilsides�t metode i Felt
  {
    sp.besked("Du lander p� helle og f�r overf�rt "+gevinst);
    sp.transaktion(gevinst);        // opdater spillers konto
  }
}
