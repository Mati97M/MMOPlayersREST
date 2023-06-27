package com.matimon.mmoplayersrest.players;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;
@Entity
@Table(name = "Players")
@XmlRootElement
public class Player {
    @Id
    private int id;
    @Column(name = "nick_name")
    private String name;
    private int level;
    private int health;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", health=" + health +
                '}';
    }
}
