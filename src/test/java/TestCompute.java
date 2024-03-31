import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class TestCompute {
  Compute c;

  @Test
  public void example() {
    MessageQueue mq = mock(MessageQueue.class);
    c = new Compute(mq);
    assertTrue(true);
  }

  @Test
  public void testCountNumberOfOccurrences() {
    MessageQueue mq = new MessageQueue() {
      private String[] elements = {"a", "b", "a", "c", "a"};

      @Override
      public String getAt(int i) {
        if (i >= 0 && i < elements.length) {
          return elements[i];
        }
        return null;
      }

      @Override
      public boolean contains(String s) {
        for (String element : elements) {
          if (element.equals(s)) {
            return true;
          }
        }
        return false;
      }

      @Override
      public int size() {
        return elements.length;
      }
    };

    Compute compute = new Compute(mq);

    assertEquals(3, compute.countOccurrences("a"));
    assertEquals(1, compute.countOccurrences("b"));
    assertEquals(1, compute.countOccurrences("c"));
    assertEquals(0, compute.countOccurrences("d"));
  }
  @Test
  public void testEmpty() {
    MessageQueue mq = new MessageQueue() {
      private String[] elements = {};

      @Override
      public String getAt(int i) {
        if (i >= 0 && i < elements.length) {
          return elements[i];
        }
        return null;
      }

      @Override
      public boolean contains(String s) {
        for (String element : elements) {
          if (element.equals(s)) {
            return true;
          }
        }
        return false;
      }

      @Override
      public int size() {
        return elements.length;
      }
    };

    Compute compute = new Compute(mq);

    assertEquals(-1, compute.countOccurrences("a"));

  }
}