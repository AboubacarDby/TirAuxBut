package fr.gouv.finances.exo;

import java.util.Random;
import java.util.Scanner;

public class TirAuxButs {

    public static void main(String[] args) {
	// initialisation des variables
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
	    // Tour du joueur
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
	    if (verticale - choixIa2 == 1 || verticale - choixIa2 == -1) {
		jetIa = jetIa - 3;
	    }
	    if (horizontale - choixIa == 1 || horizontale - choixIa == -1) {
		jetIa = jetIa - 5;

	    }
	    if (horizontale - choixIa == 2 || horizontale - choixIa == -2) {
		jetIa = jetIa - 10;
	    }
	    if (verticale - choixIa2 == 2 || verticale - choixIa2 == -2) {
		jetIa = jetIa - 10;
	    }

	    if (jetJoueur == 1) {
		System.out.println("Le tireur rate son geste !");
	    } else if (jetIa == 1) {
		System.out.println("le gardien reste immobile !");
		scoreEquipeJoueur = scoreEquipeJoueur + 1;
	    } else if (jetJoueur >= jetIa) {
		System.out.println("But du tireur !");
		scoreEquipeJoueur = scoreEquipeJoueur + 1;
	    } else {
		System.out.println("Quel arrêt du gardien du gardien adverse !");
	    }

	    System.out.println(scoreEquipeJoueur + " à " + scoreEquipeIa);

	    // Tour de l'IA
	    System.out.println("Où voulez-vous plonger :");
	    System.out.print("\t1 - en haut à gauche  \t3 - en haut à droite");
	    System.out.println("");
	    System.out.println("\t4 - au milieu à gauche \t6 - au milieu à droite");
	    System.out.println("\t7 - en bas à gauche  \t9 - en bas à droite");
	    choixJoueur = saisie.nextInt();
	    // choix du joueur en verticale
	    if (choixJoueur == 1 || choixJoueur == 3) {
		verticale = 1;
	    } else if (choixJoueur == 4 || choixJoueur == 6) {
		verticale = 2;
	    } else {
		verticale = 3;
	    }
	    // choix de zone du gardien en horizontale
	    if (choixJoueur == 1 || choixJoueur == 4 || choixJoueur == 7) {
		horizontale = 1;
	    } else {
		horizontale = 3;
	    }
//	    System.out.println(verticale + " et " + horizontale);
	    if (verticale - choixIa2 == 1 || verticale - choixIa2 == -1) {
		jetJoueur = jetJoueur - 3;
	    }
	    if (horizontale - choixIa == 1 || horizontale - choixIa == -1) {
		jetJoueur = jetJoueur - 5;
	    }
	    if (horizontale - choixIa == 2 || horizontale - choixIa == -2) {
		jetJoueur = jetJoueur - 10;
	    }
	    if (verticale - choixIa2 == 2 || verticale - choixIa == -2) {
		jetJoueur = jetJoueur - 10;
	    }
//  	    condition de réussite ou d'échec selon le résultat des jets			
	    if (jetIa == 1) {
		System.out.println("Le tireur rate son geste !");

	    } else if (jetJoueur == 1) {
		System.out.println("le gardien reste immobile !");
		scoreEquipeIa = scoreEquipeIa + 1;
	    } else if (jetIa >= jetJoueur) {
		System.out.println("But du tireur adverse !");
		scoreEquipeIa = scoreEquipeIa + 1;
	    } else {
		System.out.println("Quel arrêt du gardien !");
	    }

	    System.out.println(scoreEquipeJoueur + " à " + scoreEquipeIa);

	    // incrémenation du tour de jeu jusqu'à arriver à la fin
	    tourDeJeu++;
	}

//	condition de victoire selon score de chaque équipe, avec possibilité de match nul
	if (scoreEquipeJoueur > scoreEquipeIa) {
	    System.out.println("Victoire de l'Equipe ESI !");
	} else if (scoreEquipeJoueur < scoreEquipeIa) {
	    System.out.println("Victoire de l'ordinateur !");
	} else {
	    System.out.println("C'est un match nul !");
	}
	saisie.close();
    }

// méthode pour le jet de dé pour le tireur et le gardien
    static int d20() {
	Random rand = new Random();
	int resDe = rand.nextInt(20) + 1;
	return resDe;

    }

// méthode de choix de tir/plongeon pour l'ordinateur de manière horizontale
    static int horizontale() {
	Random h = new Random();
	int choixHorizontale = h.nextInt(2) + 1;
	if (choixHorizontale == 2) {
	    choixHorizontale = 3;
	}
	return choixHorizontale;

    }

    // méthode de choix de tir/plongeon pour l'ordinateur de manière horizontale
    static int verticale() {
	Random v = new Random();
	int choixVerticale = v.nextInt(3) + 1;
	return choixVerticale;

    }

}



