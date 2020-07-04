package com.company;
import java.util.Scanner;
import  java.util.ArrayList;


enum SUITE { // Enum to represent the suits of deck
    SPADES,
    HEART,
    CLUB,
    DIAMONDS
}

public class Main {

    public static void main(String[] args) {
        Deck deck = new Deck();  // Deck of cards
        Scanner scanner=new Scanner(System.in); //For taking input from the User
        boolean gameStarted=false; //Value that specified whether game started or not.
        ArrayList<Player> Players=new ArrayList<>(); //List of players in the game

        System.out.println("Enter 1 to Add player(s) to the game."+"\n" +
                            "Enter 2 to Remove player(s) to the game."+"\n"+
                            "Enter 3 to Shuffle the deck"+"\n"+
                            "Enter 4 to Print all the cards present in the deck."+"\n"+
                            "Enter 5 to  Start the game"+"\n"+
                            "Enter 6 to Print the card each player is holding."+"\n"+
                            "Enter 7 to Find the winner of the game."+"\n"+
                            "Enter 8 to give specified number of cards to specific player."+"\n"+
                            "Enter 9 to finish the game by returning all cards back to the dec."+"\n");

        System.out.println("Enter one of the value from above options:");
        int inputValue=scanner.nextInt();  //To store the value given by user
        while (true){
                switch (inputValue) {
                    case 1:  //Adding the players one or more
                        System.out.println("Enter the no of Players to be added to the game");
                        int noOfPlayers = scanner.nextInt();  //No of players to be added.
                        while (noOfPlayers != 0) {
                            if (deck.cardDeck.size() != 0) {
                                Player player = new Player();Players.add(player);  // Adding the players to be game
                                if(gameStarted)
                                deck.getCards(player, 1); //If new player added in the middle of the game(After game started) i am giving him/her one card from deck if there are any.
                                noOfPlayers--;
                            }
                            else
                                System.out.println("Cannot add the players to the game as there are no cards available in the deck");
                        }
                        System.out.println("Players add successfully to the game");
                        break;

                    case 2: //Removing the players one or more
                        System.out.println("No of Players in the game are "+Players.size());
                        System.out.println("Enter the no of Players to be removed from the game");
                        int noOfPlayersRem = scanner.nextInt();  //No of players to be removed.
                        if( noOfPlayersRem<=Players.size())
                        while (noOfPlayersRem != 0 )  {
                            System.out.println("Enter the Player Number to Remove in the range 1 to " + Players.size() + ": ");
                            int playerNo = scanner.nextInt();
                            try {
                                deck.addCards(Players.get(playerNo - 1).hand);   //Adding  cards back to deck belonging to the player to be removed.
                                Players.remove(playerNo - 1);  // Remove the player from the game
                            }
                            catch (Exception E) {
                                System.out.println("Please enter the Player Number to Remove in the range 1 to " + Players.size()+".    Or Please check whether players are present in the game or not.");
                            }
                            noOfPlayersRem--;
                        }
                        else
                        System.out.println("Specified number of players are not present in the game to remove.");
                        break;

                    case 3:
                        deck.shuffleDeck(); //Shuffling the deck
                        System.out.println("Cards in Deck after shuffling is\n" + deck); //The cards in deck after shuffling.
                        break;

                    case 4:
                        deck.printCardsInDeck(); //Printing all the cards present in the deck.
                        break;

                    case 5: //Starting the game
                        System.out.println("Game Started with " + Players.size() + " players and each player got one card.");
                        if(!gameStarted) {
                            gameStarted = true;
                            for (Player player : Players) //Starting the game.
                                deck.getCards(player, 1);   // Each player gets one card from the Deck when game started
                        }
                        else
                            System.out.println("Game already started cannot restart in the middle.");
                            break;

                    case 6:
                        if(gameStarted)
                        for (Player player1 : Players)
                            System.out.println(player1.getHand());          //For getting the cards each player is holding
                        else
                            System.out.println("Please start the game to get cards each player is holding.");
                        break;

                    case 7: //Winner of the game
                        int gameWinner =deck.winnerofGame(Players); //Player with low value on the card and in the priority order of the suite given int he question is winner.
                        System.out.println("The winner of the game is player number: "+gameWinner);
                        break;

                    case 8: // To get more than one cards from deck and give to the specifc player.
                        System.out.println("Enter the number of cards to get from deck: ");
                        int noOfCards=scanner.nextInt();
                        System.out.println("Enter the player number to give cards to him/her in the range 1 to "+Players.size());
                        int playerNO=scanner.nextInt();
                        try {
                            deck.getCards(Players.get(playerNO-1), noOfCards);
                        }
                        catch (Exception E){
                            System.out.println("Please Enter the player number to give cards to him/her in the range 1 to "+Players.size());
                        }
                        break;

                    case 9:  //End the Game
                        if(gameStarted)
                        for (int t = 0; t < Players.size(); t++)
                            deck.addCards(Players.get(t).hand);  //Returning the cards back to deck after finishing the game.
                        else
                            System.out.println("Cannot end the game before starting the game.Please start the game");
                        System.out.println("The Game ended successfully and all the cards returned to the deck.");
                        break;

                    case 10: //Testing purpose
                        System.out.println("No of Players in Game are: "+ Players.size());
                        System.out.println("NO of Cards remaining in the deck: "+deck.cardDeck.size());
                        break;

                    default:
                        System.out.println("Enter the number in the given options Range 1 to 8.");
                        break;
                }
                    if(inputValue==9)
                        break;
                     System.out.println("Enter one of the value from above options:");
                    inputValue=scanner.nextInt();
        }
    }
}

