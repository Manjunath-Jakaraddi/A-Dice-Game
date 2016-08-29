package android.games;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class start extends AppCompatActivity {
        int local=0;
        int uscore=0,cscore=0;
        Boolean userTurn=true;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_start);
        }

        public void click(View v) {
                final TextView changeu=(TextView)findViewById(R.id.uscore);
                final TextView changec=(TextView)findViewById(R.id.cscore);
                final TextView tpts=(TextView)findViewById(R.id.tpts);
                if (v.getId() == R.id.start) {
                        ImageView img = (ImageView) findViewById(R.id.imageView);
                        Random n = new Random();
                        int random = n.nextInt(6) + 1;
                        local+=random;
                        if(uscore>=50){
                                changeu.setText("PLAYER 1 WINS");
                                userTurn=true;
                                local=0;
                                tpts.setText("Total points : "+local);
                                uscore=cscore=0;
                        }
                        else if(cscore>=50){
                                changec.setText("PLAYER 2 WINS");
                                userTurn=true;
                                local=0;
                                tpts.setText("Total points : "+local);
                                uscore=cscore=0;
                        }
                        tpts.setText("Total points : "+local);
                        switch (random) {
                                case 1:
                                        img.setImageResource(R.drawable.dice1);
                                        local=0;
                                        if(userTurn)
                                        {
                                                tpts.setText("Total points : "+local);
                                                uscore=0;
                                                changeu.setText("USER 1 SCORE : 0");
                                        }
                                        else {
                                                tpts.setText("Total points : "+local);
                                                cscore=0;
                                                changec.setText("USER 2 SCORE : 0");
                                        }
                                        userTurn=!userTurn;
                                        break;
                                case 2:
                                        img.setImageResource(R.drawable.dice2);
                                        break;
                                case 3:
                                        img.setImageResource(R.drawable.dice3);
                                        break;
                                case 4:
                                        img.setImageResource(R.drawable.dice4);
                                        break;
                                case 5:
                                        img.setImageResource(R.drawable.dice5);
                                        break;
                                case 6:
                                        img.setImageResource(R.drawable.dice6);
                                        break;

                        }
                }
                else if(v.getId()==R.id.hold)
                {
                        if(userTurn==true) {
                                uscore += local;
                                changeu.setText("USER 1 SCORE : " + uscore);
                        }
                        else {
                                cscore+=local;
                                changec.setText("USER 2 SCORE : " + cscore);
                        }
                        local=0;
                        userTurn=!userTurn;
                }
                else
                {
                        changec.setText("USER 2 SCORE : 0");
                        changeu.setText("USER 1 SCORE : 0");
                        userTurn=true;
                        local=0;
                        tpts.setText("Total points : "+local);
                        uscore=cscore=0;
                }
        }
}
