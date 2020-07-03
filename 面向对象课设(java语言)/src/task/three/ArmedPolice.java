package task.three;

public class ArmedPolice extends Police implements Employee{
    private String armyName;
    private String grade;
    public ArmedPolice(int pno, String name, int money,String armyName,String grade) {
        super(pno, name, money);
        this.armyName=armyName;
        this.grade=grade;
    }

    public String getArmyName() {
        return armyName;
    }

    public void setArmyName(String armyName) {
        this.armyName = armyName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public void high() {
        super.setMoney((super.getMoney()+super.getMoney()*0.3));
    }

}
