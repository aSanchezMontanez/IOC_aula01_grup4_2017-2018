/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P4_E4;

import java.util.Scanner;

/**
 *
 * @author Leticia i Albert
 */
public class app_club_natació {
    // Definim CONSTANTS dels clubs
    private static final String C_HOSP = "Hospitalet";
    private static final String C_SABA = "Sabadell";
    private static final String C_BCNA = "Barcelona";
    private static final String C_CORN = "Cornellà";
    private static final String C_CARD = "Cardedeu";
    private static final String C_GRAN = "Granollers";
    private static final int HOSPITALET = 1;
    private static final int SABADELL = 2;
    private static final int BARCELONA = 3;
    private static final int CORNELLA = 4;
    private static final int CARDEDEU = 5;
    private static final int GRANOLLERS = 6;

    // Definim CONSTANTS de les CATEGORIES
    private static final String CAT_BENJ = "Benjami ";
    private static final String CAT_ALEV = "Alevi   ";
    private static final String CAT_INFA = "Infantil";
    private static final String CAT_JUVE = "Juvenil ";
    private static final int BENJAMI = 1;
    private static final int ALEVI = 2;
    private static final int INFANTIL = 3;
    private static final int JUVENIL = 4;

    // Definim CONSTANTS de ID
    private static final int ID_MIN = 1;
    private static final int ID_MAX = 2000;

    // Definim CONSTANTS d' EDAT de NAIXEMENT
    private static final int NAIX_MIN = 1999;
    private static final int NAIX_MAX = 2009;

    // Definim CONSTANTS de GÈNERE
    private static final String GEN_FEMENI = "Noia";
    private static final String GEN_MASCULI = "Noi ";
    private static final int NENA = 1;
    private static final int NEN = 2;

    // Definim CONSTANTS de PUNTUACIÓ
    private static final int MIN_PUNTUACIO = 10;
    private static final int MAX_PUNTUACIO = 50;

    // Definim CONSTANTS de COMPTADORS MÀXIMS
    private static final int INTENTS = 3;
    private static final int MAX_PARTICIPANTS = 10;
    
    // Definim CONSTANTS de SI/NO
    private static final int MIN_RESPOSTA = 1;
    private static final int MAX_RESPOSTA = 2;

