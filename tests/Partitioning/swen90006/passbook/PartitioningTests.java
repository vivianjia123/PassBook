package swen90006.passbook;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PartitioningTests {
	protected PassBook pb;

	// Any method annotated with "@Before" will be executed before each test,
	// allowing the tester to set up some shared resources.
	@Before
	public void setUp() {
		pb = new PassBook();
	}

	// Any method annotated with "@After" will be executed after each test,
	// allowing the tester to release any shared resources used in the setup.
	@After
	public void tearDown() {
	}

	@Test(expected = DuplicateUserException.class)
	public void addUser_EC1TestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = "properPassphrase1";
		pb.addUser(username, passphrase);
		pb.addUser(username, passphrase);
	}

	@Test(expected = WeakPassphraseException.class)
	public void addUser_EC2TestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = "abCD567";
		pb.addUser(username, passphrase);
	}

	@Test(expected = WeakPassphraseException.class)
	public void addUser_EC3TestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = "AAA11111";
		pb.addUser(username, passphrase);
	}

	@Test(expected = WeakPassphraseException.class)
	public void addUser_EC4TestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = "aaa11111";
		pb.addUser(username, passphrase);
	}

	@Test(expected = WeakPassphraseException.class)
	public void addUser_EC5TestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = "aaaaAAAA";
		pb.addUser(username, passphrase);
	}

	@Test(expected = WeakPassphraseException.class)
	public void addUser_EC6TestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = "11111111";
		pb.addUser(username, passphrase);
	}

	@Test(expected = WeakPassphraseException.class)
	public void addUser_EC7TestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = "AAAAAAAA";
		pb.addUser(username, passphrase);
	}

	@Test(expected = WeakPassphraseException.class)
	public void addUser_EC8TestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = "aaaaaaaa";
		pb.addUser(username, passphrase);
	}

	@Test(expected = WeakPassphraseException.class)
	public void addUser_EC9TestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = "``{{@[[/:";
		pb.addUser(username, passphrase);
	}

	@Test
	public void addUser_EC10TestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = "properPassphrase1";
		pb.addUser(username, passphrase);
		assertTrue(pb.isUser(username));
	}

	@Test(expected = NoSuchUserException.class)
	public void loginUser_EC1TestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = "properPassphrase1";
		pb.loginUser(username, passphrase);
	}

	@Test(expected = AlreadyLoggedInException.class)
	public void loginUser_EC2TestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = "properPassphrase1";
		pb.addUser(username, passphrase);
		pb.loginUser(username, passphrase);
		pb.loginUser(username, passphrase);
	}

	@Test(expected = IncorrectPassphraseException.class)
	public void loginUser_EC3TestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase1 = "properPassphrase1";
		String passphrase2 = "properPassphrase2";
		pb.addUser(username, passphrase1);
		pb.loginUser(username, passphrase2);
	}

	@Test
	public void loginUser_EC4TestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase1 = "properPassphrase1";
		pb.addUser(username, passphrase1);
		int s = pb.loginUser(username, passphrase1);
		pb.logoutUser(s);
		assertFalse(s >= Integer.MAX_VALUE);
	}

	@Test
	public void loginUser_EC5TestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase1 = "properPassphrase1";
		pb.addUser(username, passphrase1);
		int s = pb.loginUser(username, passphrase1);
		pb.logoutUser(s);
		assertFalse(s < 0);
	}

	@Test
	public void loginUser_B6TestCase() throws Throwable {
		String username = getRandomString(20);
		String passphrase1 = "properPassphrase1";
		int limit = 1000000;
		int i = 0;
		while (username != null && passphrase1 != null && i <= limit) {
			pb.addUser(username, passphrase1);
			int s = pb.loginUser(username, passphrase1);
			i++;
			username = getRandomString(20);
			assertTrue(s >= 0 && s < Integer.MAX_VALUE);
		}
	}

	@Test(expected = InvalidSessionIDException.class)
	public void updateDetails_EC1TestCase() throws Throwable {
		URL url = new URL("http://1234.com");
		String urlUsername = "urlUsername";
		String urlPassword = "urlPassword1";
		pb.addUser(urlUsername, urlPassword);
		int s = pb.loginUser(urlUsername, urlPassword);
		pb.logoutUser(s);
		pb.updateDetails(s, url, urlUsername, urlPassword);
	}

	@Test(expected = MalformedURLException.class)
	public void updateDetails_EC2TestCase() throws Throwable {
		URL url = new URL("htttp://1234.com");
		String urlUsername = "urlUsername";
		String urlPassword = "urlPassword1";
		pb.addUser(urlUsername, urlPassword);
		int s = pb.loginUser(urlUsername, urlPassword);
		pb.updateDetails(s, url, urlUsername, urlPassword);
	}

	@Test(expected = NoSuchURLException.class)
	public void updateDetails_EC3TestCase() throws Throwable {
		URL url = new URL("http://1234.com");
		String username = "passbookUsername";
		String urlUsername = null;
		String urlPassword = "urlPassword1";
		pb.addUser(username, urlPassword);
		int s = pb.loginUser(username, urlPassword);

		pb.updateDetails(s, url, urlUsername, urlPassword);
		pb.retrieveDetails(s, url);
	}

	@Test(expected = NoSuchURLException.class)
	public void updateDetails_EC4TestCase() throws Throwable {
		URL url = new URL("http://1234.com");
		String passphrase = "properPassphrase1";
		String urlUsername = "urlUsername";
		String urlPassword = null;
		pb.addUser(urlUsername, passphrase);
		int s = pb.loginUser(urlUsername, passphrase);

		pb.updateDetails(s, url, urlUsername, urlPassword);
		pb.retrieveDetails(s, url);
	}

	@Test(expected = NoSuchURLException.class)
	public void updateDetails_EC5TestCase() throws Throwable {
		URL url = new URL("http://1234.com");
		String username = "passbookUsername";
		String passphrase = "properPassphrase1";
		String urlUsername = null;
		String urlPassword = null;
		pb.addUser(username, passphrase);
		int s = pb.loginUser(username, passphrase);

		pb.updateDetails(s, url, urlUsername, urlPassword);
		pb.retrieveDetails(s, url);

	}

	@Test
	public void updateDetails_EC6TestCase() throws Throwable {
		URL url = new URL("http://1234.com");
		String username = "passbookUsername";
		String passphrase = "properPassphrase1";
		String urlUsername = "urlUsername";
		String urlPassword = "urlPassword1";
		pb.addUser(username, passphrase);
		int s = pb.loginUser(username, passphrase);

		pb.updateDetails(s, url, urlUsername, urlPassword);
		assertTrue((pb.retrieveDetails(s, url)) != null);

	}

	@Test(expected = InvalidSessionIDException.class)
	public void retrieveDetails_EC1TestCase() throws Throwable {
		URL url = new URL("http://1234.com");
		String urlUsername = "urlUsername";
		String urlPassword = "urlPassword1";
		pb.addUser(urlUsername, urlPassword);
		int s = pb.loginUser(urlUsername, urlPassword);
		pb.updateDetails(s, url, urlUsername, urlPassword);
		pb.logoutUser(s);
		pb.retrieveDetails(s, url);
	}

	@Test(expected = MalformedURLException.class)
	public void retrieveDetails_EC2TestCase() throws Throwable {
		URL url1 = new URL("http://1234.com");
		URL url2 = new URL("htttp://1234.com");
		String urlUsername = "urlUsername";
		String urlPassword = "urlPassword1";
		pb.addUser(urlUsername, urlPassword);
		int s = pb.loginUser(urlUsername, urlPassword);
		pb.updateDetails(s, url1, urlUsername, urlPassword);
		pb.retrieveDetails(s, url2);
	}

	@Test(expected = NoSuchURLException.class)
	public void retrieveDetails_EC3TestCase() throws Throwable {
		URL url = new URL("http://1234.com");
		String urlUsername = "urlUsername";
		String urlPassword = "urlPassword1";
		pb.addUser(urlUsername, urlPassword);
		int s = pb.loginUser(urlUsername, urlPassword);
		pb.retrieveDetails(s, url);
	}

	@Test(expected = NoSuchURLException.class)
	public void retrieveDetails_EC4TestCase() throws Throwable {
		URL url = new URL("http://1234.com");
		URL url2 = new URL("http://12345.com");
		String urlUsername = "urlUsername";
		String urlPassword = "urlPassword1";
		pb.addUser(urlUsername, urlPassword);
		int s = pb.loginUser(urlUsername, urlPassword);
		pb.updateDetails(s, url, urlUsername, urlPassword);
		pb.retrieveDetails(s, url2);
	}

	@Test
	public void retrieveDetails_EC5TestCase() throws Throwable {
		URL url = new URL("http://1234.com");
		String urlUsername = "urlUsername";
		String urlPassword = "urlPassword1";
		pb.addUser(urlUsername, urlPassword);
		int s = pb.loginUser(urlUsername, urlPassword);
		pb.updateDetails(s, url, urlUsername, urlPassword);
		assertTrue((pb.retrieveDetails(s, url)) != null);
	}

	// helper function
	// reference:
	// https://www.geeksforgeeks.org/generate-random-string-of-given-size-in-java/
	static String getRandomString(int n) {

		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}
		return sb.toString();
	}

}
