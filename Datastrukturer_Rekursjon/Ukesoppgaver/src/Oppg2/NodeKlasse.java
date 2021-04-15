package Oppg2;

class Node {
    int data;
    Node neste;

    public Node(int data) {
        this.data = data;
    }
}

public class NodeKlasse {

    private Node hode = null;
    private Node hale = null;

    public void leggTilNode(int verdi){

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

    public boolean inneholderNode (int sokeVerdi){
        Node denneNoden = hode;

        if (hode == null){
            return false;
        }
        else {
            do {
                if (denneNoden.data == sokeVerdi){
                    return true;
                }
                denneNoden = denneNoden.neste;
            } while (denneNoden != hode);
        }
        return false;
    }

    public void slettNode(int slettVerdi) {
        Node denneNoden = hode;

        if (hode != null){
            do {
                if (denneNoden.data == slettVerdi){

                }
            }while (denneNoden != hode);
        }
    }

    public void skrivUt(){
        Node denneNoden = hode;

        if (hode != null){
            do {
                System.out.print(denneNoden.data + " ");
                    denneNoden = denneNoden.neste;
            }
                while (denneNoden != hode);
                System.out.println();
        }
    }
}
