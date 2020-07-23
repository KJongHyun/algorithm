import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class pg42892 {
    public static void main(String[] args) {
        int[][] nodeInfo = {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};
        solution(nodeInfo);
    }

    static class Node {
        Node left;
        Node right;
        private int x;
        private int y;
        private int index;

        public Node(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void insert(Node node) {
            int x = node.getX();
            if (this.x > x) {
                if (this.left == null)
                    this.left = node;
                else
                    this.left.insert(node);
            } else {
                if (this.right == null)
                    this.right = node;
                else
                    this.right.insert(node);
            }
        }
    }

    public static int[][] solution(int[][] nodeinfo) {
        List<Node> nodeList = new ArrayList<>();
        int[][] answer = new int[2][nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            nodeList.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1));
        }

        nodeList.sort((o1, o2) -> {
            if (o1.y < o2.y)
                return 1;
            else if (o1.y > o2.y)
                return -1;
            else
                return 0;
        });
        Node root = null;
        for (Node node : nodeList) {
            if (root == null) {
                root = node;
                continue;
            }
            root.insert(node);
        }

        List<Integer> preList = new ArrayList<>();
        List<Integer> postList = new ArrayList<>();
        preSearch(root, preList);
        postSearch(root, postList);


        for (int i = 0; i < nodeinfo.length; i++) {
            answer[0][i] = preList.get(i);
            answer[1][i] = postList.get(i);
        }


        return answer;
    }

    public static void preSearch(Node node, List<Integer> returnList) {
        if (node == null)
            return;
        returnList.add(node.index);
        preSearch(node.left, returnList);
        preSearch(node.right, returnList);
    }

    public static void postSearch(Node node, List<Integer> returnList) {
        if (node == null)
            return;
        postSearch(node.left, returnList);
        postSearch(node.right, returnList);
        returnList.add(node.index);
    }

}
