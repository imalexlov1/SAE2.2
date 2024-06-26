//39efficacite.java

public class Main {
    public static String RLE(String in) {
        int nbite=0;
        if (in == null || in.length() == 0) {
            nbite+=1;
            return "";
        }

        StringBuilder sortie = new StringBuilder();
        char charPrecedent = in.charAt(0);
        int nbRep = 1;

        for (int i = 1; i < in.length(); i++) {
            nbite+=1;
            if (in.charAt(i) == charPrecedent) {
                nbite+=1;
                nbRep++;
                if (nbRep == 9) {
                    nbite+=1;
                    sortie.append(nbRep).append(charPrecedent);
                    nbRep = 0;
                }
            } else {
                nbite+=1;
                sortie.append(nbRep).append(charPrecedent);
                charPrecedent = in.charAt(i);
                nbRep = 1;
            }
        }
        sortie.append(nbRep).append(charPrecedent);
        System.out.println(nbite);
        return sortie.toString();
    }


    public static String RLE(String in, int iteration) {
        int nbite=0;
        if (iteration <= 0 || in == null || in.length() == 0) {
            nbite+=1;
            return in;
        }

        String sortie = in;
        for (int i = 0; i < iteration; i++){
            nbite+=1;
            sortie = RLE(sortie);
        }
        System.out.println(nbite);
        return sortie;
    }

    public static String unRLE(String in)  {
        int nbite=0;
        if (in == null || in.length() == 0) {
            nbite+=1;
            return "";
        }

        StringBuilder sortie = new StringBuilder();

        for (int i = 0; i < in.length(); i += 2) {
            nbite+=1;
            int nbRep = Character.getNumericValue(in.charAt(i));
            char charPrecedent = in.charAt(i + 1);

            for (int j = 0; j < nbRep; j++) {
                nbite+=1;
                sortie.append(charPrecedent);
            }
        }
        System.out.println(nbite);
        return sortie.toString();
    }

    public static String unRLE(String in, int iteration) {
        int nbite=0;
        if (iteration <= 0 || in == null || in.length() == 0) {
            nbite+=1;
            return in;
        }

        String sortie = in;
        for (int i = 0; i < iteration; i++){
            nbite+=1;
            sortie = unRLE(sortie);
        }
        System.out.println(nbite);
        return sortie;
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


