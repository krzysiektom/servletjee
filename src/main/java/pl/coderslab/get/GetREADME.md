<img alt="Logo" src="http://coderslab.pl/svg/logo-coderslab.svg" width="400">

# Java EE  - GET

### Zadania.

Rozwiązania zadań umieszczaj we wcześniej utworzonym projekcie.

#### Zadanie 1 - rozwiązywane z wykładowcą

1. W projekcie stwórz servlet `Get1`, który wczyta dwie zmienne: ```start``` i ```end``` . 
2. Po uruchomieniu aplikacji na serwerze, w przeglądarce wyświetlą się wszystkie liczby od ```start``` do ```end```. 
(dla uproszczenia załóżmy, że będziemy przesyłać tylko liczby całkowite).
Jeżeli zmienne nie są przesłane, to strona ma wypisać informację 'Brak przesłanych zmiennych'.


#### Zadanie 2  - rozwiązywane z wykładowcą

1. W projekcie stwórz servlet `Get2`, który wyświetli listę przesłanych w zapytaniu (request) parametrów i ich wartość
 (niezależnie od liczby przesłanych parametrów).
 
-------------------------------------------------------------------------------

#### Zadanie 3

1. W projekcie stwórz servlet `Get3`, który ma pobierać dwie zmienne o nazwach ```width``` i ```height```.
Jeżeli informacje nie są przesłane to ```width = 5``` i ```height = 10```. 
2. Następnie wygeneruj tabliczkę mnożenia o podanej wysokości i szerokości i wyświetl ją w przeglądarce.


#### Zadanie 4

1. W projekcie stwórz servlet `Get4`, dostępny pod adresem **/Get4**,
oraz stronę HTML `index.html`, w której zawarty jest formularz przesyłany metodą GET z jednym polem `page`.
2. Po uruchomieniu aplikacji na serwerze, uzupełnieniu i zatwierdzeniu formularza w przeglądarce wyświetli się informacja 
czy wartość została przesłana oraz wyświetlone zostaną dzielniki całkowite przesłanej liczby.


#### Zadanie 5
W projekcie stwórz servlet `Get5`, dostępny pod adresem **/Get5**, oraz stronę HTML `index.html`, w której umieścisz link do servletu z dodatkowymi parametrami    
``` ?company=coderslab&learn=php&learn=java&learn=ruby&learn=python ```    
po przejściu do servletu wyświetl informacje w następujący sposób:
````
company:
  - coderslab
learn:
  - php 
  - java
  - ruby
  - python
````

#### Zadanie 6
W projekcie stwórz  servlety `Get61`, `Get62`, `Get63`, 
dostępne odpowiednio pod adresami **/Get61**, **/Get62**, **/Get63**.
 
Dopisz następującą funkcjonalność:
* Pierwszy `Get61`, powinien generować linki do drugiego `Get62`, przekazując metodą GET dane pod kluczem `year` (od `1980` do `2010`).
* Drugi `Get62` powinien odebrać przesłane poprzez `GET` dane z pierwszego `Get61` i wygenerować `5` linków,
 gdzie każdy z nich ma przenosić do trzeciego `Get63` przekazując metodą GET następujące dane:
  * year - dane przesłane z poprzedniej strony
  * mix - losowa wartość z zakresu od `-10` do `10`
* Trzeci `Get63` ma pobrać dane z `GET62` odnośnie roku i wartości `mix` i wyświetlić rok zmodyfikowany o tyle lat ile przesłano w `mix`.

Przykład:
Wynikowy html pierwszego servletu
```html
<a href='/Project_02/Get62?year=1980'> Link do roku 1980 </a>
<a href='/Project_02/Get62?year=1981'> Link do roku 1981 </a>
...
<a href='/Project_02/Get62?year=2010'> Link do roku 2010 </a>
```

Wynikowy html drugiego servletu, któremu przekazaliśmy wartość 1985 generuje linki 
(pamiętaj wartości mix są losowe):
```html
<a href='/Project_02/Get63?year=1985&mix=-2'> Rok 1985, mix -2 </a>
<a href='/Project_02/Get63?year=1985&mix=-5'> Rok 1985, mix -5 </a>
<a href='/Project_02/Get63?year=1985&mix=7'> Rok 1985, mix 7 </a>
<a href='/Project_02/Get63?year=1985&mix=2'> Rok 1985, mix 2 </a>
<a href='/Project_02/Get63?year=1985&mix=1'> Rok 1985, mix 1 </a>
```

Wynikowy html trzeciego servletu - wyświetla odpowiedni rok (tutaj przykład dla wartości year = 1985 i mix = -5)
```html
Rok to: 1980
```

