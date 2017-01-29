package mneuonic.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstScreen extends AppCompatActivity {

    EditText etPlayer1;
    EditText etPlayer2;
    Button play;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);

        etPlayer1=(EditText) findViewById(R.id.etPlayer1);
        etPlayer2= (EditText) findViewById(R.id.etPlayer2);

        play= (Button) findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1=etPlayer1.getText().toString();
                String name2=etPlayer2.getText().toString();
                Intent i=new Intent(FirstScreen.this,FirstActivity.class);
                i.putExtra("PLAYER_1",name1);
                i.putExtra("PLAYER_2",name2);
                startActivity(i);
            }
        });


    }

}
