package handsonproblems.jsontoxml;
import org.example.handsonproblems.jsontoxml.Main;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JsonToXMLTest {

    @Test
    void testJsonToXmlConversion() {
        String json = "{ \"name\": \"Aman\", \"age\": 25 }";
        String expectedXml = "<name>Aman</name><age>25</age>";

        String actualXml = Main.convertJsonToXml(json);

        assertEquals(expectedXml, actualXml);
    }
}
