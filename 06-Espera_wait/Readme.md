1. Per què s'atura l'execució al cap d'un temps?
- Perquè tots els fils que tenen reserva es queden al wait() i no hi ha cap fil que canceli la seva reserva

2. Què passaria si en lloc de una probabilitat de 50%-50% fora de 70%(ferReserva)-30%(cancel·lar)? I si foren al revés les probabilitats? -> Mostra la porció de codi modificada i la sortida resultant en cada un dels 2 casos.
- Si fos un 70% de fer reserva, les places s'omplirien molt més ràpid i s'entraria al bucle on es para l'execució més ràpida. Només s'hauria de modificar la linea de codi

`if (Math.random() <= 0.5) esdeveniment.ferReserva(this);`

per 

`if (Math.random() <= 0.7) esdeveniment.ferReserva(this);`

Resultat execució:

    Assistent-4 ha fet una reserva. Places disponibles: 4
    Assistent-9 ha fet una reserva. Places disponibles: 3
    Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
    Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
    Assistent-5 ha fet una reserva. Places disponibles: 2
    Assistent-3 ha fet una reserva. Places disponibles: 1
    Assistent-0 ha fet una reserva. Places disponibles: 0
    Assistent-3 ha cancel·lat una reserva. Places disponibles: 1
    Assistent-6 ha fet una reserva. Places disponibles: 0
    Assistent-0 ha cancel·lat una reserva. Places disponibles: 1
    Assistent-7 ha fet una reserva. Places disponibles: 0
    Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-6 ha cancel·lat una reserva. Places disponibles: 1
    Assistent-2 ha fet una reserva. Places disponibles: 0
    Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0

En el cas contrari, s'intentaria cancel·lar molt més i seria molt complicat que s'omplisin totes les places. La linea que s'hauria de modificar en aquest cas seria així:

``if (Math.random() <= 0.3) esdeveniment.ferReserva(this);``

