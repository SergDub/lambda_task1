import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Calculator {
    public interface Supplier<T> {
        T get();
    }

    static Supplier<Calculator> instance = Calculator::new;
    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;

    // так как y=0 выводится ошибка "деление на ноль", необходимо обработать данное исключение
    BinaryOperator<Integer> devide = (x, y) ->
    {
        try {
            if (y == 0)
                throw new ArithmeticException("Exception: divide by zero.");
            return x / y;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage()); // Вывести сообщение
            return 0;
        }
    };

        //     (y != 0) ? x / y : 0;
        UnaryOperator<Integer> pow = x -> x * x;
        UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

        Predicate<Integer> isPositive = x -> x > 0;
        Consumer<Integer> println = System.out::println;
    }
