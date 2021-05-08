package com.sitMauricie.SitMaurice.model;
import javax.persistence.*;

    @Entity
    @Table(name = "individus")
    public class Individu {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;

        @Column(name = "fname")
        private String fname;

        @Column(name = "lname")
        private String lname;

        @Column(name = "sexe")
        private boolean sexe;

        @Column(name = "adresse")
        private String adresse;

        @Column(name = "telephone")
        private String telephone;

        @Column(name = "nas")
        private String nas;

        @Column(name = "pb_sante")
        private String pb_sante;

        @Column(name = "lieu_travail")
        private String lieu_travail;

        @Column(name = "date_debut_participation")
        private String date_debut_participation;

        @Column(name = "date_fin_participation")
        private String date_fin_participation;

        @Column(name = "reference")
        private String reference;

        @Column(name = "type_residence")
        private String type_residence;

        @Column(name = "niveau_scolaire")
        private String niveau_scolaire ;

        @Column(name = "statut_individu")
        private String statut_individu ;

        @Column(name = "heures_travailles_par_jour")
        private double heures_travailles_par_jour;

        @Column(name = " taux_horaires")
        private double  taux_horaires;

        @Column(name = "transport")
        private String transport;

        @Column(name = "intervenant_responsable")
        private String intervenant_responsable;

        @Column(name = "personne_urgence")
        private String personne_urgence;

        public Individu( String fname, String lname, boolean sexe) {

            this.fname = fname;
            this.lname = lname;
            this.sexe = sexe;
        }


        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getFname() {
            return fname;
        }

        public void setFname(String fname) {
            this.fname = fname;
        }

        public String getLname() {
            return lname;
        }

        public void setLname(String lname) {
            this.lname = lname;
        }



        public boolean isSexe() {
            return sexe;
        }

        public void setSexe(boolean sexe) {
            this.sexe = sexe;
        }
        public boolean isMale() {
            return sexe;
        }
    }

