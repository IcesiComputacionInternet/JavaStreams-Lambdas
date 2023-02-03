package co.edu.icesi.functional;

import co.edu.icesi.model.IcesiUser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamTest {


    @Test
    public void testCheckOrderStreamMap(){
        List<String> lastNames = defaultIcesiUsers().stream().map(IcesiUser::getLastName).toList();

        String lastName1 = "Trochez";
        String lastName2 = "Lopez";
        String lastName3 = "Corrales";
        String lastName4 = "Martinez";

        assertEquals(lastName1, lastNames.get(0));
        assertEquals(lastName2, lastNames.get(1));
        assertEquals(lastName3, lastNames.get(2));
        assertEquals(lastName4, lastNames.get(3));
    }

    @Test
    public void testStreamFilter(){
        List<IcesiUser> filteredUsers = defaultIcesiUsers().stream().filter(IcesiUser::isActive).toList();

    }

    @Test
    public void testStreamFlatMap(){
        List<List<IcesiUser>> listOfListOfIcesiUsers = List.of(defaultIcesiUsers(),defaultIcesiUsers());
        List<IcesiUser> result = listOfListOfIcesiUsers.stream().flatMap(Collection::stream).toList();
    }

    @Test
    public void testStreamReduce(){
        String names = defaultIcesiUsers().stream().map(IcesiUser::getName).reduce("", (concatenatedValue, nextValue) -> concatenatedValue.concat("," + nextValue));

    }

    @Test
    public void testStream(){

    }


    private List<IcesiUser> defaultIcesiUsers() {
        List<IcesiUser> icesiUsers = new ArrayList<>();
        IcesiUser icesiUser1 = defaultIcesiUser();
        icesiUser1.setLastName("Trochez");
        icesiUsers.add(icesiUser1);

        IcesiUser icesiUser2 = defaultIcesiUser();
        icesiUser2.setLastName("Lopez");
        icesiUsers.add(icesiUser2);

        IcesiUser icesiUser3 = defaultIcesiUser();
        icesiUser3.setActive(false);
        icesiUser3.setLastName("Corrales");
        icesiUsers.add(icesiUser3);

        IcesiUser icesiUser4 = defaultIcesiUser();
        icesiUser4.setId(4);
        icesiUser4.setLastName("Martinez");
        icesiUsers.add(icesiUser4);

        return icesiUsers;
    }

    private IcesiUser defaultIcesiUser() {
        IcesiUser icesiUser = new IcesiUser();
        icesiUser.setActive(true);
        icesiUser.setId(1);
        icesiUser.setName("John");
        icesiUser.setLastName("Doe");
        return icesiUser;
    }


}
