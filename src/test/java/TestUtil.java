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
  public void singleArgs() {
    assertFalse(c.compute(1));
  }

  @Test
  public void evenNumberOfArgs() {
    assertFalse(c.compute(2, 4));
  }

  @Test
  public void sumDivisibleByArgs() {
    assertTrue(c.compute(3, 4, 5));
  }

  @Test(expected = RuntimeException.class)
  public void zeroArgs() {
    c.compute(3, 0, 5);
  }

  @Test
  public void noArgs() {
    assertFalse(c.compute());
  }

  @Test
  public void oddNumberOfArgs() {
    assertTrue(c.compute(2,4,6));
  }

  @Test
  public void sumNotDivisibleByArgs() {
    assertFalse(c.compute(3, 5, 6));
  }
}