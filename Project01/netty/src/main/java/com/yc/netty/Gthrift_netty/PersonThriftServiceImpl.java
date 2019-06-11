package com.yc.netty.Gthrift_netty;


import org.apache.thrift.TException;
import thrift.generated.DataException;
import thrift.generated.Person;
import thrift.generated.PersonService;

/**
 * @author LX
 * @date 2019/4/2 - 21:55
 */
public class PersonThriftServiceImpl implements PersonService.Iface {


    @Override
    public Person getPersonByUserName(String username) throws DataException, TException {
        System.out.println("Got Client Param: "+username);

        Person person = new Person();

        System.out.println(username);

        person.setName("陈6");

        person.setMarried(true);

        person.setId(20);

        return person;
    }

    @Override
    public void setPerson(Person person) throws DataException, TException {

        System.out.println("Got Client Param:");

        System.out.println(person.getName());

        System.out.println(person.getId());

        System.out.println(person.isMarried());
    }


}
