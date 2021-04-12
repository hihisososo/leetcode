package leetcode;

import java.util.ArrayList;
import java.util.List;

class Trie {
	private List<Node> heads;

	/** Initialize your data structure here. */
	public Trie() {
		this.heads = new ArrayList<Node>();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		char[] wordArr = word.toCharArray();
		Node matchNode = null;
		for (Node node : heads) {
			if (node.val == wordArr[0]) {
				matchNode = node;
				break;
			}
		}

		if (matchNode == null) {
			Node node = new Node(wordArr[0]);
			heads.add(node);

			for (int i = 1; i < wordArr.length; i++) {
				Node nextNode = new Node(wordArr[i]);
				node.addNext(nextNode);
				node = nextNode;
			}
			node.setWordEnd(true);
		} else {
			Node findNode = null;
			for (int i = 1; i < wordArr.length; i++) {
				List<Node> nodes = matchNode.nexts;
				findNode = null;
				for (Node node : nodes) {
					if (node.val == wordArr[i]) {
						findNode = node;
						break;
					}
				}

				if (findNode == null) {
					for (int j = i; j < wordArr.length; j++) {
						Node nextNode = new Node(wordArr[j]);
						node.addNext(nextNode);
						node = nextNode;
					}
					findNode = node;
				} else {
					matchNode = findNode;
				}
			}
			findNode.setWordEnd(true);

		}
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		char[] wordArr = word.toCharArray();
		List<Node> nodes = heads;
		Node findNode = null;
		for (int i = 0; i < wordArr.length; i++) {
			findNode = null;
			for (Node node : nodes) {
				if (node.val == wordArr[i]) {
					findNode = node;
					break;
				}
			}
			if (findNode == null) {
				return false;
			} else {
				nodes = findNode.nexts;
			}
		}
		
		return findNode.wordEnd;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		char[] wordArr = prefix.toCharArray();
		List<Node> nodes = heads;
		for (int i = 0; i < wordArr.length; i++) {
			Node findNode = null;
			for (Node node : nodes) {
				if (node.val == wordArr[i]) {
					findNode = node;
					break;
				}
			}
			if (findNode == null) {
				return false;
			} else {
				nodes = findNode.nexts;
			}
		}
		return true;
	}

	public class Node {
		char val;
		List<Node> nexts;
		boolean wordEnd;

		public Node(char val) {
			this.val = val;
			this.nexts = new ArrayList<Node>();
			this.wordEnd = false;
		}

		public Node(char val, List<Node> nexts) {
			this.val = val;
			this.nexts = nexts;
			this.wordEnd = false;
		}

		public void addNext(Node next) {
			this.nexts.add(next);
		}

		public void setWordEnd(boolean value) {
			this.wordEnd = value;
		}
	}
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("ab");
		System.out.println(trie.search("ab")); // return True
		System.out.println(trie.search("abd")); // return False
		System.out.println(trie.startsWith("abc")); // return True
		trie.insert("abc");
		System.out.println(trie.search("abc")); // return True
	}
}
