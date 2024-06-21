//56simplicite.java

public class Main {
    public static String RLE(String in) {
        if (in.isEmpty() || in == null) {
            return "";
        }

        String resultat = "";
        char caracPrecedent = in.charAt(0);
        int nbChar = 1;
        char caracActuel = 'a';
        for (int i = 1; i < in.length(); i++) {
            caracActuel = in.charAt(i);
            if (caracActuel == caracPrecedent) {
                nbChar++;
                if (nbChar == 10) {
                    resultat +=  9 + caracPrecedent;
                    nbChar = 1;
                }
            } else {
                resultat += "" + nbChar + caracPrecedent;
                nbChar = 1;
                caracPrecedent = caracActuel;
            }
        }
        return (resultat + nbChar + caracActuel);

    }

    public static String RLE(String in, int iteration)  {
        if (iteration < 1) {
            System.out.println("Il faut que l'itération soit au moins égal à 1");
        }
        if (iteration == 1) {
            return RLE(in);
        }
        return RLE(RLE(in, iteration - 1));

    }

    public static String unRLE(String in)  {
        if (in == "" || in == null) {
            return "";
        }
        String resultat = "";
        for (int i = 0; i < in.length(); i += 2) {
            int valeur = Character.getNumericValue(in.charAt(i));
            if (valeur > 9) {
              System.out.println("Erreur : l'argument n'est pas compressé");
            }
            for (int j = 0; j < valeur; j++) {
                resultat += "" + in.charAt(i + 1);
            }
        }
        return resultat;

    }

    public static String unRLE(String in, int iteration)  {
        if (iteration < 1) {
          System.out.println("Il faut que l'itération soit au moins égal à 1");
        }
        if (iteration == 1) {
            return unRLE(in);
        }
           return unRLE(unRLE(in, iteration - 1));
    }

  public static void main(String[] args){


            // Tests pour RLE
    System.out.print ("Chaine vide -> ");System.out.println(RLE("")); 
    System.out.print ("1A1l1e1x -> "); System.out.println(RLE("Alex"));
    System.out.print ("91219252 -> ");System.out.println(RLE("1111111111122222222222222"));
    System.out.println("unRLE classique") ;


    //Tests pour unRLE    
    System.out.print ("Chaine vide -> ");System.out.println(unRLE(""));
    System.out.print ("Alex  -> "); System.out.println(unRLE("1A1l1e1x"));
    System.out.print ("1111111111122222222222222 -> ");System.out.println(unRLE("91219252"));



            System.out.println("avec itération");
            // Tests pour RLE avec récursivité
    System.out.print ("Chaine vide -> ");System.out.println(RLE("", 1));
    System.out.print ("Chaine vide -> ");System.out.println(RLE("", 3));

    System.out.print ("1a1b1c -> ");System.out.println(RLE("abc", 1));
    System.out.print ("1a2b3c -> ");System.out.println(RLE("abbccc", 1));
    System.out.print ("3a1b2a -> ");System.out.println(RLE("aaabaa", 1));
    System.out.print ("91219252 -> ");System.out.println(RLE("1111111111122222222222222",1));

    System.out.print ("1a1A1a -> ");System.out.println(RLE("aAa", 1));

    System.out.print ("111a111b111c -> ");System.out.println(RLE("abc", 2));
    System.out.print ("311a311b311c -> ");System.out.println(RLE("abc", 3));

             System.out.println("unRLE avec itération");

            // Tests pour unRLE avec récursivité
    System.out.print ("Chaine vide -> ");System.out.println(unRLE("", 1));
    System.out.print ("Chaine vide -> ");System.out.println(unRLE("", 3));

    System.out.print ("abc -> ");System.out.println(unRLE("1a1b1c", 1));
    System.out.print ("abbccc -> ");System.out.println(unRLE("1a2b3c", 1));
    System.out.print ("aaabaa -> ");System.out.println(unRLE("3a1b2a", 1));
    System.out.print ("aAa -> ");System.out.println(unRLE("1a1A1a", 1));

    System.out.print ("abc -> ");System.out.println(unRLE("111a111b111c", 2));
    System.out.print ("abc -> ");System.out.println(unRLE("311a311b311c", 3));
    System.out.print ("1111aaaaaaaaa1111aaaaaaaaaaaa -> ");System.out.println(unRLE("919a919a3a", 2)); // Séquence étendue
        }


} 


