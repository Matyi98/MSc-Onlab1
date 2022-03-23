![Package_Diagram](https://user-images.githubusercontent.com/61094345/155882386-d85c9c92-1ad8-467c-bb9d-8901e5176277.png)

Az ábrán látható módon a frontend felépítése 3 fő részre tagolódik:
- A View mappában minden egyes nézethez társul egy azt leíró osztály, amelyeket Jetpack Compose segítségével készítek el.
- A ViewModel mappában a felülethez kötött adatok szerepelnek majd, minden egyes nézethez tartozik egy adatosztály is.
- A Data mappában pedig a Room adatbázisban szereplő lokális illetve a backend adatbázisában szereplő adathoz férünk hozzá.

RestApi előzetes terv: 

A backenddel az alábbi esetekben szükséges a kommunikáció: 
- Bejelentkezés (felhasználónév + jelszó)
- Regisztráció (felhasználónév + jelszó)
- Profil mentése (telefonszámot, becenév, email, profilkép, teljes név megadható)
- Profil betöltése (telefonszámot, becenév, email, profilkép, teljes név bejelentkezés alapján)
- Család létrehozása (Családnév, fénykép megadható): egyéni azonosító generálása családhoz
- Család betöltése (tagok listájának visszaadása, tagok profiljainak visszaadása, bevásárlólisták listájának visszaadása, események listájának visszaadása)
- Család módosítása (Családnév, fénykép szerkeszthető)
- Család elhagyása/törlése
- Családhoz csatlakozás
- Tag felvétele családba
- Esemény hozzáadása (Esemény címe, szöveges ismertetése, kezdési és befejezési dátuma illetve meghívottak)
- Esemény szerkesztése (Esemény címe, szöveges ismertetése, kezdési és befejezési dátuma illetve meghívottak szerkesztése)
- Esemény visszajelzés bevitele (meghívott tag ott lesz/nem lesz ott)
- Esemény törlése
- Bevásárlólista létrehozása (helyszín szövegesen, dátum illetve a termékek listája)
- Bevásárlólista szerkesztése (helyszín szövegesen, dátum illetve a termékek listájának felülírása, termékek listája mellett megvásárolt/nem megvásárolt checkbox-al)
- Bevásárlólista törlése
