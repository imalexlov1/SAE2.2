//package iut.sae.algo;

public class simplicite{
    public static String RLE(String in){
        int numero_finChaine = in.length();
        String resultat_compression = "";
            for (int i = 0; i < numero_finChaine; i++){
                char lettre = in.charAt(i);
                int compteur = 1;
                while (i + 1 < numero_finChaine && in.charAt(i + 1) == lettre){
                    i++;
                    compteur++;
                }
                if (compteur > 9){
                    resultat_compression = resultat_compression + "9" + lettre + (compteur - 9) + lettre;
                } else {
                    resultat_compression = resultat_compression + compteur + "" + lettre;
                }
            }
            return resultat_compression;
    }

    public static String RLE(String in, int iteration) throws AlgoException{
        if (iteration == 1){
            return RLE(in);
        } else {
            return RLE(RLE(in, iteration - 1));
        }
    }

    public static String unRLE(String in) throws AlgoException{
        int numero_finChaine = in.length();
        String resultat_compression = "";
        for (int i = 0; i < numero_finChaine; i++){
            char lettre = in.charAt(i);
            if (Character.isDigit(lettre)){
                int cpt = Character.getNumericValue(lettre);
                lettre = in.charAt(i + 1);
                for (int j = 0; j < cpt; j++){
                    resultat_compression = resultat_compression + lettre;
                }
                i++;
            } else {
                resultat_compression = resultat_compression + lettre;
            }
        }
        return resultat_compression;
    }

    public static String unRLE(String in, int iteration) throws AlgoException{
        if (iteration == 1){
            return unRLE(in);
        } else {
            return unRLE(unRLE(in, iteration - 1));
        }
    }
}

