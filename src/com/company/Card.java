package com.company;

class Card {   //Class for representing the Card
        int value;  //It represents the value on the card.
        SUITE suite; //It represents the suite to which card belongs.

        public Card(int value, SUITE suite) {
            this.value = value;
            this.suite = suite;
        }

        public int getValue() {
            return value;
        }

        public SUITE getSuite() {
            return suite;
        }

        public String toString() {
            return "The Card belongs to suite: "+ suite + " and value: " + value;
        }
}

