package com.example;

import java.util.ArrayList;

public class JokesDatabase {

    private ArrayList<String> mJokesList = new ArrayList<>();
    private static final String joke1 = "What do you call a fish with no eye? Fsh";
    private static final String joke2 = "What did the koala bear say at the job interview? I have the necessary koala-fications";
    private static final String joke3 = "Why did everyone want to hangout with the mushroom? Because he was a fungi";
    private static final String joke4 = "How do you light up a soccer stadium? With a soccer match";
    private static final String joke5 = "Why did they put gates around the cemetery? Because people are dying to get in";
    private static final String joke6 = "What do you call a bear in the rain? Drizzly bear";
    private static final String joke7 = "Why are seagulls called seagulls? Because if they flew over the bay they'd be called bagels";
    private static final String joke8 = "When is the best time to go to the dentist? Two(th)-thurty";
    private static final String joke9 = "What did the doctor say to the midget? You'll just have to be a little patient";
    private static final String joke10 = "What do you call a fat computer? Adele";
    private static final String joke11 = "Where does a one-legged waitress work? Ihop";
    private static final String joke12 = "What did the worker at the rubber-band factory say when he lost his job? Oh snap";
    private static final String joke13 = "What's it called when you lend money to a bison? A buffaloan";
    private static final String joke14 = "What did the big bucket say to the little bucket? You look a little pale";
    private static final String joke15 = "What did the older chimney say to the younger chimney? You're too young to smoke";

    public JokesDatabase() {
        mJokesList.add(joke1);
        mJokesList.add(joke2);
        mJokesList.add(joke3);
        mJokesList.add(joke4);
        mJokesList.add(joke5);
        mJokesList.add(joke6);
        mJokesList.add(joke7);
        mJokesList.add(joke8);
        mJokesList.add(joke9);
        mJokesList.add(joke10);
        mJokesList.add(joke11);
        mJokesList.add(joke12);
        mJokesList.add(joke13);
        mJokesList.add(joke14);
        mJokesList.add(joke15);
    }

    public ArrayList<String> getJokes() {
        return mJokesList;
    }
    
    public void addJoke(String joke) {
        mJokesList.add(joke);
    }
}
