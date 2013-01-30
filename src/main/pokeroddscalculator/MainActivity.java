package main.pokeroddscalculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import main.pokeroddscalculator.Cards.CardRank;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;

public class MainActivity extends Activity {
	
	private List<CardRank> cards1;
	private List<CardRank> cards2;
	
	private Button player1;
	private Button player2;
	private Button player3;
	private Button player4;	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		cards1 = new ArrayList<CardRank>();
		for(CardRank c : CardRank.values()) {
			cards1.add(c);
		}
		
		cards2 = new ArrayList<CardRank>();
		for(CardRank c : CardRank.values()) {
			cards2.add(c);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public void shuffleCards(View view) {
		
		//Shuffle the cards.
		Collections.shuffle(cards1);	
		Collections.shuffle(cards2);
		
		player1 = (Button) findViewById(R.id.p1);
		player1.setText(cards1.get(0).toString() + " , " + cards2.get(0).toString());
		
		player2 = (Button) findViewById(R.id.p2);
		player2.setText(cards1.get(1).toString() + " , " + cards2.get(1).toString());
		
		player3 = (Button) findViewById(R.id.p3);
		player3.setText(cards1.get(2).toString() + " , " + cards2.get(1).toString());
		
		player4 = (Button) findViewById(R.id.p4);
		player4.setText(cards1.get(3).toString() + " , " + cards2.get(3).toString());		
	}
	
	public void computeWinner(View view) {
		
		String winner = Cards.determineWinner(cards1, cards2, 4);	
		Toast.makeText(this, winner , Toast.LENGTH_SHORT).show();			
	}

}
