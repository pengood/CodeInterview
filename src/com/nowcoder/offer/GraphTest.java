package com.nowcoder.offer;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 无向图深优先搜索与广度优先搜
 */
class GraphNode {
	int val;
	GraphNode[] neighbors;
	boolean visited;

	public GraphNode(int x) {
		// TODO Auto-generated constructor stub
		this.val = x;
	}

	public GraphNode(int x, GraphNode[] nodes) {
		// TODO Auto-generated constructor stub
		this.val = x;
		this.neighbors = nodes;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "value:" + this.val;
	}

}

public class GraphTest {
	//深度优先搜索
	public void depthFirstSearch(GraphNode root, int x) {
		if (root == null)
			throw new IllegalArgumentException();
		System.out.print(root+" ");
		dfs(root, x);
	}
	
	private void dfs(GraphNode node,int x){
		node.visited=true;
		if(node.val==x)
			System.out.println(node);
		for(GraphNode n:node.neighbors){
			if(!n.visited){
				n.visited=true;
				System.out.print(n + " ");
				if(n.val==x)
					System.out.print("(KO:" + n + ") ");
				dfs(n, x);
			}
		}
	}

	//广度优先搜索
	public void breathFirstSearch(GraphNode root, int x) {
		if (root == null)
			throw new IllegalArgumentException();
		if (root.val == x)
			System.out.println(root);
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		root.visited = true;
		System.out.print(root + " ");
		queue.add(root);
		while (!queue.isEmpty()) {
			GraphNode node = queue.poll();
			for (GraphNode n : node.neighbors) {
				if (!n.visited) {
					n.visited = true;
					System.out.print(n + " ");
					if (n.val == x)
						System.out.print("(KO:" + n + ") ");
					queue.add(n);
				}
			}
		}
	}

	public GraphNode createGraph(){
		GraphNode n1 = new GraphNode(1);
		GraphNode n2 = new GraphNode(2);
		GraphNode n3 = new GraphNode(3);
		GraphNode n4 = new GraphNode(4);
		GraphNode n5 = new GraphNode(5);
		n1.neighbors = new GraphNode[] { n2, n3, n5 };
		n2.neighbors = new GraphNode[] { n1, n4 };
		n3.neighbors = new GraphNode[] { n1, n4, n5 };
		n4.neighbors = new GraphNode[] { n2, n3, n5 };
		n5.neighbors = new GraphNode[] { n1, n3, n4 };
		return n1;
	}
	public static void main(String[] args) {
		GraphTest test = new GraphTest();
		System.out.println("breathFirstSearch:");
		test.breathFirstSearch(test.createGraph(), 4);
		System.out.println();
		System.out.println("depthFirstSearch:");
		test.depthFirstSearch(test.createGraph(), 4);

	}

}
