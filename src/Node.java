class Node {
    Node[] children;
    boolean isEndOfWord;

    public Node() {
        children = new Node[26]; 
        isEndOfWord = false;
    }
}