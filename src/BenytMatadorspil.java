import java.util.Scanner;

public class BenytMatadorspil
{
  public static void main(String[] arg)
  {
    Matadorspil spil = new Matadorspil();
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Intast antal spilere");
    int antalS = keyboard.nextInt(); // Intast tal int for antal spiller
    String name;

   for (int i = 0; i < antalS; ++i)// Løkke som brunger antal spiller, så man får muligheden for at indtaste navne på spillerene
        {
          System.out.println("Intast navn på spiller"+(i+1));
          name = keyboard.next();
          spil.spillere.add(new Spiller(name,50000 ));
        }
    //spil.spillere.add(new Spiller("S ren",50000));   // opret spiller S ren
    //spil.spillere.add(new Spiller("Gitte",50000));   // opret spiller Gitte

    // l b gennem 20 runder (40 ture)
    for (spil.spillersTur=0; spil.spillersTur<40; spil.spillersTur++)
    {
      // tag skiftevis S ren og Gitte (% er forklaret i afsnit 2.11.4)
        
      Spiller sp = spil.spillere.get(spil.spillersTur % spil.spillere.size());
            int terning1 = (int)(Math.random()*6)+1;     // og sl  et terningkast (1-6)
            int terning2 = (int)(Math.random()*6)+1; // og slå et terningkast (1-6) //slår to terninger
      System.out.println("***** "+sp.navn+" på felt "+sp.feltnr+" slår "+terning1 +" og " +terning2);
      
    int slag = terning1 + terning2;   // ligger terninge øjnene sammen
      
      if (terning1 == terning2){                  //Hvis det er to ens øjne slår spiller igen.
        spil.spillersTur = spil.spillersTur -1;
        }
        
      System.out.println(spil.spillersTur);
      for (int i=1; i<=slag; i=i+1) // nu rykkes der
      {
        // gå til næste felt. Hvis vi når over antal felter så tæl fra 0
        sp.feltnr = (sp.feltnr + 1) % spil.felter.size();
        Felt felt = spil.felter.get(sp.feltnr);

        if (i<slag) felt.passeret(sp); // kald passeret() på passerede felter
        else felt.landet(sp); // kald landet() på sidste felt
        try { Thread.sleep(300); } catch (Exception e) {} // vent 0.3 sek
      }
      try { Thread.sleep(3000); } catch (Exception e) {} // tur slut, vent 3 sek
    }
  }
}