package com.company;
import java.util.ArrayList;

public class Player { //  Class for representing the player
    ArrayList<Card> hand; // Arraylist that represents the cards each player is holding.

    public Player() {
        hand = new ArrayList<>();
    }

    public ArrayList<Card> getHand() { //Method to return the cards player is holding
            return hand;
    }

    public  Card getRecentCardinHand(){ //Method that returns the recent card that player got.
        return hand.get(hand.size()-1);
    }

    public String toString() {
            return "Player{" +
                    "hand=" + hand +
                    '}';
    }
}

