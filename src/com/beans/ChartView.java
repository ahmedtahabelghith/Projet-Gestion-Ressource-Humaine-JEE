package com.beans;

import javax.annotation.PostConstruct;

import java.io.Serializable;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.PieChartModel;
 
@ManagedBean
@SessionScoped
public class ChartView implements Serializable {
 
    private PieChartModel pieModel1;
    private PieChartModel pieModel2;
    private PieChartModel pieModel3;
    private PieChartModel pieModel4;
    private PieChartModel pieModel5;
    private PieChartModel pieModel6;
    private PieChartModel pieModel7;
   
    private PieChartModel pieModel9;
    private PieChartModel pieModel10;
    private PieChartModel pieModel11;
    private PieChartModel pieModel12;
    private PieChartModel pieModel13;
    private PieChartModel pieModel14;
    private PieChartModel pieModel15;
    private PieChartModel pieModel24;
    private PieChartModel pieModel17;
    private PieChartModel pieModel18;
    private PieChartModel pieModel19;
    private PieChartModel pieModel20;
    private PieChartModel pieModel21;
    private PieChartModel pieModel22;
    private PieChartModel pieModel23;
    private PieChartModel pieModel25;
	private Statistique stat=new Statistique();
    
	private String curentYear="0000" ;
	private String curentMonth="0000" ;
    
    @PostConstruct
    public void init() {
        createPieModels();
    }
 
    public PieChartModel getPieModel1() {
        return pieModel1;
    }
    
    public PieChartModel getPieModel2() {
        return pieModel2;
    }
 
    
    public PieChartModel getPieModel3() {
        return pieModel3;
    }
   
    public PieChartModel getPieModel4() {
        return pieModel4;
    }
    
    public PieChartModel getPieModel5() {
        return pieModel5;
    }
    
    public PieChartModel getPieModel6() {
        return pieModel6;
    }
    
    public PieChartModel getPieModel7() {
        return pieModel7;
    }
    
    
    public PieChartModel getPieModel9() {
    	createPieModel9();
        return pieModel9;
    }
    
    
    public PieChartModel getPieModel10() {
    	createPieModel10();
        return pieModel10;
    }
    
    public PieChartModel getPieModel11() {
    	createPieModel11();
        return pieModel11;
    }
    
    public PieChartModel getPieModel12() {
    	createPieModel12();
        return pieModel12;
    }
    
    public PieChartModel getPieModel13() {
    	createPieModel13();
        return pieModel13;
    }
    
    public PieChartModel getPieModel14() {
    	createPieModel14();
        return pieModel14;
    }
    public PieChartModel getPieModel15() {
    	createPieModel15();
        return pieModel15;
    }
    public PieChartModel getPieModel24() {
    	createPieModel24();
        return pieModel24;
    }
    public PieChartModel getPieModel17() {
    	createPieModel17();
        return pieModel17;
    }
    
    public PieChartModel getPieModel18() {
    	createPieModel18();
        return pieModel18;
    }
    public PieChartModel getPieModel19() {
    	createPieModel19();
        return pieModel19;
    }
    public PieChartModel getPieModel20() {
    	createPieModel20();
        return pieModel20;
    }
    
    public PieChartModel getPieModel21() {
    	createPieModel21();
        return pieModel21;
    }
    
    public PieChartModel getPieModel22() {
    	createPieModel22();
        return pieModel22;
    }
    
    public PieChartModel getPieModel23() {
    	createPieModel23();
        return pieModel23;
    }
    public PieChartModel getPieModel25() {
    	createPieModel25();
        return pieModel25;
    }
    private void createPieModels() {
        createPieModel1();
        createPieModel2();
        createPieModel3();
        createPieModel4();
        createPieModel5();
        createPieModel6();
        createPieModel7(); 
        createPieModel9();
        createPieModel10();
        createPieModel11();
        createPieModel12();
        createPieModel13();
        createPieModel14();
        createPieModel15();
        createPieModel24();
        createPieModel17();
        createPieModel18();
        createPieModel19();
        createPieModel20();
        createPieModel21();
        createPieModel22();
        createPieModel23();
        createPieModel25();
    }
 
    private void createPieModel1() {
    	Statistique stat=new Statistique();
    	
        pieModel1 = new PieChartModel();
         
        pieModel1.set("Femme", stat.rechercheNomberCTPFemme());
        pieModel1.set("Homme", stat.rechercheNomberCTPHomme());
 
        pieModel1.setTitle("Statistique formation par genre");
        pieModel1.setLegendPosition("w");
    }
    
    
    private void createPieModel9() {
    
    	
        pieModel9 = new PieChartModel();
         
        pieModel9.set("Femme", stat.rechercheNomberCTPFemmeSelonAn(this.curentYear));
        pieModel9.set("Homme", stat.rechercheNomberCTPHommeSelonAn(this.curentYear));
 
        pieModel9.setTitle("Statistique formation par genre");
        pieModel9.setLegendPosition("w");
    }
    
    
    
