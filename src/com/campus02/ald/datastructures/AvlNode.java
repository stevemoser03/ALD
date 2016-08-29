package com.campus02.ald.datastructures;

public class AvlNode<Key,Value>  {
	 protected AvlNode<Key,Value>  left;
	 protected AvlNode<Key,Value>  right;
	 protected AvlNode<Key,Value>  parent;
	 protected final Key key;
	 protected final Value value;
	 protected int balance;
	 

	 public AvlNode(Key k,Value v) {
	  left = right = parent = null;
	  balance = 0;
	  key = k;
	  value = v;
	  
	 }
	 public String toString() {
	  return "" + key;
	 }
	public Key getKey() {
		return key;
	}
	public Value getValue() {
		return value;
	}
	public AvlNode<Key, Value> getLeft() {
		return left;
	}
	public void setLeft(AvlNode<Key, Value> left) {
		this.left = left;
	}
	public AvlNode<Key, Value> getRight() {
		return right;
	}
	public void setRight(AvlNode<Key, Value> right) {
		this.right = right;
	}
	public AvlNode<Key, Value> getParent() {
		return parent;
	}
	public void setParent(AvlNode<Key, Value> parent) {
		this.parent = parent;
	}


	}