package io.github.picoledelimao.mdl.core;

public class Pair<T, V> {

	public T first;
	public V second;
	
	public Pair(T first, V second) {
		this.first = first;
		this.second = second;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(getClass().equals(obj.getClass())))
			return false;
		Pair other = (Pair) obj;
		return first.equals(other.first) && second.equals(other.second);
	}
	
	@Override
	public String toString() {
		return "[" + first + ", " + second + "]";
	}
	
}
