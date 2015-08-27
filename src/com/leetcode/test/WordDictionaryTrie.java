package com.leetcode.test;

class TrieNode {
	Object val;
	TrieNode[] nxet = new TrieNode[256];
}

public class WordDictionaryTrie {
	private TrieNode root;

	 public void addWord(String word) {
	        put(word, true);
	    }
	private void put(String key,boolean exit){
		root=put(root, key, exit, 0);
	}
	private TrieNode put(TrieNode node,String key,boolean exit,int d){
		if(node==null) 
			node=new TrieNode();
		if(d==key.length()){
			node.val=exit;
			return node;
		}
		char c=(char) (key.charAt(d)-'a');
		node.nxet[c]=put(node.nxet[c], key, exit, d+1);
		return node;
	}
	 public boolean search(String word) {
	        return get1(word);
	    }
	private boolean get(String key){
		TrieNode node=get(root, key, 0);
		if(node==null)
			return false;
		return (boolean)node.val;
	}
	private TrieNode get(TrieNode node,String key,int d){
		if(node==null)
			return null;
		if(d==key.length())
			return node;
		char c=(char) (key.charAt(d)-'a');
		return get(node.nxet[c], key, d+1);
	}
	private boolean get1(String key){
		return get2(root, key, 0);
	}
	private boolean get2(TrieNode node,String key,int d){
		if(node==null)
			return false;
	if (d == key.length()){
			if(node.val==null)
				return false;
			return true;
		}
		char c=key.charAt(d);
		if(c!='.')
			return get2(node.nxet[c-'a'], key, d+1);
		for(char ch='a';ch<='z';ch++){
			if(get2(node.nxet[ch-'a'], key, d+1))
				return true;
		}
		return false;
		
	}
	public static void main(String[] args) {
		 WordDictionaryTrie trie=new WordDictionaryTrie();
		 trie.addWord("word");
		 trie.addWord("at");
		 trie.addWord("and");
		 trie.addWord("an");
		 trie.addWord("add");
		 trie.search("a");
		 trie.search(".at");
		 trie.addWord("bat");
		 trie.search(".at");
		 trie.search("an.");
		 trie.search("a.d.");
		 trie.search("b.");
		 trie.search("a.d");
		 trie.search(".");
		 System.out.println(trie.search("w..d"));
	}
}