    private void createPieModel2() {
    	Statistique stat=new Statistique();
    	
        pieModel2 = new PieChartModel();
         
        pieModel2.set("Femme", stat.embaucheCTPFemme());
        pieModel2.set("Homme", stat.embaucheCTPHomme());
 
        pieModel2.setTitle("Statistique embauche");
        pieModel2.setLegendPosition("w");
    }
    
    
    private void createPieModel10() {
    	Statistique stat=new Statistique();
    	
        pieModel10 = new PieChartModel();
         
        pieModel10.set("Femme", stat.embaucheCTPFemmeSelanAn(this.curentYear));
        pieModel10.set("Homme", stat.embaucheCTPHommeSelanAn(this.curentYear));
 
        pieModel10.setTitle("Statistique embauche");
        pieModel10.setLegendPosition("w");
    }
    
    
    private void createPieModel3() {
    	Statistique stat=new Statistique();
    	
        pieModel3 = new PieChartModel();
         
        pieModel3.set("Femme", stat.arretAvantTermeFemme());
        pieModel3.set("Homme", stat.arretAvantTermeHomme());
 
        pieModel3.setTitle("Statistique arrêt avant terme");
        pieModel3.setLegendPosition("w");
    }
    
    
    private void createPieModel11() {
    	Statistique stat=new Statistique();
    	
        pieModel11 = new PieChartModel();
         
        pieModel11.set("Femme", stat.arretAvantTermeFemmeSelonAn(this.curentYear));
        pieModel11.set("Homme", stat.arretAvantTermeHommeSelonAn(this.curentYear));
 
        pieModel11.setTitle("Statistique arrêt avant terme");
        pieModel11.setLegendPosition("w");
    }
    
    
    
    
    
    private void createPieModel4() {
    	Statistique stat=new Statistique();
    	
        pieModel4 = new PieChartModel();
         
        pieModel4.set("Embauché", stat.situationEmbauche());
        pieModel4.set("En recherche d'emploi", stat.situationRecherchEmploi());
        pieModel4.set("Arret avant terme", stat.situationArretAvantTerme());
        
        pieModel4.setTitle("Statistique situation");
        pieModel4.setLegendPosition("w");
    }
    
    
    private void createPieModel12() {
    	Statistique stat=new Statistique();
    	
        pieModel12 = new PieChartModel();
         
        pieModel12.set("Embauché", stat.situationEmbaucheSelonAn(this.curentYear));
        pieModel12.set("En recherche d'emploi", stat.situationRecherchEmploiSelonAn(this.curentYear));
        pieModel12.set("Arret avant terme", stat.situationArretAvantTermeSelonAn(this.curentYear));
        
        pieModel12.setTitle("Statistique situation");
        pieModel12.setLegendPosition("w");
    }
    
    private void createPieModel20() {
    	Statistique stat=new Statistique();
    	
        pieModel20 = new PieChartModel();
         
        pieModel20.set("Embauché", stat.situationEmbaucheSelonAnMon(this.curentYear, this.curentMonth));
        pieModel20.set("En recherche d'emploi", stat.situationRecherchEmploiSelonAnMon(this.curentYear,this.curentMonth));
        pieModel20.set("Arret avant terme", stat.situationArretAvantTermeSelonAnMon(this.curentYear,this.curentMonth));
        
        pieModel20.setTitle("Statistique situation");
        pieModel20.setLegendPosition("w");
    }
    
    
    
    
    
    
    private void createPieModel5() {
    	Statistique stat=new Statistique();
    	
        pieModel5 = new PieChartModel();
         
        pieModel5.set("Eligible", stat.certificationEligible());
        pieModel5.set("Non-éligible", stat.certificationNonEligible()); 
        
        pieModel5.setTitle("Statistique certification");
        pieModel5.setLegendPosition("w");
    }
    

    private void createPieModel13() {
    	Statistique stat=new Statistique();
    	
        pieModel13 = new PieChartModel();
         
        pieModel13.set("Eligible", stat.certificationEligibleSelonAn(this.curentYear));
        pieModel13.set("Non-éligible", stat.certificationNonEligibleSelonAn(this.curentYear)); 
        
        pieModel13.setTitle("Statistique certification");
        pieModel13.setLegendPosition("w");
    }
    
 
    
