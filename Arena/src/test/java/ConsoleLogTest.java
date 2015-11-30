import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConsoleLogTest {
    private final ByteArrayOutputStream outPutContent = new ByteArrayOutputStream();
    private final ConsoleLog consoleLog = new ConsoleLog();
    @Before
    public void setUp(){
        System.setOut( new PrintStream( outPutContent ));
    }

    @Test
    public void should_console_log_string_i_want(){

        consoleLog.log( "i want to print");

        assertThat( outPutContent.toString(), is("i want to print"));

    }

    @Test
    public void should_console_log_sepecial_characters(){
        consoleLog.log( "\"*^&{}$#@!&%()" );

        assertThat( outPutContent.toString(), is( "\"*^&{}$#@!&%()" ) );
    }


}
