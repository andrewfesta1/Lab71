package edu.cscc;
import java.util.Random;

/**
 * This class allows the user to play the game Rock, Paper, Scissors, Lizard, Spock against the computer.
 * @author Andrew Festa
 */

public class RPSLSpock {

    static Random rand = new Random(System.currentTimeMillis());

    public static final String ROCK = "rock";
    public static final String PAPER = "paper";
    public static final String SCISSORS = "scissors";
    public static final String LIZARD = "lizard";
    public static final String SPOCK = "spock";

    /**
     * This method is called to return the user's choice or false if an invalid choice is entered.
     * @param pick = user's choice of rock, paper, scissors, lizard or spock (taken from Scanner in Main.java).
     * @return the user's choice, unless left empty or the user enters an invalid pick, then return false.
     */

    public static boolean isValidPick(String pick) {
        if (pick == null) {
            return false;
        }
        pick = pick.trim();
        return (ROCK.equalsIgnoreCase(pick) ||
                PAPER.equalsIgnoreCase(pick) ||
                SCISSORS.equalsIgnoreCase(pick) ||
                LIZARD.equalsIgnoreCase(pick) ||
                SPOCK.equalsIgnoreCase(pick));
    }

    /**
     * This method generates the computer's choice by using Random.
     * @return pick = the computer's choice of rock, paper, scissors, lizard or spock.
     */
    public static String generatePick() {
        String pick = null;
        switch (rand.nextInt(5)) {
            case 0:
                pick = ROCK;
                break;
            case 1:
                pick = PAPER;
                break;
            case 2:
                pick = SCISSORS;
                break;
            case 3:
                pick = LIZARD;
                break;
            case 4:
                pick = SPOCK;
                break;
        }
        return pick;
    }

    /**
     * This method determines in what situation the computer will win.
     * Rock beats Scissors and Lizard,
     * Paper beats Rock and Spock,
     * Scissors beats Paper and Lizard,
     * Lizard beats Paper and Spock,
     * Spock beats Rock and Scissors.
     * @param c_pick = the computer's choice from the generatePick() method.
     * @param h_pick = the user's valid choice entered into Scanner in Main.java.
     * @return the various situations in which the computer wins.
     */
    public static boolean isComputerWin(String c_pick,String h_pick) {
        h_pick = h_pick.toLowerCase();
        return ((ROCK.equals(c_pick) && (SCISSORS.equals(h_pick) || LIZARD.equals(h_pick))) ||
                (PAPER.equals(c_pick) && (ROCK.equals(h_pick) || SPOCK.equals(h_pick))) ||
                (SCISSORS.equals(c_pick) && (PAPER.equals(h_pick) || LIZARD.equals(h_pick))) ||
                (LIZARD.equals(c_pick) && (PAPER.equals(h_pick) || SPOCK.equals(h_pick))) ||
                (SPOCK.equals(c_pick) && (ROCK.equals(h_pick) || SCISSORS.equals(h_pick))));
    }
}