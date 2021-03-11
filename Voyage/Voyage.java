package Voyage;

import java.util.ArrayList;





class OptionVoyage
{
	private String nom;
	private double prixf;
	
	public OptionVoyage(String n, double p)
	{
		nom=n;
		prixf=p;
	}
	
	public String getNom()
	{
		return nom;
	}
	
	public double prix()
	{
		return prixf;
	}
	
	public String toString()
	{
		return getNom() + " -> " + prix() + " CHF.";
	}
	
}


class Sejour extends OptionVoyage
{
	private int nbreNuits;
	private double prixNuit;
	
	public Sejour(String nom,double prixf,int nbN, double prN)
	{
		super(nom, prixf);
		nbreNuits=nbN;
		prixNuit=prN;
	}
	
	public double prix()
	{
		super.prix();
		return (nbreNuits*prixNuit)+prix();
	}
	
}





class Transport extends OptionVoyage
{
	final public double TARIF_LONG = 1500.0;
	final public double TARIF_BASE = 200.0;
	private boolean isLong=false;
	
	
	public Transport(String nom, double prixf)
	{
		super(nom, prixf);
		
	}

	public Transport(String nom, double prixf, boolean isLong)
	{
		super(nom, prixf);
		this.isLong=isLong;
	}
	
	public double prix()
	{
		super.prix();
		if(isLong==false)
		{
			return TARIF_BASE;
		}
		else
		{
			return TARIF_LONG;
		}
	}
}

class KitVoyage
{
	ArrayList<OptionVoyage> option = new ArrayList<OptionVoyage>();
	private String depart;
	private String destination;
	
	
	
	public KitVoyage(String dep,String dest)
	{
		depart = dep;
		destination = dest;
	}
	
	public void afficher()
	{
		for (OptionVoyage opt : option)
		{
			System.out.println(opt.getNom() + "->" + opt.prix());
		}
	}
	
	
	

	
	public void ajouterOption(OptionVoyage optionVoyage)
	{
		if(!option.isEmpty())
		{
		option.add(optionVoyage);		
	}
	}
	
	public void annuler()
	{
		if(!option.isEmpty())
		{
			option.clear();
		}
		else
		{
			System.out.println("Vous avez encore rien ajoute");
		}
	}
	
	public int getNbOptions()
	{
		return option.size();
	}
	
	
	public double prix()
	{
		double prixtotal=0;
		for(OptionVoyage opt : option)
		{
			prixtotal= prixtotal+ opt.prix();
		}
		return prixtotal;
	}
}

public class Voyage {
    public static void main(String args[]) {

        // TEST 1
        System.out.println("Test partie 1 : ");
        System.out.println("----------------");
        OptionVoyage option1 = new OptionVoyage("Sejour au camping", 40.0);
        System.out.println(option1.toString());

        OptionVoyage option2 = new OptionVoyage("Visite guidee : London by night" , 50.0);
        System.out.println(option2.toString());
        System.out.println();

        // FIN TEST 1


        // TEST 2
        System.out.println("Test partie 2 : ");
        System.out.println("----------------");

        Transport transp1 = new Transport("Trajet en car ", 50.0);
        System.out.println(transp1.toString());

        Transport transp2 = new Transport("Croisiere", 1300.0);
        System.out.println(transp2.toString());

        Sejour sejour1 = new Sejour("Camping les flots bleus", 20.0, 10, 30.0);
        System.out.println(sejour1.toString());
        System.out.println();

        // FIN TEST 2


        // TEST 3
        System.out.println("Test partie 3 : ");
        System.out.println("----------------");

        KitVoyage kit1 = new KitVoyage("Zurich", "Paris");
        kit1.ajouterOption(new Transport("Trajet en train", 50.0));
        kit1.ajouterOption(new Sejour("Hotel 3* : Les amandiers ", 40.0, 5, 100.0));
        System.out.println(kit1.toString());
        System.out.println();
        kit1.annuler();

        KitVoyage kit2 = new KitVoyage("Zurich", "New York");
        kit2.ajouterOption(new Transport("Trajet en avion", 50.0, true));
        kit2.ajouterOption(new Sejour("Hotel 4* : Ambassador Plazza  ", 100.0, 2, 250.0));
        System.out.println(kit2.toString());
        kit2.annuler();

        // FIN TEST 3
    }
}

