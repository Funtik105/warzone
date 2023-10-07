package com.example.warzone.repositories;

import com.example.warzone.models.Attachments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachments,Long> {
}
