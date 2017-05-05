import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * Created by HiekmaHe on 05.05.2017.
 */
public class DebuggerOtherwiseTest
{
	@Test
	public void testMurmur() {
		assertThrows(
				AssertionFailedError.class, () ->
						Debugger.expect(false).toBeTrue().otherwiseMurmur());
	}

	@Test
	public void testComplain() {
		assertThrows(
				AssertionFailedError.class, () ->
						Debugger.expect(false).toBeTrue().otherwiseComplain());
	}

	@Test
	public void testAnnounce() {
		assertThrows(
				AssertionFailedError.class, () ->
						Debugger.expect(false).toBeTrue().otherwiseAnnounce("hello"));
	}
}
