package fr.univ_lille1.fil.pjea.builder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.Lexer;
import org.javatuples.Pair;

import fr.univ_lille1.fil.pjea.qgrams.QGram;
import fr.univ_lille1.fil.pjea.qgrams.TokenReader;


public class WinnowingFootprintBuilder {

	/**
	 * 
	 */
	private int t; 
	private int q;
	
	private Lexer lexer;
	
	public WinnowingFootprintBuilder(Lexer lexer, int q, int t) {
		this.lexer = lexer;
		this.q = q;
		this.t = t;
	}

	
	public List<Pair<Integer, Integer>> build() throws Exception {
		
		List<Pair<Integer, Integer>> footprint; 
		
		/* Construction des listes de tokens hashé */ 
		
		List<Integer> hashQgrams = new TokenReader(lexer, 0, t).getAllQGrams().stream().map(QGram::hashCode).collect(Collectors.toList());
		int w = t - q + 1;
		
		Pair<Integer, Integer> curMin;
		
		Map<Integer, Integer> listMin = new HashMap<>();
		
	
		for (int i = 0; i < w; i++) {
			curMin = minFrame(i, q, hashQgrams, listMin);
			if (curMin != null) {
				listMin.put(curMin.getValue0(), curMin.getValue1());
			}
		}
		
		footprint = listMin.entrySet().stream().map((e) -> new Pair<>(e.getKey(), e.getValue())).collect(Collectors.toList());
		footprint.sort((p1, p2) -> Integer.compare(p1.getValue0(), p2.getValue0()));
		return footprint;
	}
	
	/**
	 * 	
	 * @param i
	 * @param n
	 * @param list
	 * @return Retourne une paire composé d'une position et de la valeur du minimum
	 */
	private static Pair<Integer, Integer> minFrame(int i, int nFrame, List<Integer> list, Map<Integer, Integer> listMin) {
		int len = list.size();
		if (i >= len || i + nFrame > len) return null;

		
		int elm, min = list.get(i), pos = i;
		
		for (int j = i + 1; j < i + nFrame; j++) {
			elm = list.get(j);
			
				if (min > elm) {
					min = elm; 
					pos = j; 
				} else if (min == elm && !listMin.containsKey(j)) {
					pos = j;
				}	
		}
		
		return !listMin.containsKey(pos) ? new Pair<>(pos, min) : null;
	}
	
}