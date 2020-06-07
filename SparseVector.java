/**
 * @author Prénom Nom - Matricule
 * @author Prénom Nom - Matricule
 */

public class SparseVector {

    private Node head = null;
    private int length = 0;

    public class Node {
        public Object val;
        public int index;
        public Node next = null; // pointeur vers le prochain noeud

        public Node(Object val, int index) {
            this.val = val;
            this.index = index;
        }
    }


    public SparseVector() {
        this(10);
    }


    public SparseVector(int length) {
        this.length = length;
    }


    // Obtenir la valeur de l'élément à la position index
    public Object get(int index) {
        Node current = this.head;

        while (current != null) {
            
            // Retourne la valeur à l'index voulue
            if (current.index == index) {
                return current.val;
            }

            // Sinon, on regarde le prochain noeud
            current = current.next;
        }

        return null; // Si l'object n'est pas dans la liste chaînée, il est nul
    }


    // Ajouter ou mettre à jour l'élément à la position index
    public void set(int index, Object value) {

        Node current = this.head;

        while (current != null) {
            
            // Met à jour la valeur à l'index voulue
            if (current.index == index) {
                current.val = value;
                return;
            }

            // Sinon, on regarde le prochain noeud
            current = current.next;
        }

        // Ajoute l'élément si l'index n'a pas été trouvé
        Node tmp = head;
        head = new Node(value, index);
        head.next = tmp;
    }


    // Supprimer l'élément à la position index
    public void remove(int index) {

        // Enlève le premier noeud de la liste chaînée
        if (this.head != null && this.head.index == index) {
            this.head = this.head.next;
            return;
        }

        // Pointeurs vers le noeud actuel et le noeud précédent
        Node current = this.head == null ? null : this.head.next;
        Node previous = this.head;

        while (current != null) {

            // Enlève le noeud si c'est l'index qu'on cherche
            if (current.index == index) {
                previous.next = current.next;
                return;
            }

            // Sinon, on regarde le prochain noeud
            previous = current;
            current = current.next;
        }
    }


    // Longueur du vecteur creux
    public int length() {
        return this.length;
    }


    // Nombre d'éléments non nuls
    public int size() {
        Node current = this.head;
        int size = 0;

        while (current != null) {
            size++;
            current = current.next;
        }

        return size;
    }
}