package com.sagar.audit.watcher;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditMessageRepository extends JpaRepository<AuditMessage, String> {

}