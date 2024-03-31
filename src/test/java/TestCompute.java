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
    // Mock implementation of MessageQueue for testing purposes
    MessageQueue mq = new MessageQueue() {
      private String[] elements = {"apple", "banana", "apple", "orange", "apple"};

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

    // Create an instance of Compute with the mocked MessageQueue
    Compute compute = new Compute(mq);

    // Test cases
    assertEquals(3, compute.countNumberOfOccurrences("apple")); // Expecting 3 occurrences of "apple"
    assertEquals(1, compute.countNumberOfOccurrences("banana")); // Expecting 1 occurrence of "banana"
    assertEquals(1, compute.countNumberOfOccurrences("orange")); // Expecting 1 occurrence of "orange"
    assertEquals(0, compute.countNumberOfOccurrences("grape")); // Expecting 0 occurrence of "grape"
  }
  @Test
  public void testEmpty() {
    // Mock implementation of MessageQueue for testing purposes
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

    // Create an instance of Compute with the mocked MessageQueue
    Compute compute = new Compute(mq);

    // Test cases
    assertEquals(-1, compute.countNumberOfOccurrences("apple")); // Expecting 3 occurrences of "apple"
  }
}