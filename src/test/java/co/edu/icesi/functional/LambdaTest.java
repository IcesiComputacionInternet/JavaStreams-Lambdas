package co.edu.icesi.functional;

import lambda.LambdaHelper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LambdaTest {

    private LambdaHelper lambdaHelper = new LambdaHelper();


    @Test
    public void testFunction(){
        String result = lambdaHelper.stringFunctionMethod ( x -> x.concat(" world!") );
        assertEquals("Hello world!", result);
    }

    @Test
    public void testSupplier(){
        String result = lambdaHelper.stringSupplierMethod( () -> "Hello world!");
        assertEquals("Hello world!", result);
    }

    @Test
    public void testConsumer(){
        lambdaHelper.consumerMethod(System.out::println);
    }

    @Test
    public void testPredicate(){
        assertTrue(lambdaHelper.predicateMethod( x -> x.equals("Hello world!") ));
    }



}
