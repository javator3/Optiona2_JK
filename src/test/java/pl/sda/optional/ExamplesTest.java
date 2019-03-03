package pl.sda.optional;

import org.junit.Test;

import static org.junit.Assert.*;
import java.util.Optional;
import java.util.OptionalLong;

public class ExamplesTest {

    @Test
    public void whenCreateEmptyOptional_thenReturntrue(){

        Optional<String> empty = Optional.empty();
        assertFalse(empty.isPresent());

    }

    @Test
    public void givenNonNull(){
        String name = "testowa wartość";
        Optional<String> opt = Optional.of(name);
        assertEquals("Optional[testowa wartość]", opt.toString());
    }

    @Test(expected = NullPointerException.class) //ta właściwośc nad testem mówi nam ze oczekuje wyrzucenie nullpointer Exception.
    public void givenNull_whenErrorOnCreate_thenCorrect(){
        String name = null;
        Optional<String> opt = Optional.of(name);
    }

    @Test
    public void givenNull_whenCreateNullable_thenCorrect(){
        String name = null;
        Optional<String> opt = Optional.ofNullable(name);
        assertEquals("Optional.empty", opt.toString());
    }

    @Test
    public void givenOptional_whenIfPresentOK_thebCorrect(){

//        Optional<String> name = Optional.of("Maciej");
        Optional<String> name = Optional.ofNullable(null);

        name.ifPresent(n -> System.out.println("Witaj " + n));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenOrElseWorks_thenCorrect(){
        String name = null;
        String name2 = "Kinga";

        String goodName = Optional.ofNullable(name).orElse("Nowe imie");
        String goodName2 = Optional.ofNullable(name2).orElse("Nowe imie");

        Optional<String> opt = Optional.of("Wartosc");
        opt.get();
        System.out.println(opt);


        assertEquals("Nowe imie", goodName);
        assertEquals("Kinga", goodName2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenOrElseWorksWithException_thenCorrect(){
        String name = null;
        String name2 = null;

        String goodName = Optional.ofNullable(name).orElseThrow(() -> new IllegalArgumentException());
        String goodName2 = Optional.ofNullable(name2).orElseThrow(IllegalArgumentException::new);
    }

}