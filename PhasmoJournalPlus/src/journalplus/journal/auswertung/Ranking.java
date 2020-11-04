package journalplus.journal.auswertung;

import java.util.ArrayList;
import java.util.List;

import journalplus.journal.Geist;

public class Ranking {
	private List<Geist> arrayGeist;
	private List<Double> arrayRanks;
	
	private List<Geist> arrayGeistSorted;
	
	public Ranking() {
		this.arrayGeist = new ArrayList<Geist>();
		this.arrayRanks = new ArrayList<Double>();
		this.arrayGeistSorted = new ArrayList<Geist>();
		
		for(int i = 0; i < Geist.values().length; i++) {
			this.arrayGeist.add(Geist.values()[i]);
			this.arrayRanks.add(new GeistEvaluator(Geist.values()[i]).get());
		}
		
		while(this.arrayGeist.size() > 0) {
			this.arrayGeistSorted.add(getNextGeistFinished(getNextGeist()));
		}
	}
	
	public Object[] get() {
		return arrayGeistSorted.toArray();
	}
	
	private int getNextGeist() {
		if(this.arrayGeist.size() == 0) {
			return -1;
		}
		int biggestIndex = 0;
		for(int i = 0; i < this.arrayGeist.size(); i++) {
			if(this.arrayRanks.get(i) >= this.arrayRanks.get(biggestIndex)) {
				biggestIndex = i;
			}
		}
		return biggestIndex;
	}
	private Geist getNextGeistFinished(int index) {
		this.arrayRanks.remove(index);
		return this.arrayGeist.remove(index);
	}
}
