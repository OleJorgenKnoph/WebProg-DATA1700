package oslomet.webprog;

class Node {
     int data;

     Node neste;

    public Node(int data){
        this.data = data;
    }
}

public class MinListe {
    private Node hode = null;
    private Node hale = null;

        public void leggTil(int verdi){
             Node nyNode = new Node(verdi);

                if (hode == null){
                    hode = nyNode;
                }
                    else {
                        hale.neste = nyNode;
                }

             hale = nyNode;
                hale.neste = hode;
        }

        public boolean inneholderNode(int sokeVerdi){
            Node denneNoden  = hode;

                if (hode == null){
                    return false;
                }
                    else {
                        do {
                            if (denneNoden.data == sokeVerdi){
                                return true;
                            }
                                denneNoden = denneNoden.neste;
                        } while (denneNoden != null);
                }
        return false;
        }

        public void slettVerdi(int slettVerdi){
            Node forrigeNode = null;

            //Fungerer både på sletting av siste og første verdi
            if (hode != null && hode.data == slettVerdi){
                hode = hode.neste;
                return;
            }

            while (hode != null && hode.data != slettVerdi){
                forrigeNode = hode;
                hode = hode.neste;
            }

            forrigeNode.neste = hode.neste;


        }
            //FORELESNING ØVING. Funker ikke på sletting av første og siste
            /*if (!inneholderNode(slettVerdi)) return;

                   if (hode == null) return;

            do {


                if (hode.data == slettVerdi){
                    forrigeNode.neste = hode.neste;
                    hode.neste = null;
                    break;
                }
                forrigeNode = hode;
                hode.neste = null;
            }while (hode != null);*/


        public void skrivUt(){
            Node denneNoden = hode;

                if (hode != null){
                    do {
                        System.out.print(denneNoden.data + " ");
                            denneNoden = denneNoden.neste;
                    } while (denneNoden != hode);
                }
        }
}
