//18sobriete.java

public class Main {
    public static String RLE(String in) {
        if (in == null || in.isEmpty()) {
            return "";
        }
        StringBuilder resultat = new StringBuilder(in.length());
        int cpt = 1;
        for (int i = 1; i < in.length(); i++) {
            if (in.charAt(i) != in.charAt(i - 1) || cpt >= 9) {
                resultat.append(cpt).append(in.charAt(i - 1));
                cpt = 1;
            } else {
                cpt++;
            }
        }
        resultat.append(cpt).append(in.charAt(in.length() - 1));
        return resultat.toString();
    }

    public static String RLE(String in, int iteration)  {
        if (iteration < 1) {
          System.out.println("Iteration doit être >= 1");
        }
        String resultat = in;
        for (int i = 0; i < iteration; i++) {
            resultat = RLE(resultat);
        }
        return resultat;
    }

    public static String unRLE(String in){
        if (in == null || in.isEmpty()) {
            return "";
        }
        StringBuilder resultat = new StringBuilder(in.length());
        int cpt = 0;
        for (int i = 0; i < in.length(); i++) {
            char c = in.charAt(i);
            if (Character.isDigit(c)) {
                cpt = cpt * 10 + Character.getNumericValue(c);
            } else {
                while (cpt-- > 0) {
                    resultat.append(c);
                }
                cpt = 0;
            }
        }
        return resultat.toString();
    }

    public static String unRLE(String in, int iteration)  {
        if (iteration < 1) System.out.println("Iteration devrait être >= 1");
        String result = in;
        for (int i = 0; i < iteration; i++) {
            result = unRLE(result);
        }
        return result;
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


