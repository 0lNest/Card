// Programmer: Oleksandr Nesterov

// Class: CS &145 Face-to-face

// Date: 3/10/2023

// Lab: 2

// Reference Materials: 7.16 to 7.21 - page 285

// Purpose: Card Shuffling and Dealing Program

// Card class represents a playing card with a suit and rank.
public class Card {
    enum Suit {
        HEARTS, DIAMONDS, CLUBS, SPADES
    }

    enum Rank {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }

    private Suit suit;
    private Rank rank;

    // Constructor to create a card with a specific suit and rank.
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    // Getter for the suit of the card.
    public Suit getSuit() {
        return suit;
    }

    // Getter for the rank of the card.
    public Rank getRank() {
        return rank;
    }

    // Override toString method to display the card's rank and suit.
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

// CardManager class manages the deck of cards, including shuffling and dealing.
import java.util.ArrayList;
import java.util.Collections;

public class CardManager {
    private ArrayList<Card> deck;

    // Constructor to initialize the deck with 52 cards.
    public CardManager() {
        deck = new ArrayList<>();
        initializeDeck();
    }

    // Initialize the deck by adding all 52 cards.
    private void initializeDeck() {
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
    }

    // Shuffle the deck by randomly reordering the cards.
    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    // Deal a card from the deck, removing and returning the top card.
    public Card dealCard() {
        if (deck.isEmpty()) {
            return null; // No more cards to deal
        }
        return deck.remove(0);
    }
}

// Test class demonstrates the card shuffling and dealing program.
public class Test {
    public static void main(String[] args) {
        CardManager cardManager = new CardManager();

        // Shuffle the deck
        cardManager.shuffleDeck();

        // Deal and display a few cards
        for (int i = 0; i < 5; i++) {
            Card card = cardManager.dealCard();
            if (card != null) {
                System.out.println("Dealt: " + card);
            } else {
                System.out.println("No more cards to deal.");
            }
        }
    }
}