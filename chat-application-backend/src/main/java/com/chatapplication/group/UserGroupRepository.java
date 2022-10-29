package com.chatapplication.group;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserGroupRepository extends CrudRepository<UserGroup, String> {

    @Query(value = "select ug.groupId from UserGroup ug where ug.userId = ?1 ")
    List<String> getAllGroupIds(String userId);

    @Query(value = "select ug.userId from UserGroup ug where ug.groupId = ?1")
    List<String> getAllUserIds(String groupId);

}
