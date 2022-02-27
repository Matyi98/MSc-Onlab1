![Package_Diagram](https://user-images.githubusercontent.com/61094345/155882386-d85c9c92-1ad8-467c-bb9d-8901e5176277.png)
Az ábrán látható módon a frontend felépítése 3 fő részre tagolódik:
- A View mappában minden egyes nézethez társul egy azt leíró osztály, amelyeket Jetpack Compose segítségével készítek el.
- A ViewModel mappában a felülethez kötött adatok szerepelnek majd, minden egyes nézethez tartozik egy adatosztály is.
- A Data mappában pedig a Room adatbázisban szereplő lokális illetve a backend adatbázisában szereplő adathoz férünk hozzá.
