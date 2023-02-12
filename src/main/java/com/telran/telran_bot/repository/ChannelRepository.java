package com.telran.telran_bot.repository;

import com.telran.telran_bot.model.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * This is interface for saving channels in database
 *
 * @author Igors Popmans
 * @version 1.0
 */

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Integer> {

    /**
     * This is the method for find all id's by channel id from unique channel id's list
     *
     * @param channelIds channel ids list of long identifiers of channels
     * @return the list of internal ids of channels
     */

    @Query("SELECT ch.id FROM Channel ch WHERE ch.channelId IN :channelIds")
    List<Integer> findAllIdsByChannelIdFromUniqueChannelIdsList(@Param("channelIds") List<Long> channelIds);
}