    public static void main(String[] args) {

        // Iniciem l'escànner
        Scanner lector = new Scanner(System.in);

        // Definim variables String per al print que mostrem al final
        String genereresultat = null, categoriaresultat = null, clubresultat = null;

        // Variables necessàries pel "Projecte part 2" 
        int intents = 0, continuar = 0;
        boolean dadaCorrecta = true;
        boolean afegirParticipant;

        // ARRAYS necessàries pel "Projecte part 3"
        int[] id = new int[MAX_PARTICIPANTS];
        int[] naixement = new int[MAX_PARTICIPANTS];
        int[] genere = new int[MAX_PARTICIPANTS];
        int[] categoria = new int[MAX_PARTICIPANTS];
        int[] club = new int[MAX_PARTICIPANTS];
        int[] puntuacio = new int[MAX_PARTICIPANTS];

        // Index de l'array, a la posició número 0 (1)
        int i = 0;

        // Variables necessàries pel "Projecte part 3"
        int ordenar = 0, aux1 = 0;
        
        System.out.print("Entrada de dades del participant --------------------------------\n");

        do { // "Do" per a la repetició del programa per tal d'allistar un altre participant
            afegirParticipant = false;

            // ENTREM L'ID DEL CONCURSANT
            do {
                if ((intents > 0) && (intents < INTENTS)) {
                    System.out.print("Dada incorrecta. Torna-ho a probar.\n");
                }
                System.out.print("-----------------------------------------------------------------\n\nIntrodueix el ID (1 - 2000): ");
                dadaCorrecta = lector.hasNextInt();
                if (dadaCorrecta) {
                    id[i] = lector.nextInt();
                    lector.nextLine();
                    if ((id[i] < ID_MIN) || (id[i] > ID_MAX)) {
                        dadaCorrecta = false;
                    }
                }
                intents++;
            } while ((!dadaCorrecta) && (intents < INTENTS));

            // Si les dades són correctes, seguim
            // ENTREM L'ANY DE NAIXEMENT DEL CONCURSANT
            if (dadaCorrecta) {
                intents = 0; // Reiniciem la variable intents, d'aquesta manera tornem a tenir 3 intents d'introduir les dades.
                do {
                    if ((intents > 0) && (intents < INTENTS)) {
                        System.out.print("Dada incorrecta. Torna-ho a probar.\n");
                    }
                    System.out.print("-----------------------------------------------------------------\nAny de naixement (del 1999 - 2009): ");
                    dadaCorrecta = lector.hasNextInt();
                    if (dadaCorrecta) {
                        naixement[i] = lector.nextInt();
                        lector.nextLine();
                        if ((naixement[i] < NAIX_MIN) || (naixement[i] > NAIX_MAX)) {
                            dadaCorrecta = false;
                        }
                    }
                    intents++;
                } while ((!dadaCorrecta) && (intents < INTENTS));

                // Si les dades són correctes, seguim
                // ENTREM DADES DE GÈNERE
                if (dadaCorrecta) {
                    intents = 0;
                    do {
                        if ((intents > 0) && (intents < INTENTS)) {
                            System.out.print("Dada incorrecta. Torna-ho a probar.\n");
                        }
                        System.out.print("-----------------------------------------------------------------\nGénere del nadador/a (Nena: 1 / Nen: 2): ");
                        dadaCorrecta = lector.hasNextInt();
                        if (dadaCorrecta) {
                            genere[i] = lector.nextInt();
                            lector.nextLine();
                            switch (genere[i]) {
                                case 1:
                                    genere[i] = NENA;
                                    break;
                                case 2:
                                    genere[i] = NEN;
                                    break;
                                default:
                                    dadaCorrecta = false;
                                    break;
                            }
                        }
                        intents++;
                    } while ((!dadaCorrecta) && (intents < INTENTS));
                }

                // Si les dades són correctes, seguim
                // ENTREM DADES DE CATEGORIA
                if (dadaCorrecta) {
                    intents = 0;
                    do {
                        if ((intents > 0) && (intents < INTENTS)) {
                            System.out.print("Dada incorrecta. Torna-ho a probar.\n");
                        }
                        System.out.print("-----------------------------------------------------------------\n\nCategories possibles:\n-------------------------\n|\t1. Benjami\t|\n|\t2. Aleví\t|\n|\t3. Infantil\t|\n|\t4. Juvenil\t|\n-------------------------\nIntrodueixi la categoria: ");
                        dadaCorrecta = lector.hasNextInt();
                        if (dadaCorrecta) {
                            categoria[i] = lector.nextInt();
                            lector.nextLine();
                            switch (categoria[i]) {
                                case 1:
                                    categoria[i] = BENJAMI;
                                    break;
                                case 2:
                                    categoria[i] = ALEVI;
                                    break;
                                case 3:
                                    categoria[i] = INFANTIL;
                                    break;
                                case 4:
                                    categoria[i] = JUVENIL;
                                    break;
                                default:
                                    dadaCorrecta = false;
                                    break;
                            }
                        }
                        intents++;
                    } while ((!dadaCorrecta) && (intents < INTENTS));
                }

                // Si les dades són correctes, seguim
                //  ENTREM DADES DEL CLUB
                if (dadaCorrecta) {
                    intents = 0;
                    do {
                        if ((intents > 0) && (intents < INTENTS)) {
                            System.out.print("Dada incorrecta. Torna-ho a probar.\n");
                        }
                        System.out.print("-----------------------------------------------------------------\n\nClubs possibles:\n---------------------------------\n|\t1. Hospitalet\t\t|\n|\t2. Sabadell\t\t|\n|\t3. Barcelona\t\t|\n|\t4. Cornellà\t\t|\n|\t5. Cardedeu\t\t|\n|\t6. Granollers\t\t|\n---------------------------------\nIntrodueixi el club: ");
                        dadaCorrecta = lector.hasNextInt();
                        if (dadaCorrecta) {
                            club[i] = lector.nextInt();
                            lector.nextLine();
                            switch (club[i]) {
                                case 1:
                                    club[i] = HOSPITALET;
                                    break;
                                case 2:
                                    club[i] = SABADELL;
                                    break;
                                case 3:
                                    club[i] = BARCELONA;
                                    break;
                                case 4:
                                    club[i] = CORNELLA;
                                    break;
                                case 5:
                                    club[i] = CARDEDEU;
                                    break;
                                case 6:
                                    club[i] = GRANOLLERS;
                                    break;
                                default:
                                    dadaCorrecta = false;
                                    break;
                            }
                            intents++;
                        }
                    } while ((!dadaCorrecta) && (intents < INTENTS));
                }

                // Si les dades són correctes, seguim
                // ENTREM PUNTUACIÓ DEL CONCURSANT
                if (dadaCorrecta) {
                    intents = 0;
                    do {
                        if ((intents > 0) && (intents < INTENTS)) {
                            System.out.print("Dada incorrecta. Torna-ho a probar.\n");
                        }
                        System.out.print("-----------------------------------------------------------------\nIndiqui la puntuació obtinguda (10 - 50): ");
                        dadaCorrecta = lector.hasNextInt();
                        if (dadaCorrecta) {
                            puntuacio[i] = lector.nextInt();
                            lector.nextLine();
                            if ((puntuacio[i] < MIN_PUNTUACIO) || (puntuacio[i] > MAX_PUNTUACIO)) {
                                dadaCorrecta = false;
                            }
                        }
                        intents++;
                    } while ((!dadaCorrecta) && (intents < INTENTS));
                }

            }
            // Si ha introduit totes les dades correctament, es que ha afegit un concursant, per tant sumen l'index.
            if (dadaCorrecta) {
                i++;
            } else {
                System.out.println("Dada incorrecta. ¡Has superat el máxim d'intents permesos!");
            }
            System.out.print("-----------------------------------------------------------------");
            // Si esgota els intents i/o afegeix un participant correctament, preguntem si vol afegir-hi més (màxim 10)
            if (i < MAX_PARTICIPANTS) {
                intents = 0;
                do {
                    if ((intents > 0) && (intents < INTENTS)) {
                        System.out.print("Dada incorrecta. Torna-ho a probar.");
                    }
                    System.out.print("\n\nAfegir un nou participant? (Si: 1 / No: 2): ");
                    dadaCorrecta = lector.hasNextInt();
                    if (dadaCorrecta) {
                        continuar = lector.nextInt();
                        if (continuar == 1) {
                            intents = 0;
                            afegirParticipant = true;
                        }
                        if ((continuar < MIN_RESPOSTA) || (continuar > MAX_RESPOSTA)) {
                            dadaCorrecta = false;
                        }
                    }
                    intents++;
                } while ((!dadaCorrecta) && (intents < INTENTS));
            }
        } while ((afegirParticipant) && (i < MAX_PARTICIPANTS));
        if (!dadaCorrecta) {
            System.out.println("Dada incorrecta. ¡Has superat el máxim d'intents permesos!");
        }

        // Primer print mostrant les dades sense ordenar
        System.out.println("\nHeu introduit un total de: " + i + " participant/s\n-----------------------------------------------------------------\nAquests son els participants agregats:\nID\tAny\tGénere\tCategoria\tClub\t\tPuntuació\n-----------------------------------------------------------------");

        for (int j = 0; j < i; j++) {
            // Assignem a la variiable "String genere" al resultat obtingut a cada index
            switch (genere[j]) {
                case NENA:
                    genereresultat = GEN_FEMENI;
                    break;
                case NEN:
                    genereresultat = GEN_MASCULI;
                    break;
            }
            // Assignem a la variable "String categoria" al resultat obtingut a cada index
            switch (categoria[j]) {
                case BENJAMI:
                    categoriaresultat = CAT_BENJ;
                    break;
                case ALEVI:
                    categoriaresultat = CAT_ALEV;
                    break;
                case INFANTIL:
                    categoriaresultat = CAT_INFA;
                    break;
                case JUVENIL:
                    categoriaresultat = CAT_JUVE;
                    break;
            }
            // Assignem a la variable "String club" al resultat obtingut a cada index
            switch (club[j]) {
                case HOSPITALET:
                    clubresultat = C_HOSP;
                    break;
                case SABADELL:
                    clubresultat = C_SABA;
                    break;
                case BARCELONA:
                    clubresultat = C_BCNA;
                    break;
                case CORNELLA:
                    clubresultat = C_CORN;
                    break;
                case CARDEDEU:
                    clubresultat = C_CARD;
                    break;
                case GRANOLLERS:
                    clubresultat = C_GRAN;
                    break;
            }
            System.out.println(id[j] + "\t" + naixement[j] + "\t" + genereresultat + "\t" + categoriaresultat + "\t" + clubresultat + "\t" + puntuacio[j]);
        }

        // Preguntem si vol ordenar el resultat per puntuació obtinguda
        System.out.print("-----------------------------------------------------------------\n");
        intents = 0;
        do {
            if ((intents > 0) && (intents < INTENTS)) {
                System.out.print("Dada incorrecta. Torna-ho a probar.\n");
            }
            System.out.print("\nVol ordenar el llistat per la puntuació ascendent? (Si: 1 / No: 2): ");
            dadaCorrecta = lector.hasNextInt();
            if (dadaCorrecta) {
                ordenar = lector.nextInt();
                if (ordenar == 1) {
                    // Ordenem la puntuació
                    for (int k = 0; k < i - 1; k++) {
                        for (int j = k + 1; j < i; j++) {
                            // Si la puntuació 0(index) és més gran que la puntuació 1(index) es canvia l'ordre
                            // A la primera volta tindrem la puntuació més petita al primer lloc, així suscesivament
                            if (puntuacio[k] > puntuacio[j]) {

                                aux1 = puntuacio[k];
                                puntuacio[k] = puntuacio[j];
                                puntuacio[j] = aux1;

                                aux1 = id[j];
                                id[j] = id[k];
                                id[k] = aux1;

                                aux1 = naixement[j];
                                naixement[j] = naixement[k];
                                naixement[k] = aux1;

                                aux1 = genere[j];
                                genere[j] = genere[k];
                                genere[k] = aux1;

                                aux1 = categoria[j];
                                categoria[j] = categoria[k];
                                categoria[k] = aux1;

                                aux1 = club[j];
                                club[j] = club[k];
                                club[k] = aux1;

                            }
                        }
                    }
                
                    // PRINT FINAL AMB LA PUNTUACIÓ ORDENADA
                    System.out.print("\n-----------------------------------------------------------------\nAquests són els participants ordenats per puntuació:\nID\tAny\tGénere\tCategoria\tClub\t\tPuntuació\n-----------------------------------------------------------------\n");
                    for (int j = 0; j < i; j++) {
                        // Assignem a la variiable "String genere" el resultat obtingut a cada index
                        switch (genere[j]) {
                            case NENA:
                                genereresultat = GEN_FEMENI;
                                break;
                            case NEN:
                                genereresultat = GEN_MASCULI;
                                break;
                        }
                        // Assignem a la variable "String categoria" al resultat obtingut a cada index
                        switch (categoria[j]) {
                            case BENJAMI:
                                categoriaresultat = CAT_BENJ;
                                break;
                            case ALEVI:
                                categoriaresultat = CAT_ALEV;
                                break;
                            case INFANTIL:
                                categoriaresultat = CAT_INFA;
                                break;
                            case JUVENIL:
                                categoriaresultat = CAT_JUVE;
                                break;
                        }
                        // Assignem a la variable "String club" al resultat obtingut a cada index
                        switch (club[j]) {
                            case HOSPITALET:
                                clubresultat = C_HOSP;
                                break;
                            case SABADELL:
                                clubresultat = C_SABA;
                                break;
                            case BARCELONA:
                                clubresultat = C_BCNA;
                                break;
                            case CORNELLA:
                                clubresultat = C_CORN;
                                break;
                            case CARDEDEU:
                                clubresultat = C_CARD;
                                break;
                            case GRANOLLERS:
                                clubresultat = C_GRAN;
                                break;
                        }
                        System.out.println(id[j] + "\t" + naixement[j] + "\t" + genereresultat + "\t" + categoriaresultat + "\t" + clubresultat + "\t" + puntuacio[j]);
                    }
                    System.out.print("-----------------------------------------------------------------\n");
                }
                if ((ordenar < MIN_RESPOSTA) || (ordenar > MAX_RESPOSTA)) {
                    dadaCorrecta = false;
                }
            } else {
                System.out.println("Dada incorrecta. Torna-ho a probar.\n");
            }
            intents++;
        } while ((!dadaCorrecta) && (intents < INTENTS));
        if (!dadaCorrecta) {
            System.out.println("Dada incorrecta. ¡Has superat el máxim d'intents permesos!\n");
        }
    }
}
