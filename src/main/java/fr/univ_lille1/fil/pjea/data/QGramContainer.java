package fr.univ_lille1.fil.pjea.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.ToIntFunction;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;

import fr.univ_lille1.fil.pjea.data.builder.RabinHashCodeBuilder;



/**
 * Classe {@link Iterable} qui permet de parcourir les léxèmes du {@link Lexer}
 * passé en paramètre.<br/>
 * Cette classe a été créé pour répondre aux questions 10 et 11 du TP <i>Lexémisation</i>.
 */
public class QGramContainer<T> extends ArrayList<QGram<T>> {
	private static final long serialVersionUID = 1L;
	
	
	public final int step;
	public final int qGramSize;
	
	
	
	/**
	 * Contruit un {@link Iterable} qui parcours la liste des léxèmes du {@link QGram}
	 * passé en paramètre de stp à stp éléments. Chaque itération retourne un QGram de
	 * buffSize {@link Token}.<br/>
	 * Par exemple :
	 * <pre>new TokenReader(lexer, 1, 1).iterator()</pre> retournera à chaque
	 * iteration les éléments 0, 1, 2, ...<br/>
	 * <pre>new TokenReader(lexer, 1, 5).iterator()</pre> retournera à chaque
	 * iteration les éléments {0, ..., 4}, {1, ..., 5}, {2, ..., 6}, ...<br/>
	 * <pre>new TokenReader(lexer, 5, 5).iterator()</pre> retournera à chaque
	 * iteration les éléments {0, ..., 4}, {5, ..., 9}, {10, ..., 14}, ...<br/>
	 *
	 * @param tokens le {@link QGram} depuis lequel on récupère tous les léxèmes
	 * @param stp le pas de déplacement du buffer dans la liste des léxèmes, après chaque itération
	 * @param buffSize la taille du buffer, c'est à dire le nombre d'élément retourné à
	 * chaque itération.
	 */
	public QGramContainer(List<T> tokens, int step, int qGramSize, ToIntFunction<T> hashcodeFunction) {
		this.step = step;
		this.qGramSize = qGramSize;
		
		
		
		/**
		 * Contruction de la liste des QGrams
		 */
		int currentPos = 0;
		RabinHashCodeBuilder hashCodeBuilder = new RabinHashCodeBuilder(256, qGramSize);
		while (currentPos <= tokens.size() - qGramSize) {
			List<T> returnedTokens = tokens.subList(currentPos,
					Math.min(tokens.size(), currentPos + qGramSize));
			
			hashCodeBuilder.putHashCode(returnedTokens.stream()
					.skip(Math.max(qGramSize - step, 0)) // retain only last Token that are not present in the previous QGram
					.mapToInt(hashcodeFunction).toArray());
			
			int qGramPos = currentPos;
			currentPos += step;
			
			super.add(newQGram(returnedTokens, qGramPos, hashCodeBuilder.getCurrentHashCode()));
		}
		
		
		
		
	}
	
	
	
	/**
	 * Équivaut à
	 * <pre>new TokenReader(file, qGramSize, qGramSize)</pre>
	 * @param file
	 * @param qGramSize
	 */
	public QGramContainer(List<T> tokens, int qGramSize, ToIntFunction<T> hashcodeFunction) {
		this(tokens, qGramSize, qGramSize, hashcodeFunction);
	}
	
	/**
	 * Équivaut à
	 * <pre>new TokenReader(file, 1, 1)</pre>
	 * @param file
	 */
	public QGramContainer(List<T> tokens, ToIntFunction<T> hashcodeFunction) {
		this(tokens, 1, 1, hashcodeFunction);
	}
	
	
	
	
	
	
	protected QGram<T> newQGram(List<T> toks, int pos, int computedHashcode) {
		return new QGram<>(toks, pos, computedHashcode);
	}
	
	
	
	
	
	
	/*
	 * All methods that throws UnsupportedOperationException
	 */
	@Override
	public void add(int index, QGram<T> element) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean add(QGram<T> e) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean addAll(Collection<? extends QGram<T>> c) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean addAll(int index, Collection<? extends QGram<T>> c) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void clear() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public QGram<T> remove(int index) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public QGram<T> set(int index, QGram<T> element) {
		throw new UnsupportedOperationException();
	}
	// ---------------------------------
	
	
	
}
