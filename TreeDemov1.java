class Node{
	   int value;
	   Node left, right;

	   public Node(int value){
	      this.value = value;
	      left = null;
	      right = null;
	   }

	}

	class BinarySearchTree{

	   Node root;


	   /*
	   recursive insert method

	   */
	   /*
	   inserts a node into the tree
	   */
	   public void insert(int value){
	      //tree is empty
	      if(root == null){
	         root = new Node(value);
	         return;
	      }else{
	         Node current = root;
	         Node parent = null;

	         while(true){
	            parent = current;

	            if(value < current.value){
	               current = current.left;
	               if(current == null){
	                  parent.left = new Node(value);
	                  return;
	               }
	            }else{
	               current = current.right;
	               if(current == null){
	                  parent.right = new Node(value);
	                  return;
	               }
	            }

	         }//closing while

	      }//closing main if-else
	   }

		/**
        * Performs pre-order traversal (Root, Left, Right) of the binary search tree.
        * @param root the root node of the tree
        */
	   public void preOrderTraversal(Node root){
		//implement in here
		  if (root != null) {
             System.out.print(root.value + " "); // Print the root value
             preOrderTraversal(root.left); // Traverse the left subtree
             preOrderTraversal(root.right); // Traverse the right subtree
            }
	   }


		/**
         * Performs in-order traversal (Left, Root, Right) of the binary search tree.
         * This traversal prints the values in ascending order.
         * @param root the root node of the tree
         */
	   public void inOrderTraversal(Node root){
	     //implement in here
			if (root != null) {
                inOrderTraversal(root.left); // Traverse the left subtree
                System.out.print(root.value + " "); // Print the root value
                inOrderTraversal(root.right); // Traverse the right subtree
            }
	   }



    /**
     * Performs post-order traversal (Left, Right, Root) of the binary search tree.
     * @param root the root node of the tree
     */
	   public void postOrderTraversal(Node root){
         //implement in here
         if (root != null) {
                postOrderTraversal(root.left); // Traverse the left subtree
                postOrderTraversal(root.right); // Traverse the right subtree
                System.out.print(root.value + " "); // Print the root value
            }
	   }


	/**
     * Searches for a node with the given key in the binary search tree.
     * @param root the root node of the tree
     * @param key the value to search for
     * @return true if the node with the key is found, false otherwise
     */
	   public boolean find(Node root, int key){
		 //implement in here
			if(root == null){
					return false;
				}else if (root.value == key){
					return true;
				}else if(key < root.value){
					return find(root.left, key);
				}else{
					return find(root.right, key);
					}
	   }



        /**
        * Finds the minimum value in the binary search tree.
        * The minimum value is located at the leftmost node.
        * @param root the root node of the tree
        * @return the minimum value in the tree
        */
	   public int getMin(Node root){
         //implement in here
         int minv = root.value;
                while (root.left != null) {
                    minv = root.left.value;
                    root = root.left;
                }
                    return minv;
	   }



		/**
        * Finds the maximum value in the binary search tree.
        * The maximum value is located at the rightmost node.
        * @param root the root node of the tree
        * @return the maximum value in the tree
        */
	   public int getMax(Node root){
         //implement in here
         if (root == null) {
             throw new IllegalArgumentException("Tree is empty");
         }

         while (root.right != null) {
             root = root.right; // Keep going right to find the maximum
         }

         return root.value;
	   }



	   /*
	   this method will not compile until getMax
	   is implemented
	   */
	   public Node delete(Node root, int key){

	      if(root == null){
	         return root;
	      }else if(key < root.value){
	         root.left = delete(root.left, key);
	      }else if(key > root.value){
	         root.right = delete(root.right, key);
	      }else{
	         //node has been found
	         if(root.left==null && root.right==null){
	            //case #1: leaf node
	            root = null;
	         }else if(root.right == null){
	            //case #2 : only left child
	            root = root.left;
	         }else if(root.left == null){
	            //case #2 : only right child
	            root = root.right;
	         }else{
	            //case #3 : 2 children
	            root.value = getMax(root.left);
	            root.left = delete(root.left, root.value);
	         }
	      }
	      return root;
	   }
	}



	public class TreeDemov1{
	   public static void main(String[] args){
	      BinarySearchTree t1  = new BinarySearchTree();
	      t1.insert( 24);
	      t1.insert(80);
	      t1.insert(18);
	      t1.insert(9);
	      t1.insert(90);
	      t1.insert(22);

	      System.out.print("in-order :   ");
	      t1.inOrderTraversal(t1.root);
	      System.out.println();
	    }
	}
