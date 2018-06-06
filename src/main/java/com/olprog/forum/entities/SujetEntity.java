package com.olprog.forum.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sujet", schema = "forum")
public class SujetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titre;

    @Column(name = "date_creation")
    private Date dateCreation;

    @Column(name = "date_update")
    private Date dateUpdate;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private CategorieEntity categorieId;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private UtilisateurEntity userId;

    @OneToMany(mappedBy = "sujetId")
    private List<MessageEntity> messagesId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
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

    public CategorieEntity getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(CategorieEntity categorieId) {
        this.categorieId = categorieId;
    }

    public UtilisateurEntity getUserId() {
        return userId;
    }

    public void setUserId(UtilisateurEntity userId) {
        this.userId = userId;
    }

    public List<MessageEntity> getMessagesId() {
        return messagesId;
    }

    public void setMessagesId(List<MessageEntity> messagesId) {
        this.messagesId = messagesId;
    }
}
