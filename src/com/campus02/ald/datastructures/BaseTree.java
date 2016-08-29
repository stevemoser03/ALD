package com.campus02.ald.datastructures;

public abstract class BaseTree<Key,Value> 
{

		/**
		 * Wurzel des Baums (Startknoten)
		 */
		protected Node<Key,Value> root;
		
		/**
		 * Wurzel auslesen
		 * @return
		 */
		public Node<Key,Value> getRoot() 
		{
			return root;
		}

		/** 
		 * Methode zum Vergleich zweier Elemente f�r die innere Ordnung des Baums
		 * @param needle Erstes Element
		 * @param type Zweites Element
		 * @return <0, wenn a<b | >0, wenn a>b | 0, wenn a=b
		 */
		protected abstract int compareKey(Key a, Key b);
		protected abstract int compareValue(Value a, Value b);

		
		/**
		 * Neues Element hinzuf�gen
		 * @param elem Hinzuzuf�gendes Element
		 */
		public void add(Key key,Value value) 
		{
			Node<Key,Value> neu = new Node<Key,Value>(key, value);
			if (root == null) 						// Fall 1: Baum ist leer
			{
				root = neu;
				return;
			}
			Node<Key,Value> node = root;			// Fall 2: Baum ist nicht leer
			while (true) 
			{
				int vgl = compareValue(value,node.getValue());
				if (vgl < 0) {						// kleiner
					if (node.getLeft() == null) 
					{
						node.setLeft(neu);
						neu.setParent(node);
						return;
					}
					node = node.getLeft();
				}
				else if (vgl > 0) 					// gr��er
				{
					if (node.getRight() == null) 
					{
						node.setRight(neu);
						neu.setParent(node);
						return;
					}
					node = node.getRight();
				}
				else 
				{								// gleich (nicht nochmal einf�gen)
					return;
				}
			}
		}
		

		/**
		 * Element im Baum finden (startet bei Root-Node)
		 * @param needle Zu suchendes Element
		 * @return Knoten des Elements
		 */
		public Node<Key,Value> find(Value needle) 
		{
			return find(root, needle);
		}
		
		/**
		 * Element in Teilbaum finden (startet bei current-Node)
		 * @param current Startknoten
		 * @param needle  Zu suchendes Element
		 * @return Knoten des Elements
		 */
		public Node<Key,Value> find(Node<Key,Value> current, Value needle) 
		{
			if (current == null) 
			{
				return null;
			}
			int vgl = compareValue(needle, current.getValue());
			if (vgl == 0) 
			{					// Gefunden
				return current;
			}
			else if (vgl < 0) 
			{					// Links
				return find(current.getLeft(), needle);
			}
			else 
			{					// Rechts
				return find(current.getRight(), needle);
			}
		}
	

		/**
		 * Funktion zur Ausgabe des gesamten Baums.
		 */
		public void printTree() 
		{
			printTree(root, "");
		}
		
		/**
		 * Funktion zur Ausgabe des Baums unterhalb eines Knotens
		 * @param current Knoten, dessen Teilbaum ausgegeben werden soll
		 * @param prefix  Zur Einr�ckung
		 */
		public void printTree(Node<Key,Value> current, String prefix) 
		{
			if (current == null) 
			{
				return;
			}
			System.out.println(prefix + current.getValue() + current.getKey());
			printTree(current.getLeft(), prefix + " L ");
			printTree(current.getRight(), prefix + " R ");
		}

		protected int compare(Integer a, Integer b) 
		{
			// TODO Auto-generated method stub
			return 0;
		}

	}