    private void createPieModel21() {
    	Statistique stat=new Statistique();
    	
        pieModel21 = new PieChartModel();
         
        pieModel21.set("Eligible", stat.certificationEligibleSelonAnMon(this.curentYear , this.curentMonth));
        pieModel21.set("Non-éligible", stat.certificationNonEligibleSelonAnMon(this.curentYear, this.curentMonth)); 
        
        pieModel21.setTitle("Statistique certification");
        pieModel21.setLegendPosition("w");
    }
    
    
    private void createPieModel6() {
    	Statistique stat=new Statistique();
    	
        pieModel6 = new PieChartModel();
         
        pieModel6.set("Département commerce", stat.statistiqueELanSelonPoste("commerce"));
        pieModel6.set("Département finance", stat.statistiqueELanSelonPoste("finance")); 
        pieModel6.set("Département comptabilité", stat.statistiqueELanSelonPoste("comptabilite"));
        pieModel6.set("Département RH", stat.statistiqueELanSelonPoste("RH")); 
        
        pieModel6.setTitle("Statistique composition actuelle ELAN");
        pieModel6.setLegendPosition("w");
    }

    private void createPieModel14() {
    	Statistique stat=new Statistique();
    	
        pieModel14 = new PieChartModel();
         
        pieModel14.set("Département commerce", stat.statistiqueELanSelonPosteSelonAn("commerce", this.curentYear));
        pieModel14.set("Département finance", stat.statistiqueELanSelonPosteSelonAn("finance",this.curentYear)); 
        pieModel14.set("Département comptabilité", stat.statistiqueELanSelonPosteSelonAn("comptabilite",this.curentYear));
        pieModel14.set("Département RH", stat.statistiqueELanSelonPosteSelonAn("RH",this.curentYear)); 
        
        pieModel14.setTitle("Statistique composition actuelle ELAN");
        pieModel14.setLegendPosition("w");
    }
    
    private void createPieModel22() {
    	Statistique stat=new Statistique();
    	
        pieModel22 = new PieChartModel();
         
        pieModel22.set("Département commerce", stat.statistiqueElanSelonPosteSelonAnMon("commerce", this.curentYear,this.curentMonth));
        pieModel22.set("Département finance", stat.statistiqueElanSelonPosteSelonAnMon("finance",this.curentYear,this.curentMonth)); 
        pieModel22.set("Département comptabilité", stat.statistiqueElanSelonPosteSelonAnMon("comptabilite",this.curentYear,this.curentMonth));
        pieModel22.set("Département RH", stat.statistiqueElanSelonPosteSelonAnMon("RH",this.curentYear,this.curentMonth)); 
        
        pieModel22.setTitle("Statistique composition actuelle ELAN");
        pieModel22.setLegendPosition("w");
    }
    
    private void createPieModel7() {
    	Statistique stat=new Statistique();
    	
        pieModel7 = new PieChartModel();
         
        pieModel7.set("Développement", stat.statistiquePesSelonPoste("developpement"));
        pieModel7.set("Désign", stat.statistiquePesSelonPoste("design")); 
        pieModel7.set("marketing", stat.statistiquePesSelonPoste("marketing"));
         
        
        pieModel7.setTitle("Statistique composition actuelle PES");
        pieModel7.setLegendPosition("w");
    }    
    
    private void createPieModel15() {
    	Statistique stat=new Statistique();
    	
        pieModel15 = new PieChartModel();
         
        pieModel15.set("Développement", stat.statistiquePESSelonPosteSelonAn("developpement",this.curentYear));
        pieModel15.set("Désign", stat.statistiquePESSelonPosteSelonAn("design",this.curentYear)); 
        pieModel15.set("marketing", stat.statistiquePESSelonPosteSelonAn("marketing",this.curentYear));
         
        
        pieModel15.setTitle("Statistique composition actuelle PES");
        pieModel15.setLegendPosition("w");
    }    
    
    
    private void createPieModel23() {
    	Statistique stat=new Statistique();
    	
        pieModel23 = new PieChartModel();
         
        pieModel23.set("Développement", stat.statistiquePESSelonPosteSelonAnMon("developpement",this.curentYear , this.curentMonth));
        pieModel23.set("Désign", stat.statistiquePESSelonPosteSelonAnMon("design",this.curentYear, this.curentMonth)); 
        pieModel23.set("marketing", stat.statistiquePESSelonPosteSelonAnMon("marketing",this.curentYear, this.curentMonth));
         
        
        pieModel23.setTitle("Statistique composition actuelle PES");
        pieModel23.setLegendPosition("w");
    }    
    
     

    
    
    
    private void createPieModel24() {
    	Statistique stat=new Statistique();    	
        pieModel24 = new PieChartModel();         
        pieModel24.set("Janvier", stat.tauxOccupationElanSelonAnMon ("01","01", this.curentYear));
        pieModel24.set("Février", stat.tauxOccupationElanSelonAnMon ("02","01", this.curentYear)); 
        
        pieModel24.set("Mars", stat.tauxOccupationElanSelonAnMon ("03","01", this.curentYear));
        pieModel24.set("Avril", stat.tauxOccupationElanSelonAnMon ("04","01", this.curentYear));
        
        pieModel24.set("Mai", stat.tauxOccupationElanSelonAnMon ("05","01", this.curentYear));
        pieModel24.set("Juin", stat.tauxOccupationElanSelonAnMon ("06","01", this.curentYear));
        
        pieModel24.set("Juillet", stat.tauxOccupationElanSelonAnMon ("07","01", this.curentYear));
        pieModel24.set("Août ", stat.tauxOccupationElanSelonAnMon ("08","01", this.curentYear));
        
        pieModel24.set("Septembre", stat.tauxOccupationElanSelonAnMon ("09","01", this.curentYear));
        pieModel24.set("Octobre", stat.tauxOccupationElanSelonAnMon ("10","01", this.curentYear));
        
        pieModel24.set("Novembre", stat.tauxOccupationElanSelonAnMon ("11","01", this.curentYear));
        pieModel24.set("Décembre", stat.tauxOccupationElanSelonAnMon ("12","01", this.curentYear));
        
        pieModel24.setTitle("Statistique taux d'occupation ELAN (sur la base de 20 postes)");
        pieModel24.setLegendPosition("w");
    }
    
