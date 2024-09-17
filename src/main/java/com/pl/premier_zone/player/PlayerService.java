package com.pl.premier_zone.player;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    // Return all Players
    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    // Return a list of players based on Team
    public List<Player> getPlayersFromTeam(String teamName){
        return playerRepository.findAll().stream()
                .filter(player -> teamName.equals(player.getTeam())).collect(Collectors.toList());
    }

    // Return a list of players based on Name
    public List<Player> getPlayersByName(String searchText) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getName().toLowerCase().contains(searchText.toLowerCase())).collect(Collectors.toList());
    }

    // Return a list of players based on Position
    public List<Player> getPlayersByPosition(String searchText) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getPosition().toLowerCase().contains(searchText.toLowerCase())).collect(Collectors.toList());
    }

    // Return a list of players by nation
    public List<Player> getPlayersByNation(String searchText) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getNation().toLowerCase().contains(searchText.toLowerCase())).collect(Collectors.toList());
    }

    public List<Player> getPlayersByTeamAndPosition(String team, String position) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getTeam().equals(team) && player.getPosition().equals(position)).collect(Collectors.toList());
    }

    public Player updatePlayer(Player updatedPlayer) {
        Optional<Player> existingPlayer = playerRepository.findByName(updatedPlayer.getName());

        if(existingPlayer.isPresent()) {
            Player playerToUpdate = existingPlayer.get();
            playerToUpdate.setName(updatedPlayer.getName());
            playerToUpdate.setPosition(updatedPlayer.getPosition());
            playerToUpdate.setNation(updatedPlayer.getNation());
            playerToUpdate.setTeam(updatedPlayer.getTeam());

           playerRepository.save(playerToUpdate);
           return playerToUpdate;
        }

        return null;
    }

    @Transactional
    public void deletePlayer(String name) {
        Optional<Player> playerToDelete = playerRepository.findByName(name);

        if(playerToDelete.isPresent()) {
            Player player = playerToDelete.get();
            playerRepository.deleteById(player.getId());
        }
    }
}
