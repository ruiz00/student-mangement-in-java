
import java.io.*;
import java.util.Scanner;

public class Main {

    // Charge les étudiants depuis un fichier
    public static Etudiant[] load(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("Aucun fichier trouvé, tableau vide créé.");
            return new Etudiant[0];
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            Etudiant[] etudiants = new Etudiant[0];

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 4) continue;

                String nom = parts[0];
                String filiere = parts[1];
                int age = Integer.parseInt(parts[2]);
                double moyenne = Double.parseDouble(parts[3]);

                // Ajouter dans le tableau
                etudiants = addStudent(etudiants, new Etudiant(nom, filiere, moyenne, age));
            }

            System.out.println("Données chargées depuis " + filename);
            return etudiants;

        } catch (IOException e) {
            System.out.println("Erreur lors du chargement : " + e.getMessage());
            return new Etudiant[0];
        }
    }

    // Sauvegarder dans un fichier
    public static void save(String filename, Etudiant[] etudiants) {
        try (PrintWriter out = new PrintWriter(filename)) {
            for (Etudiant s : etudiants) {
                out.println(s.getNom() + "," + s.getFiliere() + "," + s.getAge() + "," + s.getMoyenne());
            }
            System.out.println("Enregistrement terminé dans : " + filename);
        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    // Ajout manuel dans un tableau fixe → créer un nouveau tableau + copier
    public static Etudiant[] addStudent(Etudiant[] tab, Etudiant e) {
        Etudiant[] newTab = new Etudiant[tab.length + 1];
        for (int i = 0; i < tab.length; i++) {
            newTab[i] = tab[i];
        }
        newTab[tab.length] = e;
        return newTab;
    }

    // Recherche
    public static int search(Etudiant[] tab, String nom) {
        for (int i = 0; i < tab.length; i++) {
            if (tab[i].getNom().equalsIgnoreCase(nom))
                return i;
        }
        return -1;
    }

    // Afficher
    public static void afficher(Etudiant[] tab) {
        if (tab.length == 0) {
            System.out.println("Aucun étudiant enregistré.");
            return;
        }

        for (Etudiant e : tab) {
            System.out.println(e.getNom() + " | " + e.getFiliere() + " | Age:" + e.getAge() + " | Moy:" + e.getMoyenne());
        }
    }

    // -------------------------
    //       MÉTHODE MAIN
    // -------------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String file = "etudiants.txt";

        // 1️⃣ Charger les données au démarrage
        Etudiant[] etudiants = load(file);

        int choix;

        do {
            System.out.println("\n===== MENU ÉTUDIANTS =====");
            System.out.println("1. Ajouter un étudiant");
            System.out.println("2. Rechercher un étudiant");
            System.out.println("3. Afficher tous les étudiants");
            System.out.println("4. Sauvegarder dans le fichier");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choix = sc.nextInt();
            sc.nextLine(); // Eviter bug scanner

            switch (choix) {

                case 1: // Ajouter
                    System.out.print("Nom : ");
                    String nom = sc.nextLine();
                    System.out.print("Filière : ");
                    String fil = sc.nextLine();
                    System.out.print("Moyenne : ");
                    double moy = sc.nextDouble();
                    System.out.print("Age : ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    Etudiant e = new Etudiant(nom, fil, moy, age);
                    etudiants = addStudent(etudiants, e);

                    System.out.println("Étudiant ajouté !");
                    break;

                case 2: // Rechercher
                    System.out.print("Nom de l'étudiant à rechercher : ");
                    String nomSearch = sc.nextLine();
                    int idx = search(etudiants, nomSearch);

                    if (idx == -1)
                        System.out.println("Étudiant non trouvé.");
                    else {
                        Etudiant s = etudiants[idx];
                        System.out.println("Trouvé : " + s.getNom() + " | " + s.getFiliere() + " | " + s.getMoyenne());
                    }
                    break;

                case 3: // Afficher
                    afficher(etudiants);
                    break;

                case 4: // Sauvegarder
                    save(file, etudiants);
                    break;

                case 0:
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide.");
            }

        } while (choix != 0);

        sc.close();
    }
}
