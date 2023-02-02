package co.edu.icesi.functional;

import lambda.LambdaHelper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LambdaTest {

    private LambdaHelper lambdaHelper = new LambdaHelper();

//4 TIPOS DE FUNCTIONAL INTERFACES

//se debe usar parentesis para varios parametros, van vacíos cuando no se recibe nada (x,y,z) -> x.concat(" world!"
//Evitar usar corchetes para funciones largas, mejor hacerlas aparte
    @Test
    public void testFunction(){
        String result = lambdaHelper.stringFunctionMethod ( x -> x.concat(" world!") );
        assertEquals("Hello world!", result);
    }
//No reciben parametros, pero sí retornan valores, son generadoras de valores
    @Test
    public void testSupplier(){
        String result = lambdaHelper.stringSupplierMethod( () -> "Hello world!");
        assertEquals("Hello world!", result);
    }
//Funciones que procesan valores, pero no tienen retorno
    @Test
    public void testConsumer(){
        lambdaHelper.consumerMethod(System.out::println);
    }
//Para colocar condiciones, las valida
    @Test
    public void testPredicate(){
        assertTrue(lambdaHelper.predicateMethod( x -> x.equals("Hello world!") ));
    }

}
