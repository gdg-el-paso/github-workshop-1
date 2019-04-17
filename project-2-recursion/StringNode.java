
/*
 * GDG El Paso Github Workshop
 * Purpose: To practice insertion sort and merge sort using arrays
 * Last Modified: 17 April 2019
 */

public class StringNode {
  public String head;
  public StringNode next; // Points to next node

  StringNode() {
  }

  StringNode(String s) {
    head = s; // head node
  }

  StringNode(String s, StringNode tail) {
    head = s;
    next = tail; // points "next" node to a (new) tail node
  }
}
