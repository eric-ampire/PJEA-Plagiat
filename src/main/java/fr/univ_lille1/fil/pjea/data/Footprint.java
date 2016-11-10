package fr.univ_lille1.fil.pjea.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.javatuples.Pair;

import fr.univ_lille1.fil.pjea.builder.WinnowingFootprintBuilder;

/**
 * Immutable {@link Footprint} generated by {@link WinnowingFootprintBuilder}.
 *
 */
public class Footprint extends ArrayList<Pair<Integer, Integer>> {
	private static final long serialVersionUID = 1L;

	public Footprint(List<Pair<Integer, Integer>> base) {
		super(base);
	}
	
	
	

	/*
	 * All methods that throws UnsupportedOperationException
	 */
	@Override
	public void add(int index, Pair<Integer, Integer> element) { throw new UnsupportedOperationException(); }
	@Override
	public boolean add(Pair<Integer, Integer> e) { throw new UnsupportedOperationException(); }
	@Override
	public boolean addAll(Collection<? extends Pair<Integer, Integer>> c) { throw new UnsupportedOperationException(); }
	@Override
	public boolean addAll(int index, Collection<? extends Pair<Integer, Integer>> c) { throw new UnsupportedOperationException(); }
	@Override
	public void clear() { throw new UnsupportedOperationException(); }
	@Override
	public Pair<Integer, Integer> remove(int index) { throw new UnsupportedOperationException(); }
	@Override
	public boolean remove(Object o) { throw new UnsupportedOperationException(); }
	@Override
	public boolean removeAll(Collection<?> c) { throw new UnsupportedOperationException(); }
	@Override
	public boolean retainAll(Collection<?> c) { throw new UnsupportedOperationException(); }
	@Override
	public Pair<Integer, Integer> set(int index, Pair<Integer, Integer> element) { throw new UnsupportedOperationException(); }
	// ---------------------------------
	
}
