package com.example.sarveshj.cs1scarnedice;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    int useroverall=0,compoverall=0,usercurrent=0,compcurrent=0;
    TextView userScore;
    TextView turnScore;
    TextView compScore;
    ImageView imageView;

    int rolledNumber1;
    public void computerTurn(){
        rolledNumber1=0;
        compScore= (TextView)findViewById(R.id.compScore);
        while(rolledNumber1!=1) {
                    Random rn = new Random();

                    rolledNumber1 = rn.nextInt(6) + 1;

                    String currentString = "dice" + Integer.toString(rolledNumber1);
                    int id = getResources().getIdentifier(currentString, "drawable", MainActivity.this.getPackageName());
                    imageView.setImageResource(id);


            if (rolledNumber1 != 1) {
                        compcurrent = compcurrent + rolledNumber1;
                        turnScore.setText("Computer Turn Score:" + String.valueOf(compcurrent));

                    } else {
                        compoverall=compoverall+compcurrent;
                        turnScore.setText("Computer Turn Score:" + "0");
                        compScore.setText("Computer Score:" + String.valueOf(compoverall));
                        compcurrent = 0;
                    }
        }
        Toast.makeText(this,"Its your turn",Toast.LENGTH_SHORT).show();
    }


    public void onRoll(View view){
        userScore= (TextView)findViewById(R.id.userScore);
        turnScore=(TextView)findViewById(R.id.turnScore);
        imageView=(ImageView) findViewById(R.id.imageView);
        Random rn=new Random();

        int rolledNumber = rn.nextInt(6) + 1;

        String currentString = "dice" + Integer.toString(rolledNumber);
        int id = getResources().getIdentifier(currentString, "drawable", MainActivity.this.getPackageName());
        imageView.setImageResource(id);

        if(rolledNumber!=1)
        {
            usercurrent=usercurrent+rolledNumber;
            turnScore.setText("Your Turn Score:"+ String.valueOf(usercurrent));

        }
        else{
            turnScore.setText("Your Turn Score:"+ "0");
            userScore.setText("Your Score:"+ String.valueOf(useroverall));
            usercurrent=0;
            computerTurn();
        }
    }
    public void onHold(View view){
        userScore= (TextView)findViewById(R.id.userScore);
        turnScore=(TextView)findViewById(R.id.turnScore);
        useroverall=useroverall+usercurrent;
        turnScore.setText("Your Turn Score:"+ "0");
        userScore.setText("Your Score:"+ String.valueOf(useroverall));
        usercurrent=0;
        computerTurn();
    }

    public void onReset(View view){
        useroverall=0;
        usercurrent=0;
        turnScore.setText("Your Turn Score:"+ "0");
        userScore.setText("Your Score:"+ "0");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
