Gherman Maria Irina @ 324 CB

Tema 1 POO

O sa analizez fisierele/clasele (si eventual metodele) separat si o sa motivez 
implementarea:

1. Main:
	In main am initializat toate variabilele care urmeaza sa ma ajute in citire
	
	Am citit numarul dat de pasageri si am creat la fiecare linie citita grupul
	respectiv si l-am adaugat in database.
	
	Am citit comenzile si le-am interpretat apeland metodele corespunzatoare.
	
	La final am scris tot ce era de scris in fisier.
	
2. Pasager

	O clasa simpla care este importanta doar pentru atributele ei. Am gandit
	implementarea astfel incat Pasager sa fie doar fundatia pe care imi 
	construiesc urmatoarele clase.
	
3. GroupType

	O alta fundatie pentru viitoarele clase, Family, Group si Single.
	
	GroupType a fost gandit astfel incat sa reprezinte caracteristicile comune
	intre cele 3 tipuri de grupuri (intre ele diferind doar numele si 
	prioritatea specifica grupului)
	
	Metodele abstracte getGroupPriority si getId sunt (logic) implementate
	de clasele ce mostenesc GroupType. Am ales sa fie abstracte pentru ca cele
	3 tipuri de grupuri cer ca aceste metode sa se comporte diferit
	(getGroupPriority returneaza 10, 5 sau 0, iar getId returneaza id-ul
	specific grupului in sine, nu GroupType-ului)
	
	Cred ca clasele Family, Group si Single nu necesita explicatii suplimentare
	
4. Database

	Un vector in care pot stoca toate grupurile declarate si unde le pot gasi
	cu usurinta (si modifica)
	
5. ReadFromFile si WriteToFile

	Sunt doar niste wrappere dragute pentru mijloacele obisnuite de a scrie
	sau citi din fisier
	
6. Heap

	Am ales sa implementez heap-ul prin ArrayList, fiind cel mai usor.
	
	Am metode ajutatoare de schimbare de noduri (swap) si de afisare
	(recursiveList).
	
	Metodele de baza sunt implementate in modul clasic (pentru ca nu
	am stat sa reinventez roata): heapifyUp, folosit la adaugare, heapityDown,
	folosit la eliminare, afisarea, extragerea maximului.
	
	Bonusul l-am realizat mai intai cautand grupul / persoana respectiva in
	database. Dupa apelare, am cautat instanta data (grupul sau persoana,
	pentru ca un grup e un pasager) si am eliminat-o.