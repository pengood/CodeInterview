package net.mindview.test;

import java.util.Arrays;

import net.mindview.util.Enums;
enum OutCome  {
	WIN,LOSE,DRAW
}

interface Competitor<T extends Competitor<T>>{
	OutCome compete(T competitor);
}
class RoShambo {
	public static <T extends Competitor<T>> void match(T a,T b){
		System.out.println(a+" vs "+b+": "+a.compete(b));
	}
	public static <T extends Enum<T>&Competitor<T>> void play(Class<T> rsClass,int size){
		for(int i=0;i<size;i++){
			match(Enums.random(rsClass),Enums.random(rsClass));
		}
	}
}
public enum RoShamboTest implements Competitor<RoShamboTest> {
	
	  PAPER(OutCome.DRAW, OutCome.LOSE, OutCome.WIN),
	  SCISSORS(OutCome.WIN, OutCome.DRAW, OutCome.LOSE),
	  ROCK(OutCome.LOSE, OutCome.WIN, OutCome.DRAW);
	private OutCome vPAPER,vSCISSORS,vROCK;
	 RoShamboTest(OutCome paper,OutCome scissors,OutCome rock) {
		// TODO Auto-generated constructor stub
		this.vPAPER=paper;
		this.vSCISSORS=scissors;
		this.vROCK=rock;
	}
	public OutCome compete(RoShamboTest competitor) {
		// TODO Auto-generated method stub
		switch (competitor) {
		default:
		case PAPER:
			return vPAPER;
		case SCISSORS:
			return vSCISSORS;
		case ROCK:
			return vROCK;
		}
	}
	
	public static void main(String[] args){
		RoShambo.play(RoShamboTest.class, 10);
		int[] a={12,12,5,12,5,1,6};
		System.out.print(Arrays.toString(a));
	}

}
