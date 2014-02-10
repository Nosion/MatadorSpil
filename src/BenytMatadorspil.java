public class BenytMatadorspil
{
  public static void main(String[] arg)
  {
    Matadorspil spil = new Matadorspil();
    spil.spillere.add(new Spiller("S�ren",50000)); // opret spiller S�ren
    spil.spillere.add(new Spiller("Gitte",50000)); // opret spiller Gitte
    	////TESTTTTTT
    // l�b gennem 20 runder (40 ture)
    for (spil.spillersTur=0; spil.spillersTur<40; spil.spillersTur++)
    {
      // tag skiftevis S�ren og Gitte (% er forklaret i afsnit 2.11.4)
      Spiller sp = spil.spillere.get(spil.spillersTur % spil.spillere.size());
      int terning1 = (int)(Math.random()*6)+1; // og sl� et terningkast (1-6)
      int terning2 = (int)(Math.random()*6)+1; // og sl� et terningkast (1-6) //sl�r to terninger
      System.out.println("***** "+sp.navn+" p� felt "+sp.feltnr+" sl�r "+terning1 +" og " +terning2);
      
      int slag = terning1 + terning2;   // ligger terninge �jnene sammen
      
      if (terning1 == terning2){                 	//Hvis det er to ens �jne sl�r spiller igen.
    	   spil.spillersTur = spil.spillersTur -1;
    	   }
    		  
      System.out.println(spil.spillersTur);
      for (int i=1; i<=slag; i=i+1) // nu rykkes der
      {
        // g� til n�ste felt. Hvis vi n�r over antal felter s� t�l fra 0
        sp.feltnr = (sp.feltnr + 1) % spil.felter.size();
        Felt felt = spil.felter.get(sp.feltnr);

        if (i<slag) felt.passeret(sp); // kald passeret() p� passerede felter
        else felt.landet(sp); // kald landet() p� sidste felt
        try { Thread.sleep(300); } catch (Exception e) {} // vent 0.3 sek
      }
      try { Thread.sleep(3000); } catch (Exception e) {} // tur slut, vent 3 sek
    }
  }
}