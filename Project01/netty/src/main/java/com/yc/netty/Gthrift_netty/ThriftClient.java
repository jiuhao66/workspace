package com.yc.netty.Gthrift_netty;

import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import thrift.generated.Person;
import thrift.generated.PersonService;

/**
 * @author LX
 * @date 2019/4/3 - 19:20
 */
public class ThriftClient {

    public static void main(String[] args) throws TTransportException {

        TSocket tSocket = new TSocket("localhost",8899);

        tSocket.setTimeout(6000);

        TTransport tTransport = new TFramedTransport(tSocket);

        TProtocol protocol = new TCompactProtocol(tTransport);

        PersonService.Client client = new PersonService.Client(protocol);

        try {

            tTransport.open();

            Person person = client.getPersonByUserName("张三");

            System.out.println(person.getName());

            System.out.println(person.getId());

            System.out.println(person.isMarried());

            System.out.println("-----------------");

           /* Person person1 = new Person();

            person1.setId(10);

            person1.setName("王五");

            person1.setMarried(false);

            client.setPerson(person1);*/

        }catch (Exception e){

            e.printStackTrace();
        }finally {
            tTransport.close();
        }

    }
}
