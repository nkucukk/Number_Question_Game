package miniprojects.sayitahminoyunu;

import java.util.Random;
import java.util.Scanner;

public class SayiTahminOyunu {
    /*
       Amaç:
       Oyuncudan 1 ile 100 arasında bir sayı tahmini alarak rastgele bir sayıyı bulmaya çalışması istenir.
       Oyuncuya her tahminde doğru sayıya yaklaşıp yaklaşmadığına dair ipuçları verilir ve oyuncuya 10 tahmin hakkı tanınır.

       Yönergeler:
       - Oyuncuya "1-100 arası bir sayı tahmini giriniz" mesajı gösterilir.
       - Oyuncu bir sayı girişi yapar.
       - Oyuncunun tahmini, rastgele seçilen sayıya göre kontrol edilir:
           - Tahmin doğru ise, "Tebrikler, X. tahminde sayıyı buldunuz!" mesajı gösterilir.
             Ardından oyuncunun puanı hesaplanır ve "Puanınız: X" mesajı gösterilir ve
             "Tekrar oynamak için 1'e, çıkmak için herhangi bir sayıya basın." mesajı gösterilir.
           - Tahmin, sayıdan küçük ise, "Bilemediniz, tahmin için X hakkınız kaldı! Daha büyük bir sayı giriniz:" mesajı gösterilir.
           - Tahmin, sayıdan büyük ise, "Bilemediniz, tahmin için X hakkınız kaldı! Daha küçük bir sayı giriniz:" mesajı gösterilir.
           - Oyuncuya 10 tahmin hakkı verilir. Oyuncu 10 tahmin hakkını da kullanırsa,
             "Hakkınız bitti, oyunu kaybettiniz. Tekrar oynamak için 1'e, çıkmak için herhangi bir sayıya basın."
             mesajı gösterilir.
           - Oyuncu 1'e basarsa, oyun yeniden başlatılır ve yeni bir rastgele sayı seçilir.
           - Oyuncu herhangi bir sayıya basarsa, oyun sona erer ve program sonlanır.
    */
    public static void main(String[] args) {
        basla();

    }


    public static void basla() {

        int sayac = 1;
        Random rand = new Random();
        int gercekSayi = rand.nextInt(101); // Bu kısımda 0-100 arasında rastgele bir atamasını istedim.

        Scanner input = new Scanner(System.in);


        System.out.println("Sayi Tahmini Oyununa Hoşgeldiniz!");
        System.out.println("Lütfen, 1-100 arasında tahmininiz olan sayı tuşlayınız. ");
        while (sayac < 12) {

            int tahminSayi = input.nextInt();

            if (sayac == 10) {
                System.out.println("Hakkınız bitti, oyunu kaybettiniz. \nTekrar oynamak için 1'e, çıkmak için herhangi bir sayıya basın.");
                int num = input.nextInt();

                if (num == 1) {
                    basla();
                } else if (num!=1) {
                    System.out.println("Yeniden görüşmek dileğiyle...");
                    break;
                }
            }


            if (tahminSayi < 0 || tahminSayi > 100) {
                System.out.println("Hatalı giriş yaptınız. \nLütfen, 1-100 arasında bir sayı tuşlayınız.");
                continue;  // Bu kısımda canım gitmeden oyunu başa döndürmek amacıyla kullandım.
            }


            if (tahminSayi == gercekSayi) {
                System.out.println("Tebrikler, " + sayac + ". tahminde sayıyı buldunuz! \n" +
                        "Bu oyunda kazandığınız puan:" + (100 - sayac*10) +
                        "\nTekrar oynamak için 1'e, çıkmak için herhangi bir sayıya basın.");

                int num = input.nextInt();
                if (num == 1) {
                    basla();
                } else if (num!=1) {
                    System.out.println("Yeniden görüşmek dileğiyle...");
                }

                sayac++;
                break;

            } else if (gercekSayi < tahminSayi) {
                System.out.println("Bilemediniz, tahmin için " + (10 - sayac) + " hakkınız kaldı! Daha kücük bir sayı giriniz:");

            } else if (gercekSayi > tahminSayi) {
                System.out.println("Bilemediniz, tahmin için " + (10 - sayac) + " hakkınız kaldı! Daha büyük bir sayı giriniz:");

            }

            sayac++;


        }


    }
}
