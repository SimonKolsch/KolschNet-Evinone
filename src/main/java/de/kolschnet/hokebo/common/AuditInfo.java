package de.kolschnet.hokebo.common;

import java.time.Instant;

public record AuditInfo(Instant createdDate, Long createdBy, Instant lastModifiedDate, Long lastModifiedBy) {

}
