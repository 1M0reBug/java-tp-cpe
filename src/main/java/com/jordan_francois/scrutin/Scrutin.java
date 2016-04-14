package com.jordan_francois.scrutin;

import fichiersPourTp.tp2.Vote;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by jordan on 14/04/16.
 */
public class Scrutin {

    private List<CandidatScrutin> candidatScrutins;
    private List<Vote> votes;
    private  int populationVotante;
    private int nbVotesValides;
    private int dateScrutin;


    public Scrutin(int population, int dateScrutin) {
        this.populationVotante = population;
        this.dateScrutin = dateScrutin;
        this.candidatScrutins = new LinkedList<CandidatScrutin>();
        this.votes = new LinkedList<Vote>();
    }

    public Scrutin(List<HommePolitique> hommePolitiques, int population, int dateScrutin) throws CloneNotSupportedException {
        this(population, dateScrutin);
        for (HommePolitique hp : hommePolitiques)
        {
            this.candidatScrutins.add(new CandidatScrutin(hp, dateScrutin));
        }
    }

    public void addCandidat(HommePolitique hp) throws CloneNotSupportedException {
        this.candidatScrutins.add(new CandidatScrutin(hp, this.dateScrutin));
    }

    public void addBulletin(Vote vote) {
        this.votes.add(vote);
    }

    @Override
    public String toString() {

        String str = "";
        Iterator it = this.candidatScrutins.iterator();
        CandidatScrutin cs;
        while(it.hasNext()) {
            cs = (CandidatScrutin) it.next();
            str += "    " + cs.getPrenomCandidat() + " " + cs.getNomCandidat() + " a eu " + cs.getNbVoix() + " votes \n";
        }

        return "Scrutin{\n" +
                "  populationVotante: "+ populationVotante +"\n" +
                "  votes valides : " + nbVotesValides + "\n" +
                "  date scrutin : " + dateScrutin  + "\n" +
                "  Candidats : { \n" +  str + "\n" +
                "  }\n" +
                "}";
    }

    public float tauxParticipation() {
        return ((float) this.nbVotesValides / (float) this.populationVotante) * 100.0f;
    }

    public void countTheVotes() {

        this.candidatScrutins.stream().forEach(e -> e.initializeNbVoix());

        Iterator it = votes.iterator();
        while(it.hasNext()) {
            Vote v = (Vote) it.next();
            if (!v.estInvalide()) {
                this.nbVotesValides++;
                this.candidatScrutins.stream()
                        .filter(x -> x.equalsHommePolitique(v.getHommePolitique()))
                        .findFirst()
                        .get()
                        .incrementerNombreVoix();
            }

        }
    }

}
