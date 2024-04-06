package com.websocket.websocket.repository;

import com.websocket.websocket.config.ObjMsg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MsgRepository extends JpaRepository<ObjMsg, Long> {
}
