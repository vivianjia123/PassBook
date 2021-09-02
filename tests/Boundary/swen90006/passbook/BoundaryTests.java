package swen90006.passbook;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

//By extending PartitioningTests, we inherit tests from the script
public class BoundaryTests extends PartitioningTests {
	// Add another test

	@Test(expected = DuplicateUserException.class)
	public void addUser_B1aTestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = "properPassphrase1";
		pb.addUser(username, passphrase);
		pb.addUser(username, passphrase);
	}

	@Test
	public void addUser_B1bTestCase() throws Throwable {
		String username = null;
		String passphrase = "properPassphrase1";
		pb.addUser(username, passphrase);
		assertTrue(pb.isUser(username));
	}

	@Test
	public void addUser_B2aTestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = "abcdEFG8";
		pb.addUser(username, passphrase);
		assertTrue(pb.isUser(username));
	}

	@Test(expected = WeakPassphraseException.class)
	public void addUser_B2bTestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = "abCD567";
		pb.addUser(username, passphrase);
	}

	@Test(expected = NullPointerException.class)
	public void addUser_B2cTestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = null;
		pb.addUser(username, passphrase);
	}

	@Test(expected = WeakPassphraseException.class)
	public void addUser_B3aTestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = "aaaaaaaa";
		pb.addUser(username, passphrase);
	}

	@Test(expected = WeakPassphraseException.class)
	public void addUser_B3bTestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = "zzzzzzzz";
		pb.addUser(username, passphrase);
	}

	@Test(expected = WeakPassphraseException.class)
	public void addUser_B3cTestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = "``ABC0123";
		pb.addUser(username, passphrase);
		assertTrue(pb.isUser(username));
	}

	@Test(expected = WeakPassphraseException.class)
	public void addUser_B3dTestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = "{{ZYX9876";
		pb.addUser(username, passphrase);
		assertTrue(pb.isUser(username));
	}

	@Test(expected = WeakPassphraseException.class)
	public void addUser_B4aTestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = "AAAAAAAA";
		pb.addUser(username, passphrase);
	}

	@Test(expected = WeakPassphraseException.class)
	public void addUser_B4bTestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = "ZZZZZZZZ";
		pb.addUser(username, passphrase);
	}

	@Test(expected = WeakPassphraseException.class)
	public void addUser_B4cTestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = "@@abc0123";
		pb.addUser(username, passphrase);
	}

	@Test(expected = WeakPassphraseException.class)
	public void addUser_B4dTestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = "[[zyx9876";
		pb.addUser(username, passphrase);
	}

	@Test(expected = WeakPassphraseException.class)
	public void addUser_B5aTestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = "00000000";
		pb.addUser(username, passphrase);
	}

	@Test(expected = WeakPassphraseException.class)
	public void addUser_B5bTestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = "99999999";
		pb.addUser(username, passphrase);
	}

	@Test(expected = WeakPassphraseException.class)
	public void addUser_B5cTestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = "///abcABC";
		pb.addUser(username, passphrase);
	}

	@Test(expected = WeakPassphraseException.class)
	public void addUser_B5dTestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = ":::xyzXYZ";
		pb.addUser(username, passphrase);
	}

	@Test(expected = WeakPassphraseException.class)
	public void addUser_B6aTestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = "aaaaAAAA";
		pb.addUser(username, passphrase);
	}

	@Test(expected = WeakPassphraseException.class)
	public void addUser_B6bTestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = "zzzzZZZZ";
		pb.addUser(username, passphrase);
	}

	@Test(expected = WeakPassphraseException.class)
	public void addUser_B7aTestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = "aaaa0000";
		pb.addUser(username, passphrase);
	}

	@Test(expected = WeakPassphraseException.class)
	public void addUser_B7bTestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = "zzzz9999";
		pb.addUser(username, passphrase);
	}

	@Test(expected = WeakPassphraseException.class)
	public void addUser_B8aTestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = "AAAA0000";
		pb.addUser(username, passphrase);
	}

	@Test(expected = WeakPassphraseException.class)
	public void addUser_B8bTestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = "ZZZZ9999";
		pb.addUser(username, passphrase);
	}

	@Test
	public void addUser_B9aTestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = "aAAAAAA0";
		pb.addUser(username, passphrase);
		assertTrue(pb.isUser(username));
	}

	@Test
	public void addUser_B9bTestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = "zZZZZZZ9";
		pb.addUser(username, passphrase);
		assertTrue(pb.isUser(username));
	}

	@Test(expected = WeakPassphraseException.class)
	public void addUser_B9cTestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = "{{{{{{{{{";
		pb.addUser(username, passphrase);
	}

	@Test(expected = WeakPassphraseException.class)
	public void addUser_B9dTestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = "/////////";
		pb.addUser(username, passphrase);
	}

	@Test
	public void addUser_B10aTestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = "bBBBBBBB1";
		pb.addUser(username, passphrase);
		assertTrue(pb.isUser(username));
	}

	@Test
	public void addUser_B10bTestCase() throws Throwable {
		String username = "passbookUsername";
		String passphrase = "yYYYYYYY8";
		pb.addUser(username, passphrase);
		assertTrue(pb.isUser(username));
	}

	@Test
	public void updateDetails_B2aTestCase() throws Throwable {
		URL url = new URL("http://1234.com");
		String urlUsername = "urlUsername";
		String urlPassword = "urlPassword1";
		pb.addUser(urlUsername, urlPassword);
		int s = pb.loginUser(urlUsername, urlPassword);
		pb.updateDetails(s, url, urlUsername, urlPassword);
		assertTrue(pb.retrieveDetails(s, url) != null);
	}

	@Test
	public void updateDetails_B2bTestCase() throws Throwable {
		URL url = new URL("https://1234.com");
		String urlUsername = "urlUsername";
		String urlPassword = "urlPassword1";
		pb.addUser(urlUsername, urlPassword);
		int s = pb.loginUser(urlUsername, urlPassword);
		pb.updateDetails(s, url, urlUsername, urlPassword);
		assertTrue(pb.retrieveDetails(s, url) != null);
	}

	@Test(expected = MalformedURLException.class)
	public void updateDetails_B2cTestCase() throws Throwable {
		URL url = new URL("httpp://1234.com");
		String urlUsername = "urlUsername";
		String urlPassword = "urlPassword1";
		pb.addUser(urlUsername, urlPassword);
		int s = pb.loginUser(urlUsername, urlPassword);
		pb.updateDetails(s, url, urlUsername, urlPassword);
	}

	@Test(expected = MalformedURLException.class)
	public void updateDetails_B2dTestCase() throws Throwable {
		URL url = new URL("http");
		String urlUsername = "urlUsername";
		String urlPassword = "urlPassword1";
		pb.addUser(urlUsername, urlPassword);
		int s = pb.loginUser(urlUsername, urlPassword);
		pb.updateDetails(s, url, urlUsername, urlPassword);
	}

	@Test(expected = MalformedURLException.class)
	public void retrieveDetails_B2aTestCase() throws Throwable {
		URL url = new URL("httpp://1234.com");
		String urlUsername = "urlUsername";
		String urlPassword = "urlPassword1";
		pb.addUser(urlUsername, urlPassword);
		int s = pb.loginUser(urlUsername, urlPassword);
		pb.retrieveDetails(s, url);
	}

}
