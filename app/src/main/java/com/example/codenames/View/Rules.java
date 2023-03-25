package com.example.codenames.View;


import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.codenames.R;

public class Rules extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String rulesContent =

                "<h1>INTRODUCTION</h1>" +
                        "<p>Codenames is a game for two teams. There is a grid of 25 words. Some of them are secretly assigned to the Red Team, some to the Blue Team. One player from each team is the Spymaster, and only Spymasters see which words belong to which team. Spymasters take turns giving clues to their teammates (Operatives), trying to lead them to guessing their team's words. The team that guesses all their words first wins the game.</p>"+
                        "<h1>DIVING IN TEAMS</h1>"+
                        "<ul>" +
                        "<li>Divide all players into two teams, <font color=\"red\">red</font> and <font color=\"blue\">blue</font>.</li>" +
                        "<li>One player from each team should click on the red or blue button that says “Spymaster.”</li>" +
                        "<li>Everyone else should click on the red or blue button that says “Operative.” They do not see the colors of the cards.”</li>" +
                        "</ul>" +
                        "<h1>GIVING CLUES</h1>"+
                        "<p>Spymasters give clues. When it’s your turn to give a clue, tap some words in your color that you want to give a clue for. Then type in a one-word clue that relates to all the selected words. Your Operatives will only see the clue and the number of marked cards.\n" +
                        "When you give a clue, your Operatives only see the word and the number.</p>"+
                        "<p>Watch out for the black card, it’s an Assassin! Avoid clues that would lead to the assassin or to the other team's words.</p>"+
                        "<p>Note: Some clues are not allowed, for example, using any form of any word on the board. </p>"+
                        "<h1>VALID CLUES</h1>"+
                        "<p>The clue is strictly limited to one word and one number. The Spymaster is expected to keep a straight face, and he shouldn't comment on players’ guesses to avoid giving up any unwanted information.</p>"+
                        "<p>Your clue is supposed to be a single word, but Spymasters can agree on more flexible rules. For example, you can agree to allow two-word place names, like NEW YORK." +
                        "Don't use any form of a word in the grid as a clue. Don't type in SUGAR as a clue for SUGAR and CHOCOLATE, and don't try to get around this rule using clues like SUGARY or SUGARCANE.</p>"+
                        "<p>Give clues in the language you have agreed on. Don't use foreign words to give extra information.</p>"+
                        "<p>The clue needs to relate to the meaning of the words. Don't give clues about the letters in the word or its position in the grid.</p>"+
                        "<p>Keep your clues in the spirit of the game, and if you aren't sure, ask the opposing Spymaster (using some chat channel that the other players can't hear or see).</p>"+
                        "<h1>GUESSING</h1>"+
                        "<p>Operatives guess the words based on the Spymaster’s clue.</p>"+
                        "<p>Tap the word card. The game will then reveal the color of the chosen word.</p>"+
                        "<p>If you guess a word of your team's color, you may guess again. You'll want to guess as many words as your Spymaster indicates.</p>"+
                        "<p>Note: You can also guess unsolved clues from previous turns.</p>"+
                        "<h1>NUMBER OF GUESSES</h1>"+
                        "<p>The number in your clue is supposed to tell your team how many words relate to that clue.</p>"+
                        "<p>They can always guess one extra word, usually an unguessable word from previous turns.</p>"+
                        "<p>If you need your Operatives to guess more extra words, you can manually select Infinity. They can guess any number of words then (but they don't know how many words your current clue relates to).</p>"+ "<p></p>"+
                        "<p>You can also use Zero 0 for your clue. It also allows operatives to guess as many words as they want. The difference is that you are telling your teammates that your clue has nothing to do with words of your color. You may use it, for example, to prevent them from guessing the Assassin or the opponent's word.</p>"+
                        "<p>No matter what type of clue you use, your team always needs to try at least one guess.</p>"+
                        "<h1>END OF TURN</h1>"+
                        "<p>Your turn can end in one of three ways:</p>"+
                        "<ul>" +
                        "<li>Guessing a word of the opponent's color or neutral color.</li>"+
                        "<li>Ending guessing manually by clicking the button.</li>"+
                        "<li>Reaching the maximum number of guesses (clue number + 1).</li>"+
                        "</ul>" +
                        "<h1>WINNING AND LOSING</h1>"+
                        "<p>Teams alternate turns. A team wins once all their words have been guessed. They lose if they guess the Assassin!</p>";

        setContentView(R.layout.activity_rules);
        TextView textViewRules = findViewById(R.id.textViewRules);
        textViewRules.setText(android.text.Html.fromHtml(rulesContent));
        textViewRules.setMovementMethod(new ScrollingMovementMethod());
    }
}