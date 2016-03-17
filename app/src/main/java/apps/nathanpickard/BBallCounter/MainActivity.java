package apps.nathanpickard.BBallCounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mTeamOneEditText;
    private EditText mTeamTwoEditText;
    private Button mStartButton;
    private Button mSkipButton;

    //Tracks the score for Team A
    int scoreTeamA = 0;
    //Tracks the score for Team B
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_entry);

        mTeamOneEditText = (EditText) findViewById(R.id.teamOneEditText);
        mTeamTwoEditText = (EditText) findViewById(R.id.teamTwoEditText);
        mStartButton = (Button) findViewById(R.id.startButton);
        mSkipButton = (Button) findViewById(R.id.skipButton);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String teamOneName = mTeamOneEditText.getText().toString();
                String teamTwoName = mTeamTwoEditText.getText().toString();
                startGame(teamOneName, teamTwoName);
            }
        });

        mSkipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String teamOneName = "Team 1";
                String teamTwoName = "Team 2";
                startGame(teamOneName, teamTwoName);
            }
        });
    }

    private void startGame(String teamOneName, String teamTwoName) {
        Intent intent = new Intent(this, ScoreBoardActivity.class);
        intent.putExtra(getString(R.string.key_name_one), teamOneName);
        intent.putExtra(getString(R.string.key_name_two), teamTwoName);
        startActivity(intent);
    }



    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Increase the score of Team A by 3 points
    public void addThreeForTeamA(View v) {
        scoreTeamA = scoreTeamA + 3;
        displayForTeamA(scoreTeamA);
    }

    //Increase the score of Team A by 2 points
    public void addTwoForTeamA(View v) {
        scoreTeamA = scoreTeamA + 2;
        displayForTeamA(scoreTeamA);
    }

    //Increase the score of Team A by 1 point
    public void addOneForTeamA(View v) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    //Increase the score for Team B by 1 point
    public void addOneForTeamB(View v) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }

    //Increase the score for Team B by 2 points
    public void addTwoForTeamB(View v) {
        scoreTeamB = scoreTeamB + 2;
        displayForTeamB(scoreTeamB);
    }

    //Increase the score for Team B by 3 points
    public void addThreeForTeamB(View v) {
        scoreTeamB = scoreTeamB + 3;
        displayForTeamB(scoreTeamB);
    }

    public void resetScore(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));

        // Message informing the user that they have passed the 100 point
        // mark and are eligible for a free medium fries.
        if (scoreTeamA == 100 || scoreTeamA == 101 || scoreTeamA == 102) {
            Toast.makeText(this, "Pick up your free medium fries at McDonalds!",
                    Toast.LENGTH_SHORT).show();
            return;
        }
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));

        // Message informing the user that they have passed the 100 point
        // mark and are eligible for a free medium fries.
        if (scoreTeamA == 100 || scoreTeamA == 101 || scoreTeamA == 102) {
            Toast.makeText(this, "Pick up your free medium fries at McDonalds!",
                    Toast.LENGTH_SHORT).show();
            return;
        }
    }
}
