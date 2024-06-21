//49sobriete.java

public class Main {
    public static String RLE(String chaineDeCaractere) {
        if (chaineDeCaractere.length() == 0) {
            return "";
        }

        String resultat = "";
        int compteur = 1;
        char premierCaractere = chaineDeCaractere.charAt(0);

        for (int i = 1; i < chaineDeCaractere.length(); i++) {
            if (chaineDeCaractere.charAt(i) == premierCaractere) {
                compteur++;
                if (compteur == 9) {
                    resultat += compteur + String.valueOf(premierCaractere);
                    compteur = 0;
                }
            } else {
                if (compteur > 0) {
                    resultat += compteur + String.valueOf(premierCaractere);
                }
                premierCaractere = chaineDeCaractere.charAt(i);
                compteur = 1;
            }
        }

        if (compteur > 0) {
            resultat += compteur + String.valueOf(premierCaractere);
        }

        return resultat;
    }

    public static String RLE(String chaineDeCaractere, int iteration) {
        String resultat = chaineDeCaractere;
        for (int i = 0; i < iteration; i++) {
            resultat = RLE(resultat);
        }
        return resultat;
    }

    public static String unRLE(String chaineCompressee) {
        String resultat = "";
        int longueur = chaineCompressee.length();

        for (int i = 0; i < longueur; i++) {
            char caractere = chaineCompressee.charAt(i);

            if (Character.isDigit(caractere)) {
                int nombre = Character.getNumericValue(caractere);
                char caractereSuivant = chaineCompressee.charAt(++i);

                for (int j = 0; j < nombre; j++) {
                    resultat += caractereSuivant;
                }
            } else {
                resultat += caractere;
            }
        }

        return resultat;
    }

    public static String unRLE(String chaineCompressee, int iteration) {
        String resultat = chaineCompressee;
        for (int i = 0; i < iteration; i++) {
            resultat = unRLE(resultat);
        }
        return resultat;
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


