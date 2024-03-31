import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class TestUtil {
  Util c;

  @Before
  public void setUp() { c = new Util(); }

  @Test
  public void example() { assertTrue(true); }
  @Test
  public void testSingleArgument() {
    assertFalse(c.compute(5));
  }

  @Test
  public void testEvenNumberOfArguments() {
    assertFalse(c.compute(2, 4));
  }

  @Test
  public void testSumDivisibleByArgument() {
    assertTrue(c.compute(3, 4, 5));
  }

  @Test(expected = RuntimeException.class)
  public void testZeroArgument() {
    c.compute(3, 0, 5);
  }

  @Test
  public void testNoArgument() {
    assertFalse(c.compute());
  }

  @Test
  public void testOddNumberOfArguments() {
    assertTrue(c.compute(2,4,6));
  }

  @Test
  public void testSumNotDivisibleByArgument() {
    assertFalse(c.compute(3, 5, 6));
  }
}