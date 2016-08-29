package com.gibbson.root.garbage;

	public class TriNode
	{

		

		/**
		 * Linkes Kind
		 */
		protected TriNode left;
		
		/**
		 * Rechtes Kind
		 */
		protected TriNode right;
		
		/**
		 * Mittleres Kind
		 */
		protected TriNode middle;
		
		/**
		 * Elternelement
		 */
		protected TriNode parent;
		
		/**
		 * Wert des Knotens, hier: String, der Wort enth�lt
		 */
		protected Integer value1;
		protected Integer value2;

		/**
		 * Konstruktor
		 * @param value Zu speichernder Wert
		 */
		public TriNode(Integer value1, Integer value2)
		{
			this.value1 = value1;
			this.value2 = value2;
		}


		public TriNode getLeft() 
		{
			return left;
		}

		public void setLeft(TriNode left) 
		{
			this.left = left;
		}

		public TriNode getRight() 
		{
			return right;
		}

		public void setRight(TriNode right) 
		{
			this.right = right;
		}
		
		public TriNode getMiddle() {
			return middle;
		}


		public void setMiddle(TriNode middle) {
			this.middle = middle;
		}

		public TriNode getParent() 
		{
			return parent;
		}

		public void setParent(TriNode parent) 
		{
			this.parent = parent;
		}

		public Integer getInteger1() 
		{
			return value1;
		}
		
		public Integer getInteger2() 
		{
			return value2;
		}
	}


