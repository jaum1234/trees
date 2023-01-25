import AVLTree.AVLTree;
import RedBlackTree.RedBlackTree;
import AVLTree.Node;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class AVLTreeTest
{
    private AVLTree<Integer> tree;

    @BeforeEach
    void setUp()
    {
        this.tree = new AVLTree<Integer>();
    }

    @Test
    @DisplayName("Should rotate left.")
    void shouldRotateLeft()
    {
        Node<Integer> node1 = new Node<Integer>(3);
        Node<Integer> node2 = new Node<Integer>(4);
        Node<Integer> node3 = new Node<Integer>(5);

        this.tree.root(node1);

        node1.right(node2);
        node2.parent(node1);

        node2.right(node3);
        node3.parent(node2);

        this.tree.rotateLeft(node1);

        String actualTree = this.tree.traverseInPreOrder();
        String expectedTree = "<4<3><5>>";

        assertEquals(expectedTree, actualTree);
    }

    @Test
    @DisplayName("Should rotate right.")
    void shouldRotateRight()
    {
        Node<Integer> node1 = new Node<Integer>(3);
        Node<Integer> node2 = new Node<Integer>(2);
        Node<Integer> node3 = new Node<Integer>(1);

        this.tree.root(node1);

        node1.left(node2);
        node2.parent(node1);

        node2.left(node3);
        node3.parent(node2);

        this.tree.rotateRight(node1);

        String actualTree = this.tree.traverseInPreOrder();
        String expectedTree = "<2<1><3>>";

        assertEquals(expectedTree, actualTree);
    }
}
