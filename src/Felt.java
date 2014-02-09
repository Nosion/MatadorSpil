/** Superklassen for alle matadorspillets felter */
public class Felt
{
  String navn;       // feltets navn, f.eks. "Hvidovrevej"

  /** kaldes når en spiller passerer dette felt */
  public void passeret(Spiller sp) 
  {
    sp.besked("Du passerer "+navn);
  }

  /** kaldes når en spiller lander på dette felt */
  public void landet(Spiller sp)
  {
  }
}
