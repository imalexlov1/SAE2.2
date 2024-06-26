//18efficacite.java

public class Main {
    public static String RLE(String in) {
        int nbite=0;
        if (in == null || in.isEmpty()) {
            nbite+=1;
            return "";
        }
        StringBuilder resultat = new StringBuilder();
        int cpt = 1;
        for (int i = 1; i < in.length(); i++) {
            nbite+=1;
            if (in.charAt(i) != in.charAt(i - 1) || cpt >= 9) {
                nbite+=1;
                resultat.append(cpt).append(in.charAt(i - 1));
                cpt = 1;
            } else {
                nbite+=1;
                cpt++;
            }
        }
        resultat.append(cpt).append(in.charAt(in.length() - 1));
        System.out.println(nbite);
        return resultat.toString();
    }

    public static String RLE(String in, int iteration)  {
        int nbite=0;
        if (iteration < 1) {
            nbite+=1;
            System.out.println("Iteration doit être >= 1");
        }
        String resultat = in;
        for (int i = 0; i < iteration; i++) {
            nbite+=1;
            resultat = RLE(resultat);
        }
        System.out.println(nbite);
        return resultat;
    }

    public static String unRLE(String in)  {
        int nbite=0;
        if (in == null || in.isEmpty()) {
            nbite+=1;
            return "";
        }
        StringBuilder resultat = new StringBuilder();
        int cpt = 0;
        for (char c : in.toCharArray()) {
            nbite+=1;
            if (Character.isDigit(c)) {
                nbite+=1;
                cpt = cpt * 10 + Character.getNumericValue(c);
            } else {
                nbite+=1;
                for (int i = 0; i < cpt; i++) {
                    nbite+=1;
                    resultat.append(c);
                }
                cpt = 0;
            }
        }
        System.out.println(nbite);
        return resultat.toString();
    }

    public static String unRLE(String in, int iteration)  {
        int nbite=0;
        if (iteration < 1) System.out.println("Iteration devrait être >= 1"); nbite+=1;
        String result = in;
        for (int i = 0; i < iteration; i++) {
            nbite+=1;
            result = unRLE(result);
        }
        System.out.println(nbite);
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


