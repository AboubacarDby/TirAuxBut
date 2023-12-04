package fr.gouv.finances.exo;

import java.util.Random;
import java.util.Scanner;

public class TirAuxButs {

    public static void main(String[] args) {
	// initialisation des variables
	int desTireur = d20();
	int desGardien = d20();
	int tourDeJeu = 1;
	int scoreEquipeJoueur = 0;
	int scoreEquipeIa = 0;
	int jetJoueur = d20();
	int jetIa = d20();
	int choixIa = verticale();
	int choixIa2 = horizontale();
	int choixJoueur = 0;
	int verticale;
	int horizontale;
	Scanner saisie = new Scanner(System.in);
	// condition d'éxecution du programme
	while (tourDeJeu != 5) {
	    System.out.println("Tour : " + tourDeJeu);
	    System.out.println("Le score est de : " + scoreEquipeJoueur + " à " + scoreEquipeIa);

	    jetJoueur = d20();
	    jetIa = d20();
	    choixIa = verticale();
	    choixIa2 = horizontale();
	    // Joueur tire
	    System.out.println("Où voulez-vous tirer :");
	    System.out.print("\t1 - en haut à gauche \t2 - en haut au mileu \t3 - en haut à droite");
	    System.out.println("");
	    System.out.println("\t4 - au milieu à gauche \t5 - au milieu au centre 6 - au milieu à droite");
	    System.out.println("\t7 - en bas à gauche \t8 - au bas au milieu \t9 - en bas à droite");
	    // l'utilisateur saisie son choix
	    choixJoueur = saisie.nextInt();

	    // choix de zone du tireur en verticale
	    if (choixJoueur == 1 || choixJoueur == 2 || choixJoueur == 3) {
		verticale = 1;
	    } else if (choixJoueur == 4 || choixJoueur == 5 || choixJoueur == 6) {
		verticale = 2;
	    } else {
		verticale = 3;
	    }
	    // choix de zone du tireur en horizontale
	    if (choixJoueur == 1 || choixJoueur == 4 || choixJoueur == 7) {
		horizontale = 1;
	    } else if (choixJoueur == 2 || choixJoueur == 5 || choixJoueur == 8) {
		horizontale = 2;
	    } else {
		horizontale = 3;
	    }
//	    System.out.println(choixIa + " et " + choixIa2);
	    if (verticale - choixIa2 == -1 || verticale - choixIa2 == 1) {
		jetIa = jetIa - 3;
	    } else if (horizontale - choixIa == 1 || horizontale - choixIa == -1) {
		jetIa = jetIa - 5;

	    } else if (horizontale - choixIa == 2) {
		jetIa = jetIa - 10;
	    } else if (verticale - choixIa2 == -2) {
		jetIa = jetIa - 10;
	    }
	    if (jetJoueur == 1) {
		System.out.println("Le tireur rate son geste !");

	    } else if (jetIa == 1) {
		System.out.println("le gardien reste immobile !");
	    } else if (jetJoueur >= jetIa) {
		System.out.println("But du tireur !");
		scoreEquipeJoueur = scoreEquipeJoueur + 1;
	    } else {
		System.out.println("Quelle arrêt du gardien !");
	    }

	    System.out.println(scoreEquipeJoueur + " à " + scoreEquipeIa);

	    // IA tire
	    System.out.println("Où voulez-vous plonger :");
	    System.out.print("\t1 - en haut à gauche \t2 - en haut au mileu \t3 - en haut à droite");
	    System.out.println("");
	    System.out.println("\t4 - au milieu à gauche \t5 - au milieu au centre 6 - au milieu à droite");
	    System.out.println("\t7 - en bas à gauche \t8 - au bas au milieu \t9 - en bas à droite");
	    choixJoueur = saisie.nextInt();
	    // choix du gardien en verticale
	    if (choixJoueur == 1 || choixJoueur == 2 || choixJoueur == 3) {
		verticale = 1;
	    } else if (choixJoueur == 4 || choixJoueur == 5 || choixJoueur == 6) {
		verticale = 2;
	    } else {
		verticale = 3;
	    }
	    // choix du gardien en horizontale
	    if (choixJoueur == 1 || choixJoueur == 4 || choixJoueur == 7) {
		horizontale = 1;
	    } else if (choixJoueur == 2 || choixJoueur == 5 || choixJoueur == 8) {
		horizontale = 2;
	    } else {
		horizontale = 3;
	    }
//	    System.out.println(verticale + " et " + horizontale);
	    if (verticale - choixIa2 == -1 || verticale - choixIa2 == 1) {
		jetJoueur = jetJoueur - 3;
	    } else if (horizontale - choixIa == 1 || horizontale - choixIa == -1) {
		jetJoueur = jetJoueur - 5;
		// faire une opération pour horizontale et verticale séparées
	    } else if (horizontale - choixIa == 2) {
		jetJoueur = jetJoueur - 10;
	    } else if (verticale - choixIa2 == -2) {
		jetJoueur = jetJoueur - 10;
	    }
// comparaison
	    if (jetIa == 1) {
		System.out.println("Le tireur rate son geste !");

	    } else if (jetJoueur == 1) {
		System.out.println("le gardien reste immobile !");
	    } else if (jetIa >= jetJoueur) {
		System.out.println("But du tireur adverse !");
		scoreEquipeIa = scoreEquipeIa + 1;
	    } else {
		System.out.println("Quelle arrêt du gardien !");
	    }

	    System.out.println(scoreEquipeJoueur + " à " + scoreEquipeIa);

	    // incrémenation
	    tourDeJeu++;

	}
	if (scoreEquipeJoueur > scoreEquipeIa) {
	    System.out.println("Victoire de l'Equipe !");
	} else if (scoreEquipeJoueur < scoreEquipeIa) {
	    System.out.println("Victoire de l'ordinateur !");
	} else {
	    System.out.println("C'est un match nul !");
	}
    }

// méthode pour le jet de dé pour le tireur et le gardien
    static int d20() {
	Random rand = new Random();
	int resDe = rand.nextInt(20) + 0;
	return resDe;

    }
// méthode aléatoire pour l'Ia pour le choix horizontale
    static int horizontale() {
	Random h = new Random();
	int choixHorizontale = h.nextInt(2) + 1;
	if (choixHorizontale == 2) {
	    choixHorizontale = 3;
	}
	return choixHorizontale;

    }
// méthode aléatoire pour l'Ia pour le choix verticale
    static int verticale() {
	Random v = new Random();
	int choixVerticale = v.nextInt(3) + 1;
	return choixVerticale;

    }

}

