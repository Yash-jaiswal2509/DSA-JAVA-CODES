package tries;

public class TriesII {
    static class Node {
        // Node[] links = new Node[26];
        // int endsWith = 0, countPrefix = 0;
        Node[] links;
        int endsWith;
        int countPrefix;

        // constructor
        Node() {
            links = new Node[26];
            endsWith = 0;
            countPrefix = 0;
        }

        boolean containsChar(char ch) {
            return links[ch - 'a'] != null;
        }

        void put(Node node, char ch) {
            links[ch - 'a'] = node;
        }

        Node get(char ch) {
            return links[ch - 'a'];
        }

        void increaseEnd() {
            endsWith++;
        }

        void deleteEnd() {
            endsWith--;
        }

        void increaseCountPrefix() {
            countPrefix++;
        }

        void decreaseCountPrefix() {
            countPrefix--;
        }
    }

    private Node root;

    TriesII() {
        root = new Node();
    }

    // insert function
    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsChar(word.charAt(i))) {
                node.put(new Node(), word.charAt(i));
            }

            // moving to the child node
            node = node.get(word.charAt(i));
            node.increaseCountPrefix();
        }

        node.increaseEnd();
    }

    // function to count the no. of words equal to given word
    // given word should be strictly equal to words in trie
    // don't get confuse with prefix function
    public int countWordsEqualTo(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsChar(word.charAt(i))) {
                node = node.get(word.charAt(i));
            } else {
                return 0;
            }
        }

        return node.endsWith;
    }

    public int countWordsWithPrefix(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsChar(word.charAt(i))) {
                node = node.get(word.charAt(i));
            } else {
                return 0;
            }
        }

        return node.countPrefix;
    }

    public void erase(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsChar(word.charAt(i))) {
                node = node.get(word.charAt(i));
                node.decreaseCountPrefix();
            } else {
                return;
            }
        }

        node.deleteEnd();
    }

    public static void main(String[] args) {
        TriesII trie = new TriesII();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("app");
        trie.insert("apps");
        trie.insert("apex");

        System.out.print("Count Words Equal to 'apple': ");
        System.out.println(trie.countWordsEqualTo("apple"));
        System.out.print("Count Words Starting With 'app': ");
        System.out.println(trie.countWordsWithPrefix("app"));
        System.out.println("Erasing word 'app' from trie");
        trie.erase("app");
        System.out.print("Count Words Equal to 'apple': ");
        System.out.println(trie.countWordsEqualTo("apple"));
        System.out.print("Count Words Starting With 'app': ");
        System.out.println(trie.countWordsWithPrefix("app"));
    }
}
