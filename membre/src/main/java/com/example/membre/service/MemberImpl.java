package com.example.membre.service;

import com.example.membre.bean.PublicationBean;
import com.example.membre.dao.EnseignantChercheurRepository;
import com.example.membre.dao.EtudiantRepository;
import com.example.membre.dao.MemberRepository;
import com.example.membre.dao.MembrePubRepository;
import com.example.membre.entities.*;
import com.example.membre.proxies.PublicationServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberImpl implements IMemberService {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MembrePubRepository membrepubrepository;
    @Autowired
    EnseignantChercheurRepository enseignantChercheurRepository;
    @Autowired
    EtudiantRepository etudiantRepository;
    @Autowired
    PublicationServiceProxy proxy ;

    public Membre addMember(Membre m) {
        memberRepository.save(m);
        return m;
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    public Membre updateMember(Membre m) {
        return memberRepository.saveAndFlush(m);
    }

    public Membre findMember(Long id) {
        Membre m = (Membre) memberRepository.findById(id).get();
        return m;
    }

    public List<Membre> findAll() {
        return memberRepository.findAll();}
    public Membre findByCin(String cin) {
        return memberRepository.findByCin(cin);}
    public Membre findByEmail(String email) {
        return memberRepository.findByEmail(email);}
    public List<Membre> findByNom(String nom) {
        return memberRepository.findByNom(nom);}
    public List<Etudiant> findByDiplome(String diplome) {
        return etudiantRepository.findByDiplome(diplome);
    }
    public List<EnseignantChercheur> findByGrade(String grade) {
        return enseignantChercheurRepository.findByGrade(grade);
    }
    public List<EnseignantChercheur> findByEtablissement(String etablissement) {
        return enseignantChercheurRepository.findByEtablissement(etablissement);
    }

    public void affecterauteurTopublication(Long idauteur, Long idpub) {
        Membre mbr= memberRepository.findById(idauteur).get();
        Membre_Publication mbs= new Membre_Publication();
        mbs.setAuteur(mbr);
        mbs.setId(new Membre_Pub_Id(idpub, idauteur));
        membrepubrepository.save(mbs);
    }

    @Override
    public List<PublicationBean> findPublicationparauteur(Long idauteur) {
        List<PublicationBean> pubs=new ArrayList<PublicationBean>();
        Membre auteur= memberRepository.findById(idauteur).get();
        List<Membre_Publication>
                idpubs=membrepubrepository.findByAuteur(auteur);
        idpubs.forEach(s->{
                    System.out.println(s);
                    pubs.add(proxy.findPublicationById(s.getId().getPublication_id()));
                }
        );
        return pubs;
    }
}