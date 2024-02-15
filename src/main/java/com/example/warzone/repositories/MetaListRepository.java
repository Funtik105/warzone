package com.example.warzone.repositories;

import com.example.warzone.models.MetaList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MetaListRepository extends JpaRepository<MetaList, Long> {
    List<MetaList> findAllByGun1(String gun1);

    List<MetaList> findAllByName(String name);

    List<MetaList> findAllByRange(String range);

    List<MetaList> findAllByCategory(String category);

    @Query("SELECT a FROM MetaList a WHERE a.attachment_1 =: attachment_1")
    List<MetaList> findAllByAttachment_1(String attachment_1);

    @Query("SELECT a FROM MetaList a WHERE a.attachment_2 =: attachment_2")
    List<MetaList> findAllByAttachment_2(String attachment_2);

    @Query("SELECT a FROM MetaList a WHERE a.attachment_3 =: attachment_3")
    List<MetaList> findAllByAttachment_3(String attachment_3);

    @Query("SELECT a FROM MetaList a WHERE a.attachment_4 =: attachment_4")
    List<MetaList> findAllByAttachment_4(String attachment_4);

    @Query("SELECT a FROM MetaList a WHERE a.attachment_5 =: attachment_5")
    List<MetaList> findAllByAttachment_5(String attachment_5);
}
