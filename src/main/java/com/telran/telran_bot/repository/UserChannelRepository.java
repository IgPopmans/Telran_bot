package com.telran.telran_bot.repository;


import com.telran.telran_bot.model.UserChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

/**
 * This is interface for saving user_channels in database
 *
 * @author Igors Popmans
 * @version 1.0
 */

public interface UserChannelRepository extends JpaRepository<UserChannel,Integer> {

   /**
    * This method for find all user_channels with user id
    *
    * @param userId internal identifier for user
    * @return list all channels for user
    */
   List<UserChannel> findByUserId(long userId);

   /**
    * This method for finding user_channels with user id and channelId
    * @param channelId iternal identifier for channel
    * @param userId internal identifier for user
    * @return list all channels for user
    */
   UserChannel findByUserIdAndChannelId(long userId, long channelId);

   /**
    * This method for find all users by channel id's from id's list
    *
    * @param channelId list internal identifier channel ids
    * @return list of user_channels
    */
   @Query("SELECT uc.userId FROM UserChannel uc WHERE uc.channelId = :channelId")
   List<Integer> findAllUserIdByChannelId(@Param("channelId") int channelId);

   /**
    * This method for find all user_channels by channel ids from ids list
    *
    * @param channelIds list internal identifier channel ids
    * @return list of user_channels
    */
   @Query("SELECT uc FROM UserChannel uc WHERE uc.channelId IN :channelIds")
   List<UserChannel> findAllUserChannelsByChannelIdFromIdsList(@Param("channelIds")List<Integer> channelIds);
}
