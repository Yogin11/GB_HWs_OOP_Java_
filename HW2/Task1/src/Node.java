public class Node {

    Human p1;
    Relat re;
    Human p2;

    public Node(Human p1, Relat re, Human p2) {
        this.p1 = p1;
        this.re = re;
        this.p2 = p2;
    }

    @Override
    public String toString() {
        return String.format("<<%s > - %s  для  <%s>>", p1, re, p2);
    }

}
