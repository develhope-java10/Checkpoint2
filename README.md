# Checkpoint #2 - Java 10

1) Scrivere un metodo loadLines(String filePath) che carichi le linee di un file di testo con percorso “filePath” e le ritorni come lista di stringhe.
2) Scrivere un metodo processLines(List<String> lines) che scorre lalista di stringhe in input e ritorna una HashMap che ha come chiavi stringhe e come valori interi.
Per ogni linea il metodo deve eseguire le seguenti operazioni:
- Se una linea è vuota non deve fare nulla
- Se una linea non contiene un carattere ‘$’ stampa un messaggio di errore
- Altrimenti divide la linea in due parti in base alla posizione di '\$' ed inserisce una nuova entry nella mappa, usando come chiave la sezione della linea prima del carattere '\$', rimuovendo eventuali spazi iniziali e finali, e come valore il numero di parole nella sezione dopo il carattere '\$'.

3) Scrivere un metodo writeLines(String filePath, HashMap<String, Integer> lines) che scriva le entry nella mappa su un file di testo al percorso ‘filePath’, una per riga, nel seguente formato: “KEY - VALORE”.

La prima linea del file d'esempio "input.txt" dovrebbe risultare nella coppia in mappa (“Light”, 3)
