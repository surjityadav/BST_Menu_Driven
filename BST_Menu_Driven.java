
import java.util.Scanner;

class Node3 {
int key;
Node3 left;
Node3 right;

Node3(int d) {
key = d;
left = right = null;
}
}

public class BST_Menu_Driven {
static Node3 root;

public BST_Menu_Driven() {
root = null;
}

public static void inorder(Node3 root) {
if (root != null) {
inorder(root.left);
System.out.println(root.key);
inorder(root.right);
}
return;
}
public static void preOrder(Node3 root)
{
if(root!=null)
{
System.out.println(root.key);
preOrder(root.left);
preOrder(root.right);
}
return;
}
public static void postOrder(Node3 root)
{
if(root!=null)
{
postOrder(root.left);
postOrder(root.right);
System.out.println(root.key);
}
return;
}

public static void search(int key) {
searchitem(root, key);
}

public static void searchitem(Node3 root, int key) {
if (root == null) {
System.out.println("Element not found");
} else if (root.key == key) {
System.out.println("Key found");
} else if (root.key > key) {
searchitem(root.left, key);
} else {
searchitem(root.right, key);
}
}

public static void insert1(int key) {
root = insert(root, key);
}

public static Node3 insert(Node3 root, int key) {
if (root == null) {
root = new Node3(key);
return root;
} else if (key < root.key) {
root.left = insert(root.left, key);
} else if (key > root.key) {
root.right = insert(root.right, key);
}
return root;
}

public static int height(Node3 root) {
int count = 0, count2 = 0;

if (root == null) {
return 0;
} else if (root.left != null) {
count++;
height(root.left);
} else if (root.right != null) {
count2++;
height(root.right);
}
if (count > count2)
return count;
else
return count2;
}

public static void main(String arg[]) {
BST_Menu_Driven tr = new BST_Menu_Driven();
Scanner sc = new Scanner(System.in);
System.out.println("BINARY SEARCH TREE:-");
char num = 'y';
while (num != 'n') 
{
    System.out.println("1) INSERT ELEMENT IN TREE:-");
    System.out.println("2) SEARCH ELEMENT IN TREE:-");
    System.out.println("3) GET HEIGHT OF TREE");
    System.out.println("4) DISPLAY THE TREE INORDER");
    System.out.println("5) DISPLAY THE TREE PREORDER");
    System.out.println("6) DISPLAY THE TREE POSTORDER");
    
    System.out.println("Enter your choice");
    int option = sc.nextInt();
    switch (option) 
    {
        case 1:
            System.out.println("Enter the elements you want to add");
            int element = sc.nextInt();
            insert1(element);
        break;
        case 2:
            System.out.println("Enter the element you want to search");
            int selement = sc.nextInt();
            search(selement);
        break;
        case 3:
            System.out.println("Height of tree will be :-");
            height(root);
        break;
        case 4:
            System.out.println("Inorder of Binary search tree is");
            inorder(root);
        break;
        case 5:
            System.out.println("preorder of Binary search tree is");
            preOrder(root);
        break;
        case 6:
            System.out.println("postorder of Binary search tree is");
            postOrder(root);
        break;
        
    }
System.out.println("DO YOU WANT TO CONTINUE");
System.out.println("y/n");
num = sc.next().charAt(0);
}
}
}