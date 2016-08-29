package com.gibbson.root.garbage;

public abstract class TriTree<Key,Value> 
{

		/**
		 * Wurzel des Baums (Startknoten)
		 */
		protected TriNode root;
		
		/**
		 * Wurzel auslesen
		 * @return
		 */
		public TriNode getRoot() 
		{
			return root;
		}

		/** 
		 * Methode zum Vergleich zweier Elemente f�r die innere Ordnung des Baums
		 * @param needle Erstes Element
		 * @param type Zweites Element
		 * @return <0, wenn a<b | >0, wenn a>b | 0, wenn a=b
		 */
		
		/**
		 * Neues Element hinzuf�gen
		 * @param elem Hinzuzuf�gendes Element
		 */
		public void add(int value) 
		{
			if (root == null) 						// Fall 1: Baum ist leer
			{
				TriNode neu = new TriNode(value, -1);
				root = neu;
				return;
			}
			TriNode neu = new TriNode(value, -1);
			TriNode node = root;			// Fall 2: Baum ist nicht leer
			while (true) 
			{
				if(node.getInteger2() == -1) //Value 2 noch leer
				{
					if (value > node.getInteger1())
					{
						node.value2 = value;
				}
				else if (value < node.getInteger1()) 	// Neue Zahl kleiner naechster Node links
				{
					if (node.getLeft() == null) 
					{
						node.setLeft(neu);
						neu.setParent(node);
					}
					node = node.getLeft();
				}
				else 							// gleich (nicht nochmal einf�gen)
					return;
				}
				
				//falls erster Node voll:
			if(value < node.getInteger1()) //Zahl kleiner als Value 1 schaue links weiter
			{
				if(node.getLeft()== null){
					node.setLeft(neu);
					neu.setParent(node);
				}
				node = node.getLeft();
			}
			else if (value>node.getInteger2()) //groesser als 2.Wert schaue rechts
			{
				if (node.getRight() == null)
				{
					node.setRight(neu);
					neu.setParent(node);
					return;
				}
				node = node.getRight();
			}
			else if (value > node.getInteger1()&&value < node.getInteger2()) // Zahl leigt zw. 1 und 2
			{
				if(node.getMiddle()== null){
					node.setMiddle(neu);
					neu.setParent(node);
					return;
				}
				node = node.getMiddle();
			}
			else
				return; //gleich (nicht nochmal einfügen
			}
		}
		

		/**
		 * Element im Baum finden (startet bei Root-Node)
		 * @param needle Zu suchendes Element
		 * @return Knoten des Elements
		 */
		public TriNode find(int needle) 
		{
			return find(root, needle);
		}
		
		/**
		 * Element in Teilbaum finden (startet bei current-Node)
		 * @param current Startknoten
		 * @param needle  Zu suchendes Element
		 * @return Knoten des Elements
		 */
		public TriNode find(TriNode current, int needle) 
		{
			if (current == null) 
			{
				return null; //nicht gefunden
			}
			if (needle == current.getInteger1() || needle == current.getInteger2()){
				return current;
			}
			else if (needle < current.getInteger1())
			{						//Linkds da kleiner als Zahl 1
				return find(current.getLeft(), needle);
			}
			else if (needle > current.getInteger2())
			{					// Rechts da groesser als Zahl 2
				return find(current.getRight(), needle);
			}
			else
			{					// Mitte da zwischen Zahl 1 und 2
				return find(current.getMiddle(), needle);
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
		public void printTree(TriNode current, String prefix) 
		{
			if (current == null) 
			{
				return;
			}
			System.out.println(prefix + current.getInteger2() + current.getInteger1());
			printTree(current.getLeft(), prefix + " L ");
			printTree(current.getMiddle(), prefix + "M ");
			printTree(current.getRight(), prefix + " R ");
		}

	}
