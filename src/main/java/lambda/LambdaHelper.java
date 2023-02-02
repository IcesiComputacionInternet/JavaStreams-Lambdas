package lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaHelper {


    public String stringFunctionMethod(Function<String, String> function){
        return function.apply("Hello");
    }

    public String stringSupplierMethod(Supplier<String> supplier){
        return supplier.get();
    }

    public void consumerMethod(Consumer<String> consumer){
        consumer.accept("Hello World!");
    }

    public boolean predicateMethod(Predicate<String> predicate){
        return predicate.test("Hello world!");
    }

}
