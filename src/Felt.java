/** Superklassen for alle matadorspillets felter */
public class Felt
{
  String navn;       // feltets navn, f.eks. "Hvidovrevej"

  /** kaldes n�r en spiller passerer dette felt */
  public void passeret(Spiller sp) 
  {
    sp.besked("Du passerer "+navn);
  }

  /** kaldes n�r en spiller lander p� dette felt */
  public void landet(Spiller sp)
  {
  }
}
