package menutest.pojo;

/**
 * @author LX
 * @date 2018/11/18 - 18:08
 */
public class Account {

    private int id;
    private String name;
    private String pwd;
    private double amount;

    public Account() {
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", amount=" + amount +
                '}';
    }

    public Account(int id, String name) {

        this.id = id;
        this.name = name;
    }

    public Account(int id, String pwd, double amount) {

        this.id = id;
        this.pwd = pwd;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
