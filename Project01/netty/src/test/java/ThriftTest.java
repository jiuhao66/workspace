import com.yc.netty.Aexample.TestServer;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import thrift.generated.DataException;
import thrift.generated.Person;
import thrift.generated.PersonService;

/**
 * @author LX
 * @date 2019/5/13 - 20:39
 */
public class ThriftTest {

    public static void main(String[] args) {

        TTransport transport = new TSocket("127.0.0.1",8899);

        try {
            transport.open();

            TProtocol tProtocol = new TBinaryProtocol(transport);

            PersonService.Client client = new PersonService.Client(tProtocol);

            Person person = client.getPersonByUserName("李鑫");

            System.out.println(person.getName());
            System.out.println(person.getId());


        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (DataException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }
    }
}
