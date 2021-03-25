package oslomet.webprog;

public class Stakk {
    private static class Node{
        private int verdi;
        private Node neste;

        public Node(int verdi){
            this.verdi = verdi;
        }
    }

    private Node topp;

        public Stakk(){
            this.topp = null;

        }

    public void push(int verdi){
            Node node = new Node(verdi);

            node.neste = topp;
                topp = node;
    }

    public boolean tom(){
            return topp == null;
    }

    public int peek(){
            if (!tom()){
                return topp.verdi;
            }
                else {
                    System.out.println("Stacken er tom");
                        return -1;
            }
    }

    public void pop(){
            if (topp == null){
                System.out.println("Stack underflow");
                    return;
            }

                topp = topp.neste;
        }

    public void printOut(){
            if (topp == null){
                System.out.println("Stack underflow");
                    System.exit(69);
            }
                else {
                    Node node = topp;
                        while (node != null){
                            System.out.print(node.verdi + " ");
                                node = node.neste;
                        }
            }
    }
}
