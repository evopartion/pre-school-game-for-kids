package com.example.cocukegitimuygulamasi;

public class DogruYanlis2 {

    public String sorular[]={

            "Güneş doğal ışık kaynağına örnektir",
            "Bir haftada 7 gün vardır",
            "İstiklal marşının yazarı Mehmet Akif Ersoydur",
            "Türkiye'nin yedi coğrafi bölgesi vardır",
            "Havaya atılan bozuk paranın tura gelme olasılığı 1/2 dir",
            "Alfabemizde 30 harf bulunur",
            "Kağıt iletken bir maddedir",
            "Cumhuriyet 23 Nisan 1920 de ilan edilmiştir",


    };

    public  String yanitlar[]={
            "true",
            "true",
            "true",
            "true",
            "true",
            "false",
            "false",
            "false",


    };

    public String getQuestions(int number) {
        return sorular[number];
    }

    public String getAnswers(int number) {
        return yanitlar[number];
    }
}

