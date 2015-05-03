package com.opendoorlogistics.studio.components.map;

import gnu.trove.set.hash.TLongHashSet;

/**
 * Thread-safe class storing the selection state
 * @author Phil
 *
 */
public class MapSelectionState {
	private final TLongHashSet selectedGlobalRowIds = new TLongHashSet();
	
	public synchronized long [] copyIds(){
		return selectedGlobalRowIds.toArray();
	}
	
	public synchronized TLongHashSet copySet(){
		return new TLongHashSet(selectedGlobalRowIds);
	}
	
	public synchronized void clear(){
		set(null);
	}
	
	public synchronized void add(long id){
		selectedGlobalRowIds.add(id);
	}
	
	public synchronized void set(long [] ids){
		selectedGlobalRowIds.clear();
		if(ids!=null){
			selectedGlobalRowIds.addAll(ids);			
		}
	}
	
	public synchronized boolean contains(long id){
		return selectedGlobalRowIds.contains(id);
	}
	
	public synchronized boolean equals(TLongHashSet set){
		return selectedGlobalRowIds.equals(set);
	}
}
