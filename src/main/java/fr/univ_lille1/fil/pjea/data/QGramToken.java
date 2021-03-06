package fr.univ_lille1.fil.pjea.data;

import java.util.List;

import org.antlr.v4.runtime.Token;

import fr.univ_lille1.fil.pjea.TokenUtils;

public class QGramToken extends QGram<Token> {
	private static final long serialVersionUID = 1L;
	
	
	
	QGramToken(List<Token> toks, int pos, int computedHashCode) {
		super(toks, pos, computedHashCode);
	}
	
	public int needlemanWunschAlignment(QGramToken q, int d) {
		return needlemanWunschAlignment(q, d, TokenUtils::tokenSimilarity);
	}
	
	public int levenshteinDistance(QGramToken qGramCompared) {
		return levenshteinDistance(qGramCompared, TokenUtils::equalsTokens);
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "[" + Integer.toHexString(hashCode()) + ":"
				+ String.join(",", this.stream().map(Token::getText).toArray(s -> new String[s])) + "]";
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof QGram))
			return false;
		if (hashCode() != obj.hashCode())
			return false;
		QGramToken other = (QGramToken) obj;
		if (size() != other.size())
			return false;
		for (int i = 0; i < size(); i++) {
			if (!TokenUtils.equalsTokens(get(i), other.get(i)))
				return false;
		}
		return true;
	}
	
}
