package main.pokeroddscalculator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Cards {	
	
	public static class TwoCard {
		CardRank cr1;
		CardRank cr2;
		
		public TwoCard(CardRank cr1,  CardRank cr2) {
			this.cr1 = cr1;
			this.cr2 = cr2;
		}
	
		
		public CardRank getCardRank1() {
			return cr1;
		}
		
		public CardRank getCardRank2() {
			return cr2;
		}
	}
	
	public static String determineWinner(List<CardRank> cards, List<CardRank> cards2,  int numberOfPlayers) {
		Map<String,TwoCard> map = new HashMap<String,TwoCard>();
		for(int i=1;i<= numberOfPlayers;i++) {
			map.put("Player:"+i, new TwoCard(cards.get(i-1), cards2.get(i-1)));			
		}
		
		String winner = "None";
		int max=0;
		for(String s : map.keySet()) {
			int cr1 = map.get(s).getCardRank1().getCardValue();
			int cr2 =  map.get(s).getCardRank2().getCardValue();
			int totalValue = cr1 + cr2;
			if( totalValue > max) {
				winner = s;
				max = totalValue;
			}
			 
		}
		
		return winner;
	}

	public enum CardRank {
		ACE(14) , KING(13) , QUEEN (12) , JACK(11) , TEN(10) , NINE(9), EIGHT(8) ,SEVEN(7), SIX(6),
		FIVE(5), FOUR(4), THREE(3), TWO(2), ONE(1) ;
		
		private int cardValue ;
		private CardRank(int i) {
			this.cardValue = i;
		}
		public int getCardValue() {
			return this.cardValue;
		}
	}
}
