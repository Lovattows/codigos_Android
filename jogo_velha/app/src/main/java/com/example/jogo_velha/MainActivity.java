package com.example.jogo_velha;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String CROSS = "X", CIRCLE = "O", lastPlayed = "X";
    RadioGroup gameMode;
    RadioButton twoPlayer, onePlayer;
    View view;
    TextView playerTurn;
    int count = 0;
    int state = 0;
    int[][] winCondition = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {1, 4, 7}, {2, 5, 8}, {3, 6, 9}, {1, 5, 9}, {3, 5, 7}};

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public String getLastPlayed() {
        return lastPlayed;
    }

    public void setLastPlayed(String lastPlayed) {
        this.lastPlayed = lastPlayed;
    }

    public Button getSquare(int tag) {
        String SQUARE = "square";
        return (Button) getView().findViewWithTag(SQUARE + tag);
    }

    @SuppressLint("InflateParams")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView(getLayoutInflater().inflate(R.layout.activity_main, null));
        setContentView(getView());
        playerTurn = findViewById(R.id.playerTurn);
        if (savedInstanceState != null) {
            state = savedInstanceState.getInt("X");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle toSave) {
        toSave.putInt("X", state);
        super.onSaveInstanceState(toSave);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @SuppressLint("SetTextI18n")
    public void start(View v) {
        gameMode = findViewById(R.id.gameMode);
        twoPlayer = findViewById(R.id.two_player);
        onePlayer = findViewById(R.id.one_player);

        if (gameMode.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getView().getContext(), "Selecione um modo de jogo", Toast.LENGTH_SHORT).show();
        } else {
            if (twoPlayer.isChecked()) {
                count = 0;
                playerTurn.setText("JOGADOR 1");
                findViewById(R.id.row_one).setVisibility(View.VISIBLE);
                findViewById(R.id.row_two).setVisibility(View.VISIBLE);
                findViewById(R.id.row_three).setVisibility(View.VISIBLE);
                setLastPlayed(CIRCLE);
                for (int i = 1; i <= 9; i++) {
                    if (getSquare(i) != null) {
                        getSquare(i).setText("");
                    }
                }
            } else if (onePlayer.isChecked()) {
                Toast.makeText(getView().getContext(), "Modo de jogo não habilitado", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @SuppressLint("SetTextI18n")
    public void click(View v) {
        if (!end()) {
            if (((Button) v).getText().equals("")) {
                count++;
                if (getLastPlayed().equals(CROSS)) {
                    ((Button) v).setText(CIRCLE);
                    playerTurn.setText("JOGADOR 1");
                    setLastPlayed(CIRCLE);
                } else {
                    ((Button) v).setText(CROSS);
                    playerTurn.setText("JOGADOR 2");
                    setLastPlayed(CROSS);
                }
            } else {
                Toast.makeText(getView().getContext(), "Posição já ocupada", Toast.LENGTH_SHORT).show();
            }
            end();
        }
    }

    @SuppressLint("SetTextI18n")
    public boolean end() {
        for (int i = 0; i <= 7; i++) {
            String w1 = getSquare(winCondition[i][0]).getText().toString();
            String w2 = getSquare(winCondition[i][1]).getText().toString();
            String w3 = getSquare(winCondition[i][2]).getText().toString();
            if ((!w1.equals("")) && (!w2.equals("")) && (!w3.equals(""))) {
                if (w1.equals(w2) && (w2.equals(w3))) {
                    if (w1.equals("O")) {
                        Toast toast = Toast.makeText(getView().getContext(), "Jogador 2 ganhou", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.END, 0, 750);
                        toast.show();
                    } else {
                        Toast.makeText(getView().getContext(), "Jogador 1 ganhou", Toast.LENGTH_SHORT).show();
                    }
                    playerTurn.setText("Jogo Finalizado");
                    return true;
                }
            }
        }
        if (count == 9) {
            Toast.makeText(getView().getContext(), "Empate", Toast.LENGTH_SHORT).show();
            count = 0;
        }
        return false;
    }
}