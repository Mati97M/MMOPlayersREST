package com.matimon.mmoplayersrest.players;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class PlayersDAO {
    private EntityManagerFactory emf;
    private EntityManager em;
    public PlayersDAO() {
        emf = Persistence.createEntityManagerFactory("restPlayers");
        em = emf.createEntityManager();
    }
    public List<Player> getPlayers() {
        Query playrsQuery =  em.createQuery("from Player");
        return playrsQuery.getResultList();
    }
    public Player getPlayer(int id) {
        return em.find(Player.class, id);
    }
    public Player udpatePlayer(Player player) {
        try {
            em.getTransaction().begin();
            Player persistedPlayer =  em.find(Player.class,player.getId());
            persistedPlayer.setName(player.getName());
            persistedPlayer.setLevel(player.getLevel());
            persistedPlayer.setHealth(player.getHealth());
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            player = null;
        }
        return player;
    }
    public Player createPlayer(Player player) {
        try {
            em.getTransaction().begin();
            em.persist(player);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            player = null;
        }
        return player;
    }
    public Player deletePlayer(int id) {
        Player player;
        try {
            em.getTransaction().begin();
            player = em.find(Player.class,id);
            em.remove(player);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            player = null;
        }
        return player;
    }
}
