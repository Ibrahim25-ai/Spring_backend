package com.example.membre.controleur;

import com.example.membre.entities.EnseignantChercheur;
import com.example.membre.entities.Etudiant;
import com.example.membre.entities.Membre;
import com.example.membre.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberRestController {
    @Autowired
    IMemberService memberService;
    @RequestMapping(value="/membres", method= RequestMethod.GET)
    public List<Membre> findMembres (){
        return memberService.findAll();
    }
    @GetMapping(value="/membres/{id}")
    public Membre findOneMemberById(@PathVariable Long id){
        return memberService.findMember(id);
    }
    @GetMapping(value="/membres/search/cin")
    public Membre findOneMemberByCin(@RequestParam String cin)
    {
        return memberService.findByCin(cin);
    }
    @GetMapping(value="/membres/search/email")
    public Membre findOneMemberByEmail(@RequestParam String email)
    {
        return memberService.findByEmail(email);
    }

    @GetMapping(value = "/membres/fullmember/{id}")
    public Membre findAFullMember(@PathVariable(name="id") Long id)
    {

        Membre mbr=memberService.findMember(id);
        mbr.setPubs(memberService.findPublicationparauteur(id));

        return mbr;
    }
    @GetMapping(value = "/membres/addpub/{id}/{id1}")
    public Membre findAFullMember1(@PathVariable(name="id") Long id, Long id1)
    {

        Membre mbr=memberService.findMember(id);
        memberService.affecterauteurTopublication(id,id1);

        return mbr;
    }
    @PostMapping(value="/membres/enseignant")
    public Membre addMembre(@RequestBody EnseignantChercheur m)
    {
        return memberService.addMember(m);
    }
    @PostMapping(value="/membres/etudiant")
    public Membre addMembre(@RequestBody Etudiant e) {
        return memberService.addMember(e);
    }
    @PutMapping(value="/membres/etudiant/{id}")
    public Membre updatemembre(@PathVariable Long id, @RequestBody
    Etudiant p)
    {

        p.setId(id);
        return memberService.updateMember(p);

    }
    @PutMapping(value="/membres/enseignant/{id}")
    public Membre updateMembre(@PathVariable Long id, @RequestBody
    EnseignantChercheur p)
    {

        p.setId(id);
        return memberService.updateMember(p);

    }
}