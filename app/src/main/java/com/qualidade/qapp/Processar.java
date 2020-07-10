package com.qualidade.qapp;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Processar {

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getData() {
        data = LocalDate.now().toString();
        return data;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getHoraArq() {

        if (LocalDateTime.now().getHour() - 3 < 0) {
            hora = Integer.toString(24 - (LocalDateTime.now().getHour() - 3));
        }
        hora = LocalDateTime.now().getHour() - 3 + "_" + LocalDateTime.now().getMinute() + "_" + LocalDateTime.now().getSecond();
        return hora;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getHora() {

        hora = String.format("%02d", LocalDateTime.now().getHour()) + ":" + String.format("%02d", LocalDateTime.now().getMinute()) + ":" +
                String.format("%02d", LocalDateTime.now().getSecond());
        return hora;
    }

    private String data = "";
    private String hora = "";

}
