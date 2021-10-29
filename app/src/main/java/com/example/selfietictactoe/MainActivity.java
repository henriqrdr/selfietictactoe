package com.example.selfietictactoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int qtd;
    private int player;
    private int mat[][] = new int[3][3];
    private Button b[] = new Button[9];
    private String winner;
    private String player1;
    private String player2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        qtd = 1;
        player = 1;
        b[0] = findViewById(R.id.button1);
        b[1] = findViewById(R.id.button2);
        b[2] = findViewById(R.id.button3);
        b[3] = findViewById(R.id.button4);
        b[4] = findViewById(R.id.button5);
        b[5] = findViewById(R.id.button6);
        b[6] = findViewById(R.id.button7);
        b[7] = findViewById(R.id.button8);
        b[8] = findViewById(R.id.button9);

        b[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                turn(b[0],0,0);

            }
        });
        b[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                turn(b[1],0,1);

            }
        });
        b[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                turn(b[1],0,2);

            }
        });
        b[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                turn(b[3],1,0);

            }
        });
        b[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                turn(b[4],1,1);

            }
        });
        b[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                turn(b[5],1,2);

            }
        });
        b[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                turn(b[6],2,0);

            }
        });
        b[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                turn(b[7],2,1);

            }
        });
        b[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                turn(b[8],2,2);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.mainmenu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.newItem:

                clean();

                final EditText  editText2 = new EditText(this);
                AlertDialog.Builder play2 = new AlertDialog.Builder(this);
                play2.setMessage("Name");
                play2.setTitle("Player 2");
                play2.setView(editText2);
                play2.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        player2 = editText2.getText().toString();
                    }
                });
                play2.create();
                play2.show();

                final EditText  editText1 = new EditText(this);
                AlertDialog.Builder play1 = new AlertDialog.Builder(this);
                play1.setMessage("Name");
                play1.setTitle("Player 1");
                play1.setView(editText1);
                play1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        player1 = editText1.getText().toString();
                    }
                });
                play1.create();
                play1.show();

                break;

        }
        return super.onOptionsItemSelected(item);
    }

    public void turn(Button b, int x, int y){
        b.setEnabled(true);
        if(player==1) {
            mat[x][y]= 1;
            b.setText("X");
            player = 2;
            winner = player1;
            winCheck(1);
        }
        else {
            mat[x][y] = 2;
            b.setText("O");
            player = 1;
            winner = player2;
            winCheck(2);
        }
        qtd++;

    }

    public boolean win(int x){

        for(int i=0;i<mat.length;i++){

            if(mat[i][0]==x && mat[i][1] ==x && mat[i][2] ==x)
                return true;
            if(mat[0][i]==x && mat[1][i] ==x && mat[2][1] ==x)
                return true;
            if(mat[0][0]==x && mat[1][1] ==x && mat[2][2] ==x)
                return true;
            if(mat[2][0]==x && mat[1][1] ==x && mat[0][2] ==x)
                return true;

        }
        return false;
    }

    public void winCheck(int x){
        if(win(x)==true){
            AlertDialog.Builder winAlert = new AlertDialog.Builder(this);
            winAlert.setTitle("WIN");
            winAlert.setMessage("Player"+ winner +"win!");
            winAlert.setIcon(android.R.drawable.star_on);
            winAlert.setPositiveButton("OK",null);
            winAlert.create();
            winAlert.show();
            endGame();
        }
    }

    public void endGame(){
        for(int i=0;i<9;i++){
            b[i].setEnabled(false);
        }
    }

    public void clean(){
        for(int i=0;i<9;i++){
            b[i].setEnabled(true);
            b[i].setText("");
        }
        for(int j=0;j<3;j++){
            for(int k=0;k<3;k++){
                mat[j][k]=0;
            }
        }

        player=0;
        player1="";
        player2="";
    }



}