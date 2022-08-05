import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;



class ThingTest {

    Thing thing = new Thing();

    @Test
    void emptyString(){
        assertThat(thing.add("")).isEqualTo(0);
    }

    @Test
    void addOneNumber(){
        assertThat(thing.add("1")).isEqualTo(1);
    }

    @Test
    void addOneAndTwo(){
        assertThat(thing.add("1,2")).isEqualTo(3);
    }

    @Test
    void addManyNumbers(){
        assertThat(thing.add("1,2,5,4,7")).isEqualTo(19);
    }
    
    @Test
    void addWithNewLine(){
        assertThat(thing.add("1\n2,3")).isEqualTo(6);
    }

    @Test
    void addWithSemicolonAsDelimiter(){
        assertThat(thing.add("//;\n1;2")).isEqualTo(3);
    }

    @Test
    void addWithOneNegative(){
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> thing.add("-1,5"));
        assertEquals(exception.getMessage(), "negatives not allowed: -1");
    }
    
    @Test
    void addWithTwoNegatives(){
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> thing.add("-1,5,-4"));
        assertEquals(exception.getMessage(), "negatives not allowed: -1, -4");
    }
}
