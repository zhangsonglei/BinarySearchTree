package com.binary.tree;

/**
 * 
 * Title:BinarySearchTree
 * Description:
 * Company: HUST
 * @author 张松磊
 * @date 2017-4-13 下午3:45:15
 */
public class BinarySearchTree<T extends Comparable<? super T>> {
	
	//二叉查找树树节点
	private static class BinaryNode<T> {
		T element;
		BinaryNode<T> left;
		BinaryNode<T> right;
		
		public BinaryNode(T element) {
			this.element = element;
		}
		
		public BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right) {
			this.element = element;
			this.left = left;
			this.right = right;
		}
	}
	
	private BinaryNode<T> root;
	
	//构造函数
	public BinarySearchTree(){
		root = null;
	}
	
	/**
	 * 
	 * @Title: makeEmpty 
	 * @Description: 将树设为空
	 * @param 
	 * @return void
	 * @throws
	 */
	public void makeEmpty() {
		root = null;
	}
	
	/**
	 * 
	 * @Title: isEmpty 
	 * @Description: 判断树是否为空
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	public boolean isEmpty()
	{
		return root == null;
	}
	
	/**
	 * 
	 * @Title: contain 
	 * @Description:
	 * @param @param data
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	public boolean contain(T data) {
		return contain(data, root);
	}

	/**
	 * 
	 * @Title: contain 
	 * @Description: 查找以root为根的树中是否存在data
	 * @param data
	 * @param root
	 * @return boolean
	 * @throws
	 */
	private boolean contain(T data, BinaryNode<T> root) {
		
		if(root==null)
			return false;
		
		int res = data.compareTo(root.element);
		
		if(res < 0)
			return contain(data, root.left);
		else if(res > 0)
			return contain(data, root.right);
		else {
			return true;
		}
	}
	
	/**
	 * 
	 * @Title: findMin 
	 * @Description: 查找树中的最小项
	 * @return T
	 * @throws
	 */
	public T findMin() {
		if(isEmpty())
			return null;
		return findMin(root).element;
	}
	
	/**
	 * 
	 * @Title: findMin 
	 * @Description: 查找以root为根的树中的最小项
	 * @param root
	 * @return BinaryNode<T>
	 * @throws
	 */
	private BinaryNode<T> findMin(BinaryNode<T> root) {
		if(root == null)
			return null;
		else if(root.left == null)
			return root;
		else return findMin(root.left);
	}

	/**
	 * 
	 * @Title: findMax 
	 * @Description: 查找树中的最大项
	 * @return T
	 * @throws
	 */
	public T findMax() {
		if(isEmpty())
			return null;
		return findMax(root).element;
	}
	
	/**
	 * 
	 * @Title: findMax 
	 * @Description: 查找以root为根的树中的最大项
	 * @param root
	 * @return BinaryNode<T>
	 * @throws
	 */
	private BinaryNode<T> findMax(BinaryNode<T> root) {
		if(root == null)
			return null;
		else if(root.right == null)
			return root;
		else return findMin(root.right);
	}

	/**
	 * 
	 * @Title: insert 
	 * @Description: 在树中插入data 
	 * @param data
	 * @return void
	 * @throws
	 */
	public void insert(T data) {
		root = insert(data, root);
	}
	
	/**
	 * 
	 * @Title: insert 
	 * @Description: 在以root为根的树中插入data
	 * @param data
	 * @param root
	 * @return BinaryNode<T>
	 * @throws
	 */
	private BinaryNode<T> insert(T data, BinaryNode<T> root) {
		if(root == null)
			return new BinaryNode<>(data, null, null);
		
		int res = data.compareTo(root.element);
		if(res < 0)
			root.left = insert(data, root.left);
		else if(res > 0)
			root.right = insert(data, root.right);
		else {
			
		}
		return root;
	}

	/**
	 * 
	 * @Title: remove 
	 * @Description: 在树中移除data 
	 * @param data
	 * @return void
	 * @throws
	 */
	public void remove(T data) {
		root = remove(data, root);
	}
	
	/**
	 * 
	 * @Title: remove 
	 * @Description: 在以root为根的树中移除data项
	 * @param data
	 * @param root
	 * @return BinaryNode<T>
	 * @throws
	 */
	private BinaryNode<T> remove(T data, BinaryNode<T> root) {
		if(root == null)
			return root;
		
		int res = data.compareTo(root.element);
		if(res < 0)
			root.left = remove(data, root.left);
		else if(res > 0)
			root.right = remove(data, root.right);
		else if(root.left != null && root.right != null){
			root.element = findMin(root.right).element;
			root.right = remove(root.element, root.right);
		}else {
			root = (root.left != null) ? root.left : root.right;
		}
		
		return root;
	}

	/**
	 * 
	 * @Title: printTree 
	 * @Description: 打印树
	 * @return void
	 * @throws
	 */
	public void printTree() {
		if(isEmpty())
			System.out.println("Empty tree");
		else 
			printTree(root);
		
	}

	/**
	 * 
	 * @Title: printTree 
	 * @Description: 打印以root为根节点的树
	 * @param root
	 * @return void
	 * @throws
	 */
	private void printTree(BinaryNode<T> root) {
		if(root != null) {
			printTree(root.left);
			System.out.println(root.element);
			printTree(root.right);
		}
	}
	
	
}
