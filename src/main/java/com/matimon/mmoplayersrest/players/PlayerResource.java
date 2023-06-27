package com.matimon.mmoplayersrest.players;

import jakarta.ws.rs.*;
import java.util.List;


@Path("players")
public class PlayerResource {

    private PlayersDAO repo = new PlayersDAO();

    @GET
    @Produces({"application/json","application/xml"})
    public List<Player> getPlayers() {
        return repo.getPlayers();
    }
    @GET
    @Path("player/{id}")
    @Produces({"application/json","application/xml"})
    public Player getPlayer(@PathParam("id") int id) {
        Player player = repo.getPlayer(id);
        if(player == null ) {
            System.out.println("Couldn`t find given player: wrong id");
        }
        return player;
    }
    @POST
    @Path("player")
    @Consumes({"application/json","application/xml"})
    public Player createPlayer(Player player) {
        System.out.println(player);
        player = repo.createPlayer(player);
        if(player == null) {
            System.out.println("Couldn`t create given player");
        }
        return player;
    }
    @PUT
    @Path("player")
    @Consumes({"application/json","application/xml"})
    public Player updatePlayer(Player player) {
        player = repo.udpatePlayer(player);
        if(player == null) {
            System.out.println("cannot update given player");
        }
        return player;
    }

    @DELETE
    @Path("player/{id}")
    public Player removePlayer(@PathParam("id") int id) {
        Player player = repo.deletePlayer(id);
        if(player == null) {
            System.out.println("Couldn`t delete given player");
        }
        return player;
    }

}
