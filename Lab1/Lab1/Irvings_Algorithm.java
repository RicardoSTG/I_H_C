package Lab1;

import java.util.ArrayList;

public class Irvings_Algorithm { 
	
	public static void main(String[] args) {
		
		Persona[] p = new Persona[6];
		
		String[] prefer11 = {"Peter","Paul","Sam","Kelly","Elise"};
		ArrayList<String> prefer1 = new ArrayList<String>();
		addList(prefer1, prefer11);
		
		Persona a = new Persona("Charlie", prefer1);
		
		String[] prefer22 = {"Kelly","Elise","Sam","Paul","Charlie"};
		ArrayList<String> prefer2 = new ArrayList<String>();
		addList(prefer2, prefer22);
		
		Persona b = new Persona("Peter", prefer2);
		
		String[] prefer33 = {"Peter","Sam","Kelly","Charlie","Paul"};
		ArrayList<String> prefer3 = new ArrayList<String>();
		addList(prefer3, prefer33);
		
		Persona c = new Persona("Elise", prefer3);
		
		String[] prefer44 = {"Elise","Charlie","Sam","Peter","Kelly"};
		ArrayList<String> prefer4 = new ArrayList<String>();
		addList(prefer4, prefer44);
		
		Persona d = new Persona("Paul", prefer4);
		
		String[] prefer55 = {"Peter","Charlie","Sam","Elise","Paul"};
		ArrayList<String> prefer5 = new ArrayList<String>();
		addList(prefer5, prefer55);
		
		Persona e = new Persona("Kelly", prefer5);
		
		String[] prefer66 = {"Charlie","Paul","Kelly","Elise","Peter"};
		ArrayList<String> prefer6 = new ArrayList<String>();
		addList(prefer6, prefer66);
		
		Persona f = new Persona("Sam", prefer6);
		
		p[0] = a;
		p[1] = b;
		p[2] = c;
		p[3] = d;
		p[4] = e;
		p[5] = f;
		
		int x=0;
		while(x!=1) {
			for(int i=0; i<p.length; i++) {
				for(int pre=0; pre<p.length-1;pre++) {
					p[i].setPareja(p[i].getPreferencias().get(pre));
					for(int j=0; j<p.length; j++) {
						//pareja repetida en J
						if(i!=j && p[i].getPareja().equals(p[j].getPareja())) {
							for(int k=0; k<p.length; k++) {
								//Quien es el buscado en K
								if(p[i].getPareja().equals(p[k].getNombre())) {
									int duda=0;
									int duda2=0;
									for(int l=0; l<p.length-1; l++) {
										if(p[k].getPreferencias().get(l).equals(p[i].getNombre())) {
											duda=l;
										} else if(p[k].getPreferencias().get(l).equals(p[j].getNombre())) {
											duda2=l;
										}
									}
									
									if(duda>duda2) {
										p[k].getPreferencias().remove(duda);
										for(int z=0; z<p.length-1; z++) {
											if(p[j].getPreferencias().get(z).equals(p[j].getPareja())) {
												p[j].getPreferencias().remove(z);
												p[j].setPareja("");
											}
										}
									} else {
										p[k].getPreferencias().remove(duda2);
										for(int z=0; z<p.length-1; z++) {
											if(p[i].getPreferencias().get(z).equals(p[j].getPareja())) {
												p[i].getPreferencias().remove(z);
												p[i].setPareja("");
											}
										}
									}
								}
							}
						}
					}
				}
				
			}
			x++;
		}
		
		for(int i=0; i<p.length-1;i++) {
			System.out.println(p[0].getPreferencias().get(i));
		}
		
		
	}
	
	private static void addList(ArrayList<String> prefer, String[] array){        
	     for (String elemento: array) {
	        prefer.add(elemento);
	    }
	}
	
	

}
