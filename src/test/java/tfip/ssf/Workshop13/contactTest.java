package tfip.ssf.Workshop13;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import tfip.ssf.Workshop13.helper.helper;
import tfip.ssf.Workshop13.model.contact;

@SpringBootTest
public class contactTest {

    @Test
    void contextLoads(){

    }

    @Test
    public void testContaxt() throws Exception{
        contact c = new contact();
        c.setName("Keldren");
        c.setEmail("a@a.com");
        c.setPhone(123456123);
        assertEquals(c.getEmail(),"a@a.com");

    }

    @Test
    public void testCreateDir(){
        helper help = new helper();
        assertTrue(help.createDir("/opt/tmp/data/this"));
    }



    @Test
    public static void main(String[] args) {

        //ID generating
        int numchars = 8;
        String ID;
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while(sb.length()< numchars){
            sb.append(Integer.toHexString(r.nextInt()));
        }
        ID = sb.toString().substring(0,numchars);
        System.out.println(ID);
    }
}


        
    
    

