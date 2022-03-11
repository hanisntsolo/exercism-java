import java.util.HashMap;

public class Blackjack {
    public static HashMap<String, Integer> cardDeck = new HashMap<>();
    public void createDeck() {
        cardDeck.put("ace", 11);
        cardDeck.put("two", 2);
        cardDeck.put("three", 3);
        cardDeck.put("four", 4);
        cardDeck.put("five", 5);
        cardDeck.put("six", 6);
        cardDeck.put("seven", 7);
        cardDeck.put("eight", 8);
        cardDeck.put("nine", 9);
        cardDeck.put("ten", 10);
        cardDeck.put("jack", 10);
        cardDeck.put("queen", 10);
        cardDeck.put("king", 10);
        cardDeck.put("other", 0);
    }
    public int parseCard(String card) {
        return cardDeck.get(card);
    }

    public boolean isBlackjack(String card1, String card2) {
       return cardDeck.get(card1) + cardDeck.get(card2) == 21;
    }

    public String largeHand(boolean isBlackjack, int dealerScore) {
        if(isBlackjack && (dealerScore  < 10) )
            return "W";
        return "S";
    }

    public String smallHand(int handScore, int dealerScore) {
        if(handScore >= 17) {
            // stand
            return "S";
        } else if (handScore <= 11) {
            // hit
            return "H";
        } else if((handScore > 11) && (handScore < 17) && dealerScore < 7) {
            // stand
            return "S";
        } else {
            // hit
            return "H";
        }
    }

    // FirstTurn returns the semi-optimal decision for the first turn, given the cards of the player and the dealer.
    // This function is already implemented and does not need to be edited. It pulls the other functions together in a
    // complete decision tree for the first turn.
    public String firstTurn(String card1, String card2, String dealerCard) {
        createDeck();
        int handScore = parseCard(card1) + parseCard(card2);
        int dealerScore = parseCard(dealerCard);

        if (20 < handScore) {
            return largeHand(isBlackjack(card1, card2), dealerScore);
        } else {
            return smallHand(handScore, dealerScore);
        }
    }
}
