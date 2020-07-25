package com.or;

import java.util.LinkedList;
import java.util.Queue;


public class BST  {

	//attributes
	private Node root;


	
	//get+set+c'tor
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
	public BST() {
		this.root = null;
	}



	
	//methods
	public void insert(int key) {
		   	
		  if (this.root==null) {
			  
			  this.root=new Node(key);
		  }
		  else {
			
			insertRec(this.root, key);    
			
		  } 
	   }    
	private void insertRec(Node tempRoot, int key) {
	    	
	    
	    	if (key>tempRoot.getData()) {
				if (tempRoot.getRight()==null) {
					tempRoot.setRight(new Node(key));
				} else {
					insertRec(tempRoot.getRight(), key);
				}
			}
	    	
	    	if (key<tempRoot.getData()) {
				if (tempRoot.getLeft()==null) {
					tempRoot.setLeft(new Node(key));
				} else {
					insertRec(tempRoot.getLeft(), key);
				}
			}
	    	
	    	if (key==tempRoot.getData()) {
	    		
	    		System.out.println(key+" is already here!");
	    	}
	    	
	    	
	    	
	}


	public void print(Node root) {
		if (root==null) {
			System.out.println("tree is empty\n\n");
			return;
		}

        Queue<Node> q = new LinkedList<Node>(); 
		q.add(root);
		System.out.println("Nodes data by levels ---> ");

		while (q.isEmpty()==false) {
			Node temp=q.remove();
			System.out.print( temp.getData()+"\t");
			
			if (temp.getLeft() != null) {
				q.add(temp.getLeft());		
				}
			
			if (temp.getRight() != null) {
				q.add(temp.getRight());
			}
			
			
			
			
			
		}
		System.out.println(" \n");

		return;
	}

	public Boolean isLeaf(Node temp) {
		
		if (temp.getLeft()==null&&temp.getRight()==null) {
			return true;
		} else {
			return false;
		}
		
		
	}
	
	
	public Node getMax() {
		
		Node temp=this.root;
		
		while (temp.getRight()!=null) {
			temp=temp.getRight();
		}
		
		return temp;
		
		
	}
	public Node getMin() {
		
		return getMinRec(this.root);
		
		
	}
	private Node getMinRec(Node root) {
		
		Node temp=root;
		
		while (temp.getLeft() != null) {
			
			temp=temp.getLeft();
		}
		
		return temp;
	}
	
	public void delete(int key) {
		
		deleteRec(this.root,key);
		

	}
	private Node deleteRec(Node node,int key) {
		
		
		
		if (key>node.getData()) {
			node.setRight(deleteRec(node.getRight(), key));
		}
		
		if (key<node.getData()) {
			node.setLeft(deleteRec(node.getLeft(), key));
		}
		
		if (node.getData()==key) {
			
			
			if (isLeaf(node)==true) { // delete leaf node
				return null;
				
			}
		
			else if (node.getLeft()==null) {  
				return node.getRight();
			}
			
			else if (node.getRight()==null) {
				return node.getLeft();
			}
			

			// what about 2 children? ->
			else if (node.getLeft()!=null&&node.getRight()!=null) {
			
				
				int val=(getMinRec(node.getRight())).getData();
				
				node.setData(val);
				node.setRight(deleteRec(node.getRight(), val));
				
			}

			
		}
		
			
			
			
		
		
		
		return node;
	}
	
	
	
	public void add(int key) {
		if (this.root==null) {
			root=new Node(key);
		}else {
			this.add(this.root, key);
			
		}
		
	}
	private Node add(Node node, int key) {

		if (node==null) {
			return new Node(key);
		}
		
		if (node.getData()<key) {
			node.setRight(add(node.getRight(), key));
		}
			
		if (node.getData()>key) {
			node.setLeft(add(node.getLeft(), key));
		}
	
		return node;
	}
	
	
	
	public int getHeight() {
		if (root==null) {
			System.out.println("tree is empty");
			return -1;
		}
	return getHeight(root);
	}
	private int getHeight(Node root) {
		
		if (root==null) {
			return -1;
		}
		
		int left=getHeight(root.getLeft());
		int right=getHeight(root.getRight());
		
		return Math.max(left,right)+1;
	}


	

}// class end