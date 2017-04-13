package com.binary.tree;

/**
 * 
 * Title:Main
 * Description:
 * Company: HUST
 * @author 张松磊
 * @date 2017-4-13 下午3:44:48
 */
public class Main {
	public static void main(String [] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.insert(6);
		bst.insert(8);
		bst.insert(2);
		bst.insert(3);
		bst.insert(1);
		bst.insert(4);
		bst.remove(2);
		
		bst.printTree();
	}
}
