
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;



public class Etudiant
{
    private String mNom;
    private String mFiliere;
    private double mMoyenne;
    private int mAge;

    public Etudiant(String nom,String filiere, double moyenne,int age)
    {
        this.mAge=age;
        this.mFiliere=filiere;
        this.mMoyenne=moyenne;
        this.mNom=nom;
    }
    //getters and setters
    public String getNom()
    {
        return this.mNom;
    }
    public String getFiliere()
    {
        return this.mFiliere;
    }
    public double getMoyenne()
    {
        return this.mMoyenne;
    }
    public int getAge()
    {
        return this.mAge;
    }
    public void setNom(String nom)
    {
        this.mNom=nom;
    }
    public void setFiliere(String filiere)
    {
        this.mFiliere=filiere;
    }
    public void setMoyenne(Double moyenne)
    {
        this.mMoyenne=moyenne;
    }
    public void setAge(int age)
    {
        this.mAge=age;
    }
    //methodes
    public void ajouterEtudiant(String nom,String filiere,Double moyenne,int age)
    {
        setNom(nom);
        setAge(age);
        setFiliere(filiere);
        setMoyenne(moyenne);
    }
    public static int search(Etudiant []etudiant,String nom)
    {
        for(int i=0; i<etudiant.length;i++)
        {
            if(etudiant[i].getNom().equalsIgnoreCase(nom))
            {
                return  i;
            }
        }
        return -1;
    }
    public double average(Etudiant []etudiant)
    {
        double somme=0;
        for(int i = 0; i < etudiant.length; i++) 
        {
            somme += etudiant[i].getMoyenne();
        }
        
        return somme/etudiant.length;

    }
    public void saving(Etudiant []etudiant, String student)
    {
        try(PrintWriter out = new PrintWriter(student))
        {
            for (Etudiant s : etudiant)
            {
                out.println("Nom : " + s.getNom() + "Filiere : " + s.getFiliere() + "Age : "+ s.getAge() + "Moyenne : "+s.getMoyenne());
            }
            System.out.println("Enregistrement termine dans " + student);
        }
        catch(IOException e)
        {
            System.out.println("Erreur lors de la sauvergarde : " + e.getMessage());
        }
    }
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
    public static Etudiant[] addStudent(Etudiant[] tab, Etudiant e) {
        Etudiant[] newTab = new Etudiant[tab.length + 1];
        for (int i = 0; i < tab.length; i++) {
            newTab[i] = tab[i];
        }
        newTab[tab.length] = e;
        return newTab;
    }
    
}