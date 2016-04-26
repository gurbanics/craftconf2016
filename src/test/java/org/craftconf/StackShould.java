package org.craftconf;

import org.junit.Assert;
import org.junit.Test;

public class StackShould {


    @Test()
    public void throw_exception_when_popped_empty() {

        MyStack stack = new MyStack();
        try {

            stack.pop();

            Assert.fail("Exception was not thrown");

        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            Assert.assertTrue(true);
            return;
        }
    }

    @Test
    public void pop_the_same_element_right_after_push() {

        Object element = new Object();
        MyStack stack = new MyStack();

        stack.push(element);

        Assert.assertEquals(element, stack.pop());
    }
}
