package com.campus02.ald.datastructures;

	public class Node<Key,Value> 
	{

		/**
		 * Linkes Kind
		 */
		protected Node<Key,Value> left;
		
		/**
		 * Rechtes Kind
		 */
		protected Node<Key,Value> right;
		
		/**
		 * Elternelement
		 */
		protected Node<Key,Value> parent;
		
		/**
		 * Wert des Knotens, hier: String, der Wort enth�lt
		 */
		protected final Value value;
		protected final Key key;

		/**
		 * Konstruktor
		 * @param value Zu speichernder Wert
		 */
		public Node(Key key, Value value) 
		{
			this.value = value;
			this.key = key;
		}


		public Node<Key,Value> getLeft() 
		{
			return left;
		}

		public void setLeft(Node<Key,Value> left) 
		{
			this.left = left;
		}

		public Node<Key,Value> getRight() 
		{
			return right;
		}

		public void setRight(Node<Key,Value> right) 
		{
			this.right = right;
		}

		public Node<Key,Value> getParent() 
		{
			return parent;
		}

		public void setParent(Node<Key,Value> parent) 
		{
			this.parent = parent;
		}

		public Value getValue() 
		{
			return value;
		}
		
		public Key getKey() 
		{
			return key;
		}
	}


