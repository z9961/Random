package bean;

import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

public class ExerciseTest {


    @Test
    public void getList() {
        Exercise exercise = new Exercise();
        List<Expression> list = exercise.getList();
        assertEquals(list.size(), 50);
    }

    @Test
    public void getList2() {
        Exercise exercise = new Exercise();
        List<Expression> list = exercise.getList(1, 10);
        for (int i = 0; i < list.size(); i++) {
            Expression expression = list.get(i);
            assertEquals(expression.getOperator(), "+");
        }
        assertEquals(list.size(), 10);
    }

    @Test
    public void getList3() {
        Exercise exercise = new Exercise();
        List<Expression> list = exercise.getList(2, 20);
        for (int i = 0; i < list.size(); i++) {
            Expression expression = list.get(i);
            assertEquals(expression.getOperator(), "-");
        }
        assertEquals(list.size(), 20);
    }

    @Test
    public void getList4() {
        Exercise exercise = new Exercise();
        List<Expression> list = exercise.getList(3, 30);
        for (int i = 0; i < list.size(); i++) {
            Expression expression = list.get(i);
            assertThat(expression.getOperator(), either(containsString("-")).or(containsString("+")));
        }
        assertEquals(list.size(), 30);
    }

    @Test
    public void getList5() {
        Exercise exercise = new Exercise();
        List<Expression> list = exercise.getList(4, 40);
        for (int i = 0; i < list.size(); i++) {
            Expression expression = list.get(i);
            assertThat(expression.getOperator(), anyOf(containsString("+"), containsString("-"), containsString("*"), containsString("/")));
        }
        assertEquals(list.size(), 40);
    }


}