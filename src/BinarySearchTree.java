/*
 * Data Structures and Algorithms.
 * Copyright (C) 2016 Rafael Guterres Jeffman
 *
 * See the LICENSE file accompanying this source code, for
 * licensing restrictions that might apply.
 *
 */

class BSTNode{

	private Pokemon value;
	private BSTNode left;
	private BSTNode right;
	
	
	
	public BSTNode(Pokemon value) {
		this.value = value;
	}
	
	public void insert(Pokemon value, int code) throws DuplicateKeyException {
		//int cmp = value.compareTo(this.value);
		if(code == 0){
			if (value.getPokedex() <= this.value.getPokedex())
				insertLeft(value, code);
			else if (value.getPokedex() > this.value.getPokedex())
				insertRight(value, code);
			else
				throw new DuplicateKeyException("Already inserted: "+value);
		}else if(code == 1 ){
			if (value.getAtkMin() <= this.value.getAtkMin())
				insertLeft(value, code);
			else if (value.getAtkMin() > this.value.getAtkMin())
				insertRight(value, code);
			else
				throw new DuplicateKeyException("Already inserted: "+value);
		}
		
	}
	
	
	private void insertLeft(Pokemon value, int code) throws DuplicateKeyException {
		if (left == null)
			left = new BSTNode(value);
		else
			left.insert(value, code);
	}

	private void insertRight(Pokemon value, int code) throws DuplicateKeyException {
		if (right == null)
			right = new BSTNode(value);
		else
			right.insert(value, code);
	}

	public void print() {
		//System.out.println();
		System.out.print("(" + value + " ");
		if (left != null)
			left.print();
		else
			System.out.print("_");
		if (right != null)
			right.print();
		else
			System.out.print(" _");
		System.out.print(")");
	}
	
	
	
	
	public void search(BSTNode node,int value, int whatSearch){
		if(whatSearch == 0){//busca na arvore de pokedex pela pokedex
			if(node == null || node.value.getPokedex() == value){
				System.out.println(this.value.toString());
				//AppendOnList(this.value);
				if(node.left != null){
					left.search(node.left,value,whatSearch);
				}/*else if(node.right != null){//Dont need this if, since equals value will be always on the left node, but...
					right.find(node.right,value,whatSearch);
				}*/else{
					return;
				}
			}
			if(value < node.value.getPokedex() && node.left != null){
				left.search(node.left,value,whatSearch);
			}
			else if(value > node.value.getPokedex() && node.right != null){
				right.search(node.right,value,whatSearch);
			}
		}else if(whatSearch == 1){//busca na arvore ATQ pelo ATQ
			if(node == null || node.value.getAtkMin() == value){
				System.out.println(this.value.toString());
				if(node.left != null){
					left.search(node.left,value,whatSearch);
				}/*else if(node.right != null){
					right.find(node.right,value,whatSearch);
				}*///Dont need this if, since equals value will be always on the left node, but...
				else{
					return;
				}
			}
			if(value < node.value.getAtkMin() && node.left != null){
				left.search(node.left,value,whatSearch);
			}
			if(value > node.value.getAtkMin() && node.right != null){
				right.search(node.right,value,whatSearch);
			}
		}else{
			System.out.println("ERRO - SEM CATEGORIA");
			return;
		}
	}
	//Busca por range
	public void searchByRange(BSTNode node, int valueMin, int valueMax){
		if(node == null || node.value.getPokedex() >= valueMin && node.value.getPokedex() <= valueMax){
			System.out.println(this.value.toString());
		}
		if(node.value.getPokedex() > valueMin  && left != null){
			searchByRange(node.left,valueMin,valueMax);
		}
		else if(node.value.getPokedex() < valueMax  && right != null){
			searchByRange(node.right,valueMin,valueMax);
		}else{
			return;
		}
	}
	
	public void searchByGambiarra(BSTNode node, int valueMin, int valueMax){
		for(int value = valueMin;value<=valueMax;value++){
			search(node,value,0);
		}
	}
	
}

public class BinarySearchTree{

	private BSTNode raiz;

	public void insert(Pokemon value, int code) throws DuplicateKeyException {
		if (raiz == null) {
			raiz = new BSTNode(value);
		} else
			raiz.insert(value, code);
	}

	public void print() {
		if (raiz != null)
			raiz.print();
	}
	public void findOnTree(int pokemon, int whatSearch){
		raiz.search(raiz,pokemon,whatSearch);
	}

	public void findOnTreeByRange(int valueMin, int valueMax) {
		
		//raiz.searchByRange(raiz, valueMin, valueMax);
		//raiz.searchByRange(raiz.getRight(), valueMin, valueMax);
		raiz.searchByGambiarra(raiz, valueMin, valueMax);
	}
}
