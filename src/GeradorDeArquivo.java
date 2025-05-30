//import java.util.Scanner;
//

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorDeArquivo {

    public void salvaJson(TaxaDeConversao taxaDeConversao) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escrita = new FileWriter(taxaDeConversao.result() + ".json");
        escrita.write(gson.toJson(taxaDeConversao));
        escrita.close();
    }

}
