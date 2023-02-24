package com.example.homework9;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@Entity
public class ExchangeRates {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Currencies fromCurrencies;

    private Currencies toCurrencies;

    private Double rate;

    public ExchangeRates(Currencies fromCurrencies, Currencies toCurrencies) {
        this.fromCurrencies = fromCurrencies;
        this.toCurrencies = toCurrencies;
    }

    public ExchangeRates() {
    }

    private Double formulaRate(Currencies fromCurrencies, Currencies toCurrencies) {
        if (fromCurrencies.equals(Currencies.UAH)) {
            if (toCurrencies.equals(Currencies.EUR)) {
                rate = 0.03;
            } else {
                rate = 0.031;
            }
        } else if (fromCurrencies.equals(Currencies.EUR)) {
            if (toCurrencies.equals(Currencies.USD)) {
                rate = 1.1;
            } else {
                rate = 39.78;
            }
        } else if (fromCurrencies.equals(Currencies.USD)) {
            if (toCurrencies.equals(Currencies.EUR)) {
                rate = 0.98;
            } else {
                rate = 36.89;
            }
        } else {
            rate = 1d;
        }
        return rate;
    }

    public static Double getPrivateBankAPI(Currencies currencies1, Currencies currencies2, Double amount) {
        Gson gson = new GsonBuilder().create();
        Double exchangeRates = 0d;
        try {
            URL url = new URL("https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=5");
            HttpURLConnection httpUrl = (HttpURLConnection) url.openConnection();
            InputStream is = httpUrl.getInputStream();
            try {
                byte[] buf = responseBodyToArray(is);
                String strBuf = new String(buf, StandardCharsets.UTF_8);

                //новый класс, созданный для получения значений от Gson
                PrivateBankAPI[] apis = gson.fromJson(strBuf, PrivateBankAPI[].class);
                List<PrivateBankAPI> strings = Arrays.asList(apis);

                for (PrivateBankAPI api : strings) {
                    if (api.getCcy().equals(currencies1.toString())) {
                        exchangeRates = api.getBuy();
                        amount *= exchangeRates;

                    } else if (api.getBase_ccy().equals(currencies1.toString())) {
                        if (api.getCcy().equals(currencies2.toString())) {
                            exchangeRates = api.getSale();
                            amount /= exchangeRates;
                        }
                    }
                }
            } finally {
                is.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return amount;
    }

    private static byte[] responseBodyToArray(InputStream is) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[10240];
        int r;

        do {
            r = is.read(buf);
            if (r > 0) bos.write(buf, 0, r);
        } while (r != -1);

        return bos.toByteArray();
    }

    public Long getId() {
        return id;
    }

    public Currencies getFromCurrencies() {
        return fromCurrencies;
    }

    public void setFromCurrencies(Currencies fromCurrencies) {
        this.fromCurrencies = fromCurrencies;
    }

    public Currencies getToCurrencies() {
        return toCurrencies;
    }

    public void setToCurrencies(Currencies toCurrencies) {
        this.toCurrencies = toCurrencies;
    }

    public double getRate() {
        return formulaRate(fromCurrencies, toCurrencies);
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
