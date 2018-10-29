import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;
import com.ideaboard.connection.*;
public class connectionTest {

	@Test
	public void testConnection() {
		// this is an integration test
		Connection con = ConnectionDB.getConnection();
		assertNotEquals(con,null);
	}

}
