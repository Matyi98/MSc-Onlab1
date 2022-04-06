![architekt ra](https://user-images.githubusercontent.com/61094345/159793451-8075b916-1b3d-40b8-b29c-36d1888fd340.jpg)

A rajzon látható egyes komponensek felelősége:
- View: a nézetek leírásáért felelős. 
- ViewModel: a nézetek számára biztosít függvényeket az adatok betöltése és továbbítása céljából. Az adatok származhatnak hálózatról vagy lokális adatbázisból, ezekhez hív tovább ez a komponens.
- LocalDatabase: egy adatbázis az adatok cachelésére illetve a lokálisan tárolt adatok elérésére. 
- Swagger.io: egy generált hálózati komunikációért felelős komponens. Swagger OpenApi-ja segítségével lett generálva a backendnek az ezt leíró yaml-je alapján. 
