/** Definition af en spiller */
public class Spiller
{
  String navn; // spillerens navn, f.eks. "S�ren"
  double konto; // antal kroner p� spillerens konto
  int feltnr; // hvad nummer felt spilleren st�r p�. ?Start? er nummer 0

  public Spiller(String navn, double konto)
  {
    this.navn = navn;
    this.konto = konto;
    feltnr = 0;
  }

  /** En besked til spilleren */
  public void besked(String besked)
  {
    System.out.println(navn+": "+besked);
  }

  /** Et ja/nej-sp�rgsm�l. Svarer brugeren ja returneres true, ellers false */
  public boolean sp�rgsm�l(String sp�rgsm�l)
  {
    String spm = navn+": Vil du "+sp�rgsm�l+"?";
    String svar = javax.swing.JOptionPane.showInputDialog(spm, "ja");
    System.out.println(spm+" "+svar);
    if (svar!=null && svar.equals("ja")) return true;
    else return false;
  }

  public void transaktion(double kr)
  {
    konto = konto + kr;
    System.out.println(navn+"s konto lyder nu p� "+konto+" kr.");
  }

  public void betal(Spiller modtager, double kr)
  {
    System.out.println(navn+" betaler "+modtager.navn+": "+kr+" kr.");
    modtager.transaktion(kr);
    transaktion(-kr);
  }
}