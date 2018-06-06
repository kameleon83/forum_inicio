package com.olprog.forum.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "message", schema = "forum")
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text")
    private String texte;

    @Column(name = "date_creation")
    private Date dateCreation;

    @Column(name = "date_update")
    private Date dateUpdate;

    @ManyToOne
    @JoinColumn(name = "sujet_id")
    private SujetEntity sujetId;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private UtilisateurEntity userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public SujetEntity getSujetId() {
        return sujetId;
    }

    public void setSujetId(SujetEntity sujetId) {
        this.sujetId = sujetId;
    }

    public UtilisateurEntity getUserId() {
        return userId;
    }

    public void setUserId(UtilisateurEntity userId) {
        this.userId = userId;
    }
}
