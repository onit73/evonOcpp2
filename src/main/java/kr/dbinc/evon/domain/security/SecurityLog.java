package kr.dbinc.evon.domain.security;

import lombok.Getter;

import javax.persistence.*;

import kr.dbinc.evon.ocpp.types.enums.Log;

import java.time.LocalDateTime;

@Entity
@Getter
public class SecurityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "security_log_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    Log logType;

    String remoteLocation;

    LocalDateTime oldestTimestamp;
    LocalDateTime latestTimestamp;

    public SecurityLog(
            Log logType,
            String remoteLocation,
            LocalDateTime oldestTimestamp,
            LocalDateTime latestTimestamp) {
        this.logType = logType;
        this.remoteLocation = remoteLocation;
        this.oldestTimestamp = oldestTimestamp;
        this.latestTimestamp = latestTimestamp;
    }
}
