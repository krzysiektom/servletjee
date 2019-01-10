<img alt="Logo" src="http://coderslab.pl/svg/logo-coderslab.svg" width="400">

# Java EE  - Servlety

### Zadania.

1. Stwórz projekt `servletjee`. Rozwiązania zadań powinny znajdować się w tym projekcie.
2. Utwórz pakiet `pl.coderslab` - servlety umieszczaj w tym pakiecie lub pakietach podrzędnych.

#### Zadanie 1 - rozwiązywane z wykładowcą

1. Stwórz projekt a w nim servlet `Servlet11`, dostępny pod adresem **/Servlet11**,
który wyświetli na konsoli "Hello First Servlet".

2. Skonfiguruj IntelliJ wraz z serwerem Tomcat.
3. Uruchom projekt.

#### Zadanie 2 - rozwiązywane z wykładowcą

1. W projekcie stwórz servlet `Servlet12`, dostępny pod adresem **/Servlet12**, 
który wyświetli w przeglądarce "Wynik servletu w przeglądarce".
2. Jednocześnie w konsoli wyświetli "Komunikat na konsoli". 
3. Adres strony powinien być określony za pomocą adnotacji.

-------------------------------------------------------------------------------

#### Zadanie 3

1. W projekcie stwórz servlet `Servlet13` dostępny pod adresem **/Servlet13**,
 który wyświetli w przeglądarce lokalny czas.
Wykorzystaj `LocalTime.now()` .

#### Zadanie 4

1. W projekcie stwórz servlet `Servlet14`, dostępny pod adresem **/Servlet14**,
który wyświetli w konsoli "Zadanie 4".
2. Komunikat na konsoli powinien zostać wyświetlony tylko raz, niezależnie od liczby odświeżeń strony. Skorzystaj z metody `init`.


#### Zadanie 5

1. W projekcie stwórz servlet `Servlet15`, dostępny pod adresem **/Servlet15**,
który wyświetli w przeglądarce "Zadanie 5".
2. Adres strony powinien być określony za pomocą odpowiedniego wpisu w deskryptorze wdrożenia (podpowiedź znajdziesz w Snippetach).


#### Zadanie 6
1. W projekcie stwórz servlet `Servlet16` dostępny pod adresem **/Servlet16**,
2. Wyświetl w przeglądarce poniższe informacje (wykorzystaj metodę **getHeader** obiektu typu **HttpServletRequest**):
    * Adres IP
    * Przeglądarkę
    * Aktualny czas (wykorzystaj `LocalTime.now()` )
