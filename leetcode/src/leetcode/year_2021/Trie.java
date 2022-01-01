package leetcode.year_2021;

import java.util.HashMap;

class Trie {
	private Node headNode;

	public Trie() {
		this.headNode = new Node();
	}

	public void insert(String word) {
		Node node = headNode;

		for (int i = 0; i < word.length(); i++) {
			HashMap<Character, Node> nextSet = node.getNexts();
			char wordChar = word.charAt(i);
			if (nextSet.get(wordChar) == null) {
				nextSet.put(wordChar, new Node(wordChar));
			}
			node = nextSet.get(wordChar);
		}
		node.setWordEnd(true);

	}

	public boolean search(String word) {
		Node node = headNode;
		
		for (int i = 0; i < word.length(); i++) {
			HashMap<Character, Node> nextSet = node.getNexts();
			char wordChar = word.charAt(i);
			if (nextSet.get(wordChar) == null) {
				return false;
			}
			node = nextSet.get(wordChar);
		}
		
		return node.isWordEnd();
		
	}

	public boolean startsWith(String prefix) {
		Node node = headNode;
		
		for (int i = 0; i < prefix.length(); i++) {
			HashMap<Character, Node> nextSet = node.getNexts();
			char wordChar = prefix.charAt(i);
			if (nextSet.get(wordChar) == null) {
				return false;
			}
			node = nextSet.get(wordChar);
		}
		
		return true;
	}

	public class Node {
		char val;
		HashMap<Character, Node> nexts;
		boolean wordEnd;

		public Node() {
			this.val = ' ';
			this.nexts = new HashMap<>();
			this.wordEnd = false;
		}

		public Node(char val) {
			this.val = val;
			this.nexts = new HashMap<>();
			this.wordEnd = false;
		}

		public Node(char val, boolean wordEnd) {
			this.val = val;
			this.nexts = new HashMap<>();
			this.wordEnd = wordEnd;
		}

		public void setWordEnd(boolean value) {
			this.wordEnd = value;
		}

		public HashMap<Character, Node> getNexts() {
			return this.nexts;
		}

		public void addWord(char c) {
			this.nexts.put(c, new Node(c));
		}

		public void addLastWord(char c) {
			this.nexts.put(c, new Node(c, true));
		}
		
		public boolean isWordEnd() {
			return wordEnd;
		}

	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		System.out.println(trie.search("apple"));   // return True
		System.out.println(trie.search("app"));     // return False
		System.out.println(trie.startsWith("app"));; // return True
		trie.insert("app");
		System.out.println(trie.search("app"));     // return True
	}
}
