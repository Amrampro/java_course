package org.goulbam;

import java.util.Scanner;

public class JeuGuerre {
    public static void main(String[] args){
        jeu();
    }

    public static void jeu(){
        String position[][] = {
                {"depart", "Chemin2", "Chemin3", "bombe"},
                {"Chemin5", "bombe", "Chemin7", "Chemin8"},
                {"Chemin9", "Chemin10", "Chemin11", "bombe"},
                {"bombe", "Chemin14", "Chemin15", "arrive"}
        };

        int vies = 2;
        int ligne = 0;
        int colonne = 0;
        String position_joueur = position[ligne][colonne];

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenu(e) dans le jeu Guerre. Vous avez " + vies + " vies");
        System.out.println("Instruction: (z) pour monter, (s) pour descendre, (q) pour aller à gauche et (d) pour aller à droite");

        while (vies > 0){
            System.out.println("Position: " + position_joueur + " vies: " + vies);

            String direction = scanner.nextLine().toLowerCase();

            // Gesttion des directions
            if (direction.equals("q") && colonne > 0){
                colonne--;
            } else if (direction.equals("d") && colonne < position.length - 1){
                colonne++;
            } else if (direction.equals("z") && ligne > 0) {
                ligne--;
            } else if (direction.equals("s") && ligne < position[0].length - 1) {
                ligne++;
            } else {
                System.out.println("Entrer les bonnes direction (z, s, q, d)");
                continue;
            }

            // Ajuster la position du joueur
            position_joueur = position[ligne][colonne];

            if (position_joueur.equals("bombe")){
                System.out.println("BOUM ! Vous avez touché une bombe");
                vies--;
            } else if (position_joueur.equals("arrive")) {
                System.out.println("Félicitations ! Vous êtes sauvé");
                break;
            }
        }

        if (vies <= 0) {
            System.out.println("Vous avez épuisé vos vies. Fin du jeu");
        }
        scanner.close();
    }
}
