package reflect.Test;

/**
 * @author LX
 * @date 2019/3/16 - 21:28
 */
public class A {

    private String email ;

    private String addr ;

    @Override
    public String toString() {
        return "A{" +
                "email='" + email + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
