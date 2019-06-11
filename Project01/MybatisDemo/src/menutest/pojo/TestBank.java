package menutest.pojo;

/**
 * @author LX
 * @date 2018/11/27 - 23:45
 */
public class TestBank {
    private int id1;
    private String name1;
    private String pwd1;

    @Override
    public String toString() {
        return "TestBank{" +
                "id1=" + id1 +
                ", name1='" + name1 + '\'' +
                ", pwd1='" + pwd1 + '\'' +
                ", balance1=" + balance1 +
                '}';
    }

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getPwd1() {
        return pwd1;
    }

    public void setPwd1(String pwd1) {
        this.pwd1 = pwd1;
    }

    public double getBalance1() {
        return balance1;
    }

    public void setBalance1(double balance1) {
        this.balance1 = balance1;
    }

    private  double balance1;
}
