package android.games;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Main extends AppCompatActivity {

    private SharedPreferences pref;
    private SharedPreferences.Editor editer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void dosomething(View view) {
        Intent i = new Intent();
        if (view.getId() == R.id.start) {
            i.setClassName("android.games", "android.games.start");
            startActivity(i);
        }
        if (view.getId() == R.id.instructions) {
            i.setClassName("android.games", "android.games.instructions");
            startActivity(i);
        }
        if (view.getId() == R.id.exit) {
            finish();
        }
    }
}
