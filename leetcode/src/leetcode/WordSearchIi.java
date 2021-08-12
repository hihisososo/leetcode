package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordSearchIi {
    public static void main(String[] args) {
        /*char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};*/
        char[][] board = {{'a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a'}};
        /*String[] words = new String[]{"oath", "pea", "eat", "rain"};*/
        String[] words = new String[]{"lllllll","fffffff","ssss","s","rr","xxxx","ttt","eee","ppppppp","iiiiiiiii","xxxxxxxxxx","pppppp","xxxxxx","yy","jj","ccc","zzz","ffffffff","r","mmmmmmmmm","tttttttt","mm","ttttt","qqqqqqqqqq","z","aaaaaaaa","nnnnnnnnn","v","g","ddddddd","eeeeeeeee","aaaaaaa","ee","n","kkkkkkkkk","ff","qq","vvvvv","kkkk","e","nnn","ooo","kkkkk","o","ooooooo","jjj","lll","ssssssss","mmmm","qqqqq","gggggg","rrrrrrrrrr","iiii","bbbbbbbbb","aaaaaa","hhhh","qqq","zzzzzzzzz","xxxxxxxxx","ww","iiiiiii","pp","vvvvvvvvvv","eeeee","nnnnnnn","nnnnnn","nn","nnnnnnnn","wwwwwwww","vvvvvvvv","fffffffff","aaa","p","ddd","ppppppppp","fffff","aaaaaaaaa","oooooooo","jjjj","xxx","zz","hhhhh","uuuuu","f","ddddddddd","zzzzzz","cccccc","kkkkkk","bbbbbbbb","hhhhhhhhhh","uuuuuuu","cccccccccc","jjjjj","gg","ppp","ccccccccc","rrrrrr","c","cccccccc","yyyyy","uuuu","jjjjjjjj","bb","hhh","l","u","yyyyyy","vvv","mmm","ffffff","eeeeeee","qqqqqqq","zzzzzzzzzz","ggg","zzzzzzz","dddddddddd","jjjjjjj","bbbbb","ttttttt","dddddddd","wwwwwww","vvvvvv","iii","ttttttttt","ggggggg","xx","oooooo","cc","rrrr","qqqq","sssssss","oooo","lllllllll","ii","tttttttttt","uuuuuu","kkkkkkkk","wwwwwwwwww","pppppppppp","uuuuuuuu","yyyyyyy","cccc","ggggg","ddddd","llllllllll","tttt","pppppppp","rrrrrrr","nnnn","x","yyy","iiiiiiiiii","iiiiii","llll","nnnnnnnnnn","aaaaaaaaaa","eeeeeeeeee","m","uuu","rrrrrrrr","h","b","vvvvvvv","ll","vv","mmmmmmm","zzzzz","uu","ccccccc","xxxxxxx","ss","eeeeeeee","llllllll","eeee","y","ppppp","qqqqqq","mmmmmm","gggg","yyyyyyyyy","jjjjjj","rrrrr","a","bbbb","ssssss","sss","ooooo","ffffffffff","kkk","xxxxxxxx","wwwwwwwww","w","iiiiiiii","ffff","dddddd","bbbbbb","uuuuuuuuu","kkkkkkk","gggggggggg","qqqqqqqq","vvvvvvvvv","bbbbbbbbbb","nnnnn","tt","wwww","iiiii","hhhhhhh","zzzzzzzz","ssssssssss","j","fff","bbbbbbb","aaaa","mmmmmmmmmm","jjjjjjjjjj","sssss","yyyyyyyy","hh","q","rrrrrrrrr","mmmmmmmm","wwwww","www","rrr","lllll","uuuuuuuuuu","oo","jjjjjjjjj","dddd","pppp","hhhhhhhhh","kk","gggggggg","xxxxx","vvvv","d","qqqqqqqqq","dd","ggggggggg","t","yyyy","bbb","yyyyyyyyyy","tttttt","ccccc","aa","eeeeee","llllll","kkkkkkkkkk","sssssssss","i","hhhhhh","oooooooooo","wwwwww","ooooooooo","zzzz","k","hhhhhhhh","aaaaa","mmmmm"};
        System.out.println(new WordSearchIi().findWords(board, words));
    }

    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node(' ');
        makeTrie(board, root);
        return findWords(words, root);
    }

    private List<String> findWords(String[] words, Node root) {
        ArrayList<String> resultList = new ArrayList<>();
        for (String word : words) {
            Node node = root;
            char[] wordChar = word.toCharArray();
            boolean find = true;
            for (int i = 0; i < wordChar.length; i++) {
                int idx = wordChar[i] - 97;
                if (node.nodes[idx] == null) {
                    find = false;
                    break;
                }
                node = node.nodes[idx];
            }
            if (find) {
                resultList.add(word);
            }
        }
        return resultList;
    }

    private void makeTrie(char[][] board, Node root) {
        HashSet<String> wordSet = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean[][] visit = new boolean[board.length][];
                for (int k = 0; k < visit.length; k++) {
                    visit[k] = new boolean[board[k].length];
                }
                addAvailableWords(board, "", i, j, wordSet, visit);
            }
        }
        makeTrie(root, wordSet);
    }

    private void makeTrie(Node root, HashSet<String> wordSet) {
        for (String word : wordSet) {
            Node node = root;
            char[] wordChar = word.toCharArray();
            for (int i = 0; i < wordChar.length; i++) {
                int idx = wordChar[i] - 97;
                if (node.nodes[idx] == null) {
                    node.nodes[idx] = new Node(wordChar[i]);
                }
                node = node.nodes[idx];
            }
        }
    }

    private void addAvailableWords(char[][] board, String prefix, int row, int col, HashSet<String> wordSet, boolean[][] visit) {
        if (prefix.length() >= 10 || visit[row][col]) {
            return;
        }
        visit[row][col] = true;

        char c = board[row][col];
        String s = prefix + c;
        wordSet.add(s);
        wordSet.add(new StringBuffer(s).reverse().toString());

        if (row > 0) {
            addAvailableWords(board, s, row - 1, col, wordSet, cloneArray(visit));
        }
        if (row < board.length - 1) {
            addAvailableWords(board, s, row + 1, col, wordSet, cloneArray(visit));
        }
        if (col > 0) {
            addAvailableWords(board, s, row, col - 1, wordSet, cloneArray(visit));
        }
        if (col < board[row].length - 1) {
            addAvailableWords(board, s, row, col + 1, wordSet, cloneArray(visit));
        }
    }

    public boolean[][] cloneArray(boolean[][] src) {
        int length = src.length;
        boolean[][] target = new boolean[length][src[0].length];
        for (int i = 0; i < length; i++) {
            System.arraycopy(src[i], 0, target[i], 0, src[i].length);
        }
        return target;
    }

    class Node {
        char c;
        Node[] nodes;

        public Node(char c) {
            nodes = new Node[26];
        }
    }


}
