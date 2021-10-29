package com.example.selfietictactoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
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

                Toast.makeText(getApplicationContext(), "Novo jogo", Toast.LENGTH_SHORT).show();

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
        }
        else
            mat[x][y]=2;
            b.setText("O");
            player = 1;
            winner = player2;


    }


}