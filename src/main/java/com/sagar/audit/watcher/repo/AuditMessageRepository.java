package com.sagar.audit.watcher.repo;

import com.sagar.audit.watcher.domain.AuditMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditMessageRepository extends JpaRepository<AuditMessage, String> {

}