Resultat execució:

    Assistent-4 ha fet una reserva. Places disponibles: 4
    Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
    Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
    Assistent-2 ha fet una reserva. Places disponibles: 3
    Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
    Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
    Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
    Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
    Assistent-1 ha fet una reserva. Places disponibles: 2
    Assistent-5 ha fet una reserva. Places disponibles: 1
    Assistent-8 ha fet una reserva. Places disponibles: 0
    Assistent-8 ha cancel·lat una reserva. Places disponibles: 1
    Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
    Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
    Assistent-1 ha fet una reserva. Places disponibles: 0
    Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-4 ha cancel·lat una reserva. Places disponibles: 1
    Assistent-2 ha fet una reserva. Places disponibles: 0
    Assistent-5 ha cancel·lat una reserva. Places disponibles: 1
    Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
    Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
    Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
    Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
    Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
    Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
    Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
    Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
    Assistent-1 ha cancel·lat una reserva. Places disponibles: 2
    Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
    Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
    Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
    Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
    Assistent-8 ha fet una reserva. Places disponibles: 1
    Assistent-2 ha cancel·lat una reserva. Places disponibles: 2
    Assistent-0 ha fet una reserva. Places disponibles: 1
    Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
    Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
    Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
    Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
    Assistent-2 ha cancel·lat una reserva. Places disponibles: 2
    Assistent-8 ha cancel·lat una reserva. Places disponibles: 3
    Assistent-0 ha cancel·lat una reserva. Places disponibles: 4
    Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
    Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
    Assistent-1 ha cancel·lat una reserva. Places disponibles: 5
    Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
    Assistent-5 ha fet una reserva. Places disponibles: 4
    Assistent-3 ha fet una reserva. Places disponibles: 3
    Assistent-6 ha fet una reserva. Places disponibles: 2
    Assistent-6 ha fet una reserva. Places disponibles: 1
    Assistent-5 ha cancel·lat una reserva. Places disponibles: 2
    Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
    Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
    Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
    Assistent-8 ha fet una reserva. Places disponibles: 1
    Assistent-1 ha fet una reserva. Places disponibles: 0
    Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-6 ha cancel·lat una reserva. Places disponibles: 1
    Assistent-1 ha fet una reserva. Places disponibles: 0
    Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-6 ha cancel·lat una reserva. Places disponibles: 1
    Assistent-0 ha fet una reserva. Places disponibles: 0
    Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-3 ha cancel·lat una reserva. Places disponibles: 1
    Assistent-1 ha cancel·lat una reserva. Places disponibles: 2
    Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
    Assistent-0 ha cancel·lat una reserva. Places disponibles: 3
    Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
    Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
    Assistent-8 ha cancel·lat una reserva. Places disponibles: 4
    Assistent-9 ha fet una reserva. Places disponibles: 3
    Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
    Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
    Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
    Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
    Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
    Assistent-2 ha fet una reserva. Places disponibles: 2
    Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
    Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
    Assistent-1 ha cancel·lat una reserva. Places disponibles: 3
    Assistent-7 ha fet una reserva. Places disponibles: 2
    Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
    Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
    Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
    Assistent-5 ha fet una reserva. Places disponibles: 1
    Assistent-9 ha fet una reserva. Places disponibles: 0
    Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-9 ha cancel·lat una reserva. Places disponibles: 1
    Assistent-7 ha fet una reserva. Places disponibles: 0
    Assistent-7 ha cancel·lat una reserva. Places disponibles: 1
    Assistent-4 ha fet una reserva. Places disponibles: 0
    Assistent-5 ha cancel·lat una reserva. Places disponibles: 1
    Assistent-2 ha fet una reserva. Places disponibles: 0
    Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-9 ha cancel·lat una reserva. Places disponibles: 1
    Assistent-1 ha fet una reserva. Places disponibles: 0
    Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-4 ha cancel·lat una reserva. Places disponibles: 1
    Assistent-5 ha fet una reserva. Places disponibles: 0
    Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-7 ha cancel·lat una reserva. Places disponibles: 1
    Assistent-2 ha fet una reserva. Places disponibles: 0
    Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-1 ha cancel·lat una reserva. Places disponibles: 1
    Assistent-9 ha fet una reserva. Places disponibles: 0
    Assistent-5 ha cancel·lat una reserva. Places disponibles: 1
    Assistent-8 ha fet una reserva. Places disponibles: 0
    Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-8 ha cancel·lat una reserva. Places disponibles: 1
    Assistent-4 ha fet una reserva. Places disponibles: 0
    Assistent-2 ha cancel·lat una reserva. Places disponibles: 1
    Assistent-3 ha fet una reserva. Places disponibles: 0
    Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-4 ha cancel·lat una reserva. Places disponibles: 1
    Assistent-7 ha fet una reserva. Places disponibles: 0
    Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-2 ha cancel·lat una reserva. Places disponibles: 1
    Assistent-3 ha fet una reserva. Places disponibles: 0
    Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-2 ha cancel·lat una reserva. Places disponibles: 1
    Assistent-9 ha fet una reserva. Places disponibles: 0
    Assistent-9 ha cancel·lat una reserva. Places disponibles: 1
    Assistent-7 ha fet una reserva. Places disponibles: 0
    Assistent-9 ha cancel·lat una reserva. Places disponibles: 1
    Assistent-1 ha fet una reserva. Places disponibles: 0
    Assistent-7 ha cancel·lat una reserva. Places disponibles: 1
    Assistent-4 ha fet una reserva. Places disponibles: 0
    Assistent-1 ha cancel·lat una reserva. Places disponibles: 1
    Assistent-9 ha fet una reserva. Places disponibles: 0
    Assistent-9 ha cancel·lat una reserva. Places disponibles: 1
    Assistent-4 ha fet una reserva. Places disponibles: 0
    Assistent-7 ha cancel·lat una reserva. Places disponibles: 1
    Assistent-2 ha fet una reserva. Places disponibles: 0
    Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    Assistent-4 ha cancel·lat una reserva. Places disponibles: 1
    Assistent-3 ha fet una reserva. Places disponibles: 0
    Assistent-4 ha cancel·lat una reserva. Places disponibles: 1
    Assistent-1 ha fet una reserva. Places disponibles: 0
    Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0

Com es pot veure en el segon cas es tarda molt més a arribar al bucle infinit on para l'execució.

3. Perquè creus que fa falta la llista i no valdria només amb una variable sencera de reserves?
- Perquè no es podria saber si un assistent té reserva o no i per tant no es podria evitar que es cancelin reserves inexistents.
