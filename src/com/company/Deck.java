package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {  //Class for representing the deck
    ArrayList<Card> cardDeck;  // Deck is represented as a ArrayList of cards
    public Deck() {
        cardDeck = new ArrayList<>();
        for(int value = 1 ; value <= 13 ; value++){
            for(SUITE suite : SUITE.values()){
                cardDeck.add(new Card(value,suite));
            }
        }
    }
    
    public String toString() { //Overriden method of Object class
        return cardDeck+"";
    }

    public void shuffleDeck(){ //Method for shuffling the cards in efficently. (O(n)->n=No of cards in deck).This method shuffles the card with equal probability of all possible shuffles of decek

        Random random = new Random();
        for (int i = cardDeck.size()-1; i > 0; i--) {
            int j = random.nextInt(i+1);
            Collections.swap(cardDeck,i,j);
        }
    }

    public void  getCards(Player player,int noOfCards){ //For getting the one or more than cards from a deck for a given player.
        Card removedCard;
        if(noOfCards<cardDeck.size()) //Checking whether there are sufficent cards in the deck.
        for(int t=0;t<noOfCards;t++) {
            removedCard = cardDeck.remove(0);
            player.getHand().add(removedCard);
        }
        else
            System.out.println("Specified number of cards are not present in the deck.");
    }

    public void addCards(ArrayList<Card> Cards){ // Method for returning the cards back to deck.
        cardDeck.addAll(Cards);
    }

    public void  printCardsInDeck(){ // Printing the cards in deck.
        System.out.println(cardDeck);
    }

    public int winnerofGame(ArrayList<Player> Players){ //Method for deceding the winner of game.
        int minCardValue =  Players.get(0).getRecentCardinHand().getValue();
        SUITE minCardSuite= Players.get(0).getRecentCardinHand().getSuite();
        int cardValue;
        SUITE cardSuite;
        int winner=0;
        try{
            for (int t=1;t<Players.size();t++) {
                cardValue = Players.get(t).getRecentCardinHand().getValue();
                cardSuite =  Players.get(t).getRecentCardinHand().getSuite();
                    if (cardValue<minCardValue && cardSuite!=minCardSuite) {
                        winner = t;
                        minCardValue=cardValue;
                    minCardSuite=cardSuite;
                    }
                    if(cardValue==minCardValue && cardSuite!=minCardSuite)
                        if(cardSuite.ordinal()<minCardSuite.ordinal()){
                            winner=t;
                            minCardValue=cardValue;
                            minCardSuite=cardSuite;
                        }
            }
        }

        catch (Exception E){
            System.out.println("One of the player does not have any cards");
            return -1;
        }
        return winner+1;
    }
}