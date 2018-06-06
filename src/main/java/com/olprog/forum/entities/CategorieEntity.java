package com.olprog.forum.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "categorie", schema = "forum")
public class CategorieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nom;

    @Column(name = "date_creation")
    private Date dateCreation;

    @Column(name = "date_update")
    private Date dateUpdate;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private CategorieEntity catId;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private UtilisateurEntity userId;

    @OneToMany(mappedBy = "categorieId")
    private List<SujetEntity> sujetsId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public CategorieEntity getCatId() {
        return catId;
    }

    public void setCatId(CategorieEntity catId) {
        this.catId = catId;
    }

    public UtilisateurEntity getUserId() {
        return userId;
    }

    public void setUserId(UtilisateurEntity userId) {
        this.userId = userId;
    }

    public List<SujetEntity> getSujetsId() {
        return sujetsId;
    }

    public void setSujetsId(List<SujetEntity> sujetsId) {
        this.sujetsId = sujetsId;
    }
}
