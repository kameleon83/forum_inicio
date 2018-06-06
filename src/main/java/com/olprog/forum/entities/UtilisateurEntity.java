package com.olprog.forum.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "utilisateur", schema = "forum")
public class UtilisateurEntity {

    @Id
    @Column(name = "email", length = 150)
    private String email;

    @Column(unique = true, length = 50, nullable = false)
    private String pseudo;

    @Column(length = 20, nullable = false)
    private String mdp;

    @Column(nullable = false)
    private Boolean role;

    @Column(nullable = false)
    private Date birthday;

    @Column(nullable = false)
    private Boolean ban;

    @Column(name = "date_creation")
    private Date dateCreation;

    @Column(name = "date_update")
    private Date dateUpdate;

    @OneToMany(mappedBy = "userId")
    private List<CategorieEntity> catsId;

    @OneToMany(mappedBy = "userId")
    private List<SujetEntity> sujetsId;

    @OneToMany(mappedBy = "userId")
    private List<MessageEntity> messagesId;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Boolean getRole() {
        return role;
    }

    public void setRole(Boolean role) {
        this.role = role;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Boolean getBan() {
        return ban;
    }

    public void setBan(Boolean ban) {
        this.ban = ban;
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

    public List<CategorieEntity> getCatsId() {
        return catsId;
    }

    public void setCatsId(List<CategorieEntity> catsId) {
        this.catsId = catsId;
    }

    public List<SujetEntity> getSujetsId() {
        return sujetsId;
    }

    public void setSujetsId(List<SujetEntity> sujetsId) {
        this.sujetsId = sujetsId;
    }

    public List<MessageEntity> getMessagesId() {
        return messagesId;
    }

    public void setMessagesId(List<MessageEntity> messagesId) {
        this.messagesId = messagesId;
    }
}
