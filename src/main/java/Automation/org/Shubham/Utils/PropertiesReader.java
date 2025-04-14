package Automation.org.Shubham.Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReader {

    public static String readKey(String key){

        Properties p=null;

        try{
            FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"src/main/Resources/data.properties");
            p= new Properties();
            p.load(file);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return p.getProperty(key);

    }
}
