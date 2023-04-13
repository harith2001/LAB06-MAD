package com.example.scorekeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //find the TextViews by ID
        mScoreText1 = (TextView) findViewByID(R.id.score_1);
        mScoreText2 = (TextView) findViewByID(R.id.score_2);

        static final String STATE_SCORE_1 = "Team 1 Score";
        static final String STATE_SCORE_2 = "Team 2 score"

        if (savedInstanceState != null) {
            mScore1 = savedInstanceState.getInt(STATE_SCORE_1);
            mScore2 = savedInstanceState.getInt(STATE_SCORE_2);

            mScoreText1.setText(String.valueOf(mScore1));
            mScoreText2.setText(String.valueOf(mScore2));
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {

        outState.putInt(STATE_SCORE_1,mScore1);
        outState.putInt(STATE_SCORE_2,mScore2);
        super.onSaveInstanceState(outState)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        int nightMode =  AppCompactDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        }else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.getItemId()==R.id.night_mode){
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if(nightMode == AppCompactDelegate.MODE_NIGHT_YES){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();
        }
        return true;
    }
//member variable for holding the score.
    private int mScore1;
    private int mScore2;

    //member variables for holding the score
    private TextView mScoreText1;
    private TextView mScoreText2;

    //onClick - decreaseScore
    public void decreaseScore(View view){
        int viewID = view.getId();
        switch(viewID){
            case R.id.decreaseTeam1:
                    mScore1 --;
                    mScoreText1.setText(String.valueOf(mScore1));
            break;
            case R.id.decreaseTeam2:
                    mScore2--;
                    mScoreText2.setText(String.valueOf(mScore2));
        }
    }

    //onClick - increaseScore

    public void increaseScore(View view){
        int viewID = view.getId();
        switch(ViewID){
            case R.id.increaseTeam1:
            mScore1++;
            mScoreText1.setText(String.valueOf(mScore1));
            break;
            case R.id.increaseTeam2:
                    mScore2++;
            mScoreText2.setText(String.valueOf(mScore2));
        }
    }

}