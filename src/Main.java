import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Moeda;
import models.Rates;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest requisicao = HttpRequest.newBuilder().uri(URI.create("https://v6.exchangerate-api.com/v6/a62ec3fd757df28ffff3b45d/latest/USD")).build();

        HttpResponse<String> resposta = client.send(requisicao, HttpResponse.BodyHandlers.ofString());

        Rates dtoRates = gson.fromJson(resposta.body(), Rates.class);
        Moeda moedas = new Moeda(dtoRates);


        String opcao= "";
        double valor = 0;
        double valorConvertido = 0;

        while(!opcao.equalsIgnoreCase("sair")){
            System.out.println("CONVERSOR DE MOEDA ATIVO");


            System.out.println("Escolha uma opção de conversão ou digite 'sair' para fechar o programa :");
            System.out.println("1. Dólar para Real");
            System.out.println("2. Real para Dólar");
            System.out.println("3. Peso Argentino para Real");
            System.out.println("4. PEso Colombiano  para Real");
            System.out.println("5. Dolar  para peso Argentino");
            opcao = scanner.next();

            if(opcao.equalsIgnoreCase("sair")){
                break;
            }

            System.out.println("DIgite o valor para converter");
            valor = scanner.nextDouble();

            if (opcao.equalsIgnoreCase("1")) {
                valorConvertido = valor * moedas.getReal();
                System.out.println("o valor em dolar para real é : " + valorConvertido);

            } else if (opcao.equalsIgnoreCase("2")) {

                valorConvertido = valor / moedas.getDolar();
                System.out.println("o valor de real para dolar é : " + valorConvertido);

            } else if (opcao.equalsIgnoreCase("3")) {
                valorConvertido = valor *(moedas.getReal() / moedas.getArgentino()) ;
                System.out.println("o valor de peso argentino para real é : " + valorConvertido);

            } else if (opcao.equalsIgnoreCase("4")) {

                valorConvertido = valor *(moedas.getReal() / moedas.getColombiano()) ;
                System.out.println("o valor de peso colombiano para real é : " + valorConvertido);

            } else if (opcao.equalsIgnoreCase("5")) {
               valorConvertido = valor * moedas.getArgentino();
                System.out.println("o valor de dolar  para peso argentino é: " + valorConvertido);
            }
             else {
                System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
            }

        }

        scanner.close();




    }
}