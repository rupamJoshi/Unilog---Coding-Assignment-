class Node<T>{
    T data;
    Node<T> previous;
    Node<T> next;
}

class DoublyLinkedList<T> {
    Node<T> start = null;
    Node<T> end = null;

    public void addNewNodeAtTheEnd(T data) {
        Node<T> newNode = new Node<T>();
        newNode.data = data;
        newNode.previous = null;
        newNode.next = null;
        if (start == null) {
            start = newNode;
            end = newNode;
        } else {
            end.next = newNode;
            newNode.previous = end;
            end = newNode;
        }
    }


    public void addNewNodeAtTheStart(T data) {
        Node<T> newNode = new Node<T>();
        newNode.data = data;
        newNode.previous = null;
        newNode.next = null;
        if (start == null) {
            start = newNode;
            end = newNode;
        } else {
            newNode.next = start;
            start.previous = newNode;
            start = newNode;
        }
    }

    public void removeNodeAtTheStart() {
        if (start == null) {
            System.out.println("Invalid Operation");
        } else {
            start.next.previous=null;
            start = start.next;
        }
    }
    public void removeNodeAtTheEnd() {
        if (start == null) {
            System.out.println("Invalid Operation");
        } else {
            end.previous.next=null;
            end = end.previous;
        }
    }

    public void addNewNodeAtAPosition(T data, int pos) {
        Node<T> temp = null;
        int x;
        Node<T> newNode = new Node<T>();
        newNode.data = data;
        newNode.next = null;
        newNode.previous = null;
        x = 0;
        temp = start;
        while (x < pos && temp != null) {
            temp = temp.next;
            x++;
        }
        if (temp == null) {
            if (start == null) {
                start = newNode;
                end = newNode;
            } else {
                end.next = newNode;
                newNode.previous = end;
                end = newNode;
            }
        } else {
            if (temp == start) {
                newNode.next = start;
                start.previous = newNode;
                start = newNode;
            } else {
                newNode.next = temp;
                newNode.previous = temp.previous;
                temp.previous.next = newNode;
            }
        }
    }

    public void removeNodeFromPosition(int pos) {
        Node<T> temp = null;
        int x = 0;
        if (start == null) {
            System.out.print("No Element List");
            return;
        }
        temp = start;
        while (x < pos && temp != null) {
            temp = temp.next;
            x++;
        }
        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }
        if (temp == start && temp == end) {
            start = null;
            end = null;
        } else {
            if (temp == start) {
                start = start.next;
                start.previous = null;
            } else {
                if (temp == end) {
                    end.previous.next = null;
                    end = null;
                } else {
                    temp.previous.next = temp.next;
                    temp.next.previous = temp.previous;
                }
            }
        }
    }

    public T getNodeAtIndexRecursive(Node<T> temp,int n) {
        if (temp == null) {
            return null;
        }
        if (n == 0) {
            return temp.data;
        }
        return getNodeAtIndexRecursive(temp.next, n - 1);
    }

    public T getNodeAtIndexRecursive(int n) {
        return getNodeAtIndexRecursive(start, n);
    }

    public T getNodeAtIndex(int n) {
        Node<T> temp = start;

        while (n != 0 && temp != null) {
            temp = temp.next;
            n--;
        }
        return temp.data;
    }


    public void printTheList() {
        Node<T> tempNode = start;
        while (tempNode != null) {
            System.out.println(tempNode.data);
            tempNode = tempNode.next;
        }
    }
}

class Test {
    public static void main(String arg[]) {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<Integer>();
        //Add ELEMENT AT END
        doublyLinkedList.addNewNodeAtTheEnd(23);
        doublyLinkedList.addNewNodeAtTheEnd(20);
        doublyLinkedList.addNewNodeAtTheEnd(24);
        // Add ELEMENT AT START
        doublyLinkedList.addNewNodeAtTheStart(12);
        // Show LIST
        doublyLinkedList.printTheList();
        // FIND ELEMENT
        System.out.println(" Find Element AT Index 1 By RECURSIVE METHOD : "+doublyLinkedList.getNodeAtIndexRecursive(1));
        System.out.println(" Find Element AT Index 1 By ITERATIVE METHOD : "+doublyLinkedList.getNodeAtIndex(1));
        // ADD Element at Postion
        doublyLinkedList.addNewNodeAtAPosition(34,1);
        System.out.println(" Find Element AT Index 1 By ITERATIVE METHOD : "+doublyLinkedList.getNodeAtIndex(1));
        doublyLinkedList.printTheList();
        // REMOVE Element at Postion
        doublyLinkedList.removeNodeFromPosition(1);
        System.out.println(" Find Element AT Index 1 By ITERATIVE METHOD : "+doublyLinkedList.getNodeAtIndex(1));
        doublyLinkedList.printTheList();
        // REMOVE Element at start
        doublyLinkedList.removeNodeAtTheStart();
        System.out.println(" Find Element AT Index 1 By ITERATIVE METHOD : "+doublyLinkedList.getNodeAtIndex(1));
        doublyLinkedList.printTheList();
        // REMOVE Element at end
        doublyLinkedList.removeNodeAtTheEnd();
        System.out.println(" Find Element AT Index 1 By ITERATIVE METHOD : "+doublyLinkedList.getNodeAtIndex(1));
        doublyLinkedList.printTheList();

        // TEST CASES FOR CHAR

        DoublyLinkedList<Character> doublyLinkedList2 = new DoublyLinkedList<Character>();
        //Add ELEMENT AT END
        doublyLinkedList2.addNewNodeAtTheEnd('B');
        doublyLinkedList2.addNewNodeAtTheEnd('C');
        doublyLinkedList2.addNewNodeAtTheEnd('D');
        // Add ELEMENT AT START
        doublyLinkedList2.addNewNodeAtTheStart('A');
        // Show LIST
        doublyLinkedList2.printTheList();
        // FIND ELEMENT
        System.out.println(" Find Element AT Index 1 By RECURSIVE METHOD : "+doublyLinkedList2.getNodeAtIndexRecursive(1));
        System.out.println(" Find Element AT Index 1 By ITERATIVE METHOD : "+doublyLinkedList2.getNodeAtIndex(1));
        // ADD Element at Postion
        doublyLinkedList2.addNewNodeAtAPosition('F',1);
        System.out.println(" Find Element AT Index 1 By ITERATIVE METHOD : "+doublyLinkedList2.getNodeAtIndex(1));
        doublyLinkedList2.printTheList();
        // REMOVE Element at Postion
        doublyLinkedList2.removeNodeFromPosition(1);
        System.out.println(" Find Element AT Index 1 By ITERATIVE METHOD : "+doublyLinkedList2.getNodeAtIndex(1));
        doublyLinkedList2.printTheList();
        // REMOVE Element at start
        doublyLinkedList2.removeNodeAtTheStart();
        System.out.println(" Find Element AT Index 1 By ITERATIVE METHOD : "+doublyLinkedList2.getNodeAtIndex(1));
        doublyLinkedList2.printTheList();
        // REMOVE Element at end
        doublyLinkedList2.removeNodeAtTheEnd();
        System.out.println(" Find Element AT Index 1 By ITERATIVE METHOD : "+doublyLinkedList2.getNodeAtIndex(1));
        doublyLinkedList2.printTheList();
    }
}