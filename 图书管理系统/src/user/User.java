package user;

import operation.IOperation;

public abstract class User {
    public String name;
    public IOperation[] operations;

    public User(String name){
        this.name=name;
    }

    public abstract int menu();

    public IOperation[] getOperations() {
        return operations;
    }
}
