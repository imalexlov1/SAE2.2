//45efficacite.java

public class Main {
    public static String RLE(String in) {
        int nbite=0;
        if (in.isEmpty()) {
            nbite+=1;
            return "";
        }

        StringBuilder out = new StringBuilder();
        int i = 0;

        while (i < in.length()) {
            nbite+=1;
            char c = in.charAt(i);
            int count = 1;
            i++;

            while (i < in.length() && in.charAt(i) == c && count < 9) {
                nbite+=1;
                count++;
                i++;
            }

            if (count >= 9) {
                nbite+=1;
                out.append("9").append(c);
            } else {
                nbite+=1;
                out.append(count).append(c);
            }
        }
        System.out.println(nbite);
        return out.toString();
    }


    public static String RLE(String in, int iterations) {
        int nbite=0;
        String result = in;

        for (int iter = 0; iter < iterations; iter++) {
            nbite+=1;
            StringBuilder out = new StringBuilder();
            int i = 0;

            while (i < result.length()) {
                nbite+=1;
                char c = result.charAt(i);
                int count = 1;
                i++;

                while (i < result.length() && result.charAt(i) == c && count < 9) {
                    nbite+=1;
                    count++;
                    i++;
                }

                if (count >= 9) {
                    nbite+=1;
                    out.append("9").append(c);
                } else {
                    nbite+=1;
                    out.append(count).append(c);
                }
            }

            result = out.toString();
        }
        System.out.println(nbite);
        return result;
    }


    public static String unRLE(String in) {
        int nbite=0;
        if (in.isEmpty()) {
            nbite+=1;
            return "";
        }

        StringBuilder out = new StringBuilder();
        int i = 0;

        while (i < in.length()) {
            nbite+=1;
            int count = Character.getNumericValue(in.charAt(i));
            char c = in.charAt(i + 1);
            i += 2;

            for (int j = 0; j < count; j++) {
                nbite+=1;
                out.append(c);
            }
        }
        System.out.println(nbite);
        return out.toString();
    }


    public static String unRLE(String in, int iterations) {
        int nbite=0;
        String result = in;

        for (int iter = 0; iter < iterations; iter++) {
            nbite+=1;
            StringBuilder out = new StringBuilder();
            int i = 0;

            while (i < result.length()) {
                nbite+=1;
                int count = Character.getNumericValue(result.charAt(i));
                char c = result.charAt(i + 1);
                i += 2;

                for (int j = 0; j < count; j++) {
                    nbite+=1;
                    out.append(c);
                }
            }

            result = out.toString();
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


