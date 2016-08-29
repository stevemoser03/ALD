package com.gibbson.root.garbage;
//package com.campus02.ald.routefinder;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//
//public class Demo {
//
//	public static void main(String[] args) {
//		
//		BaseTree<Integer,String> ctree = new BaseTree<Integer,String>() {
//			@Override
//			protected int compareKey(Integer a, Integer b) {
//				if (a<b)
//					return -1;
//				if (a>b)
//					return 1;
//				else 
//					return 0;}
//			protected int compareValue(String a, String b) {
//				// TODO Auto-generated method stub
//				return a.compareTo(b);}};
//		BaseTree<String, Integer> stree = new BaseTree<String, Integer>() {
//			@Override
//			protected int compareKey(String a, String b) {
//				return a.compareTo(b);}
//			@Override
//			protected int compareValue(Integer a, Integer b) {
//				if (a<b)
//					return -1;
//				if (a>b)
//					return 1;
//				else 
//					return 0;}};
//		
//		try (BufferedReader br = new BufferedReader(new FileReader(new File ("E:\\Java\\temp.txt")));)
//			{
//			String line;
//			Integer counter = 0;
//			while ((line=br.readLine())!=null)
//			{
//				String[]array=line.split(";");
//				String node = array[0];
//				if (ctree.find(node) == null){
//				counter++;}
//				ctree.add(counter,node);
//				stree.add(node, counter);
//			}
//			} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//
//}