    private void createPieModel25() {
    	Statistique stat=new Statistique();    	
        pieModel25 = new PieChartModel();         
        pieModel25.set("Janvier", stat.tauxOccupationPESSelonAnMon ("01","02", this.curentYear));
        pieModel25.set("Février", stat.tauxOccupationPESSelonAnMon ("02","02", this.curentYear)); 
        
        pieModel25.set("mars", stat.tauxOccupationPESSelonAnMon ("03","02", this.curentYear));
        pieModel25.set("avril", stat.tauxOccupationPESSelonAnMon ("04","02", this.curentYear));
        
        pieModel25.set("mai", stat.tauxOccupationPESSelonAnMon ("05","02", this.curentYear));
        pieModel25.set("juin", stat.tauxOccupationPESSelonAnMon ("06","02", this.curentYear));
        
        pieModel25.set("juillet", stat.tauxOccupationPESSelonAnMon ("07","02", this.curentYear));
        pieModel25.set("août ", stat.tauxOccupationPESSelonAnMon ("08","02", this.curentYear));
        
        pieModel25.set("septembre", stat.tauxOccupationPESSelonAnMon ("09","02", this.curentYear));
        pieModel25.set("octobre", stat.tauxOccupationPESSelonAnMon ("10","02", this.curentYear));
        
        pieModel25.set("novembre", stat.tauxOccupationPESSelonAnMon ("11","02", this.curentYear));
        pieModel25.set("décembre", stat.tauxOccupationPESSelonAnMon ("12","02", this.curentYear));
        
        pieModel25.setTitle("Statistique taux d'occupation PES (sur la base de 9 postes)");
        pieModel25.setLegendPosition("w");
    }
    
    
    private void createPieModel17() {
    
    	
        pieModel17 = new PieChartModel();
         
        pieModel17.set("Femme", stat.rechercheNomberCTPFemmeSelonAnMon(this.curentYear,this.curentMonth));
        pieModel17.set("Homme", stat.rechercheNomberCTPHommeSelonAnMon(this.curentYear,this.curentMonth));
 
        pieModel17.setTitle("Statistique formation par genre");
        pieModel17.setLegendPosition("w");
    }
    
    
    private void createPieModel18() {
    	Statistique stat=new Statistique();
    	
        pieModel18 = new PieChartModel();
         
        pieModel18.set("Femme", stat.embaucheCTPFemmeSelanAnMon(this.curentYear,this.curentMonth));
        pieModel18.set("Homme", stat.embaucheCTPHommeSelanAnMon(this.curentYear,this.curentMonth));
 
        pieModel18.setTitle("Statistique embauche");
        pieModel18.setLegendPosition("w");
    }
    
 
    
    private void createPieModel19() {
    	Statistique stat=new Statistique();
    	
        pieModel19 = new PieChartModel();
         
        pieModel19.set("Femme", stat.arretAvantTermeFemmeSelonAnMon(this.curentYear, this.curentMonth));
        pieModel19.set("Homme", stat.arretAvantTermeHommeSelonAnMon(this.curentYear, this.curentMonth));
 
        pieModel19.setTitle("Statistique arrêt avant terme");
        pieModel19.setLegendPosition("w");
    }
     
    
    
    
	public String getCurentYear() {
		return curentYear;
	}

	public void setCurentYear(String curentYear) {
		 
		this.curentYear = curentYear;
	}

	public String getCurentMonth() {
		return curentMonth;
	}

	public void setCurentMonth(String curentMonth) {
		this.curentMonth = curentMonth;
	}    
    
    
    
    
    
    
     
}