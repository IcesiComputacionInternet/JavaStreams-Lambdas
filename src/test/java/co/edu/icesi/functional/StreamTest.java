package co.edu.icesi.functional;

import co.edu.icesi.model.IcesiUser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StreamTest {

//forma de llamar funciones cuando el parametro corresponde con el valor que espero mapear
// IcesiUser::getLastName, clase::metodo
//Si estoy dentro de la misma clase es this::metodo

//FUNCIONES DE MAPEO, RECIBO UN VALOR Y RETORNO UN VALOR. SON PARA COLECCIONES(LISTAS, SETS)
    @Test
    public void testStreamMap(){
        List<String> lastNames = defaultIcesiUsers().stream().map(IcesiUser::getLastName).toList();
        var lastName1 = lastNames.get(0);
        var lastName2 = lastNames.get(1);
        var lastName3 = lastNames.get(2);
        var lastName4 = lastNames.get(3);
        assertEquals("Doe", lastName1);
        assertEquals("Doenson", lastName2);
        assertEquals("Lopez", lastName3);
        assertEquals("Cordoba", lastName4);
        assertTrue(lastNames.size()==4);
    }
//filtra usuarios activos, filter recibe una función que retorna una funcion
    @Test
    public void testStreamFilter(){
        List<IcesiUser> filteredUsers = defaultIcesiUsers().stream().filter(IcesiUser::isActive).toList();

    }
//A partir de listas diferentes, las une en una sola, no elimina repetidos, con distinct() pero hay que sobreescribir el equals y el hash antes es buena practica
    @Test
    public void testStreamFlatMap(){
        List<List<IcesiUser>> listOfListOfIcesiUsers = List.of(defaultIcesiUsers(),defaultIcesiUsers());
        List<IcesiUser> result = listOfListOfIcesiUsers.stream().flatMap(Collection::stream).toList();
    }
//Concatena todos los nombres, separados por coma y los coloca en un string
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
        icesiUser3.setLastName("Lopez");
        icesiUsers.add(icesiUser3);
        IcesiUser icesiUser4 = defaultIcesiUser();
        icesiUser4.setId(4);
        icesiUser4.setLastName("Cordoba");
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
