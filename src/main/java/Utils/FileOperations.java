package Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

public class FileOperations {
    private static final String DIR_PATH_PROPERTIES = System.getProperty("user.dir") + File.separator +
            "src" +File.separator + "main" + File.separator + "resources" + File.separator + "Properties" +File.separator;

    private static final String DIR_PATH_CSV = System.getProperty("user.dir")+File.separator+
            "src"+File.separator+"test"+File.separator+"resources"+File.separator+"Csv"+File.separator;

    public static Properties getProperties(String fileName)  {
        InputStream inputStream = null;
        Properties properties = new Properties();
        try {
            File file = new File(DIR_PATH_PROPERTIES + fileName + ".properties");
            inputStream = new FileInputStream(file);
            properties.load(inputStream);
            return properties;
        }
        catch (Exception e){
            System.out.println("Passando Exception"+e.getMessage());
        }
        finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }

    public static ArrayList<String[] > csvToArrayList(String fileName){
        ArrayList<String[] >   conteudo = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(DIR_PATH_CSV + fileName +".csv"))) {

           String linha = "";
           while ((linha = br.readLine()) != null){

           conteudo.add(linha.split(","));
           }

        } catch (Exception e){
            e.printStackTrace();
        }
        return conteudo;
    }

    public static void setProperties(String fileName, String propKey, String propValue)  {
        Properties prop = getProperties(fileName);
        try {
            OutputStream outputStream = new FileOutputStream(DIR_PATH_PROPERTIES + fileName + ".properties");
            prop.setProperty(propKey, propValue);
            prop.store(outputStream, null);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
