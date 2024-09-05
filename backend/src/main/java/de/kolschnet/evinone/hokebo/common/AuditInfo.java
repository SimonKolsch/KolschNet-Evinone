package de.kolschnet.evinone.hokebo.common;

import java.time.Instant;

public record AuditInfo(Instant createdOn, Long createdBy, Instant lastModifiedOn, Long lastModifiedBy) {

}
