package operation;

import book.BookLinkedList;

public class ExitOperation implements IOperation {
    @Override
    public void work(BookLinkedList bookLinkedList) {
        System.out.println("欢迎下次光临");
        System.exit(0);
    }
}
