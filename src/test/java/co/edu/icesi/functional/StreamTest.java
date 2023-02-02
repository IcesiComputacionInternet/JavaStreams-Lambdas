package co.edu.icesi.functional;

import co.edu.icesi.model.IcesiUser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {


    @Test
    public void testStreamMap(){
        List<String> lastNames = defaultIcesiUsers().stream().map(IcesiUser::getLastName).toList();
        assertEquals("Doe", lastNames.get(0));
    }

    @Test
    public void testStreamFilter(){
        List<IcesiUser> filteredUsers = defaultIcesiUsers().stream().filter(IcesiUser::isActive).toList();
        assertTrue(filteredUsers.get(0).isActive());

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
        icesiUsers.add(icesiUser1);
        IcesiUser icesiUser2 = defaultIcesiUser();
        icesiUser2.setLastName("Doenson");
        icesiUsers.add(icesiUser2);
        IcesiUser icesiUser3 = defaultIcesiUser();
        icesiUser3.setActive(false);
        icesiUsers.add(icesiUser3);
        IcesiUser icesiUser4 = defaultIcesiUser();
        icesiUser4.setId(4);
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
