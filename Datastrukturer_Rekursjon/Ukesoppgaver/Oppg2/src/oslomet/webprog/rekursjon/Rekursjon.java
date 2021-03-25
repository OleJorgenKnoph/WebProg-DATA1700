package oslomet.webprog.rekursjon;

public class Rekursjon {
    public static int fac(int tall){
            if (tall <0 ){
                return -1;
            }
                if (tall == 0){
                    return 1;
                }
                return tall * fac(tall-1);
    }

    public static int sum(int tall){
        if (tall <0 ){
            return -1;
        }
            if (tall == 0){
                return 1;
            }
                return tall + sum(tall-1);
    }

    public static int iterativSum(int tall){
        int sum = 0;

            for (int i = 0; i <= tall; ++i){
                sum +=i;
            }
        return sum;
    }



    public static void main(String[] args) {
        int[] listen = {2,4,5,6,7,9};
           System.out.println(binSok(listen, 2, 0, listen.length-1));
    }
    public static int binSok(int[] liste, int nokkel, int venstre, int hoyre){
        if (venstre <= hoyre){
            int split = (venstre+hoyre) / 2;

                if (liste[split] > nokkel){
                    return binSok(liste, nokkel, venstre, split-1);
                }
                    else if (liste[split] < nokkel){
                        return binSok(liste, nokkel, split+1, hoyre);
                }
                    else return split; //Funnet nokkel;
        }
        else return -1; //Bruker skrevet feil i main
    }

}
