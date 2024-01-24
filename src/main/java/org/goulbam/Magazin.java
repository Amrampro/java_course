package org.goulbam;

import java.util.Arrays;
import java.util.Scanner;

public class Magazin {
    public static void main(String[] args){
        achat();
    }

    public static void achat(){
        // Produits disponibles
        String produits[] = {"Fanta", "Annanas", "Coca Cola", "Tomate", "Eau"};
        double[] prix = {2.50, 5.21, 3.20, 2.99, 3.97};

        // Déclarer le panier des produits
        int produitPanier[] = {};
        int qte[] = {};
        int tailleP = produitPanier.length;

        double prixTotal = 0.0;

        Scanner scanner = new Scanner(System.in);

        // Afficher les produits
        System.out.println("Bienvenu(e) sur Amazon. Produits disponibles :");
        for (int i = 0; i < produits.length; i++) {
            System.out.println((i+1) + "." + produits[i] + " -> " + prix[i] + " Eur");
        }

        boolean continuerAchat = true;

        while (continuerAchat) {
            // Demander au client d'entrer le numéro du produit
            System.out.println("Choississez un produit ou entrer 0 pour quitter: ");
            int choixProduit = scanner.nextInt();

            if (choixProduit == 0){
                continuerAchat = false;
            } else if (choixProduit >=1 && choixProduit <= produits.length) {
                int indexProduit = choixProduit - 1;

                // Demandons la quantité
                System.out.println("Entrer la quantité de : " + produits[indexProduit]);
                int quantite = scanner.nextInt();

                // Calcule du prix du produit
                double prixPartiel = quantite * prix[indexProduit];

                prixTotal += prixPartiel;

                // Ajouter le produit au panier
                produitPanier = Arrays.copyOf(produitPanier, tailleP + 1);
                qte = Arrays.copyOf(qte, tailleP + 1);
                // Ajouts des produits au panier
                produitPanier[tailleP] = indexProduit;
                qte[tailleP] = quantite;
                tailleP++;
            } else {
                System.out.println("Le numéro entré n'est pas valide !");
            }
        }

//        for (int i = 0; i < produitPanier.length; i++) {
//            System.out.println(produits[produitPanier[i]] + " Qte: " + qte[i]);
//        }

        System.out.printf("%-15s %-10s %-10s %-10s\n", "Produit", "Prix Unitaire", "Quantité", "PrixT produit");
        for (int i = 0; i < produitPanier.length; i++) {
            double prixTP = prix[produitPanier[i]] * qte[i];
            System.out.printf("%-15s %-10s %-10s %-10s\n", produits[produitPanier[i]], prix[produitPanier[i]], qte[i], prixTP);
        }

        System.out.println("Le prix total de vos achats est : " + prixTotal + " Eur");
    }
}
