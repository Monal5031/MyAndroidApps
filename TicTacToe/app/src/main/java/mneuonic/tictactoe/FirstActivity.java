package mneuonic.tictactoe;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import junit.framework.Test;

import org.w3c.dom.Text;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener{

    int boardstatus[][]=new int[3][3];
    int counter;
    TextView Texter;
    Button M00,M01,M02,M10,M11,M12,M20,M21,M22;
    Button Reset;
    String PLAYER_X="X";
    String PLAYER_O="O";
    String tmp;
    int itmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Intent i=getIntent();

        PLAYER_X=i.getStringExtra("PLAYER_1");
        PLAYER_O=i.getStringExtra("PLAYER_2");

        M00 = (Button) findViewById(R.id.M00);
        M01 = (Button) findViewById(R.id.M01);
        M02 = (Button) findViewById(R.id.M02);

        M10 = (Button) findViewById(R.id.M10);
        M11 = (Button) findViewById(R.id.M11);
        M12 = (Button) findViewById(R.id.M12);

        M20 = (Button) findViewById(R.id.M20);
        M21 = (Button) findViewById(R.id.M21);
        M22 = (Button) findViewById(R.id.M22);

        Reset = (Button) findViewById(R.id.Reset);

        Texter= (TextView) findViewById(R.id.Texter);

        M00.setOnClickListener(this);
        M01.setOnClickListener(this);
        M02.setOnClickListener(this);

        M10.setOnClickListener(this);
        M11.setOnClickListener(this);
        M12.setOnClickListener(this);

        M20.setOnClickListener(this);
        M21.setOnClickListener(this);
        M22.setOnClickListener(this);

        Reset.setOnClickListener(this);

        initializeBoard();
    }

    public void checkWinner(){
        //Horizontal
        for(int i=0;i<3;i++){
            if( (boardstatus[i][0]==boardstatus[i][1])&&(boardstatus[i][1]==boardstatus[i][2])){
                if(boardstatus[i][0]==1)
                    result(PLAYER_X+" Wins");
                else if(boardstatus[i][0]==0)
                    result(PLAYER_O+" Wins");
            }
        }
        //Vertical
        for(int i=0;i<3;i++){
            if((boardstatus[0][i]==boardstatus[1][i])&&(boardstatus[1][i]==boardstatus[2][i])){
                if(boardstatus[0][i]==1)
                    result(PLAYER_X+" Wins");
                else if(boardstatus[0][i]==0)
                    result(PLAYER_O+" Wins");
            }
        }
        //Diagonal
            if( ( (boardstatus[0][0]==boardstatus[1][1]) && (boardstatus[2][2]==boardstatus[1][1]) ) || ( (boardstatus[0][2]==boardstatus[1][1]) && (boardstatus[2][0])==boardstatus[1][1])){
                if(boardstatus[1][1]==1)
                    result(PLAYER_X+" Wins");
                else if(boardstatus[1][1]==0)
                    result(PLAYER_O+" Wins");
            }

    }

    public void initializeBoard(){
        counter=0;
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                    boardstatus[i][j] = -1;
    }

    public void setInfo(String s){

        Texter.setText(s);
    }

    public void enableButtons(boolean value){

        M00.setEnabled(value);
        M01.setEnabled(value);
        M02.setEnabled(value);

        M10.setEnabled(value);
        M11.setEnabled(value);
        M11.setEnabled(value);

        M20.setEnabled(value);
        M21.setEnabled(value);
        M22.setEnabled(value);
    }

    public void resetButtonPress(){
        initializeBoard();
        setInfo("Start Again");
        enableButtons(true);

        Toast.makeText(FirstActivity.this,"Play Again",Toast.LENGTH_SHORT).show();

        M00.setText("");
        M01.setText("");
        M02.setText("");

        M10.setText("");
        M11.setText("");
        M12.setText("");

        M20.setText("");
        M21.setText("");
        M22.setText("");
        setInfo("Start Again");
    }

    public void result(String s){
        setInfo(s);
        enableButtons(false);
    }

    public void onClick(View view){
        int id=view.getId();

        if(counter%2==0)
        {
            tmp="O";
            itmp=0;
        }
        else
        {
            tmp="X";
            itmp=1;
        }
        switch(id){
            case R.id.M00:
                boardstatus[0][0]=itmp;
                M00.setEnabled(false);
                M00.setText(tmp);
                break;
            case R.id.M01:
                boardstatus[0][1]=itmp;
                M01.setEnabled(false);
                M01.setText(tmp);
                break;
            case R.id.M02:
                boardstatus[0][2]=itmp;
                M02.setEnabled(false);
                M02.setText(tmp);
                break;
            case R.id.M10:
                boardstatus[1][0]=itmp;
                M10.setEnabled(false);
                M10.setText(tmp);
                break;
            case R.id.M11:
                boardstatus[1][1]=itmp;
                M11.setEnabled(false);
                M11.setText(tmp);
                break;
            case R.id.M12:
                boardstatus[1][2]=itmp;
                M12.setEnabled(false);
                M12.setText(tmp);
                break;
            case R.id.M20:
                boardstatus[2][0]=itmp;
                M20.setEnabled(false);
                M20.setText(tmp);
                break;
            case R.id.M21:
                boardstatus[2][1]=itmp;
                M21.setEnabled(false);
                M21.setText(tmp);
                break;
            case R.id.M22:
                boardstatus[2][2]=itmp;
                M22.setEnabled(false);
                M22.setText(tmp);
                break;
            case R.id.Reset:
                resetButtonPress();
                break;
        }
        counter++;

            if (counter % 2 == 0){
                setInfo(PLAYER_O + " turn");
            }

            else{
                setInfo(PLAYER_X + " turn");
            }
            if(counter==9)
                result("DRAW");
            checkWinner();

    }



}
