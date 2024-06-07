package tries;

public class Tries {

    static class Node {
        Node[] links = new Node[26];
        boolean flag = false;

        boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        void put(Node node, char ch) {
            links[ch - 'a'] = node;
        }

        Node get(char ch) {
            return links[ch - 'a'];
        }

        void setEnd() {
            flag = true;
        }

        boolean isEnd() {
            return flag;
        }
    }

    private Node root;

    // gets space at memory at runtime
    public Tries() {
        /*
         * This ensures that whenever trie object is called it starts with a empty root
         * node
         */
        root = new Node();
    }

    public void insert(String word) {
        // initialized root or 1st node
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                // putting character in the new node
                node.put(new Node(), word.charAt(i));
            }

            node = node.get(word.charAt(i));
        }
        // setting flag as true for the last node
        node.setEnd();
    }

    public boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                return false;
            }

            node = node.get(word.charAt((i)));
        }
        return node.isEnd();
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!node.containsKey(prefix.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Tries trie = new Tries();
        System.out.println("Inserting words: Striver, Striving, String, Strike");
        trie.insert("striver");
        trie.insert("striving");
        trie.insert("string");
        trie.insert("strike");

        System.out.println("Search if Strawberry exists in trie: " +
                (trie.search("strawberry") ? "True" : "False"));

        System.out.println("Search if Strike exists in trie: " +
                (trie.search("strike") ? "True" : "False"));

        System.out.println("If words in Trie start with Stri: " +
                (trie.startsWith("stri") ? "True" : "False"));
    }

}