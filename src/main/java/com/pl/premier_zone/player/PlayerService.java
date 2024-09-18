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

    /**
     * Retrieve all players from the repository.
     *
     * @return List of all players.
     */
    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    /**
     * Retrieve players based on the team they belong to.
     *
     * @param teamName the name of the team.
     * @return List of players from the specified team.
     */
    public List<Player> getPlayersFromTeam(String teamName) {
        return playerRepository.findAll().stream()
                .filter(player -> teamName.equals(player.getTeam()))
                .collect(Collectors.toList());
    }

    /**
     * Retrieve players whose names contain the given search text (case-insensitive).
     *
     * @param searchText partial or full name of the player.
     * @return List of players matching the search criteria.
     */
    public List<Player> getPlayersByName(String searchText) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getName().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * Retrieve players based on their position (case-insensitive).
     *
     * @param searchText position of the player (e.g., "defender", "midfielder").
     * @return List of players matching the position.
     */
    public List<Player> getPlayersByPosition(String searchText) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getPosition().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * Retrieve players by their nationality (case-insensitive).
     *
     * @param searchText nationality of the player (e.g., "Spanish", "Brazilian").
     * @return List of players matching the nationality.
     */
    public List<Player> getPlayersByNation(String searchText) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getNation().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * Retrieve players based on both team and position.
     *
     * @param team     the team name.
     * @param position the position the player plays in.
     * @return List of players matching both team and position.
     */
    public List<Player> getPlayersByTeamAndPosition(String team, String position) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getTeam().equals(team) && player.getPosition().equals(position))
                .collect(Collectors.toList());
    }

    /**
     * Update the details of an existing player. If the player exists in the database,
     * their details are updated. Otherwise, null is returned.
     *
     * @param updatedPlayer the player with updated details.
     * @return the updated player object, or null if the player was not found.
     */
    public Player updatePlayer(Player updatedPlayer) {
        Optional<Player> existingPlayer = playerRepository.findByName(updatedPlayer.getName());

        if (existingPlayer.isPresent()) {
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

    /**
     * Add a new player to the repository.
     *
     * @param newPlayer the player to be added.
     * @return the added player.
     */
    public Player addPlayer(Player newPlayer) {
        playerRepository.save(newPlayer);
        return newPlayer;
    }

    /**
     * Delete a player from the repository by their name. If the player exists,
     * they are deleted.
     *
     * @param name the name of the player to delete.
     */
    @Transactional
    public void deletePlayer(String name) {
        Optional<Player> playerToDelete = playerRepository.findByName(name);

        if (playerToDelete.isPresent()) {
            Player player = playerToDelete.get();
            playerRepository.deleteById(player.getId());
        }
    }
}
