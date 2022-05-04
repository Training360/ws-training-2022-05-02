class: inverse, center, middle

# JSON és kezelése Java eszközökkel

---

## JSON

* JavaScript Object Notation
* XML leváltására, JavaScript elterjedésével, adatok átvitelére
* Tipikusan böngészős frontend és backend közötti kommunikációra
* Ember és számítógép számára értelmezhető szöveges, kiterjeszthető formátum
    * Érvényes JavaScript kifejezés
* Kulcs-érték párokat (object) és tömböket (array) tartalmaz
* Adattípusok: szám, karakterlánc, logikai
* Speciális üres érték: null
* Fa hierarchia

---

## Példa JSON dokumentum

```javascript
{"books":[
  {"isbn10":"059610149X",
    "title":"Java and XML"},
  {"isbn10":"1590597060",
    "title":"Pro XML Development with Java Technology"}]}
```

---

## JSON feldolgozás

* [JSON in Java (package org.json)](https://github.com/stleary/JSON-java)
* Google [Gson](https://github.com/google/gson)
* [Jackson](https://github.com/FasterXML/jackson)
* [EclipseLink MOXy](https://www.eclipse.org/eclipselink/#moxy)
* [JSON-P (JSR 374)](https://javaee.github.io/jsonp/)

---

## XML és JSON formátumot egyszerre támogató megoldások

* Jackson (`jackson-dataformat-xml`)
* EclipseLink MOXy (`eclipselink.media-type`)