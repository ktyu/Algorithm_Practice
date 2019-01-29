import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        // 노드 리스트 생성 후 초기화
        TreeNode[] nodeList = new TreeNode[n];
        for(int i=0; i<n; i++)
            nodeList[i] = new TreeNode((char) (i+'A'));

        // 입력받아서 트리 저장
        String line;
        for(int i=0; i<n; i++) {
            line = sc.nextLine();

            if(line.charAt(2) != '.')
                nodeList[line.charAt(0) - 'A'].left = nodeList[line.charAt(2) - 'A'];

            if(line.charAt(4) != '.')
                nodeList[line.charAt(0) - 'A'].right = nodeList[line.charAt(4) - 'A'];
        }


        // 순회하면서 출력
        preOrder(nodeList, 0);
        System.out.print('\n');

        inOrder(nodeList, 0);
        System.out.print('\n');

        postOrder(nodeList, 0);
        System.out.print('\n');

    }

    public static void preOrder(TreeNode[] nodeList, int idx) {
        System.out.print(nodeList[idx].name);
        if(nodeList[idx].left != null)
            preOrder(nodeList, nodeList[idx].left.name - 'A');
        if(nodeList[idx].right != null)
            preOrder(nodeList, nodeList[idx].right.name - 'A');
    }

    public static void inOrder(TreeNode[] nodeList, int idx) {
        if(nodeList[idx].left != null)
            inOrder(nodeList, nodeList[idx].left.name - 'A');
        System.out.print(nodeList[idx].name);
        if(nodeList[idx].right != null)
            inOrder(nodeList, nodeList[idx].right.name - 'A');
    }

    public static void postOrder(TreeNode[] nodeList, int idx) {
        if(nodeList[idx].left != null)
            postOrder(nodeList, nodeList[idx].left.name - 'A');
        if(nodeList[idx].right != null)
            postOrder(nodeList, nodeList[idx].right.name - 'A');
        System.out.print(nodeList[idx].name);
    }


}

class TreeNode {
    char name;
    TreeNode left;
    TreeNode right;

    TreeNode(char name) {
        this.name = name;
    }
}