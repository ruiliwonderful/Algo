package com.rui.lintcode.recursionandsearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class DirectedGraphNode {
	int label;
	ArrayList<DirectedGraphNode> neighbors;

	DirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<DirectedGraphNode>();
	}
};

public class TopologicalSorting {
	/**
	 * Given an directed graph, a topological order of the graph nodes is
	 * defined as follow:
	 * 
	 * For each directed edge A -> B in graph, A must before B in the order
	 * list. The first node in the order can be any node in the graph with no
	 * nodes direct to it. Find any topological order for the given graph.
	 * 
	 * @param graph
	 *            : A list of Directed graph node
	 * @return: Any topological order for the given graph.
	 */
	public ArrayList<DirectedGraphNode> topSort(
			ArrayList<DirectedGraphNode> graph) {

		Set<DirectedGraphNode> allPossibleStart = findAllNodeAsStarter(graph);
		ArrayList<DirectedGraphNode> solution = null;

		for (DirectedGraphNode startNode : allPossibleStart) {
			solution = new ArrayList<DirectedGraphNode>();
			Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
			Set<DirectedGraphNode> vistedNode = new HashSet<DirectedGraphNode>();
			q.add(startNode);
			while (!q.isEmpty()) {
				DirectedGraphNode node = q.poll();
				if (!vistedNode.contains(node))
					solution.add(node);
				vistedNode.add(node);
				for (DirectedGraphNode neighbors : node.neighbors) {
					q.add(neighbors);
				}
			}
			break;
		}
		return solution;
	}
	
	
	   public ArrayList<DirectedGraphNode> topSort2(ArrayList<DirectedGraphNode> graph) {
	          ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
	        HashMap<DirectedGraphNode, Integer> map = new HashMap();
	        for (DirectedGraphNode node : graph) {
	            for (DirectedGraphNode neighbor : node.neighbors) {
	                if (map.containsKey(neighbor)) {
	                    map.put(neighbor, map.get(neighbor) + 1);
	                } else {
	                    map.put(neighbor, 1); 
	                }
	            }
	        }
	        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
	        for (DirectedGraphNode node : graph) {
	            if (!map.containsKey(node)) {
	                q.offer(node);
	                result.add(node);
	            }
	        }
	        while (!q.isEmpty()) {
	            DirectedGraphNode node = q.poll();
	            for (DirectedGraphNode n : node.neighbors) {
	                map.put(n, map.get(n) - 1);
	                if (map.get(n) == 0) {
	                    result.add(n);
	                    q.offer(n);
	                }
	            }
	        }
	        return result;
	    }

	private Set<DirectedGraphNode> findAllNodeAsStarter(
			ArrayList<DirectedGraphNode> graph) {
		// ArrayList<DirectedGraphNode> allStarter=new
		// ArrayList<DirectedGraphNode>();
		Set<DirectedGraphNode> allDestNode = new HashSet<DirectedGraphNode>();
		Set<DirectedGraphNode> allNonDestNodeSoFar = new HashSet<DirectedGraphNode>();

		for (DirectedGraphNode node : graph) {
			for (DirectedGraphNode neighbornode : node.neighbors) {
				allDestNode.add(neighbornode);
				if (allNonDestNodeSoFar.contains(neighbornode))
					allNonDestNodeSoFar.remove(neighbornode);

			}
			if (!allDestNode.contains(node))
				allNonDestNodeSoFar.add(node);
			else {
				if (allNonDestNodeSoFar.contains(node))
					allNonDestNodeSoFar.remove(node);
			}
		}
		return allNonDestNodeSoFar;
	}
	
	
	public static void main(String args[]){
		TopologicalSorting ts=new TopologicalSorting();
		ArrayList<DirectedGraphNode> graph=new ArrayList<DirectedGraphNode>();
		
		DirectedGraphNode node0 =new DirectedGraphNode(0);
		DirectedGraphNode node1=new DirectedGraphNode(1);
		DirectedGraphNode node2=new DirectedGraphNode(2);
		DirectedGraphNode node3=new DirectedGraphNode(3);
		DirectedGraphNode node4=new DirectedGraphNode(4);
		DirectedGraphNode node5=new DirectedGraphNode(5);
		
		 ArrayList<DirectedGraphNode>  node0neighbors=new ArrayList<DirectedGraphNode>();
		 node0neighbors.add(node1);
		 node0neighbors.add(node2);
		 node0neighbors.add(node3);
		 node0.neighbors=node0neighbors;
		 
		 ArrayList<DirectedGraphNode>  node1neighbors=new ArrayList<DirectedGraphNode>();
		 node1neighbors.add(node4);
		
		 node1.neighbors=node1neighbors;
		 
		 ArrayList<DirectedGraphNode>  node2neighbors=new ArrayList<DirectedGraphNode>();
		 node2neighbors.add(node4);
		 node2neighbors.add(node5);
		 node2.neighbors=node2neighbors;
		 
		 ArrayList<DirectedGraphNode>  node3neighbors=new ArrayList<DirectedGraphNode>();
		 node3neighbors.add(node4);
		 node3neighbors.add(node5);
		 node3.neighbors=node3neighbors;
		 
		 graph.add(node0);
		 graph.add(node1);
		 graph.add(node2);
		 graph.add(node3);
		 graph.add(node4);
		 graph.add(node5);
		 
		 //System.out.println(ts.topSort(graph));
		 for(DirectedGraphNode node:ts.topSort(graph)){
			 System.out.print(node.label);
		 }
		 System.out.println();
		 for(DirectedGraphNode node:ts.topSort2(graph)){
			 System.out.print(node.label);
		 }
		
	}
}