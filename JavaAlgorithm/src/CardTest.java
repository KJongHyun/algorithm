class CardTest {

    public static void main(String[] args) {
        Card card1 = new Card(6);
        Card card2 = new Card(1);
        Card card3 = new Card(2);
        Card card4 = new Card(3);

        System.out.println(Card.cnt);
    }

}

class Card {
    static int cnt;
    int data;
    Card(int data) {
        this.data = data;
        cnt++;
    }
}

